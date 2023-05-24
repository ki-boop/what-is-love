<template>
  <div class="chat-wrapper">
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
</style>
