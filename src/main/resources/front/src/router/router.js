import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import AddrList from '../pages/shop-address/list'
import AddrAdd from '../pages/shop-address/addOrUpdate'
import Order from '../pages/shop-order/list'
import OrderConfirm from '../pages/shop-order/confirm'
import Cart from '../pages/shop-cart/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import mapDealer from '../pages/geshouxinxi/GaoDeMap'
import geshouxinxiList from '../pages/geshouxinxi/list'
import geshouxinxiDetail from '../pages/geshouxinxi/detail'
import geshouxinxiAdd from '../pages/geshouxinxi/add'
import gequfenleiList from '../pages/gequfenlei/list'
import gequfenleiDetail from '../pages/gequfenlei/detail'
import gequfenleiAdd from '../pages/gequfenlei/add'
import remengequList from '../pages/remengequ/list'
import remengequDetail from '../pages/remengequ/detail'
import remengequAdd from '../pages/remengequ/add'
import fufeiyinleList from '../pages/fufeiyinle/list'
import fufeiyinleDetail from '../pages/fufeiyinle/detail'
import fufeiyinleAdd from '../pages/fufeiyinle/add'
import yinlegoumaiList from '../pages/yinlegoumai/list'
import yinlegoumaiDetail from '../pages/yinlegoumai/detail'
import yinlegoumaiAdd from '../pages/yinlegoumai/add'
import shangpinfenleiList from '../pages/shangpinfenlei/list'
import shangpinfenleiDetail from '../pages/shangpinfenlei/detail'
import shangpinfenleiAdd from '../pages/shangpinfenlei/add'
import shangpinpinpaiList from '../pages/shangpinpinpai/list'
import shangpinpinpaiDetail from '../pages/shangpinpinpai/detail'
import shangpinpinpaiAdd from '../pages/shangpinpinpai/add'
import zhoubianshangpinList from '../pages/zhoubianshangpin/list'
import zhoubianshangpinDetail from '../pages/zhoubianshangpin/detail'
import zhoubianshangpinAdd from '../pages/zhoubianshangpin/add'
import jingxuanmvList from '../pages/jingxuanmv/list'
import jingxuanmvDetail from '../pages/jingxuanmv/detail'
import jingxuanmvAdd from '../pages/jingxuanmv/add'
import gedanpingfenList from '../pages/gedanpingfen/list'
import gedanpingfenDetail from '../pages/gedanpingfen/detail'
import gedanpingfenAdd from '../pages/gedanpingfen/add'
import goumaituisongList from '../pages/goumaituisong/list'
import goumaituisongDetail from '../pages/goumaituisong/detail'
import goumaituisongAdd from '../pages/goumaituisong/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
                {
                    path: 'shop-address/list',
                    component: AddrList
                },
                {
                    path: 'shop-address/addOrUpdate',
                    component: AddrAdd
                },
				{
					path: 'shop-order/order',
					component: Order
				},
				{
					path: 'cart',
					component: Cart
				},
				{
					path: 'shop-order/orderConfirm',
					component: OrderConfirm
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'geshouxinxi',
					component: geshouxinxiList
				},
				{
					path: 'mapDealer',
					component: mapDealer
				},
				{
					path: 'geshouxinxiDetail',
					component: geshouxinxiDetail
				},
				{
					path: 'geshouxinxiAdd',
					component: geshouxinxiAdd
				},
				{
					path: 'gequfenlei',
					component: gequfenleiList
				},
				{
					path: 'gequfenleiDetail',
					component: gequfenleiDetail
				},
				{
					path: 'gequfenleiAdd',
					component: gequfenleiAdd
				},
				{
					path: 'remengequ',
					component: remengequList
				},
				{
					path: 'remengequDetail',
					component: remengequDetail
				},
				{
					path: 'remengequAdd',
					component: remengequAdd
				},
				{
					path: 'fufeiyinle',
					component: fufeiyinleList
				},
				{
					path: 'fufeiyinleDetail',
					component: fufeiyinleDetail
				},
				{
					path: 'fufeiyinleAdd',
					component: fufeiyinleAdd
				},
				{
					path: 'yinlegoumai',
					component: yinlegoumaiList
				},
				{
					path: 'yinlegoumaiDetail',
					component: yinlegoumaiDetail
				},
				{
					path: 'yinlegoumaiAdd',
					component: yinlegoumaiAdd
				},
				{
					path: 'shangpinfenlei',
					component: shangpinfenleiList
				},
				{
					path: 'shangpinfenleiDetail',
					component: shangpinfenleiDetail
				},
				{
					path: 'shangpinfenleiAdd',
					component: shangpinfenleiAdd
				},
				{
					path: 'shangpinpinpai',
					component: shangpinpinpaiList
				},
				{
					path: 'shangpinpinpaiDetail',
					component: shangpinpinpaiDetail
				},
				{
					path: 'shangpinpinpaiAdd',
					component: shangpinpinpaiAdd
				},
				{
					path: 'zhoubianshangpin',
					component: zhoubianshangpinList
				},
				{
					path: 'zhoubianshangpinDetail',
					component: zhoubianshangpinDetail
				},
				{
					path: 'zhoubianshangpinAdd',
					component: zhoubianshangpinAdd
				},
				{
					path: 'jingxuanmv',
					component: jingxuanmvList
				},
				{
					path: 'jingxuanmvDetail',
					component: jingxuanmvDetail
				},
				{
					path: 'jingxuanmvAdd',
					component: jingxuanmvAdd
				},
				{
					path: 'gedanpingfen',
					component: gedanpingfenList
				},
				{
					path: 'gedanpingfenDetail',
					component: gedanpingfenDetail
				},
				{
					path: 'gedanpingfenAdd',
					component: gedanpingfenAdd
				},
				{
					path: 'goumaituisong',
					component: goumaituisongList
				},
				{
					path: 'goumaituisongDetail',
					component: goumaituisongDetail
				},
				{
					path: 'goumaituisongAdd',
					component: goumaituisongAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
