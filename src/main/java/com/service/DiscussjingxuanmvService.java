package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjingxuanmvEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjingxuanmvVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjingxuanmvView;


/**
 * 精选mv评论表
 *
 * @author 
 * @email 
 * @date 2023-05-14 09:45:37
 */
public interface DiscussjingxuanmvService extends IService<DiscussjingxuanmvEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjingxuanmvVO> selectListVO(Wrapper<DiscussjingxuanmvEntity> wrapper);
   	
   	DiscussjingxuanmvVO selectVO(@Param("ew") Wrapper<DiscussjingxuanmvEntity> wrapper);
   	
   	List<DiscussjingxuanmvView> selectListView(Wrapper<DiscussjingxuanmvEntity> wrapper);
   	
   	DiscussjingxuanmvView selectView(@Param("ew") Wrapper<DiscussjingxuanmvEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjingxuanmvEntity> wrapper);
   	

}

