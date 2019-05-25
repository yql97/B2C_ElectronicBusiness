/**
 * 
 */
package ECS_Goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ECS_Common.util.ReqResultUtil;
import ECS_Goods.service.favoritesRecordService;

/**
 * @author yueqiulin
 *
 */
@Controller
public class favoritesRecordController {
    @Autowired
    private favoritesRecordService frs;
    
    @RequestMapping(value="/getFavoriteGoodsList",method=RequestMethod.GET)
    public String getFavoritesRecord() {
    	frs.getFavoritesGoodsList(111111);
    	return ReqResultUtil.getSuccessResponse();
    }
    @RequestMapping(value="/addFavoritesRecord",method=RequestMethod.POST)
    public String addFavoritesRecord() {
    	frs.addFavoritesGoods();
    	return ReqResultUtil.getSuccessResponse();
    }
    
}
