<template>
  <input id="toggle" class="toggle" type="checkbox" @click="changeTheme()" />
  <div class="background"></div>
</template>

<script setup lang="ts">
let theme = localStorage.getItem("app-theme") || "light";
function changeTheme() {
  if (theme === "light") theme = "dark";
  else theme = "light";
  document.documentElement.setAttribute("data-theme", theme);
  localStorage.setItem("app-theme", theme);
}
</script>

<style lang="scss" scoped>
.toggle {
  --size: 1.4rem;

  appearance: none;
  outline: none;
  cursor: pointer;

  width: var(--size);
  height: var(--size);
  box-shadow: inset calc(var(--size) * 0.33) calc(var(--size) * -0.25) 0;
  border-radius: 999px;
      color: #fff;

  transition: all 500ms;

  &:checked {
    --ray-size: calc(var(--size) * -0.4);
    --offset-orthogonal: calc(var(--size) * 0.65);
    --offset-diagonal: calc(var(--size) * 0.45);

    transform: scale(0.75);
      color: #fff;
    box-shadow:
      inset 0 0 0 var(--size),
      calc(var(--offset-orthogonal) * -1) 0 0 var(--ray-size),
      var(--offset-orthogonal) 0 0 var(--ray-size),
      0 calc(var(--offset-orthogonal) * -1) 0 var(--ray-size),
      0 var(--offset-orthogonal) 0 var(--ray-size),
      calc(var(--offset-diagonal) * -1) calc(var(--offset-diagonal) * -1) 0 var(--ray-size),
      var(--offset-diagonal) var(--offset-diagonal) 0 var(--ray-size),
      calc(var(--offset-diagonal) * -1) var(--offset-diagonal) 0 var(--ray-size),
      var(--offset-diagonal) calc(var(--offset-diagonal) * -1) 0 var(--ray-size),
    ;
  }
}


.background {
  --bg: hsl(240, 100%, 10%);
  background: var(--bg);
  position: fixed;
  transition: background 500ms;
}

.toggle {
  z-index: 1;
  &:checked {
    & ~ .background {
      --bg: white;
    }
  }
}

.title {
  --color: color: #fff;
  color: var(--color);
  z-index: 1;
  cursor: pointer;
  display: block;
  padding: 0.5rem 0 0;
  transition: color 500ms;
}
</style>
