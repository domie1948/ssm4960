package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LianxishangjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LianxishangjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LianxishangjiaView;


/**
 * 联系商家
 *
 * @author 
 * @email 
 * @date 2021-03-26 13:20:57
 */
public interface LianxishangjiaService extends IService<LianxishangjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LianxishangjiaVO> selectListVO(Wrapper<LianxishangjiaEntity> wrapper);
   	
   	LianxishangjiaVO selectVO(@Param("ew") Wrapper<LianxishangjiaEntity> wrapper);
   	
   	List<LianxishangjiaView> selectListView(Wrapper<LianxishangjiaEntity> wrapper);
   	
   	LianxishangjiaView selectView(@Param("ew") Wrapper<LianxishangjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LianxishangjiaEntity> wrapper);
   	
}

