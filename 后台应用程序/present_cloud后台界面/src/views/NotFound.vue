<template>
  <div class="error-page">
    <div class="error-desc">404！Sorry, Not Found the Page :)</div>
    <div class="error-handle">
        <router-link to="/console">
            <el-button type="primary" size="large">返回首页</el-button>
        </router-link>
          <el-button class="error-btn" type="primary" size="large" @click="goBack">返回上一页</el-button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goBack () {
      this.$router.go(-1)
    }
  }
}
</script>

<style lang="scss" scoped>
    .error-page{
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        width: 100%;
        height: 100%;
        background: #f3f3f3;
        box-sizing: border-box;
    }
    .error-desc {
      font-size: 30px;
      letter-spacing: 5px;
      text-align: center;
      margin-top: 150px;
    }
    .error-handle{
      margin-top: 80px;
      padding-bottom: 200px;
    }
    .error-btn{
      margin-left: 80px;
    }
</style>
