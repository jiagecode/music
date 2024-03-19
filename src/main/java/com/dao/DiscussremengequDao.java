package com.dao;

import com.entity.DiscussremengequEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussremengequVO;
import com.entity.view.DiscussremengequView;


/**
 * 热门歌曲评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-14 09:45:37
 */
public interface DiscussremengequDao extends BaseMapper<DiscussremengequEntity> {
	
	List<DiscussremengequVO> selectListVO(@Param("ew") Wrapper<DiscussremengequEntity> wrapper);
	
	DiscussremengequVO selectVO(@Param("ew") Wrapper<DiscussremengequEntity> wrapper);
	
	List<DiscussremengequView> selectListView(@Param("ew") Wrapper<DiscussremengequEntity> wrapper);

	List<DiscussremengequView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussremengequEntity> wrapper);
	
	DiscussremengequView selectView(@Param("ew") Wrapper<DiscussremengequEntity> wrapper);
	

}
