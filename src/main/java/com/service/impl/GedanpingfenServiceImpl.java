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


import com.dao.GedanpingfenDao;
import com.entity.GedanpingfenEntity;
import com.service.GedanpingfenService;
import com.entity.vo.GedanpingfenVO;
import com.entity.view.GedanpingfenView;

@Service("gedanpingfenService")
public class GedanpingfenServiceImpl extends ServiceImpl<GedanpingfenDao, GedanpingfenEntity> implements GedanpingfenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GedanpingfenEntity> page = this.selectPage(
                new Query<GedanpingfenEntity>(params).getPage(),
                new EntityWrapper<GedanpingfenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GedanpingfenEntity> wrapper) {
		  Page<GedanpingfenView> page =new Query<GedanpingfenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GedanpingfenVO> selectListVO(Wrapper<GedanpingfenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GedanpingfenVO selectVO(Wrapper<GedanpingfenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GedanpingfenView> selectListView(Wrapper<GedanpingfenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GedanpingfenView selectView(Wrapper<GedanpingfenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
