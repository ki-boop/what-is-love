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
</script>

<style lang="scss">
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
  font-size: 16px;
  --bg-blue: #4365ee;
  --bg-violet: #d79ec6;
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

@font-face {
  font-family: "VTCSuperMarketSaleItalic";
  src: url("./assets/VTCSuperMarketSaleItalic.ttf") format("ttf");
  font-weight: 700;
}
</style>
