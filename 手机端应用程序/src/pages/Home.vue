<template>
  <div>
    <div>
      <x-header :left-options="{backText: ''}">首页</x-header>
    </div>
    <div class="content">
      <div class="group">
        <div class="course_item"  v-for="(item, i) in list" :key="i" v-on:click="toCourse(item.courseId)">
          <span class="span1">
            <img  v-if="item.courseName == '高级机器学习'" class="course_img" src="../assets/course_img/ML.jpg">
            <img  v-else-if="item.courseName == '专业英语'" class="course_img" src="../assets/course_img/zyyy.jpg">
            <img  v-else-if="item.courseName == '智能技术'" class="course_img" src="../assets/course_img/znjs.jpg">
            <img  v-else-if="item.courseName == '密码学'" class="course_img" src="../assets/course_img/mmx.jpg">
            <img  v-else-if="item.courseName == '工程实训'" class="course_img" src="../assets/course_img/rjgc.jpg">
            <img  v-else-if="item.courseName == '商务英语'" class="course_img" src="../assets/course_img/swyy.jpg">
            <img  v-else-if="item.courseName == '自然辩证法'" class="course_img" src="../assets/course_img/zrbzf.jpg">
            <img  v-else-if="item.courseName == '中西方翻译史'" class="course_img" src="../assets/course_img/zxffy.jpg">
            <img  v-else-if="item.courseName == '应用语言学'" class="course_img" src="../assets/course_img/yyyyx.jpg">
          </span>
          <span class="span2" >
            <p ref="CourseName" >课程：{{item.courseName}}</p>
            <p ref="CourseName" >考试时间：{{item.examTime}}</p>
            <p ref="CourseName" >任课老师：{{item.teacherName}}</p>
          </span>
        </div>
      </div>
      </div>
    <div class="bottom">
      <span class="icon_course">
        <img src="../assets/course_icon.png">
      </span>
      <span class="icon_person">
        <router-link to="/PersonalCenter">
          <img src="../assets/person_icon.png">
        </router-link>
      </span>
    </div>
  </div>
</template>

<script>
import { Group, Cell, XHeader, XInput, XButton } from 'vux'
import axios from 'axios'
import qs from 'qs'
export default {
  name: 'home',
  data () {
    return {
      list: [],
      userName: '',
      imgPath: ''
    }
  },
  components: {
    Group,
    Cell,
    XHeader,
    XInput,
    XButton
  },
  mounted () {
    this.showData()
  },
  methods: {
    toCourse (id) {
      // this.CourseName = this.$refs.CourseName.innerText
      sessionStorage.setItem('courseid', id)
      console.log(id)
      this.$router.push('/SignIn')
    },
    toPersonalCenter () {
      this.$router.push('/PersonalCenter')
    },
    showData () {
      //      const orderData = { 'stno': '180327001' }
      //      sessionStorage.setItem('courseinfo', JSON.stringify(orderData))
      //      const dataB = JSON.parse(sessionStorage.getItem('courseinfo'))
      this.userName = sessionStorage.getItem('username')
      axios.get('http://101.132.46.183:8080/Student/Course', qs.stringify({
        stno: this.userName
      }), {
        emulateJSON: true
      }, {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
        }
      }).then(res => {
        this.list = res.data.data
        console.log(this.list)
      })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>

<style lang="less" scoped>
  .content{
    position: absolute;
    background-color: #fafbf9;
    height: 93%;
    width: 100%;
  }
  .bottom{
    position: absolute;
    width: 100%;
    height: 5%;
    background-color: #ffffff;
    bottom: 10px;
    border-top: solid 0.5px #d3d3d3;
  }
  .icon_course{
    position: relative;
    margin-left: 80px;
    top: 5px;
  }
  .icon_person{
    position: relative;
    margin-left: 180px;
    top: 5px;
  }
  .course_item{
    background-color: #ffffff;
    height: 100px;
    width: 100%;
    border-bottom: solid 0.5px #d3d3d3;
  }
  .span1{
    display:inline-block;
    position: absolute;
    margin-top: 0px;
    height: 100px;
  }
  .span2{
    display:block;
    position: absolute;
    margin-left: 100px;
    margin-top: 18px;
    height: 100px;
    color: #8a8a8a;
    font-size: 15px;
  }
  a{
    text-decoration:none;
    font-size: 16px;
    color: #8a8a8a;
  }
  .course_img{
    position: relative;
    margin-left: 20px;
    margin-top: 15px;
    width: 70px;
    height: 70px;
  }
  .course_name{
    position: relative;
    top: 15px;
  }
</style>
