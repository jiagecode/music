import Vue from 'vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router/router'
import BaiduMap from 'vue-baidu-map'
import VueQuillEditor from 'vue-quill-editor'
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
import '@/assets/css/iconfont.css'
import config from './config/config'
import validate from './common/validate'
import { isAuth,getCurDateTime,getCurDate } from './common/system'
import App from './App.vue'
import Breadcrumb from '@/components/Breadcrumb'
import FileUpload from '@/components/FileUpload'
import Editor from "@/components/Editor";
import aplayer from 'vue-aplayer';
import store from './store'
import VueAMap from "vue-amap";

Vue.config.productionTip = false;

Vue.prototype.$config = config;
Vue.prototype.$validate = validate;
Vue.prototype.isAuth = isAuth;
Vue.prototype.getCurDateTime = getCurDateTime;
Vue.prototype.getCurDate = getCurDate;

Vue.use(VueRouter);
Vue.use(VueResource);
Vue.use(ElementUI);
Vue.use(BaiduMap, {});
Vue.use(VueQuillEditor);

Vue.component('Breadcrumb', Breadcrumb);
Vue.component('file-upload', FileUpload);
Vue.component('editor', Editor);
Vue.component('aplayer', aplayer);

Vue.use(VueAMap);
VueAMap.initAMapApiLoader({
    key: "600d0f3affe69656e40fe3f05d88bb57",
    plugin: [
        "AMap.Autocomplete",
        "AMap.PlaceSearch",
        "AMap.Scale",
        "AMap.OverView",
        "AMap.ToolBar",
        "AMap.MapType",
        "AMap.PolyEditor",
        "AMap.CircleEditor"
    ],
    // 默认高德 sdk 版本为 1.4.4
    v: "1.4.5",
    uiVersion: "1.0"
});

Vue.http.options.root = config.baseUrl;
Vue.http.headers.common['Token'] = localStorage.getItem('Token');
Vue.http.interceptors.push(function(request, next) {
　next((response) => {
    if (response.data.code == 401 || response.data.code == 403) {
      this.$router.replace('/login').catch(err => {});
    } else {
      return response;
    }
  });
});

router.afterEach((to, from) => {
  if (from.path == '/login') {
    Vue.http.headers.common['Token'] = localStorage.getItem('Token');
  }
})

new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app')
