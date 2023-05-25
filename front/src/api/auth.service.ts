import authStore from "@/store";
import { showCustomNotification } from "@/utils/notification";
import axios from "axios";
const API_TOKEN_URL =
  "http://localhost:8282/realms/chat_realm/protocol/openid-connect/token";
const API_URL = "http://localhost:8080/api/auth/";
/* eslint-disable */
// @ts-ignore
import ToastEventBus from "primevue/toasteventbus";

export class AuthService {
  static login(login: string, password: string) {
    const params = new URLSearchParams();
    params.append("client_id", "chat_client");
    params.append("username", login);
    params.append("password", password);
    params.append("grant_type", "password");
    return axios
      .post(API_TOKEN_URL, params)
      .catch((err) => {
        ToastEventBus.emit(
          "add",
          showCustomNotification(
            "error",
            "Ошибка авторизации",
            err.message,
            3000
          )
        );
        return err;
      })
      .then((response) => {
        localStorage.setItem(
          "refresh",
          JSON.stringify(response.data.refresh_token)
        );
        localStorage.setItem(
          "access",
          JSON.stringify(response.data.access_token)
        );
        authStore.dispatch("setToken", response.data.access_token);

        return response.data;
      });
    // .then(() => {
    //   this.getUser();
    // });
  }

  static getUser() {
    const token = authStore.getters.getToken;
    return axios
      .get("http://localhost:8000/api/user/", {
        headers: {
          Authorization: "Bearer " + token,
        },
      })
      .then((res) => {
        authStore.dispatch("setUser", res);
      });
  }
}
