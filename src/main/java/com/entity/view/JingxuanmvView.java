package com.entity.view;

import com.entity.JingxuanmvEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 精选mv
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@TableName("jingxuanmv")
public class JingxuanmvView  extends JingxuanmvEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingxuanmvView(){
	}
 
 	public JingxuanmvView(JingxuanmvEntity jingxuanmvEntity){
 	try {
			BeanUtils.copyProperties(this, jingxuanmvEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
