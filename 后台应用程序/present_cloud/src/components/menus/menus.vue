<template>
  <el-menu
    class="menu-nav"
    router
    :default-active="currentPath"
    background-color="#20222A"
    text-color="rgba(255,255,255,.8)"
    active-text-color="#ffd04b"
    :collapse="isCollapse">
    <el-menu-item index="/console">
      <i class="el-icon-location"></i>
      <span slot="title">主页</span>
    </el-menu-item>
    <el-submenu index="1">
      <template slot="title">
        <i class="el-icon-user"></i>
        <span>个人设置</span>
      </template>
      <el-menu-item index="/password">个人设置</el-menu-item>
    </el-submenu>
    <el-submenu index="2">
      <template slot="title">
        <i class="el-icon-star-off"></i>
        <span>权限</span>
      </template>
      <el-menu-item index="/account">账号管理</el-menu-item>
      <el-menu-item index="/system">系统设置</el-menu-item>
    </el-submenu>
    <el-submenu index="3">
      <template slot="title">
        <i class="el-icon-document"></i>
        <span>课程管理</span>
      </template>
      <el-menu-item index="/curriculum">课程管理</el-menu-item>
      <el-menu-item index="/check">考勤管理</el-menu-item>
    </el-submenu>
    <el-submenu index="4">
      <template slot="title">
        <i class="el-icon-menu"></i>
        <span>数据字典</span>
      </template>
      <el-menu-item index="datad">数据字典</el-menu-item>
      <el-menu-item index="datadm">数据字典管理</el-menu-item>
    </el-submenu>
    <el-submenu index="5">
      <template slot="title">
        <i class="el-icon-more"></i>
        <span>关于我们</span>
      </template>
      <el-menu-item index="/aboutus">关于我们</el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  props: ['isCollapse'],
  data () {
    return {
      currentPath: location.pathname
    }
  }
}
</script>

<style lang="scss" scoped>
  .el-menu {
    border: none;
  }
  .menu-nav:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }
</style>
