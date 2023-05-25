import authStore from "@/store";
import { RouteLocationNormalized } from "vue-router";
export function isAuthentivated(
  to: RouteLocationNormalized,
  from: RouteLocationNormalized,
  next: any
) {
  if (!authStore.getters.getToken) return;
}
