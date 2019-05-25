/**
 * 
 */
package ECS_Goods.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ECS_Common.entity.goods;
import ECS_Common.entity.goodsPropertyName;
import ECS_Common.entity.goodsPropertyRelate;
import ECS_Common.entity.goodsPropertyValue;
import ECS_Common.entity.goods_sku;
import ECS_Common.util.randomID;
import ECS_Goods.entity.goodsBaseInfo;
import ECS_Goods.entity.goodsPropertyInfo;
import ECS_Goods.entity.storeGoodsInfo;
import ECS_Goods.mapper.goodsMapper;
import ECS_Goods.mapper.goodsPropertyMapper;
import ECS_Goods.mapper.goodsSkuMapper;

/**
 * @author yueqiulin
 *
 */
@Service
public class goodsService {
      @Autowired
      private goodsMapper gm;
      @Autowired
      private goodsSkuMapper gsm;
      @Autowired
      private goodsPropertyMapper gpm;
      
      public List<goods> getAllGoods(){
    	  return gm.getAllGoods();
      }
      public List<goods_sku> getAllGoodsSku(){
    	  return gsm.getAllGoodsSkuList();
      }
      public goods getGoods(Integer id) {
    	  return gm.getGoodsById(id);
      }
      public goods_sku getGoodsSku(Integer id) {
    	return gsm.getGoodsSku(id)  ;
      }
      public List<goods_sku> getGoodsSkuList(Integer id){//根据goodsid
    	  return gsm.getGoodsSkuList(id);
      }
      public goodsBaseInfo getGoodsBaseInfo(Integer id) {
    	  return gsm.getGoodsBaseInfo(id);
      }
      public  int addGoods(goods g) {
    	  gm.insertGoods(g);
    	  return 0;
      } 
      public int addGoodsSku(goods_sku gs) {
    	  gsm.addGoodsSku(gs);
    	  return 0;
      }
      public int updateGoodsInfo(goods g) {
    	  int row=gm.updateGoods(g);
    	  if(row>0) return row;
    	  return 0;
      }
      public List<goods> getStoreGoods(Integer id){
    	  return gm.selectByStoreId(id);
      }
      public int updateGoodsSku(goods_sku gs) {
    	  return gsm.updateGoodsSku(gs);  
      }
      public List<storeGoodsInfo> getStroeGoodsList(Integer id){
    	  return gm.getStoreGoodsList(id);
      }
 	 public List<goodsPropertyName> getPropertyNameList(Integer id){
 		 return gpm.getPropertyNameList(id);
 	 }
 	 public List<goodsPropertyValue> getPropertyValueList(Integer id){
 		 return gpm.getPropertyValueList(id);
 	 }
      public int addNewsGoodsProperty(String propertyList ,Integer goods_sku_id) {
    	  if(propertyList.equals("")) return 1;
    	  if(propertyList!=null&&propertyList!="") {
    	  for(String str:propertyList.split(",")) {
    		  int index=str.indexOf("_");
    		  String property_name=str.substring(0,index);
    		  String property_value=str.substring(index+1,str.length());
    		  goodsPropertyName gpn=new goodsPropertyName(randomID.createRandomID(),412135950,property_name);
    		  goodsPropertyValue gpv=new goodsPropertyValue(randomID.createRandomID(),
    				  property_value,gpn.getPropertyName_id());
    		  goodsPropertyRelate gpr=new goodsPropertyRelate(goods_sku_id,gpn.getPropertyName_id(),
    				  gpv.getPropertyValue_id());
						int status=gpm.addGoodsProperty(gpn);
						if(status==1) status=status+gpm.addPropertyValue(gpv);
						if(status==2) status=status+gpm.addPropertyRelate(gpr);
						if(status==3) return 1;
					}}
    	  return 1;
      }
      public int addOldGoodsProperty(String propertyList,Integer goods_sku_id) {
    	  if(propertyList.equals("")) return 1;
    	  if(propertyList!=null&&propertyList!="") {
    	  for(String str:propertyList.split(",")) {
    		  int index=str.indexOf('_');
    		  System.out.println(index);
    		  Integer name_id=Integer.valueOf(str.substring(0,index));
    		  Integer value_id=Integer.valueOf(str.substring(index+1,str.length()));
    		  goodsPropertyRelate gpr=new goodsPropertyRelate(goods_sku_id,name_id,value_id);
    		  gpm.addPropertyRelate(gpr);
    	  }}
    	  return 1;
      }
      public List<goodsPropertyInfo> getGoodsPropertyList(Integer id){
    	  return gpm.getGoodsPropertyList(id);
      }
}
