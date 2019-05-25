/**
 * 
 */
package ECS_Goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ECS_Common.entity.goodsImages;
import ECS_Goods.mapper.imageMapper;

/**
 * @author yueqiulin
 *
 */
@Service
public class imageService {
      
	 @Autowired
     private imageMapper im;
	 
	  public int addImage(goodsImages image) {
		   int row=im.addImages(image);
		   if(row>0) return row;
		  return 0;
	  }
	  public goodsImages selectImage(Integer goods_id) {
		  goodsImages gi=im.selectImages(goods_id);
		 return gi;
	  }
	  public goodsImages getImage(Integer id) {
		  return im.getImage(id);
	  }
	  public int deleteImages(Integer id) {
		  int row=im.deleteImages(id);  
		  if(row>0) return row;
		  return 0;
	  }
}
