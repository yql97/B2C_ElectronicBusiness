/**
 * 
 */
package ECS_Goods.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ECS_Common.util.ReqResultUtil;
import ECS_Goods.entity.browseRecordInfo;
import ECS_Goods.service.browseRecordService;

/**
 * @author yueqiulin
 *
 */
@Controller
public class browseRecordController {
    @Autowired
    private browseRecordService brs;
    
    @RequestMapping(value="/getBrowseRecordList",method=RequestMethod.GET)
    @ResponseBody
    public String getBrowseRecordList(HttpServletRequest req){
    	String userid=req.getHeader("Authorization");
         List<browseRecordInfo> blist =brs.getBrowseRecordList(Integer.parseInt(userid));
         System.out.println(blist.toString());
    	return 	ReqResultUtil.getSuccessResponse(blist);
    }
    
    @RequestMapping("/deleteBrowseRecord")
    @ResponseBody
    public String deleteBrowseRecord() {
    	return ReqResultUtil.getSuccessResponse();
    }
}
