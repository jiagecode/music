<template>
<div class="home-preview" :style='{"width":"100%","margin":"0 auto","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>



<div class="recommend" :style='{"padding":"60px 7% 0","margin":"0","textAlign":"center","background":"none","display":"block","width":"100%","position":"relative","order":"4"}'>
	
    <div class="title" :style='{"padding":"10px 20px 0","margin":"0 auto 40px","alignItems":"flex-start","background":"url(http://codegen.caihongy.cn/20230204/dee7aa1825b6499695c40e2e5a76dd9c.png) repeat-x center bottom,linear-gradient(0deg, rgba(182,215,222,1) 0%, rgba(233,248,251,1) 80%, rgba(207,237,244,1) 100%),#b6d7de","display":"flex","width":"auto","position":"relative","justifyContent":"center","height":"66px"}'>
		<span :style='{"padding":"0 20px","color":"#202020","textAlign":"center","background":"none","fontSize":"18px","lineHeight":"40px","fontWeight":"500"}'>热门歌曲推荐</span>
	</div>
	
	
	
	<!-- 样式二 -->
	<div class="list list2 index-pv1" :style='{"padding":"0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		<div :style='{"cursor":"pointer","padding":"10px 10px 20px","margin":"0 0 60px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230206/de4c50b5282f45f8a59707bce3185db8.png) no-repeat left bottom / 16%,url(http://codegen.caihongy.cn/20230206/5e80378b411c4449a860d66e35c5c969.png) no-repeat right top / 16%","display":"flex","width":"48%","fontSize":"0","position":"relative","justifyContent":"center","height":"280px"}' v-for="(item,index) in remengequRecommend" class="list-item animation-box" :key="index" @click="toDetail('remengequDetail', item)">
			<img :style='{"padding":"20px","objectFit":"contain","flex":"1","display":"inline-block","width":"auto","height":"100%","maxWidth":"52%"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
			<img :style='{"padding":"20px","objectFit":"contain","flex":"1","display":"inline-block","width":"auto","height":"100%","maxWidth":"52%"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			<div class="item-info" :style='{"padding":"10px 0","verticalAlign":"middle","alignItems":"flex-start","display":"flex","right":"30px","justifyContent":"center","overflow":"hidden","top":"60px","borderRadius":"8px","width":"44%","position":"relative","height":"90%","zIndex":"999"}'>
				<div class="name line1" :style='{"border":"0 dashed #bcdbdf","padding":"10px","margin":"0 10px 0 0","overflow":"hidden","color":"#333","textAlign":"center","borderWidth":"0 1px 0 0","width":"40px","lineHeight":"1.2","fontSize":"14px"}'>{{item.songname}}</div>
				<div class="name line1" :style='{"border":"0 dashed #bcdbdf","padding":"10px","margin":"0 10px 0 0","overflow":"hidden","color":"#333","textAlign":"center","borderWidth":"0 1px 0 0","width":"40px","lineHeight":"1.2","fontSize":"14px"}'>{{item.singer}}</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	<div @click="moreBtn('remengequ')" :style='{"border":"0","cursor":"pointer","padding":"0 2px 0 10px","margin":"0 auto 20px","borderRadius":"8px","textAlign":"center","background":"none","display":"inline-block","width":"auto","lineHeight":"40px","minWidth":"120px","height":"44px"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#333","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
	<div v-if="true" class="idea recommendIdea" :style='{"minHeight":"360px","padding":"0","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230207/8b398b5309b94ebca873fd6b49b07f09.jpg) no-repeat left center / 100% 100%","display":"flex","width":"100%","justifyContent":"space-between"}'>
		<div class="box1" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
</div>
<div class="recommend" :style='{"padding":"60px 7% 0","margin":"0","textAlign":"center","background":"none","display":"block","width":"100%","position":"relative","order":"4"}'>
	
    <div class="title" :style='{"padding":"10px 20px 0","margin":"0 auto 40px","alignItems":"flex-start","background":"url(http://codegen.caihongy.cn/20230204/dee7aa1825b6499695c40e2e5a76dd9c.png) repeat-x center bottom,linear-gradient(0deg, rgba(182,215,222,1) 0%, rgba(233,248,251,1) 80%, rgba(207,237,244,1) 100%),#b6d7de","display":"flex","width":"auto","position":"relative","justifyContent":"center","height":"66px"}'>
		<span :style='{"padding":"0 20px","color":"#202020","textAlign":"center","background":"none","fontSize":"18px","lineHeight":"40px","fontWeight":"500"}'>周边商品推荐</span>
	</div>
	
	
	
	<!-- 样式二 -->
	<div class="list list2 index-pv1" :style='{"padding":"0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		<div :style='{"cursor":"pointer","padding":"10px 10px 20px","margin":"0 0 60px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230206/de4c50b5282f45f8a59707bce3185db8.png) no-repeat left bottom / 16%,url(http://codegen.caihongy.cn/20230206/5e80378b411c4449a860d66e35c5c969.png) no-repeat right top / 16%","display":"flex","width":"48%","fontSize":"0","position":"relative","justifyContent":"center","height":"280px"}' v-for="(item,index) in zhoubianshangpinRecommend" class="list-item animation-box" :key="index" @click="toDetail('zhoubianshangpinDetail', item)">
			<img :style='{"padding":"20px","objectFit":"contain","flex":"1","display":"inline-block","width":"auto","height":"100%","maxWidth":"52%"}' v-if="preHttp(item.tupian)" :src="item.tupian.split(',')[0]" alt="" />
			<img :style='{"padding":"20px","objectFit":"contain","flex":"1","display":"inline-block","width":"auto","height":"100%","maxWidth":"52%"}' v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="" />
			<div class="item-info" :style='{"padding":"10px 0","verticalAlign":"middle","alignItems":"flex-start","display":"flex","right":"30px","justifyContent":"center","overflow":"hidden","top":"60px","borderRadius":"8px","width":"44%","position":"relative","height":"90%","zIndex":"999"}'>
				<div class="name line1" :style='{"border":"0 dashed #bcdbdf","padding":"10px","margin":"0 10px 0 0","overflow":"hidden","color":"#333","textAlign":"center","borderWidth":"0 1px 0 0","width":"40px","lineHeight":"1.2","fontSize":"14px"}'>{{item.shangpinmingcheng}}</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	<div @click="moreBtn('zhoubianshangpin')" :style='{"border":"0","cursor":"pointer","padding":"0 2px 0 10px","margin":"0 auto 20px","borderRadius":"8px","textAlign":"center","background":"none","display":"inline-block","width":"auto","lineHeight":"40px","minWidth":"120px","height":"44px"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#333","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
	<div v-if="true" class="idea recommendIdea" :style='{"minHeight":"360px","padding":"0","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230207/8b398b5309b94ebca873fd6b49b07f09.jpg) no-repeat left center / 100% 100%","display":"flex","width":"100%","justifyContent":"space-between"}'>
		<div class="box1" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
</div>
<div class="recommend" :style='{"padding":"60px 7% 0","margin":"0","textAlign":"center","background":"none","display":"block","width":"100%","position":"relative","order":"4"}'>
	
    <div class="title" :style='{"padding":"10px 20px 0","margin":"0 auto 40px","alignItems":"flex-start","background":"url(http://codegen.caihongy.cn/20230204/dee7aa1825b6499695c40e2e5a76dd9c.png) repeat-x center bottom,linear-gradient(0deg, rgba(182,215,222,1) 0%, rgba(233,248,251,1) 80%, rgba(207,237,244,1) 100%),#b6d7de","display":"flex","width":"auto","position":"relative","justifyContent":"center","height":"66px"}'>
		<span :style='{"padding":"0 20px","color":"#202020","textAlign":"center","background":"none","fontSize":"18px","lineHeight":"40px","fontWeight":"500"}'>精选mv推荐</span>
	</div>
	
	
	
	<!-- 样式二 -->
	<div class="list list2 index-pv1" :style='{"padding":"0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		<div :style='{"cursor":"pointer","padding":"10px 10px 20px","margin":"0 0 60px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230206/de4c50b5282f45f8a59707bce3185db8.png) no-repeat left bottom / 16%,url(http://codegen.caihongy.cn/20230206/5e80378b411c4449a860d66e35c5c969.png) no-repeat right top / 16%","display":"flex","width":"48%","fontSize":"0","position":"relative","justifyContent":"center","height":"280px"}' v-for="(item,index) in jingxuanmvRecommend" class="list-item animation-box" :key="index" @click="toDetail('jingxuanmvDetail', item)">
			<img :style='{"padding":"20px","objectFit":"contain","flex":"1","display":"inline-block","width":"auto","height":"100%","maxWidth":"52%"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
			<img :style='{"padding":"20px","objectFit":"contain","flex":"1","display":"inline-block","width":"auto","height":"100%","maxWidth":"52%"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			<div class="item-info" :style='{"padding":"10px 0","verticalAlign":"middle","alignItems":"flex-start","display":"flex","right":"30px","justifyContent":"center","overflow":"hidden","top":"60px","borderRadius":"8px","width":"44%","position":"relative","height":"90%","zIndex":"999"}'>
				<div class="name line1" :style='{"border":"0 dashed #bcdbdf","padding":"10px","margin":"0 10px 0 0","overflow":"hidden","color":"#333","textAlign":"center","borderWidth":"0 1px 0 0","width":"40px","lineHeight":"1.2","fontSize":"14px"}'>{{item.mvmingcheng}}</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	<div @click="moreBtn('jingxuanmv')" :style='{"border":"0","cursor":"pointer","padding":"0 2px 0 10px","margin":"0 auto 20px","borderRadius":"8px","textAlign":"center","background":"none","display":"inline-block","width":"auto","lineHeight":"40px","minWidth":"120px","height":"44px"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#333","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
	<div v-if="true" class="idea recommendIdea" :style='{"minHeight":"360px","padding":"0","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230207/8b398b5309b94ebca873fd6b49b07f09.jpg) no-repeat left center / 100% 100%","display":"flex","width":"100%","justifyContent":"space-between"}'>
		<div class="box1" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"0","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
</div>

	
<div class="news" :style='{"padding":"0","margin":"40px 7% 0","alignItems":"space-between","flexWrap":"wrap","background":"none","flex":"1","display":"flex","width":"86%","position":"relative","order":"1"}'>
	<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"margin":"0 auto 20px","top":"0","background":"url(http://codegen.caihongy.cn/20230204/dee7aa1825b6499695c40e2e5a76dd9c.png) repeat-x center bottom,linear-gradient(0deg, rgba(182,215,222,1) 0%, rgba(233,248,251,1) 80%, rgba(207,237,244,1) 100%),#b6d7de","display":"flex","width":"100%","position":"relative","zIndex":"99","height":"56px"}'>
		<span :style='{"padding":"0 20px","margin":"0 10px 0 0","color":"#202020","textAlign":"center","background":"url(\"http://codegen.caihongy.cn/20230204/dee7aa1825b6499695c40e2e5a76dd9c.png\") center bottom repeat-x, linear-gradient(0deg, rgb(182, 215, 222) 0%, rgb(233, 248, 251) 80%, rgb(207, 237, 244) 100%), rgb(182, 215, 222)","width":"auto","fontSize":"18px","lineHeight":"44px","fontWeight":"500"}'>音乐资讯</span>
	</div>
	
	
	
	
	
	
	
	
	
	
	<!-- 样式九 -->
	<div v-if="newsList.length" class="list list9 index-pv1" :style='{"width":"100%","padding":"10px 20px 100px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230204/89ee15e6746c4bebbe94e76247cbaf70.png) repeat-x center bottom / 50% auto","display":"flex","height":"auto"}'>
	  <div v-for="(item,index) in newsList" v-if="index<6" :key="index" @click="toDetail('newsDetail', item)" :style='{"cursor":"pointer","padding":"0 20px 0 60px","margin":"0 10px 20px 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","position":"relative","height":"78px"}' class="new9-list-item animation-box">
		<div :style='{"padding":"2px 10px","whiteSpace":"nowrap","overflow":"hidden","color":"#333","width":"calc(100% - 140px)","fontSize":"14px","lineHeight":"24px","textOverflow":"ellipsis","fontWeight":"600","order":"2","height":"24px"}' class="new9-list-item-title line1">{{ item.title }}</div>
		<div :style='{"color":"#333","top":"0px","borderRadius":"4px","textAlign":"center","background":"linear-gradient(150deg, rgba(215,238,242,.3) 0%, rgba(255,255,255,.3) 50%, rgba(215,238,242,.3) 100%),#d7eef2","width":"100px","fontSize":"12px","lineHeight":"24px","position":"absolute","right":"0"}' class="new9-list-item-time">{{ item.addtime.split(' ')[0] }}</div>
	    <div :style='{"padding":"4px 0","overflow":"hidden","color":"#666","width":"100%","fontSize":"14px","lineHeight":"24px","textIndent":"2em","height":"48px","order":"3"}' class="new9-list-item-descript line2">{{ item.introduction }}</div>
		<div :style='{"padding":"4px 10px","color":"#333","textAlign":"center","display":"flex","justifyContent":"center","top":"0","left":"0","background":"#d7eef2","width":"40px","fontSize":"14px","lineHeight":"1.2","position":"absolute","height":"100%"}' class="new9-list-item-identification">新闻动态</div>
	  </div>
	</div>
	
	
	<div @click="moreBtn('news')" :style='{"border":"0","padding":"0 12px 0 20px","margin":"0 auto","textAlign":"center","left":"46%","background":"none","bottom":"20px","display":"inline-block","width":"44px","lineHeight":"40px","minWidth":"120px","position":"absolute"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#333","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>


<div class="lists" :style='{"padding":"0 0 60px","margin":"60px 7% 0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230204/1e43bef82bed4dc0acd878fcc2f73aa8.png) no-repeat center bottom / 100% auto,#fff","display":"block","width":"56%","position":"relative","order":"30"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"padding":"10px 20px 0","margin":"0 0 40px","alignItems":"flex-start","background":"url(http://codegen.caihongy.cn/20230204/dee7aa1825b6499695c40e2e5a76dd9c.png) repeat-x center bottom,linear-gradient(0deg, rgba(182,215,222,1) 0%, rgba(233,248,251,1) 80%, rgba(207,237,244,1) 100%),#b6d7de","display":"flex","width":"auto","position":"relative","justifyContent":"center","height":"66px"}'>
	  <span :style='{"padding":"0 20px","fontSize":"18px","lineHeight":"40px","color":"#202020","fontWeight":"500","display":"inline-block"}'>歌手信息展示</span>
	</div>
	
	
	<!-- 样式一 -->
	<div class="list list1 index-pv1" :style='{"padding":"0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		<div :style='{"padding":"30px 20px","margin":"0 0 30px","borderRadius":"8px","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230206/de4c50b5282f45f8a59707bce3185db8.png) no-repeat left bottom / 20%,url(http://codegen.caihongy.cn/20230206/5e80378b411c4449a860d66e35c5c969.png) no-repeat right top / 20%","display":"flex","width":"48%","position":"relative","justifyContent":"center","height":"auto"}' v-for="(item,index) in geshouxinxiList" :key="index" @click="toDetail('geshouxinxiDetail', item)" class="list-item animation-box">
			<img :style='{"margin":"0 3% 0 0","objectFit":"contain","background":"none","flex":"1","display":"block","width":"auto","height":"220px","maxWidth":"60%"}' v-if="preHttp(item.touxiang)" :src="item.touxiang.split(',')[0]" alt="" />
			<img :style='{"margin":"0 3% 0 0","objectFit":"contain","background":"none","flex":"1","display":"block","width":"auto","height":"220px","maxWidth":"60%"}' v-else :src="baseUrl + (item.touxiang?item.touxiang.split(',')[0]:'')" alt="" />
			<div class="name line1" :style='{"border":"0 dashed #bcdbdf","padding":"0 10px","overflow":"hidden","color":"#333","alignItems":"flex-start","textAlign":"center","borderWidth":"0 1px 0 0","display":"flex","width":"32px","lineHeight":"1.2","fontSize":"14px","height":"auto"}'>{{item.geshouxingming}}</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	<div @click="moreBtn('geshouxinxi')" :style='{"border":"0","padding":"0 20px","margin":"20px auto 0","borderRadius":"8px","textAlign":"center","background":"none","display":"inline-block","width":"auto","lineHeight":"40px","minWidth":"120px"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#333","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>


</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        newsList: [],
        remengequRecommend: [],
        zhoubianshangpinRecommend: [],
        jingxuanmvRecommend: [],

        geshouxinxiList: [],
      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getNewsList();
      this.getList();
    },
    //方法集合
    methods: {
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
		getNewsList() {
			this.$http.get('news/list', {params: {
				page: 1,
				limit: 4,
                sort: 'addtime',
			order: 'desc'}}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
          let autoSortUrl = "";
          autoSortUrl = "remengequ/autoSort";
          if(localStorage.getItem('Token')) {
              autoSortUrl = "remengequ/autoSort2";
          }
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 4,
			}}).then(res => {
				if (res.data.code == 0) {
					this.remengequRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "zhoubianshangpin/autoSort";
          if(localStorage.getItem('Token')) {
              autoSortUrl = "zhoubianshangpin/autoSort2";
          }
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 4,
			}}).then(res => {
				if (res.data.code == 0) {
					this.zhoubianshangpinRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "jingxuanmv/autoSort";
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 4,
			}}).then(res => {
				if (res.data.code == 0) {
					this.jingxuanmvRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
			
			this.$http.get('geshouxinxi/list', {params: {
				page: 1,
				limit: 4,
			}}).then(res => {
				if (res.data.code == 0) {
					this.geshouxinxiList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
	
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform:  translate3d(0px, -10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: translate3d(10px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform:  skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
</style>
