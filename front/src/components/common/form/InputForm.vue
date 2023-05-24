<template>
    <InputText id="input" v-model="value" class="p-inputtext-sm" :placeholder="placeholder"></InputText>
</template>
<script lang="ts" setup>
/* eslint-disable */
import InputText from "primevue/inputtext";
import { ref } from "vue";
const props = defineProps({
  val: String,
  placeholder: String,
});
const value = ref(props.val);
const emit = defineEmits(["change"]);

function changeVal(event: string) {
  emit("change", event);
}
</script>

<style scoped lang="scss"></style>
