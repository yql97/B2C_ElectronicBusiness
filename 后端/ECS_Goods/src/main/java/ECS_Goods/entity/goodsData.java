/**
 * 
 */
package ECS_Goods.entity;

import java.util.List;

/**
 * @author yueqiulin
 *
 */
public class goodsData {
          private Object goodsInfo;
          private Object goodsProperty;
          
		@Override
		public String toString() {
			return "goodsData [goodsInfo=" + goodsInfo.toString() + ", goodsProperty=" + goodsProperty.toString() + "]";
		}
		public goodsData(Object goodsInfo, Object goodsProperty) {
			super();
			this.goodsInfo = goodsInfo;
			this.goodsProperty = goodsProperty;
		}
		public Object getGoodsInfo() {
			return goodsInfo;
		}
		public void setGoodsInfo(Object goodsInfo) {
			this.goodsInfo = goodsInfo;
		}
		public Object getGoodsProperty() {
			return goodsProperty;
		}
		public void setGoodsProperty(Object goodsProperty) {
			this.goodsProperty = goodsProperty;
		} 
          
} 
