<template>
  <div class="chat-wrapper">
    <div class="circle1"></div>
    <div class="circle2"></div>
    <div class="circle3"></div>
    <div class="circle4"></div>
    <div class="circle5"></div>
    <div class="circle6"></div>
    <div class="circle7"></div>
    <div v-for="chat in chatsActivity" :key="chat.id">
      <ChatListItem :product="chat" class="product"/>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ChatItemModel } from "@/models/chatItem.model";
import  ChatListItem  from "../components/common/shared/ChatListItem.vue";

const chatsActivity: ChatItemModel[] = [
  { id: "1", name: "Товар 1", price: 3500, },
  { id: "3", name: "Товар 2", price: 2700, },
  { id: "2", name: "Товар 3", price: 3700, },
];
const chatsHistory = [
  { id: "1", name: "chat 1" },
  { id: "3", name: "chat 2" },
  { id: "2", name: "chat 3" },
];
</script>

<style lang="scss" scoped>
.chat-wrapper {
  display: flex;
  flex-wrap: wrap;
  gap: 50px;
  padding: 20px 30px;
  justify-content: space-evenly;
}

.circle1 {
  position: absolute;
  background: radial-gradient(circle, rgba(237, 136, 228, 0.8), rgba(252, 124, 169, 0.8));
  border-radius: 50%;
  width: 300px;
  height: 300px;
  z-index: -1;
  top: 0;
  left: 0;
  transform: translate(-20%, -10%);
  filter: blur(2px);
}

.circle2 {
  position: absolute;
  background: radial-gradient(circle, rgb(198, 193, 247), rgb(145, 141, 209));
  border-radius: 50%;
  width: 100px;
  height: 100px;
  z-index: -1;
  top: 150px;
  left: 170px;
  filter: blur(2px);
}

.circle3 {
  position: absolute;
  background: radial-gradient(circle, rgb(255, 199, 252), rgb(239, 131, 249));
  border-radius: 50%;
  width: 200px;
  height: 200px;
  z-index: -1;
  top: 150px;
  left: 1100px;
  transform: translate(-20%, -10%);
  filter: blur(1px);
}

.circle4 {
  position: absolute;
  background: radial-gradient(circle, rgb(198, 193, 247), rgb(145, 141, 209));
  border-radius: 50%;
  width: 70px;
  height: 70px;
  z-index: -1;
  top: 580px;
  left: 1150px;
  transform: translate(-20%, -10%);
  filter: blur(1px);
}

.circle5 {
  position: absolute;
  background: radial-gradient(circle, rgb(254, 189, 250), rgb(237, 133, 251));
  border-radius: 50%;
  width: 250px;
  height: 250px;
  z-index: -1;
  top: 650px;
  left: 650px;
  transform: translate(-20%, -10%);
  filter: blur(5px);
}

.circle6 {
  position: absolute;
  background: radial-gradient(circle, rgb(255, 188, 236), rgb(255, 108, 152));
  border-radius: 50%;
  width: 90px;
  height: 90px;
  z-index: 0;
  top: 580px;
  left: 1700px;
  transform: translate(-20%, -10%);
  filter: blur(2px);
}

.circle7 {
  position: absolute;
  background: linear-gradient(rgb(220, 149, 255), rgb(165, 168, 255));
  border-radius: 50%;
  width: 500px;
  height: 500px;
  z-index: -1;
  top: 600px;
  left: 1750px;
  transform: translate(-20%, -10%);
  filter: blur(10px);
}

.product{
  background: linear-gradient(150deg, rgb(85, 68, 159), rgba(250, 248, 248, 0.2));
}
</style>
