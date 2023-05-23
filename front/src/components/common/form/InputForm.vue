<template>
  <span class="p-float-label">
    <InputText
      id="input"
      name="input"
      type="text"
      v-bind="val"
      @update:model-value="changeVal($event)"
      class="p-inputtext-sm"
    ></InputText>
    <label for="input">{{ label || "" }}</label>
  </span>
</template>
<script lang="ts" setup>
/* eslint-disable */
import InputText from "primevue/inputtext";
defineProps({
  val: String,
  label: String,
});
const emit = defineEmits(["change"]);

function changeVal(event: string) {
  emit("change", event);
}
</script>

<style scoped lang="scss"></style>
