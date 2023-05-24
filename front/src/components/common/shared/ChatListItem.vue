<template>
  <div class="product-wrapper">

    <div class="chat">
      <div class="two-header">

      </div>
      <div class="name-product">
        {{ product?.name }}
      </div>
      <div class="phone-product">
      </div>
    </div>
    <div class="question">
      <img src="@/views/question.png" width="20" height="20" class="image">
      <button class="text-question"
              style="color: rgba(255,255,255,0.5); text-decoration:none; border: none; font-size: 12px">
        Задать вопрос о товаре или оплате
      </button>
    </div>
    <div class="price-phone">
      <div class="price-product">
        <div class="number-price"> {{ product?.price }}</div>
        <div class="well">руб.</div>
      </div>
    </div>
    <div class="btn">
      <div class="button-phone">
        <button class="text-question-more"
                style="color: white; text-decoration: none; border: white; font-size: 20px">
          Подробнее
        </button>
      </div>
      <div class="button-phone-buy">
        <button class="text-question-buy"
                style="color: white; text-decoration: none; border: white; font-size: 20px">
          Купить
        </button>
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import {ChatItemModel} from "@/models/chatItem.model";
/* eslint-disable */

defineProps({
  product: ChatItemModel,
});
</script>
<style lang="scss" scoped>
.product-wrapper {
  width: 350px;
  height: 400px;
  background: rgba($color: #f7feff, $alpha: 1);
  border-radius: 10px;
  transition: box-shadow ease 0.2s;

  &:hover {
    box-shadow: 0px 0px 4px 4px rgba($color: #9f9f9f, $alpha: 0.2);
    //cursor: pointer;
  }
}

.chat {
  display: flex;
  padding: 10% 8% 7% 15%;
}

.name-product {
  color: white;
  font-size: 30px;
  font-weight: 500;
  display: flex;
  align-items: center;
}

.phone-product {
  background: rgb(147, 68, 159);
  width: 75px;
  height: 75px;
  border-radius: 10px;
  margin-left: 87px;
}

.image {
  opacity: 0.4;
  filter: alpha(opacity=40);

}

.text-question {
  background-color: transparent;
  border: none;
  color: #000;
  text-decoration: underline;
  cursor: pointer;
  margin-left: 10px;
}

.question {
  display: flex;
  align-items: center;
  margin-left: 7%;
}

.price-phone {
  background: rgba(208, 184, 184, 0.5);
  width: 315px;
  height: 100px;
  border-radius: 10px;
  margin: 5% 5% 5% 5%;
  display: flex;
  align-items: center;
}

.price-product {
  color: white;
  display: flex;
  margin-left: 5%;
}

.number-price {
  font-size: 35px;
  font-weight: 500;
}

.well {
  display: flex;
  align-items: center;
  margin-top: 15px;
  margin-left: 5px;
}

.button-phone {
  background: rgba(23, 23, 23, 0.01);
  border: 1px solid rgba(252, 247, 247, 0.5);
  border-radius: 10px;
  text-align: center;
  margin-left: 15px;
  transition: background-color 0.5s ease;

}

.text-question-more {
  background-color: transparent;
  border: none;
  color: #000;
  text-decoration: underline;
  cursor: pointer;
  padding: 5px 20px 10px 20px;
}

.button-phone-buy{
  background: rgba(23, 23, 23, 0.01);
  border: 1px solid rgba(252, 247, 247, 0.5);
  border-radius: 10px;
  text-align: center;
  margin-left: 25px;
  padding: 5px 40px 10px 40px;
  transition: background-color 0.5s ease;
}

.text-question-buy{
  background: none;
  border: none;
  color: #000;
  text-decoration: underline;
  cursor: pointer;
}

.btn{
  display: flex;
}

.button-phone-buy:hover{
  background: rgba(62, 217, 217, 0.38);
}

.button-phone:hover{
  background: rgba(62, 217, 217, 0.38);
}

</style>
