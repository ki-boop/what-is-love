import { RouteLocationNormalized } from "vue-router";
export function isAuthentivated(
  to: RouteLocationNormalized,
  from: RouteLocationNormalized,
  next: any
) {
  // for redirect
  next({
    path: "/about",
    replace: true,
  });
}
