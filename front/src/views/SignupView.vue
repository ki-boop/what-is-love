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
          :label="'Логин'"
        ></InputForm>
        <InputForm
          v-model="form.password"
          @change="changePassword($event)"
          :label="'Пароль'"
        ></InputForm>
        <ButtonForm :label="'Войти'" @clicked="foo()"></ButtonForm>
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { onMounted } from "vue";
// @ts-inore
import SockJS from "sockjs-client";
import Stomp from "stompjs";
import { useToast } from "primevue/usetoast";
const toast = useToast();

export interface ILoginForm {
  login: string;
  password: string;
}
import InputForm from "@/components/common/form/InputForm.vue";
import ButtonForm from "@/components/common/form/ButtonForm.vue";
import { showCustomNotification } from "@/utils/notification";

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
function foo() {
  toast.add({
    severity: "success",
    summary: "Success Message",
    detail: "Message Content",
    life: 3000,
  });
}
onMounted(() => {
  // connectWS();
});

function connectWS() {
  const ws = new SockJS("http://localhost:8000/ws");

  let client: Stomp.Client | null = Stomp.over(ws);

  client.connect({}, () => {
    client.subscribe("/echo", (mes: any) => {
      console.log(mes);
    });
  });
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
