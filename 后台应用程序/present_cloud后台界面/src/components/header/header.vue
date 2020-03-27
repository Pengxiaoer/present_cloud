<template>
  <div class="header-box">
    <el-row type="flex" justify="space-between">
      <el-col :span="6">
        <button class="btn-tool" title="折叠" @click="collapse" >
            <i class="el-icon-d-arrow-left"></i>
        </button>
        <button class="btn-tool" title="刷新" @click="refresh">
            <i class="el-icon-refresh"></i>
        </button>
        <button class="btn-tool" title="全屏" @click="Utils.fullScreen">
            <i class="el-icon-rank"></i>
        </button>
      </el-col>
      <el-col :span="6" align="right">
        <span>{{ Utils.todayDate() }}</span>
        <el-dropdown trigger="click" class="user-name" @command="handleCommand">
          <span class="el-dropdown-link">
            {{ username }}<i class="el-icon-caret-bottom el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="logout" divided>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  inject: ['reload'],
  methods: {
    collapse () {
      this.$store.commit('switchCollapse')
    },
    refresh () {
      this.reload()
    },
    saveNotes () {
      localStorage.setItem('notes', this.notes)
    },
    handleCommand (command) {
      switch (command) {
        case 'logout':
          this.$router.replace({ path: '/login' })
          break
      }
    }
  },
  computed: {
    username () {
      let { username } = JSON.parse(sessionStorage.getItem('user'))
      return username.toUpperCase()
    }
  }
}
</script>

<style lang="scss" scoped>
  .btn-tool {
    border: none;
    background: transparent;
    font-size: 18px;
    padding: 5px 10px;
    cursor: pointer;
    outline: none;
    text-align: left;
  }
  .user-name {
    margin-left: 20px;
  }
</style>
