<template>
  <div>
    <div>
      <x-header :left-options="{backText: ''}">课程详情</x-header>
      <div style="padding: 40px 50px 0 70px">
        <flexbox orient="vertical">
          <p @click="getParams()">test</p>
          <flexbox-item><div class="flex-demo" >课程：<p ref="ClassNumber"></p></div></flexbox-item>
          <flexbox-item><div class="flex-demo">考试时间：{{Times}}</div></flexbox-item>
          <flexbox-item><div class="flex-demo">任课老师：{{Teacher}}</div></flexbox-item>
        </flexbox>
      </div>
    </div>
  </div>
</template>

<script>
import { Group, Cell, XHeader, XInput, XButton, Flexbox, FlexboxItem } from 'vux'
import axios from 'axios'
import qs from 'qs'
export default {
  name: 'CourseInfo',
  data () {
    return {
      test: '180327001',
      CourseName: '',
      ClassNumber: '',
      Times: '',
      Teacher: ''
    }
  },
  components: {
    Group,
    Cell,
    XHeader,
    XInput,
    XButton,
    Flexbox,
    FlexboxItem
  },
  watch: {
    // detection route
    '$router': 'getParams'
  },
  methods: {
    posts: function () {
      axios.post('http://47.106.217.11:8083/login', qs.stringify({
        stno: '180327001',
        password: '654321'
      }), {
        emulateJSON: true
      }, {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
        }
      }).then(res => {
        console.log(res.data)
      })
        .catch(function (error) {
          console.log(error)
        })
    },
    gets: function () {
      axios.get('http://47.106.217.11:8083/Student/SignRecord', {
        params: {
          courseid: 2,
          studentid: '180327001'
        }
      }).then(function (response) { 
        console.log(response)
      }).catch(function (error) { 
        console.log(error)
      })
    },
    dels: function () {
      axios.delete('http://47.106.217.11:8083/User', {
        params: {
          stno: '180327008'
        }
      }).then(function (response) { 
        console.log(response)
      }).catch(function (error) { 
        console.log(error)
      })
    },
    put: function () {
      axios.put('http://47.106.217.11:8083/Student/SignRecord', {
        courseid: 1,
        studentid: '180327001'
      }).then(function (response) { 
        console.log(response)
      }).catch(function (error) { 
        console.log(error)
      })
    },
    getParams: function () {
      //      let routerParams = this.$router.query.CourseName
      //      this.textareText = routerParams
      const dataB = JSON.parse(localStorage.getItem('courseinfo'))
      axios.get('http://47.106.217.11:8083/CourseMsg', {
        params: {
          courseid: 1
        }
      }).then(function (response) { // 请求成功回调函数
        console.log(response)
        this.$refs.ClassNumber.innerText = response.data.data
      }).catch(function (error) { // 请求失败时的回调函数
        console.log(error)
      })
      console.log(dataB)
    }
  }
}
</script>
<style lang="less" scoped>
</style>
