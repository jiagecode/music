package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussremengequEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussremengequVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussremengequView;


/**
 * 热门歌曲评论表
 *
 * @author 
 * @email 
 * @date 2023-05-14 09:45:37
 */
public interface DiscussremengequService extends IService<DiscussremengequEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussremengequVO> selectListVO(Wrapper<DiscussremengequEntity> wrapper);
   	
   	DiscussremengequVO selectVO(@Param("ew") Wrapper<DiscussremengequEntity> wrapper);
   	
   	List<DiscussremengequView> selectListView(Wrapper<DiscussremengequEntity> wrapper);
   	
   	DiscussremengequView selectView(@Param("ew") Wrapper<DiscussremengequEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussremengequEntity> wrapper);
   	

}

