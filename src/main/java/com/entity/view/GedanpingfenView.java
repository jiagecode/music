package com.entity.view;

import com.entity.GedanpingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 歌单评分
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@TableName("gedanpingfen")
public class GedanpingfenView  extends GedanpingfenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GedanpingfenView(){
	}
 
 	public GedanpingfenView(GedanpingfenEntity gedanpingfenEntity){
 	try {
			BeanUtils.copyProperties(this, gedanpingfenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
