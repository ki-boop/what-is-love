<template>
  <Toast />
  <NavHeader />
  <router-view v-slot="{ Component }">
    <transition name="route" mode="out-in">
      <component :is="Component"></component>
    </transition>
  </router-view>
</template>

<script lang="ts" setup>
import "primevue/resources/primevue.min.css";
import "primevue/resources/themes/lara-light-indigo/theme.css";
import "primeicons/primeicons.css";
import NavHeader from "./components/common/NavHeader.vue";
import Toast from "primevue/toast";
import { onMounted } from "vue";
import authStore from "./store";
import { useTheme } from "./utils/useTheme";

onMounted(() => {
  useTheme();
  authStore.dispatch("setToken");
});
</script>

<style lang="scss">
@import url(./themes.css);
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
  font-size: 16px;
  --bg-blue: rgb(67, 101, 238);
  --bg-violet: rgb(215, 158, 198);
  font-family: "Segoe UI", Arial, sans-serif;
}

body {
  &::-webkit-scrollbar {
    width: 10px;
    height: 10px;
  }

  &::-webkit-scrollbar-track {
    background: #f1f1f1;
  }

  &::-webkit-scrollbar-thumb {
    background: linear-gradient(45deg, var(--bg-blue), #fff);
    border-radius: 10px;
  }

  background: radial-gradient(circle, #375bbb, #050549);
}
a {
  text-decoration: none;
}

.flex-wrapper {
  width: 100%;
  align-items: center;
  justify-content: center;
  display: flex;
}

/* route transitions */
.route-enter-from {
  opacity: 0;
  transform: translateX(100px);
}
.route-enter-active {
  transition: all 0.3s ease-out;
}
.route-leave-to {
  opacity: 0;
  transform: translateX(-100px);
}
.route-leave-active {
  transition: all 0.3s ease-in;
}
</style>
