/**
 * 
 */
package ECS_Goods.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

import ECS_Common.entity.goods;
import ECS_Common.entity.goodsCategory;
import ECS_Common.entity.goodsImages;
import ECS_Common.entity.goods_sku;
import ECS_Common.util.fileUtil;
import ECS_Common.util.randomID;
import ECS_Goods.entity.goodsSku;
import ECS_Goods.entity.goodsSpu;
import ECS_Goods.service.goodsCategoryService;
import ECS_Goods.service.goodsService;
import ECS_Goods.service.imageService;

/**
 * @author yueqiulin
 *
 */
@RestController
public class goodsController {
    @Autowired
    private goodsService gs;
    @Autowired
    private goodsCategoryService gcs;
    @Autowired
    private imageService is;
    
	@RequestMapping("/getGoodsInfo")
	public String test() {
		goods g=null;
		return "";
	}
	@RequestMapping(value="/addGoodsSkuInfo",method= RequestMethod.POST)
	public void addGoodsSkuInfo(@ModelAttribute goodsSku goods_sku,
			@RequestParam("imgfile") MultipartFile file,HttpServletResponse response) throws IOException {
		System.out.println(goods_sku.toString());
		System.out.println(file.getOriginalFilename());
		goods_sku goodSku=new goods_sku(randomID.createRandomID(),"",412135950,
				goods_sku.getGoods_price(),goods_sku.getGoods_price(),
				goods_sku.getGoods_sku_num(),0,new Date());
		gs.addGoodsSku(goodSku);
		gs.addNewsGoodsProperty(goods_sku.getAdd_property_list(),goodSku.getId());
		gs.addOldGoodsProperty(goods_sku.getPropertyNameValue_list(),goodSku.getId());
		String filePath ="D:\\linux\\file\\image\\";
		String fileName =randomID.createRandomID()+"_"+goods_sku.getGoods_id()+file.getOriginalFilename();
		uploadGoodsImage(file.getBytes(), filePath, fileName);
		String image_url= filePath+fileName;
		goodsImages goods_image=new goodsImages(goodSku.getId(),image_url,0);
		is.addImage(goods_image);
		response.sendRedirect("manage?pageIndex=2");
	}	
	public static Integer uploadGoodsImage(byte[] file,String filePath,String fileName) {
		try {
			fileUtil.uploadFile(file, filePath, fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	} 
	@RequestMapping(value="/addGoodsSpuInfo",method= RequestMethod.POST)
	public void addGoodsSpuInfo(@ModelAttribute goodsSpu goods_spu,HttpServletResponse response) throws IOException {
		System.out.println(goods_spu.toString());
		goodsCategory gc=new goodsCategory(randomID.createRandomID(),
				goods_spu.getGoods_family_id(),goods_spu.getGoods_category());
		gcs.addGoodsCategory(gc);
		goods g=new goods(randomID.createRandomID(),goods_spu.getGoods_name(),
				goods_spu.getGoods_title(),111111,gc.getId(),new Date());
		gs.addGoods(g);
		response.sendRedirect("manage?pageIndex=2");
	}
	@RequestMapping(value="/getStoreGoodsList",method= RequestMethod.GET)
	public void getStoreGoodsList(HttpServletResponse response) throws IOException {	
	
		response.sendRedirect("manage?pageIndex=2"); 
	}	
	@RequestMapping(value="/upGoods",method= RequestMethod.GET)
	public void upGoods() {
		
	}
	@RequestMapping(value="/downGoods",method= RequestMethod.GET)
	public void downGoods() {
		
	}
	@RequestMapping(value="/deleteGoods",method= RequestMethod.GET)
	public void deleteGoods(){
		
	}
}
