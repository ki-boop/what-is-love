<template>
  <div class="flex-wrapper">
    <div class="form-wrapper">
      <div class="form-header">
        <span><img src="\img\logo.svg" /></span>
      </div>
      <div class="fields">
        <InputForm
          v-model="form.login"
          @change="changeLogin($event)"
          :label="'email'"
          val=""
        ></InputForm>
        <InputForm
          v-model="form.password"
          @change="changePassword($event)"
          :label="'password'"
        ></InputForm>
        <ButtonForm :label="'Войти'"></ButtonForm>
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { ref, onMounted } from 'vue'
import SockJs from 'sockjs-client'
export interface ILoginForm {
  login: string;
  password: string;
}
import InputForm from "@/components/common/form/InputForm.vue";
import ButtonForm from "@/components/common/form/ButtonForm.vue";

const form: ILoginForm = {
  login: "",
  password: "",
};

function changeLogin(login: string) {
  form.login = login.toLocaleLowerCase();
}

function changePassword(password: string) {
  form.password = password.toLocaleLowerCase();
}
let connection = null;

onMounted(() => {
  console.log(123213);
  
  connection = new WebSocket("ws://localhost:8000/ws");
  connection.onmessage = (event) => {
    console.log(event);
  }
})


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
    margin-top: 20px;
    display: flex;
    flex-direction: column;
    gap: 10px;
  }
}
</style>
