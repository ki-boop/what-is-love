<template>
  <div class="chat-wrapper">
    <div class="chat-list">
      <DialogItem v-for="chat in chatList" :key="chat.id" :dialog="chat" />
    </div>
    <div class="dialog-window">
      <div class="header">DASDASD sdasd</div>
      <div class="window">
        <div v-for="mes in messages" v-bind:key="mes">
        {{ mes }}</div>
      </div>
      <div class="input">
        <InputText v-model="mes"/>
        <Button @click="send()"/>
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { ShortDialog } from "@/models/dialog.model";
import { image } from "@/models/user.model";
import DialogItem from "@/components/common/shared/DialogItem.vue";
import InputText from "primevue/inputtext";
import Button from "primevue/button";
import { onMounted, ref } from "vue";
import { MessageService } from "@/api/messager.service";

const mes = ref('');
const messages = ref(['']);


function send() {
  messages.value.push(mes.value);
  mes.value = '';
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
    width: 30%;
    height: 70vh;
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
    width: 70%;
    height: 70vh;
    border: 1px solid black;
  }

  .dialog-window {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }
}
</style>
