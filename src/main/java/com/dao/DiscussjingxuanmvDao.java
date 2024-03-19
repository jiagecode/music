package com.dao;

import com.entity.DiscussjingxuanmvEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjingxuanmvVO;
import com.entity.view.DiscussjingxuanmvView;


/**
 * 精选mv评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-14 09:45:37
 */
public interface DiscussjingxuanmvDao extends BaseMapper<DiscussjingxuanmvEntity> {
	
	List<DiscussjingxuanmvVO> selectListVO(@Param("ew") Wrapper<DiscussjingxuanmvEntity> wrapper);
	
	DiscussjingxuanmvVO selectVO(@Param("ew") Wrapper<DiscussjingxuanmvEntity> wrapper);
	
	List<DiscussjingxuanmvView> selectListView(@Param("ew") Wrapper<DiscussjingxuanmvEntity> wrapper);

	List<DiscussjingxuanmvView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjingxuanmvEntity> wrapper);
	
	DiscussjingxuanmvView selectView(@Param("ew") Wrapper<DiscussjingxuanmvEntity> wrapper);
	

}
