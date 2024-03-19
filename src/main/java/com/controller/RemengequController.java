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

import com.entity.RemengequEntity;
import com.entity.view.RemengequView;

import com.service.RemengequService;
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
 * 热门歌曲
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@RestController
@RequestMapping("/remengequ")
public class RemengequController {
    @Autowired
    private RemengequService remengequService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RemengequEntity remengequ,
		HttpServletRequest request){
        EntityWrapper<RemengequEntity> ew = new EntityWrapper<RemengequEntity>();

		PageUtils page = remengequService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remengequ), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RemengequEntity remengequ, 
		HttpServletRequest request){
        EntityWrapper<RemengequEntity> ew = new EntityWrapper<RemengequEntity>();

		PageUtils page = remengequService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remengequ), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RemengequEntity remengequ){
       	EntityWrapper<RemengequEntity> ew = new EntityWrapper<RemengequEntity>();
      	ew.allEq(MPUtil.allEQMapPre( remengequ, "remengequ")); 
        return R.ok().put("data", remengequService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RemengequEntity remengequ){
        EntityWrapper< RemengequEntity> ew = new EntityWrapper< RemengequEntity>();
 		ew.allEq(MPUtil.allEQMapPre( remengequ, "remengequ")); 
		RemengequView remengequView =  remengequService.selectView(ew);
		return R.ok("查询热门歌曲成功").put("data", remengequView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RemengequEntity remengequ = remengequService.selectById(id);
		remengequ.setClicknum(remengequ.getClicknum()+1);
		remengequ.setClicktime(new Date());
		remengequService.updateById(remengequ);
        return R.ok().put("data", remengequ);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RemengequEntity remengequ = remengequService.selectById(id);
		remengequ.setClicknum(remengequ.getClicknum()+1);
		remengequ.setClicktime(new Date());
		remengequService.updateById(remengequ);
        return R.ok().put("data", remengequ);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RemengequEntity remengequ, HttpServletRequest request){
    	remengequ.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(remengequ);
        remengequService.insert(remengequ);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RemengequEntity remengequ, HttpServletRequest request){
    	remengequ.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(remengequ);
        remengequService.insert(remengequ);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RemengequEntity remengequ, HttpServletRequest request){
        //ValidatorUtils.validateEntity(remengequ);
        remengequService.updateById(remengequ);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        remengequService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,RemengequEntity remengequ, HttpServletRequest request,String pre){
        EntityWrapper<RemengequEntity> ew = new EntityWrapper<RemengequEntity>();
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
		PageUtils page = remengequService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remengequ), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,RemengequEntity remengequ, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "gequfenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "remengequ").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<RemengequEntity> remengequList = new ArrayList<RemengequEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                remengequList.addAll(remengequService.selectList(new EntityWrapper<RemengequEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<RemengequEntity> ew = new EntityWrapper<RemengequEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = remengequService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, remengequ), params), params));
        List<RemengequEntity> pageList = (List<RemengequEntity>)page.getList();
        if(remengequList.size()<limit) {
            int toAddNum = (limit-remengequList.size())<=pageList.size()?(limit-remengequList.size()):pageList.size();
            for(RemengequEntity o1 : pageList) {
                boolean addFlag = true;
                for(RemengequEntity o2 : remengequList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    remengequList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(remengequList.size()>limit) {
            remengequList = remengequList.subList(0, limit);
        }
        page.setList(remengequList);
        return R.ok().put("data", page);
    }







}
