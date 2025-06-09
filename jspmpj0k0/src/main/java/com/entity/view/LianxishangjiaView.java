package com.entity.view;

import com.entity.LianxishangjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 联系商家
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-26 13:20:57
 */
@TableName("lianxishangjia")
public class LianxishangjiaView  extends LianxishangjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LianxishangjiaView(){
	}
 
 	public LianxishangjiaView(LianxishangjiaEntity lianxishangjiaEntity){
 	try {
			BeanUtils.copyProperties(this, lianxishangjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
