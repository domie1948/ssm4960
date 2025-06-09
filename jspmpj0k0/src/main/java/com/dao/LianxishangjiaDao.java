package com.dao;

import com.entity.LianxishangjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LianxishangjiaVO;
import com.entity.view.LianxishangjiaView;


/**
 * 联系商家
 * 
 * @author 
 * @email 
 * @date 2021-03-26 13:20:57
 */
public interface LianxishangjiaDao extends BaseMapper<LianxishangjiaEntity> {
	
	List<LianxishangjiaVO> selectListVO(@Param("ew") Wrapper<LianxishangjiaEntity> wrapper);
	
	LianxishangjiaVO selectVO(@Param("ew") Wrapper<LianxishangjiaEntity> wrapper);
	
	List<LianxishangjiaView> selectListView(@Param("ew") Wrapper<LianxishangjiaEntity> wrapper);

	List<LianxishangjiaView> selectListView(Pagination page,@Param("ew") Wrapper<LianxishangjiaEntity> wrapper);
	
	LianxishangjiaView selectView(@Param("ew") Wrapper<LianxishangjiaEntity> wrapper);
	
}
