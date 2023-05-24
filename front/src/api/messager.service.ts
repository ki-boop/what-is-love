import authStore from "@/store";
import { Stomp } from "@stomp/stompjs";
import SockJS from "sockjs-client";
const WS_SOCKET_CONNECTION = "http://localhost:8000/ws";

export class MessageService {
  static initConnection() {
    const ws = new SockJS(WS_SOCKET_CONNECTION);
    const client = Stomp.over(ws);
    if (client)
      client.connect(
        { "X-Authorization": "Bearer " + authStore.getters.getToken },
        () => {
          client.subscribe("/echo", (mes: any) => {
            console.log(mes);
          });
        }
      );
  }
}