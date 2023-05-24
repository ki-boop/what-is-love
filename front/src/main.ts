import { createApp } from "vue";
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router";
import store from "./store";
import PrimeVue from "primevue/config";
import ToastService from "primevue/toastservice";
import setup from "./api/interceptor";
setup(store);
createApp(App)
  .use(store)
  .use(router)
  .use(PrimeVue)
  .use(ToastService)
  .mount("#app");
