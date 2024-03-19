<template>
  <div class="amap-page-container" v-loading="loading" style="height: 100%; background-color: red;">
    <el-card>
      <div>
<!--        <el-form label-width="80px" size="mini" :inline="true">
          <table>
            <tr>
              <td>
                <el-form-item label="销售公司" abel-position="left" prop="etdvSaleCompanyName">
                  <el-select v-model="queryForm.etdvSaleCompanyName" placeholder="请选择">
                    <el-option v-for="item in etdvCompanyOptions" :key="item.code" :label="item.description"
                               :value="item.code">
                    </el-option>s
                  </el-select>
                </el-form-item>
              </td>
              <td>
                <el-form-item label="经销商" abel-position="left" prop="etdvCustomerName">
                  <el-input v-model="queryForm.etdvCustomerName"/>
                </el-form-item>
              </td>
              <td>
                <el-form-item label="承运商" abel-position="left" prop="etdvCarrierName">
                  <el-input v-model="queryForm.etdvCarrierName"/>
                </el-form-item>
              </td>
              <td>
                <el-form-item label="VIN" abel-position="left" prop="vin">
                  <el-input v-model="queryForm.vin"/>
                </el-form-item>
              </td>
              <td>
                <el-form-item label="车牌" abel-position="left" prop="etdvVehicleCard">
                  <el-input v-model="queryForm.etdvVehicleCard"/>
                </el-form-item>
              </td>
            </tr>
            <tr>
              <td>
                <el-form-item label="车型" abel-position="left" prop="etdvSaleEquName">
                  <el-input v-model="queryForm.etdvSaleEquName"/>
                </el-form-item>
              </td>
              <td>
                &lt;!&ndash; label="交货单创建日期" &ndash;&gt;
                <el-form-item label="创建日期" abel-position="left" prop="deliveryCreateTime">
                  <el-input type="date" v-model="queryForm.deliveryCreateTime"/>
                </el-form-item>
              </td>
              <td>
                <el-form-item label="ERP单号" abel-position="left" prop="etdvErpNo">
                  <el-input v-model="queryForm.etdvErpNo"/>
                </el-form-item>
              </td>
              <td>
                <el-form-item label="运单状态" abel-position="left" prop="etdvStatus">
                  <el-select v-model="queryForm.etdvStatus" placeholder="请选择">
                    <el-option v-for="item in etdvStatusOptions" :key="item.code" :label="item.description"
                               :value="item.code">
                    </el-option>
                  </el-select>
                </el-form-item>
              </td>
              <td>
                <el-form-item label="订单类型" abel-position="left" prop="etdvIntention">
                  <el-select v-model="queryForm.etdvIntention" placeholder="请选择">
                    <el-option v-for="item in currentStatusOptions" :key="item.code" :label="item.description"
                               :value="item.code">
                    </el-option>
                  </el-select>
                </el-form-item>
              </td>
            </tr>
          </table>

          <el-form-item style="float: right">
            <el-button type="info" @click="addMarker">查询</el-button>
          </el-form-item>
        </el-form>-->
      </div>
    </el-card>
    <el-card class="el-card-map" style="margin-top: 5px;height: 100%;width: 100%;">
      <div id="mapsDiv" style="position: relative;height: 100%;width: 100%;">
        <el-amap vid="amapDemo" :zoom="zoom" :center="center" :amap-manager="amapManager">
          <el-amap-marker v-for="(marker, index) in markers" :key="index" :position="marker.position"
                          :visible="marker.visible" :draggable="marker.draggable" :icon="marker.icon"
                          :label="marker.label"
                          :vid="index" :events="marker.events" :extData="marker.extData"></el-amap-marker>
        </el-amap>
        <div id="test">
          <el-row>
            <div class="test-text" :class="click2 ? 'show-detail' : ''">
              <el-button type="text" :loading="this.isClick2" @click="clickMap(0)">在途数量：&nbsp;{{
                  allCount
                }}
              </el-button>
              <i class="el-icon-more" @click="showClick(2)"></i>
              <el-collapse-transition>
                <div v-show="click2">
                  <p><span>营销:</span>{{ this.detail2['营销'] }}</p>
                  <p><span>星途:</span>{{ this.detail2['星途'] }}</p>
                  <p><span>国际:</span>{{ this.detail2['国际'] }}</p>
                  <p><span>星途国际:</span>{{ this.detail2['星途国际'] }}</p>
                  <p><span>新能源:</span>{{ this.detail2['新能源'] }}</p>
                  <p><span>商用车:</span>{{ this.detail2['商用车'] }}</p>
                </div>
              </el-collapse-transition>
            </div>
            <div class="test-text" :class="click4 ? 'show-detail' : ''">
              <el-button type="text" :loading="this.isClick4" @click="clickMap(1)">正常数量：&nbsp;{{ normalCount }}
              </el-button>
              <i class="el-icon-more" @click="showClick(4)"></i>
              <el-collapse-transition>
                <div v-show="click4">
                  <p><span>营销:</span>{{ this.detail4['营销'] }}</p>
                  <p><span>星途:</span>{{ this.detail4['星途'] }}</p>
                  <p><span>国际:</span>{{ this.detail4['国际'] }}</p>
                  <p><span>星途国际:</span>{{ this.detail4['星途国际'] }}</p>
                  <p><span>新能源:</span>{{ this.detail4['新能源'] }}</p>
                  <p><span>商用车:</span>{{ this.detail4['商用车'] }}</p>
                </div>
              </el-collapse-transition>
            </div>
            <div class="test-text" :class="click1 ? 'show-detail' : ''">
              <el-button type="text" :loading="this.isClick1" @click="clickMap(2)">超时数量：&nbsp;{{ overTimeCount }}
              </el-button>
              <i class="el-icon-more" @click="showClick(1)"></i>
              <el-collapse-transition>
                <div v-show="click1">
                  <p><span>营销:</span>{{ this.detail1['营销'] }}</p>
                  <p><span>星途:</span>{{ this.detail1['星途'] }}</p>
                  <p><span>国际:</span>{{ this.detail1['国际'] }}</p>
                  <p><span>星途国际:</span>{{ this.detail1['星途国际'] }}</p>
                  <p><span>新能源:</span>{{ this.detail1['新能源'] }}</p>
                  <p><span>商用车:</span>{{ this.detail1['商用车'] }}</p>
                </div>
              </el-collapse-transition>
            </div>
            <div class="test-text" :class="click3 ? 'show-detail' : ''">
              <el-button type="text" :loading="this.isClick4" @click="clickMap(3)">预警数量：&nbsp;{{ waringCount }}
              </el-button>
              <i class="el-icon-more" @click="showClick(3)"></i>
              <el-collapse-transition>
                <div v-show="click3">
                  <p><span>营销:</span>{{ this.detail3['营销'] }}</p>
                  <p><span>星途:</span>{{ this.detail3['星途'] }}</p>
                  <p><span>国际:</span>{{ this.detail3['国际'] }}</p>
                  <p><span>星途国际:</span>{{ this.detail3['星途国际'] }}</p>
                  <p><span>新能源:</span>{{ this.detail3['新能源'] }}</p>
                  <p><span>商用车:</span>{{ this.detail3['商用车'] }}</p>
                </div>
              </el-collapse-transition>
            </div>
          </el-row>
        </div>
        <img class="full_screen" :src="!fullScreen ? fullScreenImg : notFullScreenImg" title="全屏缩放"
             @click="toFullScreen()"/>
        <el-dialog :title="dialogTitle" :visible.sync="dialogTableVisible" :modal-append-to-body="false"
                   :close-on-click-modal="false" width="60%">
          <el-form :model="form" label-width="90px" :inline="true" size="mini">
            <el-form-item label="承运商名称">
              <el-input style="width:140px" v-model="form.etdvCarrierName"></el-input>
            </el-form-item>
            <el-form-item label="编码">
              <el-input style="width:140px" v-model="form.etdvCarrierCode"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="getAll">查询所有</el-button>
            </el-form-item>
          </el-form>
          <!-- <el-divider></el-divider> -->
          <el-table :data="dataList" height="450">
            <el-table-column property="etdvId" label="序号"></el-table-column>
            <el-table-column property="etdvCarrierName" label="承运商名称" width="280"></el-table-column>
            <el-table-column property="etdvCarrierCode" label="编码"></el-table-column>
            <el-table-column property="countVin" label="在途数量">
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
              </template>
            </el-table-column>
          </el-table>

          <el-pagination style="margin-top:10px;" background @size-change="handleSizeChange"
                         @current-change="handleCurrentChange" :current-page="pageNo" :page-sizes="[20, 50, 100]"
                         :page-size="pageSize" layout="total, sizes, prev, pager, next" :total="total">
          </el-pagination>
        </el-dialog>
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
      this.getDetails(1);
      this.getDetails(2);
      this.getDetails(3);
      this.getDetails(4);
    }, 1000 * 60 * 1);
  },
  beforeDestroy() {
    clearInterval(this.timer);
    this.timer = null;
  },
  methods: {
    closeLoading() {
      this.isClick1 = false;
      this.isClick2 = false;
      this.isClick3 = false;
      this.isClick4 = false;
    },

    currentStatusChange(data) {
      debugger;
      this.closeLoading();
      if (data === "") {
        this.isClick1 = true;
      } else if (data === "1") {
        this.isClick2 = true;
      } else if (data === "2") {
        this.isClick3 = true;
      } else if (data === "3") {
        this.isClick4 = true;
      }
    },

    clickMap(data) {
      //修改为展示表格
      this.queryType = data;
      this.form = {
        etdvCarrierName: null,
        etdvCarrierCode: null,
      };
      this.dialogTableVisible = true;
      this.queryTableData();

      // this.closeLoading();

      // if (data === 0) {
      //   this.isClick1 = true;
      // } else if (data === 1) {
      //   this.isClick2 = true;
      //   this.queryForm.currentStatus = "1";
      // } else if (data === 4) {
      //   this.isClick3 = true;
      //   this.queryForm.currentStatus = "2";
      // } else if (data === 5) {
      //   this.isClick4 = true;
      //   this.queryForm.currentStatus = "3";
      // }
      // this.markers = [];
      // this.addMarker();
    },
    showClick(data) {
      if (data === 1) {
        this.click1 = true;
        this.click2 = false;
        this.click3 = false;
        this.click4 = false;
      }
      if (data === 2) {
        this.click2 = true;
        this.click1 = false;
        this.click3 = false;
        this.click4 = false;
      }
      if (data === 3) {
        this.click3 = true;
        this.click2 = false;
        this.click1 = false;
        this.click4 = false;
      }
      if (data === 4) {
        this.click4 = true;
        this.click2 = false;
        this.click3 = false;
        this.click1 = false;
      }
      this.getDetails(data);
    },
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
              click: (e) => {
                debugger;
                const extData = e.target.De.extData;
                this.$store.commit("setRouteData", extData.etdvDoKry);
                this.$router.push({name: "mapDeawer"});
              },
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
    onSubmit() {
      this.pageNo = 1;
      this.queryTableData();
    },
    //获取表格
    queryTableData() {
      let type;
      switch (this.queryType) {
        case 0: //在途
          type = 2;
          this.dialogTitle = "在途数量";
          break;
        case 1: //正常
          type = 4;
          this.dialogTitle = "正常数量";
          break;
        case 2: //超时
          type = 1;
          this.dialogTitle = "超时数量";
          break;
        case 3: //预警
          type = 3;
          this.dialogTitle = "预警数量";
          break;
      }

      // let param = {
      //   pageNumber: 1,
      //   pageSize: 10,
      //   params: null,
      //   queryType: queryType //1,超时 2，在途 3，预警 4，正常
      // };
      // let queryData = {
      //   etdvCarrierName: "",
      //   etdvCarrierCode: ""
      // };
      this.$api
          .post(
              `/etDispatchOrderVehicleController/queryDispatchVehiclePageList/${this.pageNo}/${this.pageSize}/${type}`,
              this.form
          )
          .then((res) => {
            const result = res.data;
            if (result.code === 2000) {
              this.dataList = result.data.list;
              this.pageNo = result.data.pageNum;
              this.pageSize = result.data.pageSize;
              this.total = result.data.total;
            }
          });
    },
    //查看
    handleClick(row) {
      this.$store.commit("setMenuId", "508");
      let type;
      switch (this.dialogTitle) {
        case "在途数量": //在途
          type = "5";
          break;
        case "正常数量": //正常
          type = "6";
          break;
        case "超时数量": //超时
          type = "7";
          break;
        case "预警数量": //预警
          type = "8";
          break;
      }
      this.$router.push({
        name: "dispatch",
        query: {etdvCarrierName: row.etdvCarrierName, queryType: type},
      });
    },
    getAll() {
      this.$store.commit("setMenuId", "508");
      let type;
      switch (this.dialogTitle) {
        case "在途数量": //在途
          type = "5";
          break;
        case "正常数量": //正常
          type = "6";
          break;
        case "超时数量": //超时
          type = "7";
          break;
        case "预警数量": //预警
          type = "8";
          break;
      }
      this.$router.push({
        name: "dispatch",
        query: {queryType: type},
      });
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageNo = 1;
      this.pageSize = val;
      this.queryTableData();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageNo = val;
      this.queryTableData();
    },
  },
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