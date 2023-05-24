<template>
  <div class="product-wrapper">
    <div>{{ product?.id }}</div>
  </div>
</template>
<script lang="ts" setup>
import { ChatItemModel } from "@/models/chatItem.model";
/* eslint-disable */

defineProps({
  product: ChatItemModel,
});
</script>
<style lang="scss" scoped>
.product-wrapper {
  width: 300px;
  height: 400px;
  background: rgba($color: #f7feff, $alpha: 1);
  border-radius: 10px;
  transition: box-shadow ease 0.2s;

  &:hover {
    box-shadow: 0px 0px 4px 4px rgba($color: #9f9f9f, $alpha: 0.2);
    cursor: pointer;
  }
}
</style>
