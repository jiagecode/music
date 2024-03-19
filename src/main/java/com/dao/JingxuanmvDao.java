package com.dao;

import com.entity.JingxuanmvEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JingxuanmvVO;
import com.entity.view.JingxuanmvView;


/**
 * 精选mv
 * 
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public interface JingxuanmvDao extends BaseMapper<JingxuanmvEntity> {
	
	List<JingxuanmvVO> selectListVO(@Param("ew") Wrapper<JingxuanmvEntity> wrapper);
	
	JingxuanmvVO selectVO(@Param("ew") Wrapper<JingxuanmvEntity> wrapper);
	
	List<JingxuanmvView> selectListView(@Param("ew") Wrapper<JingxuanmvEntity> wrapper);

	List<JingxuanmvView> selectListView(Pagination page,@Param("ew") Wrapper<JingxuanmvEntity> wrapper);
	
	JingxuanmvView selectView(@Param("ew") Wrapper<JingxuanmvEntity> wrapper);
	

}
