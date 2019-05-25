/**
 * 
 */
package ECS_Logistics.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ECS_Logistics.dao.logisticsDistributionMapper;
import ECS_Logistics.dao.logisticsMapper;
import ECS_Logistics.entity.logisticsOrder;
import ECS_Logistics.entity.shippingInfo;

/**
 * @author yueqiulin
 *
 */
@Service
public class logisticsService {
  
	@Autowired
	private logisticsMapper lm;
	@Autowired
	private logisticsDistributionMapper ldbm;
	public List getLogisticsInfoList() {
		return null;
	}
	public int updateLogisticsInfo() {
		return 0;
	}
	public int createLogisticsOrder(logisticsOrder o,shippingInfo i) {
		lm.addLogisticsOrder(o);
		lm.addShippingInfo(i);
		return 1;
	}
	 public int updateOrder(Integer id, Integer status) {
		 return lm.updateOrder(id, status);
	 }
}
