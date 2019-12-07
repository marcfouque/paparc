import Vue from 'vue'
import App from './App.vue'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

require('../node_modules/vue-suggestion/dist/vue-suggestion.css')

Vue.config.productionTip = false
new Vue({
  render: h => h(App),
}).$mount('#app')
