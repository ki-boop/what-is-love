<template>
  <div
    class="slider-wrapper"
    :class="props.collapsed ? 'collapsed' : 'expanded'"
  >
    <div class="profile">
      <div class="img-wrapper"><img :src="user?.image" /></div>
      <div class="user-info">
        <span class="header">{{ user?.username }}</span>
        <span class="sub-info">{{ user?.role }}</span>
      </div>
    </div>
    <OptionsBar />
  </div>
</template>
<script setup lang="ts">
import userStore from "@/store/userStore";
import { ref, defineProps } from "vue";
import OptionsBar from "./OptionsBar.vue";

let props = defineProps({
  collapsed: Boolean,
});

const user = userStore.getters.getUser;
</script>

<style scoped lang="scss">
.profile {
  padding: 10px 10px;
  display: flex;
  gap: 40px;
  color: #fff;
  font-size: 20px;

  .user-info {
    display: flex;
    flex-direction: column;
    justify-content: center;
    .sub-info {
      font-size: 14px;
    }
  }
}
.slider-wrapper {
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  background: linear-gradient(
    45deg,
    rgba(67, 101, 238, 0.9),
    rgba(215, 158, 198, 1)
  );
  transition: 1s all ease;
  height: calc(100vh - 60px);
  left: -400px;
  width: 300px;
}

.collapsed {
  animation: slider-on 0.8s;
  left: 0px;
}
.img-wrapper {
  img {
    width: 100px;
    height: 100px;
    border-radius: 50%;
  }
}
.expanded {
  animation: slider-in 2s;
}

@keyframes slider-on {
  0% {
    transform: translateX(-300px);
  }
  100% {
    transform: translateX(0px);
  }
}

@keyframes slider-in {
  0% {
    transform: translateX(0px);
  }
  100% {
    transform: translateX(-300px);
  }
}
</style>
