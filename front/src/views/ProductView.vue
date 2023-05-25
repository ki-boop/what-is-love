<template>
  <div class="flex-wrapper">
    <div class="circle1"></div>
    <div class="circle2"></div>
    <div class="circle3"></div>
    <div class="circle4"></div>
    <div class="circle5"></div>
    <div class="circle6"></div>
    <div class="circle7"></div>
    <div class="product-wrapper">
      <div class="product-header">

      </div>

      <div class="product-name">

        <div>awdawdawd</div>
        <div>1111115</div>

      </div>

      <div>
        <p>Задать вопрос о данном товаре</p>
        <h1>3500</h1>
      </div>


      <div class="product-name">

        <div>awdawdawd</div>
        <div>1111115</div>

      </div>


      <div class="fields">

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
.product-wrapper {
  margin: 30vh;
  width: 400px;
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: 10px;
  border: 1px solid rgba(34, 60, 80, 0.2);
  padding: 20px;

  .product-header {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 40px;
  }

  .product-name {
    display: flex;

  }

  .fields {
    margin-top: 20px;
    display: flex;
    flex-direction: column;
    gap: 20px;
  }
}

.circle1 {
  position: absolute;
  background: radial-gradient(circle, rgba(237, 136, 228, 0.8), rgba(252, 124, 169, 0.8));
  border-radius: 50%;
  width: 300px;
  height: 300px;
  z-index: 0;
  top: 0;
  left: 0;
  transform: translate(-20%, -10%);
  filter: blur(2px);
}
.circle2 {
  position: absolute;
  background: radial-gradient(circle, rgb(198, 193, 247), rgb(145, 141, 209));
  border-radius: 50%;
  width: 100px;
  height: 100px;
  z-index: -1;
  top: 150px;
  left: 170px;
  filter: blur(2px);
}
.circle3 {
  position: absolute;
  background: radial-gradient(circle, rgb(255, 199, 252), rgb(239, 131, 249));
  border-radius: 50%;
  width: 200px;
  height: 200px;
  z-index: -1;
  top: 150px;
  left: 1100px;
  transform: translate(-20%, -10%);
  filter: blur(1px);
}
.circle4 {
  position: absolute;
  background: radial-gradient(circle, rgb(198, 193, 247), rgb(145, 141, 209));
  border-radius: 50%;
  width: 70px;
  height: 70px;
  z-index: -1;
  top: 580px;
  left: 1150px;
  transform: translate(-20%, -10%);
  filter: blur(1px);
}
.circle5 {
  position: absolute;
  background: radial-gradient(circle, rgb(254, 189, 250), rgb(237, 133, 251));
  border-radius: 50%;
  width: 250px;
  height: 250px;
  z-index: -1;
  top: 650px;
  left: 650px;
  transform: translate(-20%, -10%);
  filter: blur(5px);
}
.circle6 {
  position: absolute;
  background: radial-gradient(circle, rgb(255, 188, 236), rgb(255, 108, 152));
  border-radius: 50%;
  width: 90px;
  height: 90px;
  z-index: 0;
  top: 580px;
  left: 1700px;
  transform: translate(-20%, -10%);
  filter: blur(2px);
}
.circle7 {
  position: absolute;
  background: linear-gradient(rgb(220, 149, 255), rgb(165, 168, 255));
  border-radius: 50%;
  width: 500px;
  height: 500px;
  z-index: -1;
  top: 600px;
  left: 1750px;
  transform: translate(-20%, -10%);
  filter: blur(10px);
}
</style>
