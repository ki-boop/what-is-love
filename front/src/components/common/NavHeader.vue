<template>
  <header>
    <nav>
      <div class="router">
        <!-- <span class="logo">[ mang ]<strong> CHAT</strong></span> -->
      </div>
      <div class="user-info">
        <span
          class="pi pi-user"
          style="font-size: 1.2rem"
          @click="click()"
        ></span>
        <router-link :to="{ name: 'chats', params: { id: 1 } }">
          <span class="pi pi-comment" style="font-size: 1.2rem"></span
        ></router-link>
        <ThemeSwitcher />
      </div>
    </nav>
    <SliderMenu :collapsed="collapsed" v-on-click-outside="toggleSlideMenu" />
  </header>
</template>

<script lang="ts" setup>
import { vOnClickOutside } from "@vueuse/components";
import authStore from "@/store";
import ThemeSwitcher from "../common/shared/ThemeSwitcher.vue";
import router from "@/router";
import SliderMenu from "../common/shared/SliderMenu.vue";
import { ref } from "vue";
const collapsed = ref(false);
/* eslint-disable */
function click() {
  if (authStore.getters.getToken) toogleSlideM();
  router.push("auth");
}


function toogleSlideM() {
  if(collapsed.value) return;
  collapsed.value = !collapsed.value;
}

function toggleSlideMenu() {
  collapsed.value = false;
}


</script>

<style lang="scss" scoped>
header {
  height: 60px;
  border-bottom: 1px solid rgba(34, 60, 80, 0.2);
  position: relative;
  background: linear-gradient(45deg, var(--bg-blue), var(--bg-violet));
  color: #fff;
  z-index: 2;
}

span:hover {
  cursor: pointer;
}

nav {
  display: flex;
  height: 100%;
  align-items: center;
  justify-content: space-between;
  padding: 0 20px;
}
.logo {
  font-weight: bold;
  letter-spacing: 1px;
}

a {
  color: #fff;
  font-size: 16px;
}
.pi :hover {
  cursor: pointer;
}
.router {
  display: flex;
  gap: 30px;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 20px;
}

.user-info .user-name {
  font-weight: bold;
}

.user-info .user-role {
  font-weight: bold;

  color: rgba(255, 255, 255, 0.8);
}
</style>
