package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshangpinshangjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshangpinshangjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshangpinshangjiaView;


/**
 * 商品上架评论表
 *
 * @author 
 * @email 
 * @date 2021-03-26 13:20:58
 */
public interface DiscussshangpinshangjiaService extends IService<DiscussshangpinshangjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshangpinshangjiaVO> selectListVO(Wrapper<DiscussshangpinshangjiaEntity> wrapper);
   	
   	DiscussshangpinshangjiaVO selectVO(@Param("ew") Wrapper<DiscussshangpinshangjiaEntity> wrapper);
   	
   	List<DiscussshangpinshangjiaView> selectListView(Wrapper<DiscussshangpinshangjiaEntity> wrapper);
   	
   	DiscussshangpinshangjiaView selectView(@Param("ew") Wrapper<DiscussshangpinshangjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshangpinshangjiaEntity> wrapper);
   	
}

