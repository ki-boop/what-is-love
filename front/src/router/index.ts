import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import HomeView from "../views/HomeView.vue";
import ChatView from "../views/ChatView.vue";
import SignUpView from "../views/SignupView.vue";
import { isAuthentivated } from "./middlewares/isAutenficated";
import authStore from "@/store";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    component: ChatView,
  },
  {
    path: "/auth",
    name: "auth",
    component: SignUpView,
    redirect: authStore.getters.getToken ? "support" : "",
    children: [
      {
        path: ":id",
        component: ChatView,
      },
    ],
  },
  {
    path: "/support",
    name: "support",
    component: () => import("../views/SupportView.vue"),
  },
  {
    path: "/chats",
    name: "chats",
    component: () => import("../views/ChatView.vue"),
  },
  {
    path: "/product",
    name: "product",
    component: () => import("../views/ProductView.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
