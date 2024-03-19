package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RemengequEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RemengequVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RemengequView;


/**
 * 热门歌曲
 *
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public interface RemengequService extends IService<RemengequEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RemengequVO> selectListVO(Wrapper<RemengequEntity> wrapper);
   	
   	RemengequVO selectVO(@Param("ew") Wrapper<RemengequEntity> wrapper);
   	
   	List<RemengequView> selectListView(Wrapper<RemengequEntity> wrapper);
   	
   	RemengequView selectView(@Param("ew") Wrapper<RemengequEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RemengequEntity> wrapper);
   	

}

