package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.LianxishangjiaEntity;
import com.entity.view.LianxishangjiaView;

import com.service.LianxishangjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 联系商家
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-26 13:20:57
 */
@RestController
@RequestMapping("/lianxishangjia")
public class LianxishangjiaController {
    @Autowired
    private LianxishangjiaService lianxishangjiaService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LianxishangjiaEntity lianxishangjia, 
		HttpServletRequest request){

        EntityWrapper<LianxishangjiaEntity> ew = new EntityWrapper<LianxishangjiaEntity>();
    	PageUtils page = lianxishangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lianxishangjia), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LianxishangjiaEntity lianxishangjia, HttpServletRequest request){
        EntityWrapper<LianxishangjiaEntity> ew = new EntityWrapper<LianxishangjiaEntity>();
    	PageUtils page = lianxishangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lianxishangjia), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LianxishangjiaEntity lianxishangjia){
       	EntityWrapper<LianxishangjiaEntity> ew = new EntityWrapper<LianxishangjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lianxishangjia, "lianxishangjia")); 
        return R.ok().put("data", lianxishangjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LianxishangjiaEntity lianxishangjia){
        EntityWrapper< LianxishangjiaEntity> ew = new EntityWrapper< LianxishangjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lianxishangjia, "lianxishangjia")); 
		LianxishangjiaView lianxishangjiaView =  lianxishangjiaService.selectView(ew);
		return R.ok("查询联系商家成功").put("data", lianxishangjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LianxishangjiaEntity lianxishangjia = lianxishangjiaService.selectById(id);
        return R.ok().put("data", lianxishangjia);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LianxishangjiaEntity lianxishangjia = lianxishangjiaService.selectById(id);
        return R.ok().put("data", lianxishangjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LianxishangjiaEntity lianxishangjia, HttpServletRequest request){
    	lianxishangjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lianxishangjia);

        lianxishangjiaService.insert(lianxishangjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LianxishangjiaEntity lianxishangjia, HttpServletRequest request){
    	lianxishangjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lianxishangjia);

        lianxishangjiaService.insert(lianxishangjia);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LianxishangjiaEntity lianxishangjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lianxishangjia);
        lianxishangjiaService.updateById(lianxishangjia);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lianxishangjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<LianxishangjiaEntity> wrapper = new EntityWrapper<LianxishangjiaEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = lianxishangjiaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
