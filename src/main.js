import {createApp} from 'vue'

import ViewUIPlus from 'view-ui-plus'
import 'view-ui-plus/dist/styles/viewuiplus.css'

import ElementUI from 'element-plus'
import 'element-plus/dist/index.css'

import App from './App.vue'
import router from './router'

const app = createApp(App)
app.use(ViewUIPlus).use(router).mount('#app')
app.use(ElementPlus)
app.mount('#app')