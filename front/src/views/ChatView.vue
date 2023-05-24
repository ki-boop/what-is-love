<template>
  <div class="chat-wrapper">
    <div class="circle1"></div>
    <div class="circle2"></div>
    <div class="circle3"></div>
    <div class="circle4"></div>
    <div class="circle5"></div>
    <div class="circle6"></div>
    <div class="circle7"></div>
    <div class="chat-list">
      <DialogItem v-for="chat in chatList" :key="chat.id" :dialog="chat" />
    </div>
    <div class="dialog-window">
      <div class="header">DASDASD sdasd</div>
      <div class="chat">
        <MessageItem
          v-for="mes in messages"
          v-bind:key="mes.message"
          :message="mes.message"
          :self="mes.self"
        />
      </div>
      <div class="input-wrapper">
        <InputText
          v-model="mes"
          v-on:keyup.enter="send()"
          :placeholder="'Написать сообщение'"
          :pt="{
            root: { class: 'send-input' },
          }"
        />
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { ShortDialog } from "@/models/dialog.model";
import { image } from "@/models/user.model";
import DialogItem from "@/components/common/shared/DialogItem.vue";
import InputText from "primevue/inputtext";
import { onMounted, ref } from "vue";
import { MessageService } from "@/api/messager.service";
import MessageItem from "@/components/common/shared/MessageItem.vue";

const mes = ref("");
const messages = ref([{message: 'adasdadasd', self: true}, { message: 'adasdadasd', self: false }]);

function send() {
  messages.value.push({message: mes.value, self: true});
  mes.value = "";
}

onMounted(() => {
  MessageService.initConnection();
});

const chatList: ShortDialog[] = [
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "sdfksldmflkdsmflksdmf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
  {
    id: "1",
    user: {
      id: "1",
      role: "",
      username: "Slkdmalsd KLLKDs",
      image: image,
    },
    lastMessage: "RErerererererekjnfskjf",
  },
];
</script>
<style lang="scss" scoped>
.chat-wrapper {
  display: flex;
  width: 100%;
  height: 100%;

  .chat-list {
    width: 40%;
    height: calc(100vh - 70px);
    overflow-y: scroll;
    &::-webkit-scrollbar {
      width: 3px;
      height: 3px;
    }

    &::-webkit-scrollbar-track {
      background: transparent;
    }

    &::-webkit-scrollbar-thumb {
      background: transparent;
      border-radius: 10px;
    }
  }
  .dialog-window {
    width: 60%;
    height: calc(100vh - 70px);
    border: 1px solid black;
  }
  .input-wrapper {
    display: flex;
    gap: 20px;
    padding: 0px 20px;
    .send-input {
      width: 100%;
      border-radius: 20px;
    }
  }

  .dialog-window {
    display: flex;
    flex-direction: column;
    justify-content: space-between;

    .header {
      height: 60px;
      border-bottom: 1px solid black;
      display: flex;
      align-items: center;
      padding-left: 40px;
    }

    .chat {
      height: 100%;
      display: flex;
      flex-direction: column;
      gap: 20px;
      overflow-y: scroll;
      margin-bottom: 20px;
      padding: 0 20px;
      padding-top: 20px;
      overflow-x: hidden;
    }
  }
}

.circle1 {
  position: absolute;
  background: radial-gradient(circle, rgba(237, 136, 228, 0.8), rgba(252, 124, 169, 0.8));
  border-radius: 50%;
  width: 300px;
  height: 300px;
  z-index: -1;
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
