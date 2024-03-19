package com.dao;

import com.entity.GedanpingfenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GedanpingfenVO;
import com.entity.view.GedanpingfenView;


/**
 * 歌单评分
 * 
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public interface GedanpingfenDao extends BaseMapper<GedanpingfenEntity> {
	
	List<GedanpingfenVO> selectListVO(@Param("ew") Wrapper<GedanpingfenEntity> wrapper);
	
	GedanpingfenVO selectVO(@Param("ew") Wrapper<GedanpingfenEntity> wrapper);
	
	List<GedanpingfenView> selectListView(@Param("ew") Wrapper<GedanpingfenEntity> wrapper);

	List<GedanpingfenView> selectListView(Pagination page,@Param("ew") Wrapper<GedanpingfenEntity> wrapper);
	
	GedanpingfenView selectView(@Param("ew") Wrapper<GedanpingfenEntity> wrapper);
	

}
