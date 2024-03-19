package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 付费音乐
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-14 09:45:36
 */
@TableName("fufeiyinle")
public class FufeiyinleEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FufeiyinleEntity() {
		
	}
	
	public FufeiyinleEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 歌曲名称
	 */
					
	private String gequmingcheng;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date faxingriqi;
	
	/**
	 * 歌曲介绍
	 */
					
	private String gequjieshao;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：歌曲名称
	 */
	public void setGequmingcheng(String gequmingcheng) {
		this.gequmingcheng = gequmingcheng;
	}
	/**
	 * 获取：歌曲名称
	 */
	public String getGequmingcheng() {
		return gequmingcheng;
	}
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
