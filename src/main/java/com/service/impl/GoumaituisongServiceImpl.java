package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GoumaituisongDao;
import com.entity.GoumaituisongEntity;
import com.service.GoumaituisongService;
import com.entity.vo.GoumaituisongVO;
import com.entity.view.GoumaituisongView;

@Service("goumaituisongService")
public class GoumaituisongServiceImpl extends ServiceImpl<GoumaituisongDao, GoumaituisongEntity> implements GoumaituisongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoumaituisongEntity> page = this.selectPage(
                new Query<GoumaituisongEntity>(params).getPage(),
                new EntityWrapper<GoumaituisongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GoumaituisongEntity> wrapper) {
		  Page<GoumaituisongView> page =new Query<GoumaituisongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GoumaituisongVO> selectListVO(Wrapper<GoumaituisongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoumaituisongVO selectVO(Wrapper<GoumaituisongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoumaituisongView> selectListView(Wrapper<GoumaituisongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoumaituisongView selectView(Wrapper<GoumaituisongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
