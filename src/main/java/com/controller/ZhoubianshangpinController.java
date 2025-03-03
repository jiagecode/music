package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.entity.OrdersEntity;
import com.service.OrdersService;

import com.entity.ZhoubianshangpinEntity;
import com.entity.view.ZhoubianshangpinView;

import com.service.ZhoubianshangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 周边商品
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@RestController
@RequestMapping("/zhoubianshangpin")
public class ZhoubianshangpinController {
    @Autowired
    private ZhoubianshangpinService zhoubianshangpinService;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhoubianshangpinEntity zhoubianshangpin,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<ZhoubianshangpinEntity> ew = new EntityWrapper<ZhoubianshangpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = zhoubianshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhoubianshangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhoubianshangpinEntity zhoubianshangpin, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<ZhoubianshangpinEntity> ew = new EntityWrapper<ZhoubianshangpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = zhoubianshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhoubianshangpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhoubianshangpinEntity zhoubianshangpin){
       	EntityWrapper<ZhoubianshangpinEntity> ew = new EntityWrapper<ZhoubianshangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhoubianshangpin, "zhoubianshangpin")); 
        return R.ok().put("data", zhoubianshangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhoubianshangpinEntity zhoubianshangpin){
        EntityWrapper< ZhoubianshangpinEntity> ew = new EntityWrapper< ZhoubianshangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhoubianshangpin, "zhoubianshangpin")); 
		ZhoubianshangpinView zhoubianshangpinView =  zhoubianshangpinService.selectView(ew);
		return R.ok("查询周边商品成功").put("data", zhoubianshangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhoubianshangpinEntity zhoubianshangpin = zhoubianshangpinService.selectById(id);
		zhoubianshangpin.setClicknum(zhoubianshangpin.getClicknum()+1);
		zhoubianshangpin.setClicktime(new Date());
		zhoubianshangpinService.updateById(zhoubianshangpin);
        return R.ok().put("data", zhoubianshangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhoubianshangpinEntity zhoubianshangpin = zhoubianshangpinService.selectById(id);
		zhoubianshangpin.setClicknum(zhoubianshangpin.getClicknum()+1);
		zhoubianshangpin.setClicktime(new Date());
		zhoubianshangpinService.updateById(zhoubianshangpin);
        return R.ok().put("data", zhoubianshangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhoubianshangpinEntity zhoubianshangpin, HttpServletRequest request){
    	zhoubianshangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhoubianshangpin);
        zhoubianshangpinService.insert(zhoubianshangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhoubianshangpinEntity zhoubianshangpin, HttpServletRequest request){
    	zhoubianshangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhoubianshangpin);
        zhoubianshangpinService.insert(zhoubianshangpin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhoubianshangpinEntity zhoubianshangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhoubianshangpin);
        zhoubianshangpinService.updateById(zhoubianshangpin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhoubianshangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZhoubianshangpinEntity zhoubianshangpin, HttpServletRequest request,String pre){
        EntityWrapper<ZhoubianshangpinEntity> ew = new EntityWrapper<ZhoubianshangpinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = zhoubianshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhoubianshangpin), params), params));
        return R.ok().put("data", page);
    }


        /**
     * 协同算法（按用户购买推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ZhoubianshangpinEntity zhoubianshangpin, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String goodtypeColumn = "shangpinmingcheng";
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>().eq("userid", userId).eq("tablename", "zhoubianshangpin").orderBy("addtime", false));
        List<String> goodtypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ZhoubianshangpinEntity> zhoubianshangpinList = new ArrayList<ZhoubianshangpinEntity>();
	//去重
    	List<OrdersEntity> ordersDist = new ArrayList<OrdersEntity>();
    	for(OrdersEntity o1 : orders) {
    		boolean addFlag = true;
    		for(OrdersEntity o2 : ordersDist) {
    			if(o1.getGoodid()==o2.getGoodid() || o1.getGoodtype().equals(o2.getGoodtype())) {
    				addFlag = false;
    				break;
    			}
    		}
    		if(addFlag) ordersDist.add(o1);
    	}
        if(ordersDist!=null && ordersDist.size()>0) {
                for(OrdersEntity o : ordersDist) {
                        zhoubianshangpinList.addAll(zhoubianshangpinService.selectList(new EntityWrapper<ZhoubianshangpinEntity>().eq(goodtypeColumn, o.getGoodtype())));
                }
        }
        EntityWrapper<ZhoubianshangpinEntity> ew = new EntityWrapper<ZhoubianshangpinEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = zhoubianshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhoubianshangpin), params), params));
        List<ZhoubianshangpinEntity> pageList = (List<ZhoubianshangpinEntity>)page.getList();
        if(zhoubianshangpinList.size()<limit) {
                int toAddNum = (limit-zhoubianshangpinList.size())<=pageList.size()?(limit-zhoubianshangpinList.size()):pageList.size();
                for(ZhoubianshangpinEntity o1 : pageList) {
                    boolean addFlag = true;
                    for(ZhoubianshangpinEntity o2 : zhoubianshangpinList) {
                        if(o1.getId().intValue()==o2.getId().intValue()) {
                            addFlag = false;
                            break;
                        }
                    }
                    if(addFlag) {
                        zhoubianshangpinList.add(o1);
                        if(--toAddNum==0) break;
                    }   
                }
        } else if(zhoubianshangpinList.size()>limit) {
            zhoubianshangpinList = zhoubianshangpinList.subList(0, limit);
        }
        page.setList(zhoubianshangpinList);
        return R.ok().put("data", page);
    }







}
