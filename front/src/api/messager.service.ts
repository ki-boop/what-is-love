import authStore from "@/store";
import { Stomp } from "@stomp/stompjs";
import SockJS from "sockjs-client";
import axios from "axios";
import messageStore from "@/store/messageStore";
const WS_SOCKET_CONNECTION = "http://localhost:8000/ws";
/* eslint-disable */
export class MessageService {
  static initConnection() {
    const ws = new SockJS(WS_SOCKET_CONNECTION);
    const client = Stomp.over(ws);
    console.log(client);
    console.log(authStore.getters.getToken);

    if (client)
      client.connect(
        {
          "X-Authorization": "Bearer " + JSON.parse(authStore.getters.getToken),
        },
        () => {
          client.subscribe("/user/queue/drivers", (mes: any) => {
            console.log(mes.body);

            messageStore.dispatch("pushToStore", mes.body);
          });
        }
      );
  }

  static getAvalibleChat(productId: number) {
    return axios
      .post(`http://localhost:8000/api/chat/create?productId:${productId}`)
      .then((res) => {});
  }

  static sendMessage(chatId: string, msg: string) {
    const ws = new SockJS(WS_SOCKET_CONNECTION);
    const client = Stomp.over(ws);

    if (client) {
      client.send(
        "/app/chat",
        {},
        JSON.stringify({
          chatId: chatId,
          content: msg,
        })
      );
    }
  }
}
