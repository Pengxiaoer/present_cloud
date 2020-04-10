<template>
  <div class="console">
    <div>
        <h1 class = "text">欢 迎 来 到 “ 到 云 ” 后 台 管 理 系 统</h1>
        <br/>
        <br/>
        <br/>
        <br/>
        <img v-show="!isCollapse" src="./../assets/show.jpg" alt="ELementUI">
      </div>
  </div>
</template>

<script>
export default {
}
</script>

<style lang="scss" scoped>
  .console {
    font-size: 30px;
    text-align: center;
  }
  .text{
    font-size: 50px;
    text-align: center;
  }
</style>
