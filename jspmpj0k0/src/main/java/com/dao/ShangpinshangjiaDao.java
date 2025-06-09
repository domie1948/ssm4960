package com.dao;

import com.entity.ShangpinshangjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangpinshangjiaVO;
import com.entity.view.ShangpinshangjiaView;


/**
 * 商品上架
 * 
 * @author 
 * @email 
 * @date 2021-03-26 13:20:57
 */
public interface ShangpinshangjiaDao extends BaseMapper<ShangpinshangjiaEntity> {
	
	List<ShangpinshangjiaVO> selectListVO(@Param("ew") Wrapper<ShangpinshangjiaEntity> wrapper);
	
	ShangpinshangjiaVO selectVO(@Param("ew") Wrapper<ShangpinshangjiaEntity> wrapper);
	
	List<ShangpinshangjiaView> selectListView(@Param("ew") Wrapper<ShangpinshangjiaEntity> wrapper);

	List<ShangpinshangjiaView> selectListView(Pagination page,@Param("ew") Wrapper<ShangpinshangjiaEntity> wrapper);
	
	ShangpinshangjiaView selectView(@Param("ew") Wrapper<ShangpinshangjiaEntity> wrapper);
	
}
