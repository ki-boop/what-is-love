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
import { ref, onMounted } from "vue";
// @ts-inore
import SockJS from "sockjs-client";
import Stomp from "stompjs";

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
// let connection = null;

// onMounted(() => {
//   const ws = new SockJS("http://localhost:8000/ws");
//   console.log(ws);
  
//   let client: Stomp.Client | null = Stomp.over(ws);
//   console.log(client);
  
//   client.connect(() => {
//     client.subscribe("/echo", (mes: any) => {
//       console.log(mes);
//     });
//   });
// });

// const socket = new WebSocket('wss://localhost:8000')
//   socket.onopen = () => {
//     console.log('WebSocket connection established.');
//     // Perform any necessary actions after the connection is established
//   };

//   socket.onmessage = (event) => {
//     console.log('Received message from WebSocket server:', event.data);
//     // Handle incoming messages from the WebSocket server
//   };

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
