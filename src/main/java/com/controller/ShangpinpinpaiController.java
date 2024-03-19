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

import com.entity.ShangpinpinpaiEntity;
import com.entity.view.ShangpinpinpaiView;

import com.service.ShangpinpinpaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 商品品牌
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@RestController
@RequestMapping("/shangpinpinpai")
public class ShangpinpinpaiController {
    @Autowired
    private ShangpinpinpaiService shangpinpinpaiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangpinpinpaiEntity shangpinpinpai,
		HttpServletRequest request){
        EntityWrapper<ShangpinpinpaiEntity> ew = new EntityWrapper<ShangpinpinpaiEntity>();

		PageUtils page = shangpinpinpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinpinpai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangpinpinpaiEntity shangpinpinpai, 
		HttpServletRequest request){
        EntityWrapper<ShangpinpinpaiEntity> ew = new EntityWrapper<ShangpinpinpaiEntity>();

		PageUtils page = shangpinpinpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinpinpai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangpinpinpaiEntity shangpinpinpai){
       	EntityWrapper<ShangpinpinpaiEntity> ew = new EntityWrapper<ShangpinpinpaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangpinpinpai, "shangpinpinpai")); 
        return R.ok().put("data", shangpinpinpaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangpinpinpaiEntity shangpinpinpai){
        EntityWrapper< ShangpinpinpaiEntity> ew = new EntityWrapper< ShangpinpinpaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangpinpinpai, "shangpinpinpai")); 
		ShangpinpinpaiView shangpinpinpaiView =  shangpinpinpaiService.selectView(ew);
		return R.ok("查询商品品牌成功").put("data", shangpinpinpaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangpinpinpaiEntity shangpinpinpai = shangpinpinpaiService.selectById(id);
        return R.ok().put("data", shangpinpinpai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangpinpinpaiEntity shangpinpinpai = shangpinpinpaiService.selectById(id);
        return R.ok().put("data", shangpinpinpai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinpinpaiEntity shangpinpinpai, HttpServletRequest request){
    	shangpinpinpai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinpinpai);
        shangpinpinpaiService.insert(shangpinpinpai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinpinpaiEntity shangpinpinpai, HttpServletRequest request){
    	shangpinpinpai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinpinpai);
        shangpinpinpaiService.insert(shangpinpinpai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShangpinpinpaiEntity shangpinpinpai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinpinpai);
        shangpinpinpaiService.updateById(shangpinpinpai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangpinpinpaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
