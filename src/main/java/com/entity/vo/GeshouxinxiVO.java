package com.entity.vo;

import com.entity.GeshouxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 歌手信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public class GeshouxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 歌手性别
	 */
	
	private String geshouxingbie;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 标签
	 */
	
	private String biaoqian;
		
	/**
	 * 地区
	 */
	
	private String diqu;
		
	/**
	 * 代表歌曲
	 */
	
	private String daibiaogequ;
		
	/**
	 * 热门歌曲
	 */
	
	private String remengequ;
		
	/**
	 * 专辑介绍
	 */
	
	private String zhuanjijieshao;
		
	/**
	 * 歌手介绍
	 */
	
	private String geshoujieshao;
				
	
	/**
	 * 设置：歌手性别
	 */
	 
	public void setGeshouxingbie(String geshouxingbie) {
		this.geshouxingbie = geshouxingbie;
	}
	
	/**
	 * 获取：歌手性别
	 */
	public String getGeshouxingbie() {
		return geshouxingbie;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：标签
	 */
	 
	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}
	
	/**
	 * 获取：标签
	 */
	public String getBiaoqian() {
		return biaoqian;
	}
				
	
	/**
	 * 设置：地区
	 */
	 
	public void setDiqu(String diqu) {
		this.diqu = diqu;
	}
	
	/**
	 * 获取：地区
	 */
	public String getDiqu() {
		return diqu;
	}
				
	
	/**
	 * 设置：代表歌曲
	 */
	 
	public void setDaibiaogequ(String daibiaogequ) {
		this.daibiaogequ = daibiaogequ;
	}
	
	/**
	 * 获取：代表歌曲
	 */
	public String getDaibiaogequ() {
		return daibiaogequ;
	}
				
	
	/**
	 * 设置：热门歌曲
	 */
	 
	public void setRemengequ(String remengequ) {
		this.remengequ = remengequ;
	}
	
	/**
	 * 获取：热门歌曲
	 */
	public String getRemengequ() {
		return remengequ;
	}
				
	
	/**
	 * 设置：专辑介绍
	 */
	 
	public void setZhuanjijieshao(String zhuanjijieshao) {
		this.zhuanjijieshao = zhuanjijieshao;
	}
	
	/**
	 * 获取：专辑介绍
	 */
	public String getZhuanjijieshao() {
		return zhuanjijieshao;
	}
				
	
	/**
	 * 设置：歌手介绍
	 */
	 
	public void setGeshoujieshao(String geshoujieshao) {
		this.geshoujieshao = geshoujieshao;
	}
	
	/**
	 * 获取：歌手介绍
	 */
	public String getGeshoujieshao() {
		return geshoujieshao;
	}
			
}
