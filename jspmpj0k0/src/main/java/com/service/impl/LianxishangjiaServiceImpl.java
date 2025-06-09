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


import com.dao.LianxishangjiaDao;
import com.entity.LianxishangjiaEntity;
import com.service.LianxishangjiaService;
import com.entity.vo.LianxishangjiaVO;
import com.entity.view.LianxishangjiaView;

@Service("lianxishangjiaService")
public class LianxishangjiaServiceImpl extends ServiceImpl<LianxishangjiaDao, LianxishangjiaEntity> implements LianxishangjiaService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LianxishangjiaEntity> page = this.selectPage(
                new Query<LianxishangjiaEntity>(params).getPage(),
                new EntityWrapper<LianxishangjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LianxishangjiaEntity> wrapper) {
		  Page<LianxishangjiaView> page =new Query<LianxishangjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LianxishangjiaVO> selectListVO(Wrapper<LianxishangjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LianxishangjiaVO selectVO(Wrapper<LianxishangjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LianxishangjiaView> selectListView(Wrapper<LianxishangjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LianxishangjiaView selectView(Wrapper<LianxishangjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
