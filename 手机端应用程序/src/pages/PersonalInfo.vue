<template>
  <div>
    <div>
      <x-header :left-options="{backText: ''}">个人信息</x-header>
    </div>
    <div>
      <div class="list">
        <group>
          <cell :title="'姓名'" >{{name}}</cell>
          <cell :title="'学号'" >{{stno}}</cell>
          <cell :title="'学院'" >{{academy}}</cell>
          <cell :title="'专业'" >{{majors}}</cell>
          <cell :title="'手机'" >{{tel}}</cell>
        </group>
      </div>
    </div>
  </div>
</template>

<script>
import { Group, Cell, XHeader, XInput, XButton } from 'vux'
import axios from 'axios'
export default {
  name: 'PersonalInfo',
  components: {
    Group,
    Cell,
    XHeader,
    XInput,
    XButton
  },
  data () {
    return {
      userName: '',
      name: '',
      majors: '',
      academy: '',
      tel: '',
      stno: '',
      list: []
    }
  },
  mounted () {
    this.showData()
  },
  // 存放方法
  methods: {
    showData: function () {
      this.userName = localStorage.getItem('username')
      console.log(this.userName)
      axios.get('http://101.132.46.183:8080/Self', {
        params: {
          stno: this.userName
        }
      }).then((response) => {
        // 响应正确回调
        console.log(response.data)
        //         this.infoList = response.data// 把数据存放到data中
        console.log(response.data.data.name)
        console.log(response.data.data.major)
        console.log(response.data.data.academy)
        console.log(response.data.data.stno)
        console.log(response.data.data.tel)
        this.name = response.data.data.name
        this.majors = response.data.data.major
        this.academy = response.data.data.academy
        this.stno = response.data.data.stno
        this.tel = response.data.data.tel
      }, (response) => {
        // 响应错误回调
      })
    }
  }
}
</script>

<style lang="less" scoped>
  .flex-demo{
    font-weight: 500;
    font-size: 15px;
  }
</style>
