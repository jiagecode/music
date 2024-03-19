package com.entity.view;

import com.entity.GoumaituisongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 购买推送
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@TableName("goumaituisong")
public class GoumaituisongView  extends GoumaituisongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoumaituisongView(){
	}
 
 	public GoumaituisongView(GoumaituisongEntity goumaituisongEntity){
 	try {
			BeanUtils.copyProperties(this, goumaituisongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
