package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangpinpinpaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangpinpinpaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpinpinpaiView;


/**
 * 商品品牌
 *
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public interface ShangpinpinpaiService extends IService<ShangpinpinpaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangpinpinpaiVO> selectListVO(Wrapper<ShangpinpinpaiEntity> wrapper);
   	
   	ShangpinpinpaiVO selectVO(@Param("ew") Wrapper<ShangpinpinpaiEntity> wrapper);
   	
   	List<ShangpinpinpaiView> selectListView(Wrapper<ShangpinpinpaiEntity> wrapper);
   	
   	ShangpinpinpaiView selectView(@Param("ew") Wrapper<ShangpinpinpaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangpinpinpaiEntity> wrapper);
   	

}

