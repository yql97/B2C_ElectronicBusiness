package shiro.controller;

import ECS_Common.util.ReqResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shiro.entity.peopleCard;
import shiro.service.peopleCardService;

@Controller
@RequestMapping("/identityAuthentic")
public class peopleCardController {
    @Autowired
    private peopleCardService pcs;
    //实名认证
    @RequestMapping(value ="/authenticPeopleCard.action",method = RequestMethod.POST)
    @ResponseBody
    public String authenticPeopleCard(@ModelAttribute("peopleCard") peopleCard people_card){
        people_card.setStatus(0);
        int status=pcs.addpeopleCard(people_card);
        if(status==1) return ReqResultUtil.getSuccessResponse();
        return ReqResultUtil.getFailedResponse();
    }
    //是否认证
    @RequestMapping(value ="/getAuthenticStatus.action",method = RequestMethod.GET)
    @ResponseBody
    public String getAuthenticStatus(int userid){
        return ReqResultUtil.getFailedResponse();
    }

}
