package com.entity.vo;

import com.entity.FufeiyinleEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 付费音乐
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
public class FufeiyinleVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 歌曲分类
	 */
	
	private String gequfenlei;
		
	/**
	 * 歌曲封面
	 */
	
	private String gequfengmian;
		
	/**
	 * 歌手姓名
	 */
	
	private String geshouxingming;
		
	/**
	 * 试听音频
	 */
	
	private String shitingyinpin;
		
	/**
	 * 单曲价格
	 */
	
	private Integer danqujiage;
		
	/**
	 * 发行日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date faxingriqi;
		
	/**
	 * 歌曲介绍
	 */
	
	private String gequjieshao;
				
	
	/**
	 * 设置：歌曲分类
	 */
	 
	public void setGequfenlei(String gequfenlei) {
		this.gequfenlei = gequfenlei;
	}
	
	/**
	 * 获取：歌曲分类
	 */
	public String getGequfenlei() {
		return gequfenlei;
	}
				
	
	/**
	 * 设置：歌曲封面
	 */
	 
	public void setGequfengmian(String gequfengmian) {
		this.gequfengmian = gequfengmian;
	}
	
	/**
	 * 获取：歌曲封面
	 */
	public String getGequfengmian() {
		return gequfengmian;
	}
				
	
	/**
	 * 设置：歌手姓名
	 */
	 
	public void setGeshouxingming(String geshouxingming) {
		this.geshouxingming = geshouxingming;
	}
	
	/**
	 * 获取：歌手姓名
	 */
	public String getGeshouxingming() {
		return geshouxingming;
	}
				
	
	/**
	 * 设置：试听音频
	 */
	 
	public void setShitingyinpin(String shitingyinpin) {
		this.shitingyinpin = shitingyinpin;
	}
	
	/**
	 * 获取：试听音频
	 */
	public String getShitingyinpin() {
		return shitingyinpin;
	}
				
	
	/**
	 * 设置：单曲价格
	 */
	 
	public void setDanqujiage(Integer danqujiage) {
		this.danqujiage = danqujiage;
	}
	
	/**
	 * 获取：单曲价格
	 */
	public Integer getDanqujiage() {
		return danqujiage;
	}
				
	
	/**
	 * 设置：发行日期
	 */
	 
	public void setFaxingriqi(Date faxingriqi) {
		this.faxingriqi = faxingriqi;
	}
	
	/**
	 * 获取：发行日期
	 */
	public Date getFaxingriqi() {
		return faxingriqi;
	}
				
	
	/**
	 * 设置：歌曲介绍
	 */
	 
	public void setGequjieshao(String gequjieshao) {
		this.gequjieshao = gequjieshao;
	}
	
	/**
	 * 获取：歌曲介绍
	 */
	public String getGequjieshao() {
		return gequjieshao;
	}
			
}
