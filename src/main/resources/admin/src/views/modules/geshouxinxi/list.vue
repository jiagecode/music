<template>
	<div class="main-content" :style='{"minHeight":"100vh","padding":"30px 30px 30px 30px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20220730/cb552a530d5f4a9ab3f49b479dc1140f.png) center center/cover no-repeat fixed","flexDirection":"row-reverse","display":"flex","height":"auto"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"width":"10%","padding":"0 20px","margin":"0 0 20px 0","background":"#fff"}' :inline="true" :model="searchForm">
				<el-row :style='{"alignItems":"center","flexDirection":"column","display":"flex"}' >
					<div :style='{"width":"100%","margin":"0","flexDirection":"column","display":"flex"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#000","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">歌手姓名</label>
						<el-input v-model="searchForm.geshouxingming" placeholder="歌手姓名" clearable></el-input>
					</div>
					<div :style='{"width":"100%","margin":"0","flexDirection":"column","display":"flex"}' class="select" label="歌手性别" prop="geshouxingbie">
						<label :style='{"margin":"0 10px 0 0","color":"#000","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">歌手性别</label>
						<el-select  @change="geshouxingbieChange" clearable v-model="searchForm.geshouxingbie" placeholder="请选择歌手性别">
							<el-option v-for="(item,index) in geshouxingbieOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<div :style='{"width":"100%","margin":"0","flexDirection":"column","display":"flex"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#000","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">标签</label>
						<el-input v-model="searchForm.biaoqian" placeholder="标签" clearable></el-input>
					</div>
					<div :style='{"width":"100%","margin":"0","flexDirection":"column","display":"flex"}' class="select" label="地区" prop="diqu">
						<label :style='{"margin":"0 10px 0 0","color":"#000","textAlign":"center","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">地区</label>
						<el-select  @change="diquChange" clearable v-model="searchForm.diqu" placeholder="请选择地区">
							<el-option v-for="(item,index) in diquOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<el-button :style='{"border":"1px solid ","cursor":"pointer","padding":"0 24px","outline":"none","margin":"10px 0 0","color":"#857EF0","borderRadius":"4px","background":"#fff","borderImage":"linear-gradient(180deg, rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 1), rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 0.10000000149011612)) 1 1","width":"100%","fontSize":"14px","height":"40px"}' type="success" @click="search()">查询</el-button>
				</el-row>

				<el-row :style='{"margin":"20px 0","alignItems":"center","flexDirection":"column","display":"flex"}'>
					<el-button :style='{"border":"1px solid ","cursor":"pointer","padding":"0 24px","margin":"0 0 6px","outline":"none","color":"#857EF0","borderRadius":"0","background":"#fff","borderImage":"linear-gradient(180deg, rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 1), rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 0.10000000149011612)) 1 1","width":"100%","fontSize":"14px","height":"40px"}' v-if="isAuth('geshouxinxi','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"border":"1px solid","cursor":"pointer","padding":"0 24px","margin":"0 0 6px","outline":"none","color":"#857EF0","borderRadius":"0","background":"#fff","borderImage":"linear-gradient(180deg, rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 1), rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 0.10000000149011612)) 1 1","width":"100%","fontSize":"14px","height":"40px"}' v-if="isAuth('geshouxinxi','删除')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">删除</el-button>




				</el-row>
			</el-form>
			
			<!-- <div> -->
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","borderColor":"#eee","borderWidth":"1px 0 0 1px","background":"#fff","width":"90%","borderStyle":"solid","height":"fit-content"}' 
					v-if="isAuth('geshouxinxi','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="geshouxingming"
					label="歌手姓名">
						<template slot-scope="scope">
							{{scope.row.geshouxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="geshouxingbie"
					label="歌手性别">
						<template slot-scope="scope">
							{{scope.row.geshouxingbie}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="touxiang" width="200" label="头像">
						<template slot-scope="scope">
							<div v-if="scope.row.touxiang">
								<img v-if="scope.row.touxiang.substring(0,4)=='http'" :src="scope.row.touxiang.split(',')[0]" width="100" height="100">
								<img v-else :src="$base.url+scope.row.touxiang.split(',')[0]" width="100" height="100">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="biaoqian"
					label="标签">
						<template slot-scope="scope">
							{{scope.row.biaoqian}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="diqu"
					label="地区">
						<template slot-scope="scope">
							{{scope.row.diqu}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="daibiaogequ" label="代表歌曲">
						<template slot-scope="scope">
							<el-button v-if="scope.row.daibiaogequ" type="text" size="small" @click="download($base.url+scope.row.daibiaogequ)">预览</el-button>
                            <span v-else >无</span>
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button :style='{"border":"1px solid","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#857EF0","borderRadius":"0","background":"#fff","borderImage":"linear-gradient(180deg, rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 1), rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 0.10000000149011612)) 1 1","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('geshouxinxi','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
							<el-button :style='{"border":"1px solid","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#857EF0","borderRadius":"0","background":"#fff","borderImage":"linear-gradient(180deg, rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 1), rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 0.10000000149011612)) 1 1","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('geshouxinxi','修改')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>


							<el-button :style='{"border":"1px solid","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#857EF0","borderRadius":"0","background":"#fff","borderImage":"linear-gradient(180deg, rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 1), rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 0.10000000149011612)) 1 1","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('geshouxinxi','查看评论')" type="primary" size="mini" @click="disscussListHandler(scope.row.id)">查看评论</el-button>



							<el-button :style='{"border":"1px solid","cursor":"pointer","padding":"0 24px","margin":"0 10px 6px 0","outline":"none","color":"#857EF0","borderRadius":"0","background":"#fff","borderImage":"linear-gradient(180deg, rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 1), rgba(133.00000727176666, 126.00000008940697, 240.00000089406967, 0.10000000149011612)) 1 1","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('geshouxinxi','删除') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination
					@size-change="sizeChangeHandle"
					@current-change="currentChangeHandle"
					:current-page="pageIndex"
					background
					:page-sizes="[10, 20, 30, 50]"
					:page-size="pageSize"
					:layout="layouts.join()"
					:total="totalPage"
					prev-text="<"
					next-text=">"
					:hide-on-single-page="false"
					:style='{"width":"100%","padding":"0","margin":"20px 0 0","whiteSpace":"nowrap","color":"#333","fontWeight":"500"}'
				></el-pagination>
			<!-- </div> -->
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>





	</div>
</template>

<script>
//$graphType1
//$buttonName1
//$subNameList1
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      layouts: ["total","prev","pager","next","sizes","jumper"],

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentPageStyleChange()
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },








    init () {
          this.geshouxingbieOptions = "男,女".split(',')
          this.diquOptions = "大陆,港台,日韩,欧美,其它地区".split(',')
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.geshouxingming!='' && this.searchForm.geshouxingming!=undefined){
            params['geshouxingming'] = '%' + this.searchForm.geshouxingming + '%'
          }
           if(this.searchForm.geshouxingbie!='' && this.searchForm.geshouxingbie!=undefined){
            params['geshouxingbie'] = this.searchForm.geshouxingbie
          }
           if(this.searchForm.biaoqian!='' && this.searchForm.biaoqian!=undefined){
            params['biaoqian'] = '%' + this.searchForm.biaoqian + '%'
          }
           if(this.searchForm.diqu!='' && this.searchForm.diqu!=undefined){
            params['diqu'] = this.searchForm.diqu
          }
      this.$http({
        url: "geshouxinxi/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 查看评论
    disscussListHandler(id,type) {
	this.$router.push({path:'/discussgeshouxinxi',query:{refid:id}});
    },
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "geshouxinxi/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 1px solid #857EF0;
				border-radius: 4px;
				padding: 0 12px;
				box-shadow: 0px 4px 0px 0px #8A70FF;
				outline: none;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 1px solid #857EF0;
				border-radius: 4px;
				padding: 0 10px;
				box-shadow: 0px 4px 0px 0px #8A70FF;
				outline: none;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 1px solid #8A70FF;
				border-radius: 4px;
				padding: 0 10px 0 30px;
				box-shadow: 0px 4px 0px 0px #8A70FF;
				outline: none;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 40px;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #999;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: #857EF0;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				color: #fff;
				background: transparent;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: #fff;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #6F6F97;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}
	
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 12px 0;
				color: #000;
				background: rgba(133, 126, 240, 0.3);
				border-color: #6F6F97;
				border-width: 0 1px 1px 0;
				border-style: solid;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #6F6F97;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
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
	
	.main-content .el-pagination /deep/ .btn-next {
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
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
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
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
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

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
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
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #857EF0;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #FFF;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #857EF0;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
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
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
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
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
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
</style>
