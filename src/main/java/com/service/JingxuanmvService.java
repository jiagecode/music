package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingxuanmvEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JingxuanmvVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JingxuanmvView;


/**
 * 精选mv
 *
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public interface JingxuanmvService extends IService<JingxuanmvEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingxuanmvVO> selectListVO(Wrapper<JingxuanmvEntity> wrapper);
   	
   	JingxuanmvVO selectVO(@Param("ew") Wrapper<JingxuanmvEntity> wrapper);
   	
   	List<JingxuanmvView> selectListView(Wrapper<JingxuanmvEntity> wrapper);
   	
   	JingxuanmvView selectView(@Param("ew") Wrapper<JingxuanmvEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingxuanmvEntity> wrapper);
   	

}

