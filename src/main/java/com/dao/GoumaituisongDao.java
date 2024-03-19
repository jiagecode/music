package com.dao;

import com.entity.GoumaituisongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GoumaituisongVO;
import com.entity.view.GoumaituisongView;


/**
 * 购买推送
 * 
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public interface GoumaituisongDao extends BaseMapper<GoumaituisongEntity> {
	
	List<GoumaituisongVO> selectListVO(@Param("ew") Wrapper<GoumaituisongEntity> wrapper);
	
	GoumaituisongVO selectVO(@Param("ew") Wrapper<GoumaituisongEntity> wrapper);
	
	List<GoumaituisongView> selectListView(@Param("ew") Wrapper<GoumaituisongEntity> wrapper);

	List<GoumaituisongView> selectListView(Pagination page,@Param("ew") Wrapper<GoumaituisongEntity> wrapper);
	
	GoumaituisongView selectView(@Param("ew") Wrapper<GoumaituisongEntity> wrapper);
	

}
