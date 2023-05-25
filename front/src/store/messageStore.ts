import { AuthStoreModel } from "@/models/auth.model";
import { createStore } from "vuex";
import { image } from "@/models/user.model";
/* eslint-disable */
const messageStore = createStore({
  state: { messages: Array<String>() },
  getters: {
    getMessages(state) {
      return state.messages;
    },
  },
  mutations: {},
  actions: {
    pushToStore({ state }, msg: string) {
      state.messages.push(msg);
    },
  },
  modules: {},
});

export default messageStore;
