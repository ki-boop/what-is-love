<template>
  <div :class="self ? 'my-message' : 'companion-message'" class="msg">
    <span class="text">{{ message }}</span>
    <span class="time">16:35</span>
  </div>
</template>
<script setup lang="ts">
import { defineProps } from "vue";
defineProps({
  message: String,
  self: Boolean,
});
</script>
<style lang="scss" scoped>
.my-message {
  align-self: flex-end;
  .text {
    background: linear-gradient(95.17deg, #ff8caf 8.18%, #ff6895 83.23%);
  }

  &::after {
    margin-left: -5px;
    right: -21px;
  }

  &::before {
    right: -11px;
    margin-left: -5px;
    background: linear-gradient(95.17deg, #ff8caf 8.18%, #ff6895 83.23%);
  }
}
.companion-message {
  align-self: flex-start;
  .text {
    background: linear-gradient(
      88.34deg,
      #8044ff 10.86%,
      rgba(170, 224, 255, 0.865479) 102.55%
    );
  }

  &::before {
    left: -11px;
    margin-right: -5px;

    background: linear-gradient(
      88.34deg,
      #8044ff 10.86%,
      rgba(170, 224, 255, 0.865479) 102.55%
    );
  }

  &::after {
    margin-right: -5px;
    left: -21px;
  }
}

.msg {
  display: inline-block;
  position: relative;
  color: #fff;
}
.time {
  position: absolute;
  right: 5px;
  bottom: 0;
  font-size: 10px;
}

.msg > .text {
  border-radius: 0.4em;
  display: inline-block;
  padding: 10px 20px 10px 30px;
  z-index: 1;
}

.msg::after {
  background-color: #ffffff;
  border-radius: 0 0 50% 0;
  border-right: 0;
  bottom: 14px;
  content: "";
  height: 30px;
  margin-top: -5px;
  position: absolute;
  width: 30px;
  z-index: -1;
}

.msg::before {
  border-radius: 50%;
  border-right: 0;
  bottom: 7px;
  content: "";
  height: 30px;
  margin-top: -5px;
  position: absolute;
  width: 30px;
  z-index: -1;
}
</style>
Х
