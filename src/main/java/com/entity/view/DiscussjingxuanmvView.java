package com.entity.view;

import com.entity.DiscussjingxuanmvEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 精选mv评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-14 09:45:37
 */
@TableName("discussjingxuanmv")
public class DiscussjingxuanmvView  extends DiscussjingxuanmvEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussjingxuanmvView(){
	}
 
 	public DiscussjingxuanmvView(DiscussjingxuanmvEntity discussjingxuanmvEntity){
 	try {
			BeanUtils.copyProperties(this, discussjingxuanmvEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
