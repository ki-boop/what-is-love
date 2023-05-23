<template>
  <header>
    <nav>
      <router-link to="/auth">Auth</router-link>
      <router-link to="/about">Home</router-link>
    </nav>
  </header>
</template>

<script lang="ts" setup></script>

<style lang="scss" scoped>
header {
  height: 60px;
  border-bottom: 1px solid rgba(34, 60, 80, 0.2);
  position: relative;
  background: linear-gradient(45deg, var(--bg-blue), var(--bg-violet));
  color: #fff;

  nav {
    display: flex;
    height: 100%;
    align-items: center;
    justify-content: center;
    gap: 20px;

    a {
      color: #fff;
      font-size: 16px;
    }
  }
}
</style>
