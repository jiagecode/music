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

import com.entity.GedanpingfenEntity;
import com.entity.view.GedanpingfenView;

import com.service.GedanpingfenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 歌单评分
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@RestController
@RequestMapping("/gedanpingfen")
public class GedanpingfenController {
    @Autowired
    private GedanpingfenService gedanpingfenService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GedanpingfenEntity gedanpingfen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			gedanpingfen.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GedanpingfenEntity> ew = new EntityWrapper<GedanpingfenEntity>();

		PageUtils page = gedanpingfenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gedanpingfen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GedanpingfenEntity gedanpingfen, 
		HttpServletRequest request){
        EntityWrapper<GedanpingfenEntity> ew = new EntityWrapper<GedanpingfenEntity>();

		PageUtils page = gedanpingfenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gedanpingfen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GedanpingfenEntity gedanpingfen){
       	EntityWrapper<GedanpingfenEntity> ew = new EntityWrapper<GedanpingfenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gedanpingfen, "gedanpingfen")); 
        return R.ok().put("data", gedanpingfenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GedanpingfenEntity gedanpingfen){
        EntityWrapper< GedanpingfenEntity> ew = new EntityWrapper< GedanpingfenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gedanpingfen, "gedanpingfen")); 
		GedanpingfenView gedanpingfenView =  gedanpingfenService.selectView(ew);
		return R.ok("查询歌单评分成功").put("data", gedanpingfenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GedanpingfenEntity gedanpingfen = gedanpingfenService.selectById(id);
        return R.ok().put("data", gedanpingfen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GedanpingfenEntity gedanpingfen = gedanpingfenService.selectById(id);
        return R.ok().put("data", gedanpingfen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GedanpingfenEntity gedanpingfen, HttpServletRequest request){
    	gedanpingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gedanpingfen);
        gedanpingfenService.insert(gedanpingfen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GedanpingfenEntity gedanpingfen, HttpServletRequest request){
    	gedanpingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gedanpingfen);
        gedanpingfenService.insert(gedanpingfen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GedanpingfenEntity gedanpingfen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gedanpingfen);
        gedanpingfenService.updateById(gedanpingfen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gedanpingfenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
