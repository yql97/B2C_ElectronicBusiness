/**
 * 
 */
package ECS_Goods.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ECS_Common.entity.shopCart;
import ECS_Goods.entity.goodsData;
import ECS_Goods.entity.goodsPropertyInfo;
import ECS_Goods.entity.shopCartBaseInfo;
import ECS_Goods.mapper.shoppingCartMapper;

/**
 * @author yueqiulin
 *
 */
@Service
public class shopCartService {
	@Autowired
	private shoppingCartMapper scm;

	public List<goodsData> getShopCartList(int userid) {
		List<goodsData> gdList = new ArrayList<goodsData>();
		List<shopCartBaseInfo> scgList = scm.getShopCartList(userid);
		for (shopCartBaseInfo scb : scgList) {
			List<goodsPropertyInfo> gpiList = scm.getGoodsProperty(scb.getGoods_sku_id());
			goodsData gd = new goodsData(scb, gpiList);
			gdList.add(gd);
		}
		return gdList;

	}

	public shopCartBaseInfo getShopCartGoods(Integer id) {
		return scm.getShopCartGoods(id);
	}

	public int addToShopCart(shopCart sc) {
		return scm.addShopCart(sc);
	}

	public int removeFromShopCart(Integer id) {
		scm.deleteShopCart(id);
		return 0;
	}

	public int updateShopCartInfo() {
		return 0;
	}
}
