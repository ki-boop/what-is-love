<template>
  <div class="container">
    <div class="column">
      <div class="home">
        <h1>Activity chats</h1>
      </div>
      <div class="chat" v-for="chatActivity in chatsActivity" :key="chatActivity.id">
        <div class="chat-info"><strong>Name:</strong> {{ chatActivity.name }}</div>
      </div>
    </div>

    <div class="column">
      <div class="home">
        <h1>History chats</h1>
      </div>
      <div class="chat" v-for="chatHistory in chatsHistory" :key="chatHistory.id">
        <div class="chat-info"><strong>Name:</strong> {{ chatHistory.name }}</div>
      </div>
    </div>
  </div>
</template>

<script lang="js" >
import axios from "axios";

export default {
  data() {
    return {
      chatsActivity: [
        {id: 1, name: 'chat 1'},
        {id: 3, name: 'chat 2'},
        {id: 2, name: 'chat 3'},
      ],
      chatsHistory: [
        {id: 1, name: 'chat 1'},
        {id: 3, name: 'chat 2'},
        {id: 2, name: 'chat 3'},
      ]
    };
  },
  mounted() {
    this.fetchChatActivity();
    this.fetchChatHistory();
  },
  methods: {
    fetchChatActivity() {
      axios.get('http://localhost')
          .then(response => {
            this.chatsActivity = response.data;
          })
          .catch(error => {
            console.error(error);
          });
    },
    fetchChatHistory() {
      axios.get('http://localhost')
          .then(response => {
            this.chatsHistory = response.data;
          })
          .catch(error => {
            console.error(error);
          });
    }
  }
}
</script>

<style lang="scss">
.container {
  display: flex;
  gap: 20px;
}

.column {
  flex: 1;
}

.home h1 {
  font-size: 20px;
  margin-bottom: 10px;
}

.chat {
  background-color: #f5f5f5;
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 4px;
}

.chat-info {
  font-size: 14px;
  margin-bottom: 5px;
}

.chat-info strong {
  font-weight: bold;
}
</style>