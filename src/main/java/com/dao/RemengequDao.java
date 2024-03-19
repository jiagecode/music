package com.dao;

import com.entity.RemengequEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RemengequVO;
import com.entity.view.RemengequView;


/**
 * 热门歌曲
 * 
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public interface RemengequDao extends BaseMapper<RemengequEntity> {
	
	List<RemengequVO> selectListVO(@Param("ew") Wrapper<RemengequEntity> wrapper);
	
	RemengequVO selectVO(@Param("ew") Wrapper<RemengequEntity> wrapper);
	
	List<RemengequView> selectListView(@Param("ew") Wrapper<RemengequEntity> wrapper);

	List<RemengequView> selectListView(Pagination page,@Param("ew") Wrapper<RemengequEntity> wrapper);
	
	RemengequView selectView(@Param("ew") Wrapper<RemengequEntity> wrapper);
	

}
