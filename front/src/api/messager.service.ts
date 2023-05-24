import authStore from "@/store";
import { Stomp } from "@stomp/stompjs";
import SockJS from "sockjs-client";
const WS_SOCKET_CONNECTION = "http://localhost:8000/ws";

export class MessageService {
  static initConnection() {
    const ws = new SockJS(WS_SOCKET_CONNECTION);
    const client = Stomp.over(ws);
    console.log(client);
    console.log(authStore.getters.getToken);

    if (client)
      client.connect(
        { "X-Authorization": "Bearer " + authStore.getters.getToken },
        () => {
          client.subscribe("/user/queue/drivers", (mes: any) => {
            console.log(mes);
          });
//           client.subscribe("/queue/drivers", (mes: any) => {
//                       console.log(mes);
//                     });
          client.send("/app/chat", {}, JSON.stringify({ chatId: "asd", content: "asd"}))
        }
      );

  }
}
