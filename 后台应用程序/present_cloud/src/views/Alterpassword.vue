<template>
  <div class = "text">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/console' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-form-item label="原密码" prop="pass">
          <el-input type="password" v-model="changePwd.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="新密码" prop="passNew">
          <el-input type="password" v-model="changePwd.passNew" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPass">
          <el-input type="password" v-model="changePwd.checkPass" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('changePwd')">提交</el-button>
          <el-button @click="resetForm('changePwd')">重置</el-button>
        </el-form-item>
        </el-form>
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
