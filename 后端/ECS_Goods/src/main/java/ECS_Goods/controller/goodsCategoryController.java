/**
 * 
 */
package ECS_Goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ECS_Common.entity.goodsCategory;
import ECS_Common.util.ReqResultUtil;
import ECS_Goods.service.goodsCategoryService;

/**
 * @author yueqiulin
 *
 */
@Controller
public class goodsCategoryController {
    @Autowired
    private goodsCategoryService gcs;
    
    @RequestMapping(value="/getParentCategoryList",method=RequestMethod.GET)
    @ResponseBody
    public String getParentCategoryList(Integer id) {
    	return ReqResultUtil.getSuccessResponse(gcs.getGoodsFamilyList(id));
    }
    @RequestMapping(value="/getAllParentCategory",method=RequestMethod.GET)
    @ResponseBody
    public String getAllParentCategoryList() {
    	return ReqResultUtil.getSuccessResponse(gcs.getAllGoodsFamily());
    }
    @RequestMapping(value="/getCategoryList",method=RequestMethod.GET)
    @ResponseBody
    public String getCategoryList(Integer id) {
    	goodsCategory gc=new goodsCategory(0,id,null);
    	return ReqResultUtil.getSuccessResponse(gcs.getGoodsCategory(gc));
    }
    @RequestMapping(value="/getCategory",method=RequestMethod.GET)
    @ResponseBody
    public String getCategory(Integer id) {//根据序列查种类
    	//System.out.println(id);
    	return ReqResultUtil.getSuccessResponse(gcs.getCategoryBySequence(id));
    }
    
    
}
