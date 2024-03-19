package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GoumaituisongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GoumaituisongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GoumaituisongView;


/**
 * 购买推送
 *
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public interface GoumaituisongService extends IService<GoumaituisongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoumaituisongVO> selectListVO(Wrapper<GoumaituisongEntity> wrapper);
   	
   	GoumaituisongVO selectVO(@Param("ew") Wrapper<GoumaituisongEntity> wrapper);
   	
   	List<GoumaituisongView> selectListView(Wrapper<GoumaituisongEntity> wrapper);
   	
   	GoumaituisongView selectView(@Param("ew") Wrapper<GoumaituisongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GoumaituisongEntity> wrapper);
   	

}

