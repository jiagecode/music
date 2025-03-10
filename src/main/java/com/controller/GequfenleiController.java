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

import com.entity.GequfenleiEntity;
import com.entity.view.GequfenleiView;

import com.service.GequfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 歌曲分类
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@RestController
@RequestMapping("/gequfenlei")
public class GequfenleiController {
    @Autowired
    private GequfenleiService gequfenleiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GequfenleiEntity gequfenlei,
		HttpServletRequest request){
        EntityWrapper<GequfenleiEntity> ew = new EntityWrapper<GequfenleiEntity>();

		PageUtils page = gequfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gequfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GequfenleiEntity gequfenlei, 
		HttpServletRequest request){
        EntityWrapper<GequfenleiEntity> ew = new EntityWrapper<GequfenleiEntity>();

		PageUtils page = gequfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gequfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GequfenleiEntity gequfenlei){
       	EntityWrapper<GequfenleiEntity> ew = new EntityWrapper<GequfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gequfenlei, "gequfenlei")); 
        return R.ok().put("data", gequfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GequfenleiEntity gequfenlei){
        EntityWrapper< GequfenleiEntity> ew = new EntityWrapper< GequfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gequfenlei, "gequfenlei")); 
		GequfenleiView gequfenleiView =  gequfenleiService.selectView(ew);
		return R.ok("查询歌曲分类成功").put("data", gequfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GequfenleiEntity gequfenlei = gequfenleiService.selectById(id);
        return R.ok().put("data", gequfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GequfenleiEntity gequfenlei = gequfenleiService.selectById(id);
        return R.ok().put("data", gequfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GequfenleiEntity gequfenlei, HttpServletRequest request){
    	gequfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gequfenlei);
        gequfenleiService.insert(gequfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GequfenleiEntity gequfenlei, HttpServletRequest request){
    	gequfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gequfenlei);
        gequfenleiService.insert(gequfenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GequfenleiEntity gequfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gequfenlei);
        gequfenleiService.updateById(gequfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gequfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
