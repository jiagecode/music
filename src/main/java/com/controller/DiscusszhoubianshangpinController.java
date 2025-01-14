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

import com.entity.DiscusszhoubianshangpinEntity;
import com.entity.view.DiscusszhoubianshangpinView;

import com.service.DiscusszhoubianshangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 周边商品评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 09:45:37
 */
@RestController
@RequestMapping("/discusszhoubianshangpin")
public class DiscusszhoubianshangpinController {
    @Autowired
    private DiscusszhoubianshangpinService discusszhoubianshangpinService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszhoubianshangpinEntity discusszhoubianshangpin,
		HttpServletRequest request){
        EntityWrapper<DiscusszhoubianshangpinEntity> ew = new EntityWrapper<DiscusszhoubianshangpinEntity>();

		PageUtils page = discusszhoubianshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhoubianshangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszhoubianshangpinEntity discusszhoubianshangpin, 
		HttpServletRequest request){
        EntityWrapper<DiscusszhoubianshangpinEntity> ew = new EntityWrapper<DiscusszhoubianshangpinEntity>();

		PageUtils page = discusszhoubianshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhoubianshangpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhoubianshangpinEntity discusszhoubianshangpin){
       	EntityWrapper<DiscusszhoubianshangpinEntity> ew = new EntityWrapper<DiscusszhoubianshangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhoubianshangpin, "discusszhoubianshangpin")); 
        return R.ok().put("data", discusszhoubianshangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhoubianshangpinEntity discusszhoubianshangpin){
        EntityWrapper< DiscusszhoubianshangpinEntity> ew = new EntityWrapper< DiscusszhoubianshangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhoubianshangpin, "discusszhoubianshangpin")); 
		DiscusszhoubianshangpinView discusszhoubianshangpinView =  discusszhoubianshangpinService.selectView(ew);
		return R.ok("查询周边商品评论表成功").put("data", discusszhoubianshangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhoubianshangpinEntity discusszhoubianshangpin = discusszhoubianshangpinService.selectById(id);
        return R.ok().put("data", discusszhoubianshangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhoubianshangpinEntity discusszhoubianshangpin = discusszhoubianshangpinService.selectById(id);
        return R.ok().put("data", discusszhoubianshangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhoubianshangpinEntity discusszhoubianshangpin, HttpServletRequest request){
    	discusszhoubianshangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhoubianshangpin);
        discusszhoubianshangpinService.insert(discusszhoubianshangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhoubianshangpinEntity discusszhoubianshangpin, HttpServletRequest request){
    	discusszhoubianshangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhoubianshangpin);
        discusszhoubianshangpinService.insert(discusszhoubianshangpin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusszhoubianshangpinEntity discusszhoubianshangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhoubianshangpin);
        discusszhoubianshangpinService.updateById(discusszhoubianshangpin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhoubianshangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
