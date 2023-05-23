<template>
  <header>
    <nav>
      <div class="router">
        <!-- <span class="logo">[ mang ]<strong> CHAT</strong></span> -->
      </div>
      <div class="user-info">
        <router-link to="/auth"><span class="pi pi-user" style="font-size: 1.2rem"></span></router-link>
        <router-link :to="{ name: 'chats', params: { id: 1 } }">
          <span class="pi pi-comment" style="font-size: 1.2rem"></span
        ></router-link>
        <ThemeSwitcher/>
        
      </div>
    </nav>
  </header>
</template>

<script lang="ts" setup>
  import ThemeSwitcher from "../common/shared/ThemeSwitcher.vue"
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
.logo {
  font-weight: bold;
  letter-spacing: 1px;
}

a {
  color: #fff;
  font-size: 16px;
}
.pi :hover {
  cursor: pointer;
}
.router {
  display: flex;
  gap: 30px;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 20px;
}

.user-info .user-name {
  font-weight: bold;
}

.user-info .user-role {
  font-weight: bold;

  color: rgba(255, 255, 255, 0.8);
}
</style>
