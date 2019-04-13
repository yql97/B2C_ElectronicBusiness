/**
 * 
 */
package ECS_Goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ECS_Goods.service.orderService;

/**
 * @author yueqiulin
 *
 */
@Controller
public class orderController {
    @Autowired 
    private orderService os;
   
    @RequestMapping(value="getStoreOrderList",method=RequestMethod.GET)
    public void getStoreOrderList() {
               	
    }
    
    @RequestMapping(value="remindPayment",method=RequestMethod.GET)
    public void remindPayment() {
    	
    }
    
    @RequestMapping(value="markShipping",method=RequestMethod.GET)
    public void markShipping() {
    	
    }
    
    @RequestMapping(value="remindReceipt",method=RequestMethod.GET)
    public void remindReceipt() {
    	
    }
}
