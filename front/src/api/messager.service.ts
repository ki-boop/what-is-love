import authStore from "@/store";
import { Stomp } from "@stomp/stompjs";
import SockJS from "sockjs-client";
import axios from "axios";
import messageStore from "@/store/messageStore";
const WS_SOCKET_CONNECTION = "http://localhost:8000/ws";
/* eslint-disable */
export class MessageService {
  static ws = new SockJS(WS_SOCKET_CONNECTION);
  static client = Stomp.over(this.ws);

  initConnection() {
    if (MessageService.client)
      MessageService.client.connect(
        {
          "X-Authorization": "Bearer " + JSON.parse(authStore.getters.getToken),
        },
        () => {
          MessageService.client.subscribe("/user/queue/drivers", (mes: any) => {
            console.log(mes.body);

            messageStore.dispatch("pushToStore", mes.body);
          });
        }
      );
  }

  getAvalibleChat(productId: number) {
    return axios.post(
      `http://localhost:8000/api/chat/create?productId=${productId}`,
      {},
      {
        headers: {
          Authorization: "Bearer " + JSON.parse(authStore.getters.getToken),
        },
      }
    );
  }

  sendMessage(chatId: string, msg: string) {
    if (MessageService.client) {
      MessageService.client.send(
        "/app/chat",
        {
          "X-Authorization": "Bearer " + JSON.parse(authStore.getters.getToken),
        },
        JSON.stringify({
          chatId: chatId,
          content: msg,
        })
      );
    }
  }
}
