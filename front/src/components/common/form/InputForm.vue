<template>
  <span class="p-float-label">
    <InputText type="text" class="p-inputtext-sm"></InputText>
    <label for="username">{{ label }}</label>
  </span>
</template>
<script lang="ts" setup>
/* eslint-disable */
import InputText from "primevue/inputtext";
defineProps({
  label: String,
});
</script>

<style scoped lang="scss"></style>
