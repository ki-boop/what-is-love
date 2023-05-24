import { createStore } from "vuex";

const authStore = createStore({
  state: { token: "", refreshToken: "", user: "" },
  getters: {
    getToken(state) {
      return state.token;
    },
  },
  mutations: {},
  actions: {
    setToken({ state }, token: string) {
      this.state.token = localStorage.getItem("access") || "";
    },
    setRefreshToken({ state }, refreshToken: string) {
      this.state.refreshToken = refreshToken;
    },
    removeToken() {
      this.state.token = "";
    },
    removeRefreshToken() {
      this.state.refreshToken = "";
    },
    setUser({ state }, user: string) {
      this.state.user = user;
    },
  },
  modules: {},
});

export default authStore;
