<template>
  <div class="amap-page-container" v-loading="loading" style="height: 1000px; background-color: red;">
    <el-card class="el-card-map" style="margin-top: 5px;height: 100%;width: 100%;">
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
</template>

<script>
import {AMapManager} from "vue-amap";

let amapManager = new AMapManager();
let map, marker, polyline, polygon;
export default {

  name: "VehicleVisula",
  data() {
    return {
      loading: false,
      amapManager,
      queryForm: {
        etdvSaleCompanyName: "",
        etdvCustomerName: "",
        etdvCarrierName: "",
        vin: "",
        etdvErpNo: "",
        etdvSaleEquName: "",
        deliveryCreateTime: "",
        etdvStatus: "",
        etdvVehicleCard: "",
        etdvIntention: "",
        currentStatus: "",
      },
      etdvStatusOptions: [
        {code: "", description: ""},
        {code: "10", description: "下发"},
        {code: "20", description: "确认"},
        {code: "30", description: "执行中"},
      ],
      currentStatusOptions: [
        {code: "", description: ""},
        {code: "1", description: "客户订单"},
        {code: "4", description: "备库车辆"},
        {code: "5", description: "其他"},
      ],
      etdvCompanyOptions: [
        {code: "", description: ""},
        {code: "1000", description: "股份"},
        {code: "2000", description: "营销"},
        {code: "2001", description: "星途"},
        {code: "2020", description: "国际"},
      ],
      allCount: 0,
      overTimeCount: 0,
      normalCount: 0,
      waringCount: 0,
      count: 0.5,
      img: require("../../assets/img/xiaoche.png"),
      zoom: 14,
      center: [118.374169, 31.424962],
      markers: [],
      isClick1: false,
      isClick2: false,
      isClick3: false,
      isClick4: false,
      click1: true,
      click2: true,
      click3: true,
      click4: true,
      detail1: {},
      detail2: {},
      detail3: {},
      detail4: {},
      fullScreen: false, // 是否全屏
      fullScreenImg: require("../../assets/img/full_screen_in.png"),
      notFullScreenImg: require("../../assets/img/full_screen_out.png"),
      // 弹出的表格数据
      queryType: null,
      dialogTableVisible: false,
      dialogTitle: null,
      pageNo: 1,
      pageSize: 20,
      total: 0,
      dataList: [
        // {
        //   etdvId: "1",
        //   etdvCarrierName: "奇瑞汽车(芜湖)滚装码头有限公司(2)",
        //   etdvCarrierCode: 200333,
        //   countVin: 100
        // },
        // {
        //   etdvId: "2",
        //   etdvCarrierName: "海南长久物流有限公司",
        //   etdvCarrierCode: 200333,
        //   countVin: 100
        // }
      ],
      form: {
        etdvCarrierName: null,
        etdvCarrierCode: null,
      },
      timer: null,
    };
  },
  mounted() {
    this.addMarker();
    this.timer = setInterval(() => {
      setTimeout(this.addMarker, 0)
    }, 1000 * 60 * 1);
  },
  beforeDestroy() {
    clearInterval(this.timer);
    this.timer = null;
  },
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
            "      \"ettaLocation\": \"118.378788,31.431831\",\n" +
            "      \"ettaEtveCard\": \"京AFD068\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"芜湖经开区鞍山路3号/芜湖经开区华山路\",\n" +
            "      \"etdvDoKry\": \"10574FY202208100001\",\n" +
            "      \"ettaCarrierEbcuName\": \"芜湖长久物流有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L75691\",\n" +
            "      \"ettaLocation\": \"118.378788,31.431831\",\n" +
            "      \"ettaEtveCard\": \"皖M11739\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"安徽省安庆市经济开发区三期方兴路与站南路交叉口\",\n" +
            "      \"etdvDoKry\": \"LY-GLFY202208100003\",\n" +
            "      \"ettaCarrierEbcuName\": \"海南长久物流有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L80128\",\n" +
            "      \"ettaLocation\": \"117.176960,30.555799\",\n" +
            "      \"ettaEtveCard\": \"皖M13499\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"安徽省安庆市经济开发区三期方兴路与站南路交叉口\",\n" +
            "      \"etdvDoKry\": \"17419FY202208100001\",\n" +
            "      \"ettaCarrierEbcuName\": \"海南长久物流有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L91998\",\n" +
            "      \"ettaLocation\": \"117.176960,30.555799\",\n" +
            "      \"ettaEtveCard\": \"皖M14125\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"芜湖经开区鞍山路3号/芜湖经开区华山路\",\n" +
            "      \"etdvDoKry\": \"18252FY202208100001\",\n" +
            "      \"ettaCarrierEbcuName\": \"芜湖长久物流有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L75696\",\n" +
            "      \"ettaLocation\": \"118.378788,31.431831\",\n" +
            "      \"ettaEtveCard\": \"皖M15693\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"芜湖经开区鞍山路3号/芜湖经开区华山路\",\n" +
            "      \"etdvDoKry\": \"21930FY202208100001\",\n" +
            "      \"ettaCarrierEbcuName\": \"芜湖长久物流有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L75619\",\n" +
            "      \"ettaLocation\": \"118.378788,31.431831\",\n" +
            "      \"ettaEtveCard\": \"皖M15762\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"芜湖经开区鞍山路3号/芜湖经开区华山路\",\n" +
            "      \"etdvDoKry\": \"17458FY202208090002\",\n" +
            "      \"ettaCarrierEbcuName\": \"芜湖长久物流有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L75710\",\n" +
            "      \"ettaLocation\": \"118.378788,31.431831\",\n" +
            "      \"ettaEtveCard\": \"皖M17240\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"芜湖经开区鞍山路3号/芜湖经开区华山路\",\n" +
            "      \"etdvDoKry\": \"23472FY202208100001\",\n" +
            "      \"ettaCarrierEbcuName\": \"芜湖长久物流有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L75499\",\n" +
            "      \"ettaLocation\": \"118.378788,31.431831\",\n" +
            "      \"ettaEtveCard\": \"皖M24377\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"芜湖市经济技术开发区淮河路安之达库（方通物流）\",\n" +
            "      \"etdvDoKry\": \"22384FY202208100001\",\n" +
            "      \"ettaCarrierEbcuName\": \"北京方通物流有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L80350\",\n" +
            "      \"ettaLocation\": \"118.370496,31.410845\",\n" +
            "      \"ettaEtveCard\": \"粤ADB915\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"芜湖市鸠江区九华北路183号\",\n" +
            "      \"etdvDoKry\": \"20169FY202208100001\",\n" +
            "      \"ettaCarrierEbcuName\": \"襄阳大正物流有限公司（大正物流）\",\n" +
            "      \"ettaEblnLineName\": \"L75848\",\n" +
            "      \"ettaLocation\": \"118.407680,31.428060\",\n" +
            "      \"ettaEtveCard\": \"粤ADN438\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"芜湖市经济技术开发区淮河路安之达库（方通物流）\",\n" +
            "      \"etdvDoKry\": \"23607FY202208100001\",\n" +
            "      \"ettaCarrierEbcuName\": \"北京方通物流有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L094683\",\n" +
            "      \"ettaLocation\": \"118.370496,31.410845\",\n" +
            "      \"ettaEtveCard\": \"粤ADV893\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"安徽省安庆市经济开发区三期方兴路与站南路交叉口\",\n" +
            "      \"etdvDoKry\": \"ZBWLFY202208100004\",\n" +
            "      \"ettaCarrierEbcuName\": \"海南长久物流有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L80128\",\n" +
            "      \"ettaLocation\": \"116.85723142117773,33.88446630432838\",\n" +
            "      \"ettaEtveCard\": \"苏A5C873\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"芜湖市经济技术开发区华山路198号（长久北库）\",\n" +
            "      \"etdvDoKry\": \"17580FY202208100001\",\n" +
            "      \"ettaCarrierEbcuName\": \"吉林恒远物流有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L75747\",\n" +
            "      \"ettaLocation\": \"118.387814,31.473639\",\n" +
            "      \"ettaEtveCard\": \"苏JS1897\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"芜湖市经济技术开发区鞍山路达奥库（日日顺物流）\",\n" +
            "      \"etdvDoKry\": \"17561FY202208100001\",\n" +
            "      \"ettaCarrierEbcuName\": \"青岛日日顺供应链有限公司\",\n" +
            "      \"ettaEblnLineName\": \"L76267\",\n" +
            "      \"ettaLocation\": \"118.370496,31.410845\",\n" +
            "      \"ettaEtveCard\": \"调整运输方式\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"etdvDepartureAddress\": \"芜湖市鸠江区九华北路183号\",\n" +
            "      \"etdvDoKry\": \"23145FY202208100001\",\n" +
            "      \"ettaCarrierEbcuName\": \"襄阳大正物流有限公司（大正物流）\",\n" +
            "      \"ettaEblnLineName\": \"L75871\",\n" +
            "      \"ettaLocation\": \"118.407680,31.428060\",\n" +
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
        console.log(list);
        let label = {};
        list.forEach((item) => {
          const $item = item.ettaLocation;
          let positions = $item.split(",");
          const $remark =
              "车牌号：" +
              (item.ettaEtveCard || " ") +
              "<br />" +
              "承运商：" +
              (item.ettaCarrierEbcuName || " ") +
              "<br />" +
              "线路名：" +
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
        this.zoom = 14;
        this.center = [118.374169, 31.424962];
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
  }
};
</script>

<style>
.el-card-map .el-card__body {
  height: 100%;
}

.amap-page-container .el-select {
  width: 120px;
}

.amap-page-container .el-input {
  width: 120px;
}
</style>

<style scoped>
.amap-demo {
  height: 880px;
}

.amap-demo-full {
  height: 100%;
}

#test {
  position: absolute;
  top: 40px;
  left: 30px;
  padding: 4px;
  background: white;
}

.test-text {
  height: 26px;
  line-height: 26px;
  font-size: 13px;
  position: relative;
  padding-right: 16px;
}

.test-text button {
  padding: 0;
}

.test-text p {
  margin: 0;
  height: 20px;
  line-height: 20px;
  padding-left: 8px;
}

.test-text p span {
  margin-right: 4px;
}

.test-text i {
  position: absolute;
  right: 2px;
  top: 6px;
}

.show-detail {
  height: 150px;
  overflow: hidden;
}

.el-form table tr td .el-form-item {
  margin: 0px;
  padding: 0px;
}

.el-form-item {
  margin-bottom: 0px;
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

#mapsDiv >>> .el-dialog {
  max-height: 800px;
}

#mapsDiv >>> .el-divider--horizontal {
  margin: 4px 0;
}

#mapsDiv >>> .amap-marker-label {
  border: 0 none !important;
  background-color: #fff;
  white-space: nowrap;
  box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.3);
  border-radius: 5px;
  line-height: 24px;
  font-size: 12px;
  padding: 2px 10px;
  z-index: 100;
}

#mapsDiv >>> .amap-marker-label:after {
  position: absolute;
  border: 5px solid transparent;
  border-top-color: #fff;
  top: 75px;
  left: 43%;
  content: "";
  width: 0;
  height: 0;
}
</style>