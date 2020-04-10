import Vue from 'vue'
import Router from 'vue-router'
import Index from './views/Index.vue'
import Console from './views/Console.vue'
import Users from './views/Users.vue'
import Articles from './views/Articles.vue'
import Echarts from './views/Echarts.vue'
import Login from './views/Login.vue'
import NotFound from './views/NotFound.vue'
import Profile from './views/Profile.vue'
import Alterpassword from './views/Alterpassword.vue'
import Aboutus from './views/AboutUs.vue'
import Account from './views/Account.vue'
import Check from './views/CheckWork.vue'
import Curriculum from './views/Curriculum.vue'
import DataD from './views/DataDictionary'
import DataDM from './views/DataDictionaryM'
import System from './views/SystemSetting'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/login',
      component: Login
    },
    {
      path: '/',
      component: Index,
      children: [
        {
          path: '/console',
          name: 'console',
          component: Console
        },
        {
          path: '/users',
          name: 'users',
          component: Users
        },
        {
          path: '/articles',
          name: 'articles',
          component: Articles
        },
        {
          path: '/echarts',
          name: 'echarts',
          component: Echarts
        },
        {
          path: '/profile',
          name: 'profile',
          component: Profile
        },
        {
          path: '/password',
          name: 'password',
          component: Alterpassword
        },
        {
          path: '/aboutus',
          name: 'aboutus',
          component: Aboutus
        },
        {
          path: '/account',
          name: 'account',
          component: Account
        },
        {
          path: '/check',
          name: 'check',
          component: Check
        },
        {
          path: '/curriculum',
          name: 'curriculum',
          component: Curriculum
        },
        {
          path: '/datad',
          name: 'datad',
          component: DataD
        },
        {
          path: '/datadm',
          name: 'datadm',
          component: DataDM
        },
        {
          path: '/system',
          name: 'system',
          component: System
        },
        {
          path: '/404',
          component: NotFound
        }
      ]
    },
    {
      path: '*',
      redirect: { path: '/404' }
    }
  ]
})

// 全局路由守卫
router.beforeEach((to, from, next) => {
  const LOGINURL = '/login'
  let url, user

  url = to.path
  user = sessionStorage.getItem('user')

  if (url === LOGINURL) {
    sessionStorage.removeItem('user')
  }

  // 判断是否登录
  if (!user && url !== LOGINURL) {
    next({ path: LOGINURL })
  } else {
    next()
  }
})

export default router
