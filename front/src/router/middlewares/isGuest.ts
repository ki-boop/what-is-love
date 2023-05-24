import authStore from "@/store";
import { RouteLocationNormalized } from "vue-router";
export function isGuest(
  to: RouteLocationNormalized,
  from: RouteLocationNormalized,
  next: any
) {
  if (!authStore.getters.getToken) {
    next();
  } else {
    next(from);
  }
}
