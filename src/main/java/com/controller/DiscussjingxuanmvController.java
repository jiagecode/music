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

import com.entity.DiscussjingxuanmvEntity;
import com.entity.view.DiscussjingxuanmvView;

import com.service.DiscussjingxuanmvService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 精选mv评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 09:45:37
 */
@RestController
@RequestMapping("/discussjingxuanmv")
public class DiscussjingxuanmvController {
    @Autowired
    private DiscussjingxuanmvService discussjingxuanmvService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjingxuanmvEntity discussjingxuanmv,
		HttpServletRequest request){
        EntityWrapper<DiscussjingxuanmvEntity> ew = new EntityWrapper<DiscussjingxuanmvEntity>();

		PageUtils page = discussjingxuanmvService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjingxuanmv), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjingxuanmvEntity discussjingxuanmv, 
		HttpServletRequest request){
        EntityWrapper<DiscussjingxuanmvEntity> ew = new EntityWrapper<DiscussjingxuanmvEntity>();

		PageUtils page = discussjingxuanmvService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjingxuanmv), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjingxuanmvEntity discussjingxuanmv){
       	EntityWrapper<DiscussjingxuanmvEntity> ew = new EntityWrapper<DiscussjingxuanmvEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjingxuanmv, "discussjingxuanmv")); 
        return R.ok().put("data", discussjingxuanmvService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjingxuanmvEntity discussjingxuanmv){
        EntityWrapper< DiscussjingxuanmvEntity> ew = new EntityWrapper< DiscussjingxuanmvEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjingxuanmv, "discussjingxuanmv")); 
		DiscussjingxuanmvView discussjingxuanmvView =  discussjingxuanmvService.selectView(ew);
		return R.ok("查询精选mv评论表成功").put("data", discussjingxuanmvView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjingxuanmvEntity discussjingxuanmv = discussjingxuanmvService.selectById(id);
        return R.ok().put("data", discussjingxuanmv);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjingxuanmvEntity discussjingxuanmv = discussjingxuanmvService.selectById(id);
        return R.ok().put("data", discussjingxuanmv);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussjingxuanmvEntity discussjingxuanmv, HttpServletRequest request){
    	discussjingxuanmv.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjingxuanmv);
        discussjingxuanmvService.insert(discussjingxuanmv);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjingxuanmvEntity discussjingxuanmv, HttpServletRequest request){
    	discussjingxuanmv.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjingxuanmv);
        discussjingxuanmvService.insert(discussjingxuanmv);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussjingxuanmvEntity discussjingxuanmv, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjingxuanmv);
        discussjingxuanmvService.updateById(discussjingxuanmv);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussjingxuanmvService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
