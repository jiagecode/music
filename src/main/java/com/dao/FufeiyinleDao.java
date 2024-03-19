package com.dao;

import com.entity.FufeiyinleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FufeiyinleVO;
import com.entity.view.FufeiyinleView;


/**
 * 付费音乐
 * 
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public interface FufeiyinleDao extends BaseMapper<FufeiyinleEntity> {
	
	List<FufeiyinleVO> selectListVO(@Param("ew") Wrapper<FufeiyinleEntity> wrapper);
	
	FufeiyinleVO selectVO(@Param("ew") Wrapper<FufeiyinleEntity> wrapper);
	
	List<FufeiyinleView> selectListView(@Param("ew") Wrapper<FufeiyinleEntity> wrapper);

	List<FufeiyinleView> selectListView(Pagination page,@Param("ew") Wrapper<FufeiyinleEntity> wrapper);
	
	FufeiyinleView selectView(@Param("ew") Wrapper<FufeiyinleEntity> wrapper);
	

}