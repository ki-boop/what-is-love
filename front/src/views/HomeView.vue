<template>
  <div class="chat-wrapper">
    <div v-for="chat in chatsActivity" :key="chat.id">
      <ChatListItem :product="chat"/>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ChatItemModel } from "@/models/chatItem.model";
import  ChatListItem  from "../components/common/shared/ChatListItem.vue";

const chatsActivity: ChatItemModel[] = [
  { id: "1", name: "chat 1" },
  { id: "3", name: "chat 2" },
  { id: "2", name: "chat 3" },
  { id: "1", name: "chat 1" },
  { id: "3", name: "chat 2" },
  { id: "2", name: "chat 3" },
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
</style>
