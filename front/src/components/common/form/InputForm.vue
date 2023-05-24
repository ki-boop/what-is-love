<template>
  <span class="p-float-label">
    <InputText
      id="input"
      v-model="value"
      @update:model-value="changeVal($event)"
      class="p-inputtext-sm"
      :type="type"
    ></InputText>
    <label for="input">{{ label || "" }}</label>
  </span>
</template>
<script lang="ts" setup>
/* eslint-disable */
import InputText from "primevue/inputtext";
import { ref } from "vue";
const props = defineProps({
  val: String,
  label: String,
  type: String,
});
const value = ref(props.val);
const emit = defineEmits(["change"]);

function changeVal(event: string) {
  emit("change", event);
}
</script>

<style scoped lang="scss"></style>
