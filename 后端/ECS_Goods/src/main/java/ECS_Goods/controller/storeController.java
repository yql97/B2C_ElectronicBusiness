/**
 * 
 */
package ECS_Goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ECS_Goods.service.storeService;

/**
 * @author yueqiulin
 *
 */
@Controller
public class storeController {
     	@Autowired
     	private storeService ss;
     	
     	@RequestMapping(value="/getStoreInfo",method= RequestMethod.GET)
     	public void getStoreInfo() {
     		
     	}
     	@RequestMapping(value="/getStoreSaleList",method= RequestMethod.GET)
     	public void getStoreSaleList() {
     		
     	}
     	@RequestMapping(value="/closeStore",method= RequestMethod.GET)
     	public void closeStore(){
     		
     	}
    	@RequestMapping(value="/openStore",method= RequestMethod.GET)
     	public void openStore(){
     		
     	}
    	@RequestMapping(value="/updateStoreInfo",method= RequestMethod.GET)
     	public void updateStoreInfo(){
     		
     	}
     	
}
