package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GedanpingfenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GedanpingfenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GedanpingfenView;


/**
 * 歌单评分
 *
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public interface GedanpingfenService extends IService<GedanpingfenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GedanpingfenVO> selectListVO(Wrapper<GedanpingfenEntity> wrapper);
   	
   	GedanpingfenVO selectVO(@Param("ew") Wrapper<GedanpingfenEntity> wrapper);
   	
   	List<GedanpingfenView> selectListView(Wrapper<GedanpingfenEntity> wrapper);
   	
   	GedanpingfenView selectView(@Param("ew") Wrapper<GedanpingfenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GedanpingfenEntity> wrapper);
   	

}

