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

import com.entity.JingxuanmvEntity;
import com.entity.view.JingxuanmvView;

import com.service.JingxuanmvService;
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
 * 精选mv
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@RestController
@RequestMapping("/jingxuanmv")
public class JingxuanmvController {
    @Autowired
    private JingxuanmvService jingxuanmvService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingxuanmvEntity jingxuanmv,
		HttpServletRequest request){
        EntityWrapper<JingxuanmvEntity> ew = new EntityWrapper<JingxuanmvEntity>();

		PageUtils page = jingxuanmvService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingxuanmv), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingxuanmvEntity jingxuanmv, 
		HttpServletRequest request){
        EntityWrapper<JingxuanmvEntity> ew = new EntityWrapper<JingxuanmvEntity>();

		PageUtils page = jingxuanmvService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingxuanmv), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingxuanmvEntity jingxuanmv){
       	EntityWrapper<JingxuanmvEntity> ew = new EntityWrapper<JingxuanmvEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingxuanmv, "jingxuanmv")); 
        return R.ok().put("data", jingxuanmvService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingxuanmvEntity jingxuanmv){
        EntityWrapper< JingxuanmvEntity> ew = new EntityWrapper< JingxuanmvEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingxuanmv, "jingxuanmv")); 
		JingxuanmvView jingxuanmvView =  jingxuanmvService.selectView(ew);
		return R.ok("查询精选mv成功").put("data", jingxuanmvView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingxuanmvEntity jingxuanmv = jingxuanmvService.selectById(id);
		jingxuanmv.setClicknum(jingxuanmv.getClicknum()+1);
		jingxuanmv.setClicktime(new Date());
		jingxuanmvService.updateById(jingxuanmv);
        return R.ok().put("data", jingxuanmv);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingxuanmvEntity jingxuanmv = jingxuanmvService.selectById(id);
		jingxuanmv.setClicknum(jingxuanmv.getClicknum()+1);
		jingxuanmv.setClicktime(new Date());
		jingxuanmvService.updateById(jingxuanmv);
        return R.ok().put("data", jingxuanmv);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingxuanmvEntity jingxuanmv, HttpServletRequest request){
    	jingxuanmv.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingxuanmv);
        jingxuanmvService.insert(jingxuanmv);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingxuanmvEntity jingxuanmv, HttpServletRequest request){
    	jingxuanmv.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingxuanmv);
        jingxuanmvService.insert(jingxuanmv);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingxuanmvEntity jingxuanmv, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingxuanmv);
        jingxuanmvService.updateById(jingxuanmv);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingxuanmvService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JingxuanmvEntity jingxuanmv, HttpServletRequest request,String pre){
        EntityWrapper<JingxuanmvEntity> ew = new EntityWrapper<JingxuanmvEntity>();
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
		PageUtils page = jingxuanmvService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingxuanmv), params), params));
        return R.ok().put("data", page);
    }









}
