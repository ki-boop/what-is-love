import authStore from "@/store";
import { Stomp } from "@stomp/stompjs";
import SockJS from "sockjs-client";
import axios from "axios";
const WS_SOCKET_CONNECTION = "http://localhost:8000/ws";

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
            console.log(mes);
          });
          //           client.subscribe("/queue/drivers", (mes: any) => {
          //                       console.log(mes);
          //                     });
          client.send(
            "/app/chat",
            {},
            JSON.stringify({
              chatId: "b63da074-af73-4836-90c8-aa8b4d6a983d",
              content: "message",
            })
          );
        }
      );
  }

  static getAValibleChat() {
    return axios.get("");
  }
}
