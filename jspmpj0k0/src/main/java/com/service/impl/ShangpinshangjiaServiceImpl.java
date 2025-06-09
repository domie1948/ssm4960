package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShangpinshangjiaDao;
import com.entity.ShangpinshangjiaEntity;
import com.service.ShangpinshangjiaService;
import com.entity.vo.ShangpinshangjiaVO;
import com.entity.view.ShangpinshangjiaView;

@Service("shangpinshangjiaService")
public class ShangpinshangjiaServiceImpl extends ServiceImpl<ShangpinshangjiaDao, ShangpinshangjiaEntity> implements ShangpinshangjiaService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangpinshangjiaEntity> page = this.selectPage(
                new Query<ShangpinshangjiaEntity>(params).getPage(),
                new EntityWrapper<ShangpinshangjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangpinshangjiaEntity> wrapper) {
		  Page<ShangpinshangjiaView> page =new Query<ShangpinshangjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangpinshangjiaVO> selectListVO(Wrapper<ShangpinshangjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangpinshangjiaVO selectVO(Wrapper<ShangpinshangjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangpinshangjiaView> selectListView(Wrapper<ShangpinshangjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangpinshangjiaView selectView(Wrapper<ShangpinshangjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
