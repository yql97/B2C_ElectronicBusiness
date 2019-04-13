/**
 * 
 */
package ECS_Logistics.entity;

import java.util.Date;

/**
 * @author yueqiulin
 *
 */
public class logisticsDistributionInfo {
	     private Date create_time;
         private int physical_status;
         private String physical_distribution_info;
         
		public Date getCreate_time() {
			return create_time;
		}
		public void setCreate_time(Date create_time) {
			this.create_time = create_time;
		}
		public int getPhysical_status() {
			return physical_status;
		}
		public void setPhysical_status(int physical_status) {
			this.physical_status = physical_status;
		}
		public String getPhysical_distribution_info() {
			return physical_distribution_info;
		}
		public void setPhysical_distribution_info(String physical_distribution_info) {
			this.physical_distribution_info = physical_distribution_info;
		}
         
}
