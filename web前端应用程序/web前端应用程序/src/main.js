import Vue from 'vue'
import App from '@/App'
import router from '@/router'                 
import store from '@/store'                   
import VueCookie from 'vue-cookie'            
import '@/element-ui'                         
import '@/icons'                              
import '@/element-ui-theme'
import '@/assets/scss/index.scss'
import httpRequest from '@/utils/httpRequest' 
import { isAuth } from '@/utils'
import cloneDeep from 'lodash/cloneDeep'
import Viewer from 'v-viewer'
import 'viewerjs/dist/viewer.css'

Vue.use(VueCookie)
Vue.use(Viewer)
Vue.config.productionTip = false

if (process.env.NODE_ENV !== 'production') {
  require('@/mock')
}

// 挂载全局
Vue.prototype.$http = httpRequest // ajax请求方法
Vue.prototype.isAuth = isAuth     // 权限方法


// 保存整站vuex本地储存初始状态
window.SITE_CONFIG['storeState'] = cloneDeep(store.state)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
