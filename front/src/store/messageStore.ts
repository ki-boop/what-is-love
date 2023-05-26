import { AuthStoreModel } from "@/models/auth.model";
import { createStore } from "vuex";
import { image } from "@/models/user.model";
import { ChatMessage } from "@/models/dialog.model";
/* eslint-disable */
const messageStore = createStore({
  state: { messages: Array<ChatMessage>() },
  getters: {
    getMessages(state) {
      return state.messages;
    },
  },
  mutations: {},
  actions: {
    pushToStore({ state }, msg: ChatMessage) {
      state.messages.push(msg);
    },
  },
  modules: {},
});

export default messageStore;
