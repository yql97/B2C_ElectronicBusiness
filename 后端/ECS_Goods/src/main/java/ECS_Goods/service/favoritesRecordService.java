/**
 * 
 */
package ECS_Goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ECS_Common.entity.store;
import ECS_Goods.entity.goodsBaseInfo;
import ECS_Goods.mapper.favoritesRecordMapper;

/**
 * @author yueqiulin
 *
 */
@Service
public class favoritesRecordService {
        @Autowired
        private favoritesRecordMapper frm;
        
        public int addFavoritesGoods() {
        	frm.addFavoritesRecord(null);
        	return 0;
        }
        public int addFavoritesStore() {
        	return 0;
        }
        public int removeFavoritesGoods() {
        	frm.deleteFavorites();
        	return 0;
        }
        public int removeFavoritesStore() {
        	return 0;
        }
        public List<goodsBaseInfo> getFavoritesGoodsList(Integer userid){
        	return frm.getFavoritesGoods(userid);
        }
        public List<store> getFavoritesStore(Integer userid){
        	return frm.getFavoritesStore(userid);
        }
}

