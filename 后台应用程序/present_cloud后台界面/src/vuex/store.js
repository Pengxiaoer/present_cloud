import Vue from 'vue'
import Vuex from 'vuex'
import * as actions from './actions'
import * as getters from './getters'
//调用
Vue.use(Vuex)

// 出师状态
const state = {
    count: 10
}

// 定义所需的 mutations
const mutations = {
    INCREMENT(state) {
        state.count++
    },
    DECREMENT(state) {
        state.count--
    }
}
/**
 * // 创建 sfun 实例
export default new Vuex.fum({
   
    mutations
})
 */
// 创建 store 实例
export default new Vuex.Store({
    actions,
    getters,
    state,
    mutations
})