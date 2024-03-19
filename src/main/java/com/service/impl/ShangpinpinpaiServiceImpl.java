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


import com.dao.ShangpinpinpaiDao;
import com.entity.ShangpinpinpaiEntity;
import com.service.ShangpinpinpaiService;
import com.entity.vo.ShangpinpinpaiVO;
import com.entity.view.ShangpinpinpaiView;

@Service("shangpinpinpaiService")
public class ShangpinpinpaiServiceImpl extends ServiceImpl<ShangpinpinpaiDao, ShangpinpinpaiEntity> implements ShangpinpinpaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangpinpinpaiEntity> page = this.selectPage(
                new Query<ShangpinpinpaiEntity>(params).getPage(),
                new EntityWrapper<ShangpinpinpaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangpinpinpaiEntity> wrapper) {
		  Page<ShangpinpinpaiView> page =new Query<ShangpinpinpaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangpinpinpaiVO> selectListVO(Wrapper<ShangpinpinpaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangpinpinpaiVO selectVO(Wrapper<ShangpinpinpaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangpinpinpaiView> selectListView(Wrapper<ShangpinpinpaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangpinpinpaiView selectView(Wrapper<ShangpinpinpaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
