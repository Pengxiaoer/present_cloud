import Vue from 'vue'
import Router from 'vue-router'
import Register from '@/pages/register'
import ForgetPassword from '@/pages/ForgetPassword'
import Login from '@/pages/Login'
import Home from '@/pages/Home'
import AboutUs from '@/pages/AboutUs'
import Course from '@/pages/Course'
import ModifyPassword from '@/pages/ModifyPassword'
import PersonalCenter from '@/pages/PersonalCenter'
import PersonalInfo from '@/pages/PersonalInfo'
import PublishSign from '@/pages/PublishSign'
import SignIn from '@/pages/SignIn'
import ChangeImg from '@/pages/ChangeImg'
import CheckUpdate from '@/pages/CheckUpdate'
import PerfectInfo from '@/pages/PerfectInfo'
import TeacherHome from '@/pages/TeacherHome'
import TeacherSignrecord from '@/pages/TeacherSignrecord'
import SignResult from '@/pages/SignResult'
import SuccessSign from '@/pages/SuccessSign'
import Createcourse from '@/pages/Createcourse'
import bkxq from '@/pages/bkxq'
import addbk from '@/pages/addbk'
import xxbkxq from '@/pages/xxbkxq'
Vue.use(Router)
export default new Router({
  mode: 'hash',
  routes: [
    {
      path: '/xxbkxq', 
      name: 'xxbkxq',
      meta: {
        isLogin: true
      },
      component: xxbkxq
    },
    {
      path: '/addbk', 
      name: 'addbk',
      meta: {
        isLogin: true
      },
      component: addbk
    },
    {
      path: '/Register', 
      name: 'Register',
      meta: {
        isLogin: false
      },
      component: Register
    },
    {
      path: '/Forgetpassword', 
      name: 'Forgetpassword',
      meta: {
        isLogin: false
      },
      component: ForgetPassword
    },
    {
      path: '/', 
      name: 'Login',
      meta: {
        isLogin: false
      },
      component: Login
    },
    {
      path: '/Home', 
      name: 'Home',
      meta: {
        isLogin: true
      },
      component: Home
    },
    {
      path: '/AboutUs', 
      name: 'AboutUs',
      meta: {
        isLogin: true
      },
      component: AboutUs
    },
    {
      path: '/PersonalCenter', 
      name: 'PersonalCenter',
      meta: {
        isLogin: true
      },
      component: PersonalCenter
    },
    {
      path: '/ModifyPassword', 
      name: 'ModifyPassword',
      meta: {
        isLogin: true
      },
      component: ModifyPassword
    },
    {
      path: '/PersonalInfo', 
      name: 'PersonalInfo',
      meta: {
        isLogin: true
      },
      component: PersonalInfo
    },
    {
      path: '/PublishSign',
      name: 'PublishSign',
      meta: {
        isLogin: true
      },
      component: PublishSign
    },
    {
      path: '/SignIn', 
      name: 'SignIn',
      meta: {
        isLogin: true
      },
      component: SignIn
    },
    {
      path: '/SignResult', 
      name: 'SignResult',
      meta: {
        isLogin: true
      },
      component: SignResult
    },
    {
      path: '/ChangeImg', 
      name: 'ChangeImg',
      meta: {
        isLogin: true
      },
      component: ChangeImg
    },
    {
      path: '/CheckUpdate', 
      name: 'CheckUpdate',
      meta: {
        isLogin: true
      },
      component: CheckUpdate
    },
    {
      path: '/PerfectInfo',
      name: 'PerfectInfo',
      meta: {
        isLogin: false
      },
      component: PerfectInfo
    },
    {
      path: '/Course', 
      name: 'Course',
      meta: {
        isLogin: true
      },
      component: Course
    },
    {
      path: '/TeacherHome', 
      name: 'TeacherHome',
      meta: {
        isLogin: true
      },
      component: TeacherHome
    },
    {
      path: '/TeacherSignrecord',
      name: 'TeacherSignrecord',
      meta: {
        isLogin: true
      },
      component: TeacherSignrecord
    },
    {
      path: '/PublishSign',
      name: 'PublishSign',
      meta: {
        isLogin: true
      },
      component: PublishSign
    },
    {
      path: '/SuccessSign',
      name: 'SuccessSign',
      meta: {
        isLogin: true
      },
      component: SuccessSign
    },
    {
      path: '/Createcourse', 
      name: 'Createcourse',
      meta: {
        isLogin: true
      },
      component: Createcourse
    },
    {
      path: '/bkxq', 
      name: 'bkxq',
      meta: {
        isLogin: true
      },
      component: bkxq
    }
  ]
})
