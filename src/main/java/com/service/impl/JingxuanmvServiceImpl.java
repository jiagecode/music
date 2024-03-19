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


import com.dao.JingxuanmvDao;
import com.entity.JingxuanmvEntity;
import com.service.JingxuanmvService;
import com.entity.vo.JingxuanmvVO;
import com.entity.view.JingxuanmvView;

@Service("jingxuanmvService")
public class JingxuanmvServiceImpl extends ServiceImpl<JingxuanmvDao, JingxuanmvEntity> implements JingxuanmvService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingxuanmvEntity> page = this.selectPage(
                new Query<JingxuanmvEntity>(params).getPage(),
                new EntityWrapper<JingxuanmvEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingxuanmvEntity> wrapper) {
		  Page<JingxuanmvView> page =new Query<JingxuanmvView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JingxuanmvVO> selectListVO(Wrapper<JingxuanmvEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JingxuanmvVO selectVO(Wrapper<JingxuanmvEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JingxuanmvView> selectListView(Wrapper<JingxuanmvEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingxuanmvView selectView(Wrapper<JingxuanmvEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
