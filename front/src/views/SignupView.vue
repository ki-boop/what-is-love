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
          :placeholder="'Логин'"
          type="text"
        ></InputForm>
        <InputForm
          v-model="form.password"
          @change="changePassword($event)"
          :placeholder="'Пароль'"
          :type="'password'"
        ></InputForm>
        <ButtonForm :label="'Войти'" @clicked="logIn()"></ButtonForm>
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { onMounted } from "vue";
import InputForm from "@/components/common/form/InputForm.vue";
import ButtonForm from "@/components/common/form/ButtonForm.vue";
import { AuthService } from "@/api/auth.service";
import { ILoginForm } from "@/models/auth.model";
import { MessageService } from "@/api/messager.service";

const form: ILoginForm = {
  login: "",
  password: "",
};

onMounted(() => {
  MessageService.initConnection();
});

function changeLogin(login: string) {
  form.login = login.toLocaleLowerCase();
}

function changePassword(password: string) {
  form.password = password.toLocaleLowerCase();
}
function logIn() {
  auth();
}

function auth() {
  AuthService.login(form.login, form.password);
}
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
    gap: 20px;
  }
}
</style>
