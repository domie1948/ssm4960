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


import com.dao.DiscussshangpinshangjiaDao;
import com.entity.DiscussshangpinshangjiaEntity;
import com.service.DiscussshangpinshangjiaService;
import com.entity.vo.DiscussshangpinshangjiaVO;
import com.entity.view.DiscussshangpinshangjiaView;

@Service("discussshangpinshangjiaService")
public class DiscussshangpinshangjiaServiceImpl extends ServiceImpl<DiscussshangpinshangjiaDao, DiscussshangpinshangjiaEntity> implements DiscussshangpinshangjiaService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshangpinshangjiaEntity> page = this.selectPage(
                new Query<DiscussshangpinshangjiaEntity>(params).getPage(),
                new EntityWrapper<DiscussshangpinshangjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshangpinshangjiaEntity> wrapper) {
		  Page<DiscussshangpinshangjiaView> page =new Query<DiscussshangpinshangjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussshangpinshangjiaVO> selectListVO(Wrapper<DiscussshangpinshangjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshangpinshangjiaVO selectVO(Wrapper<DiscussshangpinshangjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshangpinshangjiaView> selectListView(Wrapper<DiscussshangpinshangjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshangpinshangjiaView selectView(Wrapper<DiscussshangpinshangjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
