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


import com.dao.DiscussjingxuanmvDao;
import com.entity.DiscussjingxuanmvEntity;
import com.service.DiscussjingxuanmvService;
import com.entity.vo.DiscussjingxuanmvVO;
import com.entity.view.DiscussjingxuanmvView;

@Service("discussjingxuanmvService")
public class DiscussjingxuanmvServiceImpl extends ServiceImpl<DiscussjingxuanmvDao, DiscussjingxuanmvEntity> implements DiscussjingxuanmvService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjingxuanmvEntity> page = this.selectPage(
                new Query<DiscussjingxuanmvEntity>(params).getPage(),
                new EntityWrapper<DiscussjingxuanmvEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjingxuanmvEntity> wrapper) {
		  Page<DiscussjingxuanmvView> page =new Query<DiscussjingxuanmvView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussjingxuanmvVO> selectListVO(Wrapper<DiscussjingxuanmvEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjingxuanmvVO selectVO(Wrapper<DiscussjingxuanmvEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjingxuanmvView> selectListView(Wrapper<DiscussjingxuanmvEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjingxuanmvView selectView(Wrapper<DiscussjingxuanmvEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
