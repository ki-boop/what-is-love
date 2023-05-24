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
<style>
.p-button{
  border-radius: 25px;
  border: none;
  background: linear-gradient( 50deg, rgb(255, 46, 218), rgb(255, 116, 158));
  margin-right: 50px;
  margin-left: 50px;
}

.p-button-sm{
  margin-right: 30px;
  margin-left: 30px;
  margin-bottom: 15px;
}

.p-button-label{
  font-size: 25px;
}
</style>
