<template>
    <InputText id="input" v-model="value" class="p-inputtext-sm" :placeholder="placeholder" ></InputText>
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

<style scoped lang="scss">
.p-inputtext{
  border-radius: 25px;
  //padding-right: 50px;
  //padding-left: 50px;
  text-align: center;
}

.p-inputtext-sm{
  font-size: 25px;
}
</style>
