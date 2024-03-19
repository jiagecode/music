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

import com.entity.GoumaituisongEntity;
import com.entity.view.GoumaituisongView;

import com.service.GoumaituisongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 购买推送
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@RestController
@RequestMapping("/goumaituisong")
public class GoumaituisongController {
    @Autowired
    private GoumaituisongService goumaituisongService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GoumaituisongEntity goumaituisong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			goumaituisong.setYonghu((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GoumaituisongEntity> ew = new EntityWrapper<GoumaituisongEntity>();

		PageUtils page = goumaituisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goumaituisong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GoumaituisongEntity goumaituisong, 
		HttpServletRequest request){
        EntityWrapper<GoumaituisongEntity> ew = new EntityWrapper<GoumaituisongEntity>();

		PageUtils page = goumaituisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goumaituisong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GoumaituisongEntity goumaituisong){
       	EntityWrapper<GoumaituisongEntity> ew = new EntityWrapper<GoumaituisongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( goumaituisong, "goumaituisong")); 
        return R.ok().put("data", goumaituisongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GoumaituisongEntity goumaituisong){
        EntityWrapper< GoumaituisongEntity> ew = new EntityWrapper< GoumaituisongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( goumaituisong, "goumaituisong")); 
		GoumaituisongView goumaituisongView =  goumaituisongService.selectView(ew);
		return R.ok("查询购买推送成功").put("data", goumaituisongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GoumaituisongEntity goumaituisong = goumaituisongService.selectById(id);
        return R.ok().put("data", goumaituisong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GoumaituisongEntity goumaituisong = goumaituisongService.selectById(id);
        return R.ok().put("data", goumaituisong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoumaituisongEntity goumaituisong, HttpServletRequest request){
    	goumaituisong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goumaituisong);
        goumaituisongService.insert(goumaituisong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GoumaituisongEntity goumaituisong, HttpServletRequest request){
    	goumaituisong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goumaituisong);
        goumaituisongService.insert(goumaituisong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GoumaituisongEntity goumaituisong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(goumaituisong);
        goumaituisongService.updateById(goumaituisong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        goumaituisongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
