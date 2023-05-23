<template>
  <header>
    <nav>
      <div class="router">
          <router-link to="/auth" class="" style="margin-right: 10px;">Auth</router-link>
          <router-link to="/about">Home</router-link>
          <router-link :to="{ name: 'chats', params: { id: 1 } }">Chat</router-link>
        </div>
        <div class="user-info">
          <router-link to="/support">Write to support</router-link>
          <div class="user-name">{{ user.name }}</div>
          <div class="user-role">{{ user.role }}</div>
        </div>
        
    </nav>

  </header>
</template>

<script lang="js">
import axios from "axios";

export default {
  data() {
    return {
      user:
          {id: 1, name: 'ivan', role: 'user'}

    };
  },

  mounted() {
    this.fetchUsers();
  },

  methods: {
    fetchUsers() {
      axios.get('http://localhost')
          .then(response => {
            this.users = response.data;
          })
          .catch(error => {
            console.error(error);
          });
    }
  }

}
</script>

<style lang="scss" scoped>
header {
  height: 60px;
  border-bottom: 1px solid rgba(34, 60, 80, 0.2);
  position: relative;
  background: linear-gradient(45deg, var(--bg-blue), var(--bg-violet));
  color: #fff;
}

nav {
  display: flex;
  height: 100%;
  align-items: center;
  justify-content: space-between;
  padding: 0 20px;
}

a {
  color: #fff;
  font-size: 16px;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 10px;
}

.user-info .user-name {
  font-weight: bold;
}

.user-info .user-role {
  font-weight: bold;

  color: rgba(255, 255, 255, 0.8);
}

</style>
