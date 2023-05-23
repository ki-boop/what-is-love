<template>
  <div class="home">
    <h1>List your chats</h1>
  </div>
  <div class="chat" v-for="chat in chats" :key="chat.id">
    <div><strong>Name:</strong> {{ chat.name }}</div>
  </div>
</template>

<script lang="js" >
import axios from "axios";

export default {
  data() {
    return {
      chats: [
        {id: 1, name: 'chat 1'},
        {id: 3, name: 'chat 2'},
        {id: 2, name: 'chat 3'},
      ]
    };
  },
  mounted() {
    this.fetchChat();
  },
  methods: {
    fetchChat() {
      axios.get('http://localhost')
          .then(response => {
            this.chats = response.data;
          })
          .catch(error => {
            console.error(error);
          });
    }
  }
}
</script>
