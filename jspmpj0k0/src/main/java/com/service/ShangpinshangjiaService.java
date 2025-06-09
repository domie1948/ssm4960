package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangpinshangjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangpinshangjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpinshangjiaView;


/**
 * 商品上架
 *
 * @author 
 * @email 
 * @date 2021-03-26 13:20:57
 */
public interface ShangpinshangjiaService extends IService<ShangpinshangjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangpinshangjiaVO> selectListVO(Wrapper<ShangpinshangjiaEntity> wrapper);
   	
   	ShangpinshangjiaVO selectVO(@Param("ew") Wrapper<ShangpinshangjiaEntity> wrapper);
   	
   	List<ShangpinshangjiaView> selectListView(Wrapper<ShangpinshangjiaEntity> wrapper);
   	
   	ShangpinshangjiaView selectView(@Param("ew") Wrapper<ShangpinshangjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangpinshangjiaEntity> wrapper);
   	
}

