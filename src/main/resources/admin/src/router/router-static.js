import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import fufeiyinle from '@/views/modules/fufeiyinle/list'
    import shangpinpinpai from '@/views/modules/shangpinpinpai/list'
    import discussremengequ from '@/views/modules/discussremengequ/list'
    import geshouxinxi from '@/views/modules/geshouxinxi/list'
    import zhoubianshangpin from '@/views/modules/zhoubianshangpin/list'
    import remengequ from '@/views/modules/remengequ/list'
    import jingxuanmv from '@/views/modules/jingxuanmv/list'
    import storeup from '@/views/modules/storeup/list'
    import gedanpingfen from '@/views/modules/gedanpingfen/list'
    import discusszhoubianshangpin from '@/views/modules/discusszhoubianshangpin/list'
    import yinlegoumai from '@/views/modules/yinlegoumai/list'
    import yonghu from '@/views/modules/yonghu/list'
    import shangpinfenlei from '@/views/modules/shangpinfenlei/list'
    import chat from '@/views/modules/chat/list'
    import gequfenlei from '@/views/modules/gequfenlei/list'
    import discussgeshouxinxi from '@/views/modules/discussgeshouxinxi/list'
    import discussjingxuanmv from '@/views/modules/discussjingxuanmv/list'
    import orders from '@/views/modules/orders/list'
    import config from '@/views/modules/config/list'
    import goumaituisong from '@/views/modules/goumaituisong/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '音乐资讯',
        component: news
      }
      ,{
	path: '/fufeiyinle',
        name: '付费音乐',
        component: fufeiyinle
      }
      ,{
	path: '/shangpinpinpai',
        name: '商品品牌',
        component: shangpinpinpai
      }
      ,{
	path: '/discussremengequ',
        name: '热门歌曲评论',
        component: discussremengequ
      }
      ,{
	path: '/geshouxinxi',
        name: '歌手信息',
        component: geshouxinxi
      }
      ,{
	path: '/zhoubianshangpin',
        name: '周边商品',
        component: zhoubianshangpin
      }
      ,{
	path: '/remengequ',
        name: '热门歌曲',
        component: remengequ
      }
      ,{
	path: '/jingxuanmv',
        name: '精选mv',
        component: jingxuanmv
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/gedanpingfen',
        name: '歌单评分',
        component: gedanpingfen
      }
      ,{
	path: '/discusszhoubianshangpin',
        name: '周边商品评论',
        component: discusszhoubianshangpin
      }
      ,{
	path: '/yinlegoumai',
        name: '音乐购买',
        component: yinlegoumai
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/shangpinfenlei',
        name: '商品分类',
        component: shangpinfenlei
      }
      ,{
	path: '/chat',
        name: '在线客服',
        component: chat
      }
      ,{
	path: '/gequfenlei',
        name: '歌曲分类',
        component: gequfenlei
      }
      ,{
	path: '/discussgeshouxinxi',
        name: '歌手信息评论',
        component: discussgeshouxinxi
      }
      ,{
	path: '/discussjingxuanmv',
        name: '精选mv评论',
        component: discussjingxuanmv
      }
      ,{
        path: '/orders/:status',
        name: '订单管理',
        component: orders
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/goumaituisong',
        name: '购买推送',
        component: goumaituisong
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
