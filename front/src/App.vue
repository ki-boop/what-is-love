<template>
  <NavHeader />
  <router-view />
</template>

<script lang="ts" setup>
import "primevue/resources/primevue.min.css";
import "primevue/resources/themes/lara-light-indigo/theme.css";
import NavHeader from "./components/common/NavHeader.vue";
</script>

<style lang="scss">
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
  font-size: 16px;
  --bg-blue: #9ec7ff;
  --bg-violet: #c4b8ff;
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
</style>
