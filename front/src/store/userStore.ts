import { AuthStoreModel } from "@/models/auth.model";
import { createStore } from "vuex";
import { image } from "@/models/user.model";

const userStore = createStore({
  state: {
    user: {
      username: "Ivan Ivanov",
      role: "Manager",
      image: image,
    },
  },
  getters: {
    getUser(state) {
      return state.user;
    },
  },
  mutations: {},
  actions: {},
  modules: {},
});

export default userStore;
