package com.dao;

import com.entity.DiscussshangpinshangjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshangpinshangjiaVO;
import com.entity.view.DiscussshangpinshangjiaView;


/**
 * 商品上架评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-26 13:20:58
 */
public interface DiscussshangpinshangjiaDao extends BaseMapper<DiscussshangpinshangjiaEntity> {
	
	List<DiscussshangpinshangjiaVO> selectListVO(@Param("ew") Wrapper<DiscussshangpinshangjiaEntity> wrapper);
	
	DiscussshangpinshangjiaVO selectVO(@Param("ew") Wrapper<DiscussshangpinshangjiaEntity> wrapper);
	
	List<DiscussshangpinshangjiaView> selectListView(@Param("ew") Wrapper<DiscussshangpinshangjiaEntity> wrapper);

	List<DiscussshangpinshangjiaView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshangpinshangjiaEntity> wrapper);
	
	DiscussshangpinshangjiaView selectView(@Param("ew") Wrapper<DiscussshangpinshangjiaEntity> wrapper);
	
}
