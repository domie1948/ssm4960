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

import com.entity.ShangpinshangjiaEntity;
import com.entity.view.ShangpinshangjiaView;

import com.service.ShangpinshangjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 商品上架
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-26 13:20:57
 */
@RestController
@RequestMapping("/shangpinshangjia")
public class ShangpinshangjiaController {
    @Autowired
    private ShangpinshangjiaService shangpinshangjiaService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangpinshangjiaEntity shangpinshangjia, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shangpinshangjia.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShangpinshangjiaEntity> ew = new EntityWrapper<ShangpinshangjiaEntity>();
    	PageUtils page = shangpinshangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinshangjia), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangpinshangjiaEntity shangpinshangjia, HttpServletRequest request){
        EntityWrapper<ShangpinshangjiaEntity> ew = new EntityWrapper<ShangpinshangjiaEntity>();
    	PageUtils page = shangpinshangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinshangjia), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangpinshangjiaEntity shangpinshangjia){
       	EntityWrapper<ShangpinshangjiaEntity> ew = new EntityWrapper<ShangpinshangjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangpinshangjia, "shangpinshangjia")); 
        return R.ok().put("data", shangpinshangjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangpinshangjiaEntity shangpinshangjia){
        EntityWrapper< ShangpinshangjiaEntity> ew = new EntityWrapper< ShangpinshangjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangpinshangjia, "shangpinshangjia")); 
		ShangpinshangjiaView shangpinshangjiaView =  shangpinshangjiaService.selectView(ew);
		return R.ok("查询商品上架成功").put("data", shangpinshangjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangpinshangjiaEntity shangpinshangjia = shangpinshangjiaService.selectById(id);
		shangpinshangjia.setClicktime(new Date());
		shangpinshangjiaService.updateById(shangpinshangjia);
        return R.ok().put("data", shangpinshangjia);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangpinshangjiaEntity shangpinshangjia = shangpinshangjiaService.selectById(id);
		shangpinshangjia.setClicktime(new Date());
		shangpinshangjiaService.updateById(shangpinshangjia);
        return R.ok().put("data", shangpinshangjia);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ShangpinshangjiaEntity shangpinshangjia = shangpinshangjiaService.selectById(id);
        if(type.equals("1")) {
        	shangpinshangjia.setThumbsupnum(shangpinshangjia.getThumbsupnum()+1);
        } else {
        	shangpinshangjia.setCrazilynum(shangpinshangjia.getCrazilynum()+1);
        }
        shangpinshangjiaService.updateById(shangpinshangjia);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinshangjiaEntity shangpinshangjia, HttpServletRequest request){
    	shangpinshangjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinshangjia);

        shangpinshangjiaService.insert(shangpinshangjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinshangjiaEntity shangpinshangjia, HttpServletRequest request){
    	shangpinshangjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangpinshangjia);

        shangpinshangjiaService.insert(shangpinshangjia);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpinshangjiaEntity shangpinshangjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinshangjia);
        shangpinshangjiaService.updateById(shangpinshangjia);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangpinshangjiaService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ShangpinshangjiaEntity> wrapper = new EntityWrapper<ShangpinshangjiaEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = shangpinshangjiaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ShangpinshangjiaEntity shangpinshangjia, HttpServletRequest request,String pre){
        EntityWrapper<ShangpinshangjiaEntity> ew = new EntityWrapper<ShangpinshangjiaEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = shangpinshangjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinshangjia), params), params));
        return R.ok().put("data", page);
    }


}
