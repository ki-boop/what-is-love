<template>
  <div class="dialog">
    <img :src="dialog?.user.image" />
    <div class="info">
      <div class="title">{{ dialog?.user.username }}</div>
      <div class="msg">{{ dialog?.lastMessage }}</div>
    </div>
    <div class="sub-info">
      <!-- <span class="time">00:01</span> -->
    </div>
  </div>
</template>
<script lang="ts" setup>
import { ShortDialog } from "@/models/dialog.model";
/* eslint-disable */
defineProps({
  dialog: ShortDialog,
});
</script>
<style lang="scss" scoped>
.dialog {
  width: 100%;
  height: 100px;
  border-bottom: 1px solid rgba(228, 228, 228, 0.9);
  display: flex;
  align-items: center;
  gap: 10px;
  transition: all;

  &:hover {
    cursor: pointer;
    background-color: rgb(32, 53, 156);
  }
}

.info {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
img {
  width: 70px;
  height: 70px;
  border-radius: 50%;
}
.msg,
.time {
  font-size: 12px;
}
</style>
