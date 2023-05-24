<template>
  <ul>
    <li v-for="option in listOptions" :key="option.name">
      <span
        class="span-wrapper"
        @click="
          {
            {
              option.action();
            }
          }
        "
        ><i :class="option.icon" style="color: white"></i>
        <span>{{ option.name }}</span></span
      >
    </li>
  </ul>
</template>
<script setup lang="ts">
import { OptionByRoleItem } from "@/models/user.model";

const listOptions: OptionByRoleItem[] = [
  {
    name: "Отложенное",
    icon: "pi pi-bookmark-fill",
    action: () => console.log("Отложенное"),
  },
  {
    name: "Покупки",
    icon: "pi pi-dollar",
    action: () => console.log("Покупки"),
  },
  {
    name: "Мои карты",
    icon: "pi pi-wallet",
    action: () => console.log("Мои"),
  },
  {
    name: "Активные сеансы",
    icon: "pi pi-eye",
    action: () => console.log("Активные"),
  },
  {
    name: "Настройки",
    icon: "pi pi-cog",
    action: () => console.log("Настройки"),
  },
  {
    name: "Информация",
    icon: "pi pi-info-circle",
    action: () => console.log("Информация"),
  },
];
</script>
<style scoped lang="scss">
ul {
  margin-top: 40px;
  list-style-type: none;
  color: #ffffff;
  font-size: 32px;
  display: flex;
  flex-direction: column;
  gap: 20px;
}
li {
  .span-wrapper {
    display: flex;
    gap: 20px;
    align-items: center;
    transition: all 1s ease-in-out;
  }

  &:hover {
    cursor: pointer;
    background-size: auto auto;
    background-clip: border-box;
    background-size: 200% auto;
    color: #fff;
    background-clip: text;
    text-fill-color: transparent;
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    display: inline-block;
    animation: textclip 0.8s linear;
    background-image: linear-gradient(-225deg, #ffffff 50%, #231557 50%);
  }
  @keyframes textclip {
    to {
      background-position: 200% center;
    }
  }
}
</style>
