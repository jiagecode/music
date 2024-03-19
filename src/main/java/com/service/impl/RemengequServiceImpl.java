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


import com.dao.RemengequDao;
import com.entity.RemengequEntity;
import com.service.RemengequService;
import com.entity.vo.RemengequVO;
import com.entity.view.RemengequView;

@Service("remengequService")
public class RemengequServiceImpl extends ServiceImpl<RemengequDao, RemengequEntity> implements RemengequService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RemengequEntity> page = this.selectPage(
                new Query<RemengequEntity>(params).getPage(),
                new EntityWrapper<RemengequEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RemengequEntity> wrapper) {
		  Page<RemengequView> page =new Query<RemengequView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RemengequVO> selectListVO(Wrapper<RemengequEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RemengequVO selectVO(Wrapper<RemengequEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RemengequView> selectListView(Wrapper<RemengequEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RemengequView selectView(Wrapper<RemengequEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
