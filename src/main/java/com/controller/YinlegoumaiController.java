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

import com.entity.YinlegoumaiEntity;
import com.entity.view.YinlegoumaiView;

import com.service.YinlegoumaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 音乐购买
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@RestController
@RequestMapping("/yinlegoumai")
public class YinlegoumaiController {
    @Autowired
    private YinlegoumaiService yinlegoumaiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinlegoumaiEntity yinlegoumai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yinlegoumai.setYonghu((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YinlegoumaiEntity> ew = new EntityWrapper<YinlegoumaiEntity>();

		PageUtils page = yinlegoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlegoumai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinlegoumaiEntity yinlegoumai, 
		HttpServletRequest request){
        EntityWrapper<YinlegoumaiEntity> ew = new EntityWrapper<YinlegoumaiEntity>();

		PageUtils page = yinlegoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlegoumai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinlegoumaiEntity yinlegoumai){
       	EntityWrapper<YinlegoumaiEntity> ew = new EntityWrapper<YinlegoumaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinlegoumai, "yinlegoumai")); 
        return R.ok().put("data", yinlegoumaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinlegoumaiEntity yinlegoumai){
        EntityWrapper< YinlegoumaiEntity> ew = new EntityWrapper< YinlegoumaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinlegoumai, "yinlegoumai")); 
		YinlegoumaiView yinlegoumaiView =  yinlegoumaiService.selectView(ew);
		return R.ok("查询音乐购买成功").put("data", yinlegoumaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinlegoumaiEntity yinlegoumai = yinlegoumaiService.selectById(id);
        return R.ok().put("data", yinlegoumai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinlegoumaiEntity yinlegoumai = yinlegoumaiService.selectById(id);
        return R.ok().put("data", yinlegoumai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinlegoumaiEntity yinlegoumai, HttpServletRequest request){
    	yinlegoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinlegoumai);
        yinlegoumaiService.insert(yinlegoumai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinlegoumaiEntity yinlegoumai, HttpServletRequest request){
    	yinlegoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinlegoumai);
        yinlegoumaiService.insert(yinlegoumai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinlegoumaiEntity yinlegoumai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlegoumai);
        yinlegoumaiService.updateById(yinlegoumai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinlegoumaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
