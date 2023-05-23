<template>
  <Button
    :label="label"
    iconPos="right"
    size="small"
    :disabled="disabled"
    :loading="loading"
    @click="click()"
  ></Button>
</template>
<script setup lang="ts">
/* eslint-disable */
export interface ButtonProps {
  disabled?: boolean;
  label: string;
  loading?: boolean;
}
import Button from "primevue/button";
const props = withDefaults(defineProps<ButtonProps>(), {
  disabled: false,
  label: "button",
  loading: false,
});

function click() {
  if (props.disabled) return;
  emit("clicked");
}

const emit = defineEmits(["clicked"]);
</script>
<style></style>
