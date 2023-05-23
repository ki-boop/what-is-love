<template>
  <div class="flex-wrapper">
    <div class="form-wrapper">
      <div class="form-header"><span>Logo</span></div>
      <div class="fields">
        <InputForm :foo="'asdasd'"></InputForm>
        <InputForm></InputForm>
        <InputForm></InputForm>
        <ButtonForm></ButtonForm>
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import InputForm from "@/components/common/form/InputForm.vue";
import ButtonForm from "@/components/common/form/ButtonForm.vue";

</script>
<style scoped lang="scss">
.form-wrapper {
  margin: 30vh;
  width: 400px;
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: 10px;
  border: 1px solid rgba(34, 60, 80, 0.2);
  padding: 20px;

  .form-header {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 40px;
  }
  .fields {
    display: flex;
    flex-direction: column;
    gap: 10px;
  }
}
</style>
