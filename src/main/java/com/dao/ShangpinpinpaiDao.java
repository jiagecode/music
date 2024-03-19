package com.dao;

import com.entity.ShangpinpinpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangpinpinpaiVO;
import com.entity.view.ShangpinpinpaiView;


/**
 * 商品品牌
 * 
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public interface ShangpinpinpaiDao extends BaseMapper<ShangpinpinpaiEntity> {
	
	List<ShangpinpinpaiVO> selectListVO(@Param("ew") Wrapper<ShangpinpinpaiEntity> wrapper);
	
	ShangpinpinpaiVO selectVO(@Param("ew") Wrapper<ShangpinpinpaiEntity> wrapper);
	
	List<ShangpinpinpaiView> selectListView(@Param("ew") Wrapper<ShangpinpinpaiEntity> wrapper);

	List<ShangpinpinpaiView> selectListView(Pagination page,@Param("ew") Wrapper<ShangpinpinpaiEntity> wrapper);
	
	ShangpinpinpaiView selectView(@Param("ew") Wrapper<ShangpinpinpaiEntity> wrapper);
	

}
