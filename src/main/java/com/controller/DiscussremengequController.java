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

import com.entity.DiscussremengequEntity;
import com.entity.view.DiscussremengequView;

import com.service.DiscussremengequService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 热门歌曲评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 09:45:37
 */
@RestController
@RequestMapping("/discussremengequ")
public class DiscussremengequController {
    @Autowired
    private DiscussremengequService discussremengequService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussremengequEntity discussremengequ,
		HttpServletRequest request){
        EntityWrapper<DiscussremengequEntity> ew = new EntityWrapper<DiscussremengequEntity>();

		PageUtils page = discussremengequService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussremengequ), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussremengequEntity discussremengequ, 
		HttpServletRequest request){
        EntityWrapper<DiscussremengequEntity> ew = new EntityWrapper<DiscussremengequEntity>();

		PageUtils page = discussremengequService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussremengequ), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussremengequEntity discussremengequ){
       	EntityWrapper<DiscussremengequEntity> ew = new EntityWrapper<DiscussremengequEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussremengequ, "discussremengequ")); 
        return R.ok().put("data", discussremengequService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussremengequEntity discussremengequ){
        EntityWrapper< DiscussremengequEntity> ew = new EntityWrapper< DiscussremengequEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussremengequ, "discussremengequ")); 
		DiscussremengequView discussremengequView =  discussremengequService.selectView(ew);
		return R.ok("查询热门歌曲评论表成功").put("data", discussremengequView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussremengequEntity discussremengequ = discussremengequService.selectById(id);
        return R.ok().put("data", discussremengequ);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussremengequEntity discussremengequ = discussremengequService.selectById(id);
        return R.ok().put("data", discussremengequ);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussremengequEntity discussremengequ, HttpServletRequest request){
    	discussremengequ.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussremengequ);
        discussremengequService.insert(discussremengequ);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussremengequEntity discussremengequ, HttpServletRequest request){
    	discussremengequ.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussremengequ);
        discussremengequService.insert(discussremengequ);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussremengequEntity discussremengequ, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussremengequ);
        discussremengequService.updateById(discussremengequ);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussremengequService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
