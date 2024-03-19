<template>
<div>
	<div :style='{"padding":"0 20px","margin":"0 7%","borderRadius":"20px","alignItems":"center","background":"#ceeff3","display":"flex","width":"86%","lineHeight":"44px","height":"auto"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'Ξ'" :style='{"fontSize":"14px","lineHeight":"44px"}'>
			<el-breadcrumb-item>首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in breadcrumbItem" :key="index">{{item.name}}</el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	
	<div class="list-preview" :style='{"width":"100%","margin":"0 auto","position":"relative","flexWrap":"wrap","background":"none","display":"flex"}'>


    <el-form :inline="true" :model="formSearch" class="list-form-pv"
             :style='{"border":"0 outset #bcdbdf","padding":"30px 20px","margin":"20px 7% 0","alignItems":"center","flexWrap":"wrap","background":"#fff","borderWidth":"1px 0 2px","display":"flex","width":"86%","height":"auto"}'>
<!--      <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
        <div class="lable" v-if="true"
             :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>歌手姓名
        </div>
        <el-input v-model="formSearch.geshouxingming" placeholder="歌手姓名" clearable></el-input>
      </el-form-item>-->
      <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 20px 0 0","color":"#fff","minWidth":"130px","outline":"none","borderRadius":"30px","background":"#40a8c4","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}'
                   type="primary" @click="getList(1, curFenlei)">歌手推荐</el-button>
      </el-form-item>
      <!--      <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
          <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>歌手性别</div>
              <el-select v-model="formSearch.geshouxingbie" placeholder="请选择歌手性别" :clearable="true">
                <el-option v-for="(item, index) in geshouxingbieOptions" :key="index" :label="item" :value="item"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
            <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>标签</div>
              <el-input v-model="formSearch.biaoqian" placeholder="标签" clearable></el-input>
            </el-form-item>-->
<!--      <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
        <div class="lable" v-if="true"
             :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>地区
        </div>
        <el-select v-model="formSearch.diqu" placeholder="请选择地区" :clearable="true">
          <el-option v-for="(item, index) in diquOptions" :key="index" :label="item" :value="item"></el-option>
        </el-select>
      </el-form-item>-->
      <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 20px 0 0","color":"#fff","minWidth":"130px","outline":"none","borderRadius":"30px","background":"#40a8c4","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}'
                   type="primary" @click="getMap()">地区显示</el-button>
      </el-form-item>
<!--      <el-button v-if=" true "
                 :style='{"cursor":"pointer","border":"0","padding":"0px 10px","margin":"0 10px 0 0","color":"#fff","minWidth":"90px","outline":"none","borderRadius":"30px","background":"#40a8c4","width":"auto","fontSize":"14px","lineHeight":"42px","height":"42px"}'
                 type="primary" @click="getList(1, curFenlei)"><i v-if="true"
                                                                  :style='{"color":"#fff","margin":"0 10px 0 0","fontSize":"14px"}'
                                                                  class="el-icon-search"></i>查询
      </el-button>
      <el-button v-if="isAuth('geshouxinxi','新增')"
                 :style='{"cursor":"pointer","border":"0","padding":"0px 10px","margin":"0 4px 0 0","color":"#fff","minWidth":"90px","outline":"none","borderRadius":"30px","background":"#f7aa00","width":"auto","fontSize":"14px","lineHeight":"42px","height":"42px"}'
                 type="primary" @click="add('/index/geshouxinxiAdd')"><i v-if="true"
                                                                         :style='{"color":"#fff","margin":"0 10px 0 0","fontSize":"14px"}'
                                                                         class="el-icon-circle-plus-outline"></i>添加
      </el-button>-->
    </el-form>

    <div class="list" :style='{"padding":"40px 0 20px","margin":"40px 7% 0","background":"none","flex":"1","width":"100%","minWidth":"850px","order":"4"}'>
      <!-- 样式一 -->

      <!-- 样式二 -->
      <div v-if="isShow" class="list2 index-pv1"
           :style='{"padding":"0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
        <div :style='{"cursor":"pointer","padding":"10px","margin":"0 0 100px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230206/de4c50b5282f45f8a59707bce3185db8.png) no-repeat left bottom / 20%,url(http://codegen.caihongy.cn/20230206/5e80378b411c4449a860d66e35c5c969.png) no-repeat right top / 20%","display":"flex","width":"49%","fontSize":"0","position":"relative","justifyContent":"space-between","height":"240px"}'
            v-for="(item, index) in dataList" :key="index" @click="toDetail(item)" class="list-item animation-box">
          <img :style='{"width":"52%","padding":"20px","objectFit":"contain","display":"inline-block","height":"100%"}'
               v-if="item.touxiang && item.touxiang.substr(0,4)==='http'" :src="item.touxiang" class="image"/>
          <img :style='{"width":"52%","padding":"20px","objectFit":"contain","display":"inline-block","height":"100%"}'
               v-else :src="baseUrl + (item.touxiang?item.touxiang.split(',')[0]:'')" class="image"/>
          <div class="item-info"
               :style='{"padding":"10px","overflow":"hidden","top":"60px","alignItems":"flex-start","borderRadius":"8px","flexWrap":"wrap","display":"flex","width":"44%","position":"absolute","right":"30px","justifyContent":"center","height":"90%"}'>
            <div
                :style='{"border":"0 dashed #bcdbdf","padding":"0 10px","margin":"0 10px 0 0","color":"#333","textAlign":"center","borderWidth":"0 1px 0 0","width":"40px","lineHeight":"1.2","fontSize":"14px"}'
                class="name ">{{ item.geshouxingming }}
            </div>
            <div v-if="item.price"
                 :style='{"width":"100%","padding":"0 4px","lineHeight":"24px","fontSize":"14px","color":"#f00","textAlign":"center"}'
                 class="price"><span :style='{"fontSize":"12px"}'>￥</span>{{ item.price }}
            </div>
          </div>
        </div>
      </div>

      <!--   地图   -->
      <el-card v-else class="el-card-map" style="margin-top: 5px;height: 800px;width: 100%;">
        <div id="mapsDiv" style="position: relative;height: 100%;width: 100%;">
          <el-amap vid="amapDemo" :zoom="zoom" :center="center" :amap-manager="amapManager">
            <el-amap-marker v-for="(marker, index) in markers" :key="index" :position="marker.position"
                            :visible="marker.visible" :draggable="marker.draggable" :icon="marker.icon"
                            :label="marker.label"
                            :vid="index" :events="marker.events" :extData="marker.extData"></el-amap-marker>
          </el-amap>
          <img class="full_screen" :src="!fullScreen ? fullScreenImg : notFullScreenImg" title="全屏缩放"
               @click="toFullScreen()" alt="全屏缩放"/>
        </div>
      </el-card>
    </div>


    <el-pagination
        background
        class="pagination"
        :pager-count="7"
        :page-size="pageSize"
        :page-sizes="pageSizes"
        prev-text="<"
        next-text=">"
        :hide-on-single-page="true"
        :layout='["total","prev","pager","next","sizes","jumper"].join()'
        :total="total"
        :style='{"padding":"0","margin":"10px auto","whiteSpace":"nowrap","color":"#333","textAlign":"center","width":"1200px","fontWeight":"500"}'
        @current-change="curChange"
        @size-change="sizeChange"
        @prev-click="prevClick"
        @next-click="nextClick"
    ></el-pagination>

  </div>
</div>
</template>

<script>
import {AMapManager} from "vue-amap";

let amapManager = new AMapManager();
let map;
  import {getMap} from "core-js/internals/reflect-metadata";

  export default {
    //数据集合
    data() {
      return {
        isShow: true,
        layouts: '',
        swiperIndex: -1,
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '推荐信息'
          }
        ],
        formSearch: {
          geshouxingming: '',
          geshouxingbie: '',
          biaoqian: '',
          diqu: '',
        },
        fenlei: [],
        dataList: [],
        total: 1,
        pageSize: 12,
        pageSizes: [10, 20, 30, 50],
        totalPage: 1,
        curFenlei: '全部',
        isPlain: false,
        indexQueryCondition: '',
        geshouxingbieOptions: [],
        diquOptions: [],
        timeRange: [],

        // aMap
        amapManager,
        fullScreen: false, // 是否全屏
        fullScreenImg: require("../../assets/img/full_screen_in.png"),
        notFullScreenImg: require("../../assets/img/full_screen_out.png"),
        allCount: 0,
        overTimeCount: 0,
        normalCount: 0,
        waringCount: 0,
        count: 0.5,
        img: require("../../assets/img/xiaoche.png"),
        zoom: 5,
        center: [108.94,34.34],
        markers: []
      }
    },
    created() {
      this.indexQueryCondition = this.$route.query.indexQueryCondition ? this.$route.query.indexQueryCondition : '';
      this.baseUrl = this.$config.baseUrl;
      this.geshouxingbieOptions = '男,女'.split(',');
      this.diquOptions = '大陆,港台,日韩,欧美,其它地区'.split(',');
      this.getFenlei();
      this.getList(1, '全部');
    },
    mounted() {
      this.addMarker();
      this.timer = setInterval(() => {
        setTimeout(this.addMarker, 0)
      }, 1000 * 60 * 1);
    },
    //方法集合
    methods: {

      addMarker() {
        {
          let jsonString = "{\n" +
              "  \"normalCount\": 1,\n" +
              "  \"allCount\": 798,\n" +
              "  \"cars\": [\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖经开区鞍山路3号/芜湖经开区华山路\",\n" +
              "      \"etdvDoKry\": \"22973FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"芜湖长久物流有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L75348\",\n" +
              "      \"ettaLocation\": \"106.5516,29.563\",\n" + // 重庆
              "      \"ettaEtveCard\": \"京AFD068\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖经开区鞍山路3号/芜湖经开区华山路\",\n" +
              "      \"etdvDoKry\": \"10574FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"赵雷/喜子\",\n" +
              "      \"ettaEblnLineName\": \"赵雷/喜子/姜北生\",\n" +
              "      \"ettaLocation\": \"104.0657,30.6595\",\n" + // 成都
              "      \"ettaEtveCard\": \"成都\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"安徽省安庆市经济开发区三期方兴路与站南路交叉口\",\n" +
              "      \"etdvDoKry\": \"LY-GLFY202208100003\",\n" +
              "      \"ettaCarrierEbcuName\": \"海南长久物流有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L80128\",\n" +
              "      \"ettaLocation\": \"112.9388,28.2283\",\n" + // 长沙
              "      \"ettaEtveCard\": \"皖M13499\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"安徽省安庆市经济开发区三期方兴路与站南路交叉口\",\n" +
              "      \"etdvDoKry\": \"17419FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"海南长久物流有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L91998\",\n" +
              "      \"ettaLocation\": \"121.4651,25.0123\",\n" + // 台北
              "      \"ettaEtveCard\": \"皖M14125\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖经开区鞍山路3号/芜湖经开区华山路\",\n" +
              "      \"etdvDoKry\": \"18252FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"芜湖长久物流有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L75696\",\n" +
              "      \"ettaLocation\": \"116.30,39.93\",\n" + // 广东
              "      \"ettaEtveCard\": \"皖M15693\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖经开区鞍山路3号/芜湖经开区华山路\",\n" +
              "      \"etdvDoKry\": \"21930FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"芜湖长久物流有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L75619\",\n" +
              "      \"ettaLocation\": \"114.17,22.28\",\n" + // 香港
              "      \"ettaEtveCard\": \"皖M15762\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖经开区鞍山路3号/芜湖经开区华山路\",\n" +
              "      \"etdvDoKry\": \"17458FY202208090002\",\n" +
              "      \"ettaCarrierEbcuName\": \"芜湖长久物流有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L75710\",\n" +
              "      \"ettaLocation\": \"120.38,36.07\",\n" + // 青岛
              "      \"ettaEtveCard\": \"皖M17240\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖经开区鞍山路3号/芜湖经开区华山路\",\n" +
              "      \"etdvDoKry\": \"23472FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"芜湖长久物流有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L75499\",\n" +
              "      \"ettaLocation\": \"104.68,31.47\",\n" + // 绵阳
              "      \"ettaEtveCard\": \"皖M24377\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖市经济技术开发区淮河路安之达库（方通物流）\",\n" +
              "      \"etdvDoKry\": \"22384FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"北京方通物流有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L80350\",\n" +
              "      \"ettaLocation\": \"120.21,30.25\",\n" +  // 杭州
              "      \"ettaEtveCard\": \"粤ADB915\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖市鸠江区九华北路183号\",\n" +
              "      \"etdvDoKry\": \"20169FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"襄阳大正物流有限公司（大正物流）\",\n" +
              "      \"ettaEblnLineName\": \"L75848\",\n" +
              "      \"ettaLocation\": \"114.30,30.59\",\n" +  // 武汉
              "      \"ettaEtveCard\": \"粤ADN438\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖市经济技术开发区淮河路安之达库（方通物流）\",\n" +
              "      \"etdvDoKry\": \"23607FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"北京方通物流有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L094683\",\n" +
              "      \"ettaLocation\": \"106.63,26.65\",\n" +  // 贵阳
              "      \"ettaEtveCard\": \"粤ADV893\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"安徽省安庆市经济开发区三期方兴路与站南路交叉口\",\n" +
              "      \"etdvDoKry\": \"ZBWLFY202208100004\",\n" +
              "      \"ettaCarrierEbcuName\": \"海南长久物流有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L80128\",\n" +
              "      \"ettaLocation\": \"108.94,34.34\",\n" +  // 西安
              "      \"ettaEtveCard\": \"苏A5C873\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖市经济技术开发区华山路198号（长久北库）\",\n" +
              "      \"etdvDoKry\": \"17580FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"吉林恒远物流有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L75747\",\n" +
              "      \"ettaLocation\": \"113.26,23.13\",\n" + // 广州
              "      \"ettaEtveCard\": \"苏JS1897\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖市经济技术开发区鞍山路达奥库（日日顺物流）\",\n" +
              "      \"etdvDoKry\": \"17561FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"青岛日日顺供应链有限公司\",\n" +
              "      \"ettaEblnLineName\": \"L76267\",\n" +
              "      \"ettaLocation\": \"106.75,31.87\",\n" +  // 巴中
              "      \"ettaEtveCard\": \"调整运输方式\"\n" +
              "    },\n" +
              "    {\n" +
              "      \"etdvDepartureAddress\": \"芜湖市鸠江区九华北路183号\",\n" +
              "      \"etdvDoKry\": \"23145FY202208100001\",\n" +
              "      \"ettaCarrierEbcuName\": \"襄阳大正物流有限公司（大正物流）\",\n" +
              "      \"ettaEblnLineName\": \"L75871\",\n" +
              "      \"ettaLocation\": \"108.37,22.82\",\n" + // 南宁市
              "      \"ettaEtveCard\": \"鄂FTV150\"\n" +
              "    }\n" +
              "  ],\n" +
              "  \"waringCount\": 0,\n" +
              "  \"overTimeCount\": 797\n" +
              "}";

          let result = JSON.parse(jsonString);
          this.allCount = result.allCount;
          this.overTimeCount = result.overTimeCount;
          this.normalCount = result.normalCount;
          this.waringCount = result.waringCount;
          this.markers = [];
          let list = result.cars;
          let label = {};
          list.forEach((item) => {
            const $item = item.ettaLocation;
            let positions = $item.split(",");
            const $remark =
                "单曲：" +
                (item.ettaEtveCard || " ") +
                "<br />" +
                "编曲：" +
                (item.ettaCarrierEbcuName || " ") +
                "<br />" +
                "制作人：" +
                (item.ettaEblnLineName || " ");
            if (map === undefined || map === null) {
              map = amapManager.getMap();
            }
            let markerTemp = {
              map: map,
              position: [positions[0], positions[1]],
              visible: true,
              draggable: false,
              icon: this.img,
              label: {
                // content: $remark,
                // offset: [50, 2]
              },
              extData: item,
              events: {
                // 鼠标移动到marker点显示label
                mouseover: (e) => {
                  markerTemp.label = {
                    content: $remark,
                    offset: [-70, -85],
                  };
                },
                // 鼠标移除marker点label消失
                mouseout: (e) => {
                  markerTemp.label = {};
                },
              },
            };
            this.markers.push(markerTemp);
          });
        }
      },
      //全屏
      toFullScreen() {
        // let element = document.documentElement;//设置后就是我们平时的整个页面全屏效果
        let element = document.getElementById("mapsDiv"); //（）填容器需要全屏的id
        if (this.fullScreen) {
          if (document.exitFullscreen) {
            document.exitFullscreen();
          } else if (document.webkitCancelFullScreen) {
            document.webkitCancelFullScreen();
          } else if (document.mozCancelFullScreen) {
            document.mozCancelFullScreen();
          } else if (document.msExitFullscreen) {
            document.msExitFullscreen();
          }
          this.zoom = 5;
          this.center = [108.94,34.34];
        } else {
          if (element.requestFullscreen) {
            element.requestFullscreen();
          } else if (element.webkitRequestFullScreen) {
            element.webkitRequestFullScreen();
          } else if (element.mozRequestFullScreen) {
            element.mozRequestFullScreen();
          } else if (element.msRequestFullscreen) {
            // IE11
            element.msRequestFullscreen();
          }
          this.zoom = 5;
          this.center = [105.26948, 36.843178];
        }
        this.fullScreen = !this.fullScreen;
      },
      getMap() {
        this.isShow = false;
        // this.$router.push({path: '/index/mapDealer'});
      },
      add(path) {
        this.$router.push({path: path});
      },
      getFenlei() {
      },
      getList(page, fenlei, ref = '') {
        this.isShow = true;
        let params = {page, limit: this.pageSize};
        let searchWhere = {};
        if (this.formSearch.geshouxingming != '') searchWhere.geshouxingming = '%' + this.formSearch.geshouxingming + '%';
        if (this.formSearch.geshouxingbie != '') searchWhere.geshouxingbie = this.formSearch.geshouxingbie;
        if (this.formSearch.biaoqian != '') searchWhere.biaoqian = '%' + this.formSearch.biaoqian + '%';
        if (this.formSearch.diqu != '') searchWhere.diqu = this.formSearch.diqu;
        this.$http.get('geshouxinxi/list', {params: Object.assign(params, searchWhere)}).then(res => {
          if (res.data.code === 0) {
            let data = res.data.data;
            let list = data.list;
            // 对数组进行无序随机排序
            list = list.sort(() => Math.random() - 0.5);
            this.dataList = list;
            this.total = data.total;
            this.pageSize = data.pageSize;
            this.totalPage = data.totalPage;

            this.pageSizes = [this.pageSize, this.pageSize * 2, this.pageSize * 3, this.pageSize * 5];
          }
        });
      },
      curChange(page) {
        this.getList(page);
      },
      prevClick(page) {
        this.getList(page);
      },
      sizeChange(size) {
        this.pageSize = size
        this.getList(1);
      },
      nextClick(page) {
        this.getList(page);
      },
      toDetail(item) {
        this.$router.push({path: '/index/geshouxinxiDetail', query: {detailObj: JSON.stringify(item)}});
      },
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.list-preview .list-form-pv .el-input {
		width: auto;
	}

	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 9px;
		color: #666;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner a {
		color: #999;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner {
		color: #333;
		display: inline-block;
	}
	
	.category-1 .item {
		cursor: pointer;
		border: 0 solid #a8c4d9;
		padding: 0 10px;
		margin: 0 10px 10px 0;
		color: #333;
		font-size: 15px;
		line-height: 47px;
		border-radius: 10px;
		box-shadow: inset 0px 0px 32px 0px #b6d7de;
		background: #fff;
		width: auto;
		border-width: 0 2px;
		text-align: center;
		min-width: 110px;
		height: 51px;
	}
	
	.category-1 .item:hover {
		cursor: pointer;
		border: 0 solid #40a8cd;
		margin: 0 10px 10px 0;
		color: #333;
		font-size: 15px;
		line-height: 47px;
		border-radius: 10px;
		box-shadow: inset 0px 0px 32px 0px #40a8c4;
		background: #fff;
		width: auto;
		border-width: 0 2px;
		text-align: center;
		min-width: 110px;
	}
	
	.category-1 .item.active {
		cursor: pointer;
		border: 0 solid #40a8c4;
		margin: 0 10px 10px 0;
		color: #333;
		font-size: 15px;
		line-height: 47px;
		border-radius: 10px;
		box-shadow: inset 0px 0px 32px 0px #40a8c4;
		background: #fff;
		width: auto;
		border-width: 0 2px;
		text-align: center;
		min-width: 110px;
	}
	
	.category-2 .item {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item:hover {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item.active {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.list-form-pv .el-input /deep/ .el-input__inner {
		border: 1px solid #eee;
		border-radius: 30px;
		padding: 0 10px;
		margin: 0;
		outline: none;
		color: #666;
		width: 140px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list-form-pv .el-select /deep/ .el-input__inner {
		border: 1px solid #eee;
		border-radius: 30px;
		padding: 0 10px;
		margin: 0;
		outline: none;
		color: #666;
		width: 120px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list-form-pv .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #eee;
		border-radius: 30px;
		padding: 0 30px;
		margin: 0;
		outline: none;
		color: #666;
		width: 140px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list .index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.list .index-pv1 .animation-box:hover {
		transform:  translate3d(0px,10px, 0px);
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: 0.3s;
		z-index: 1;
	}
	
	.list .index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.list .index-pv1 .animation-box img:hover {
		transform: skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: 0.3s;
	}
	
	.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f4f4f5;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #409EFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #235784;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #235784;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}
	
	.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}

  .full_screen {
    position: absolute;
    height: 45px;
    top: 20px;
    right: 20px;
    padding: 10px;
    background: #90939963;
    cursor: pointer;
    /* opacity:0.2;   */
  }
</style>
