/**
 * 
 */
package ECS_Goods.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import ECS_Common.entity.goods;
import ECS_Common.entity.goodsCategory;
import ECS_Common.entity.goodsImages;
import ECS_Common.entity.goods_sku;
import ECS_Common.util.ReqResultUtil;
import ECS_Common.util.RequestResult;
import ECS_Common.util.fileUtil;
import ECS_Common.util.randomID;
import ECS_Goods.entity.goodsBaseInfo;
import ECS_Goods.entity.goodsData;
import ECS_Goods.entity.goodsPropertyInfo;
import ECS_Goods.entity.goodsSku;
import ECS_Goods.entity.goodsSpu;
import ECS_Goods.entity.shopCartBaseInfo;
import ECS_Goods.entity.storeGoodsInfo;
import ECS_Goods.service.goodsCategoryService;
import ECS_Goods.service.goodsService;
import ECS_Goods.service.imageService;
import ECS_Goods.service.storeService;
import ECS_Goods.util.autherInfo;

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
    private storeService ss;
    @Autowired
    private imageService is;
    @Autowired 
    private autherInfo auth;
    
	@RequestMapping("/getGoodsInfo")
	public String test() {
		goods g=null;
		return "";
	}
	@RequestMapping(value="/selectGoodsByStore",method =RequestMethod.GET)
	@ResponseBody
	public String selectGoodsByStore(HttpServletRequest request) throws IOException {
		String  data=auth.getAuther(request);
	    if(data.equals("index")) {
	    	return data;
	    } 
	    RequestResult o= auth.getBusiness(Integer.parseInt(data));
		  JSONObject jo=JSONObject.parseObject(o.getResult_object().toString());
		  int storeid=Integer.parseInt(jo.get("store_id").toString());
		return ReqResultUtil.getSuccessResponse(gs.getStoreGoods(storeid));
	}
	@RequestMapping(value="/getGoodsToOrder",method =RequestMethod.GET)
	@ResponseBody
	public String getOrderGoods(String goods_sku_id) {
		System.out.println(goods_sku_id);
		goodsBaseInfo  gsku=gs.getGoodsBaseInfo(Integer.parseInt(goods_sku_id));
		List<goodsPropertyInfo> gpiList=gs.getGoodsPropertyList(Integer.parseInt(goods_sku_id));
		System.out.println(gsku.toString());
		System.out.println(gpiList.toString());
	if(gsku!=null&&gpiList!=null&&gpiList.size()>0) {	
		goodsData gd=new goodsData(gsku,gpiList);
		return ReqResultUtil.getSuccessResponse(gd);
	}
		return ReqResultUtil.getFailedResponse();
	}
	@RequestMapping(value="/getAllGoodsList",method =RequestMethod.GET)
	@ResponseBody
	public String getGoodsList() {
		  List<goods_sku> goodsSkuList=gs.getAllGoodsSku();
		  List<goods> goodsList=gs.getAllGoods();
		//  System.out.println(goodsSkuList.toString());
		//  System.out.println(goodsList.toString());
		  List<Map> dataList =new ArrayList<Map>();
		  for(int i=0;i<goodsSkuList.size();i++) {
			  goodsImages gi=is.selectImage(goodsSkuList.get(i).getId());
			  if(gi!=null) {
				 // System.out.println(gi.toString());
				  Map<String,Object> map=new HashMap<String,Object>();
			  for(goods g:goodsList) {
				  if(g.getId()==goodsSkuList.get(i).getGoods_id()) {
					  map.put("goods_name",g.getName());
					  map.put("goods_month_sales",g.getMonthlySales());
					  map.put("goods_comment_volume",g.getCommentVolume());
					  map.put("goods_favorite_volume",g.getFavoritesVolume());
					  map.put("store_id",g.getStore_id());
				  }
			  }
			   map.put("goods_now_price", goodsSkuList.get(i).getNow_price());
			   map.put("goods_old_price", goodsSkuList.get(i).getOld_price());
			   map.put("goods_image",gi.getImage_path());
			   map.put("goods_id", goodsSkuList.get(i).getGoods_id());
			   dataList.add(i, map);
			   }
			  //System.out.println(dataList.get(i));
		  }
		  //System.out.println(dataList.toString());
		return ReqResultUtil.getSuccessResponse(dataList);
	}
	@RequestMapping(value="/getGoodsPropertyInfoList",method =RequestMethod.GET)
	@ResponseBody
	public String getGoodsSkuList(String goods_id) {
		//  gs.getGoodsPropertyList();
		//List<goods_sku> glist=gs.getGoodsSkuList(Integer.parseInt(goods_id));
		
		return ReqResultUtil.getSuccessResponse();
	}
	@RequestMapping(value="/getGoodsBaseInfo",method =RequestMethod.GET)
	@ResponseBody
	public String getGoodsBaseInfo(@RequestParam("goods_id") String goods_id) {
		//		System.out.println(goods_id);
		List<goods_sku> glist=gs.getGoodsSkuList(Integer.parseInt(goods_id));
		if(glist==null||glist.size()==0)  return ReqResultUtil.getFailedResponse();
		List<goodsBaseInfo> gbList=new ArrayList<goodsBaseInfo>();
		for(goods_sku g:glist) {
		goodsBaseInfo gbi=gs.getGoodsBaseInfo(g.getId());
		System.out.println(gbi.toString());
		gbList.add(gbi);
		}
		return ReqResultUtil.getSuccessResponse(gbList);
	}
	@RequestMapping(value="/addGoodsSkuInfo",method= RequestMethod.POST)
	public void addGoodsSkuInfo(@ModelAttribute goodsSku goods_sku,
			@RequestParam("imgfile") MultipartFile file,HttpServletResponse response) throws IOException {
		System.out.println(goods_sku.toString());
		System.out.println(file.getOriginalFilename());
		goods_sku goodSku=new goods_sku(randomID.createRandomID(),"",goods_sku.getGoods_id(),
				goods_sku.getGoods_price(),goods_sku.getGoods_price(),
				goods_sku.getGoods_sku_num(),0,new Date());
		gs.addGoodsSku(goodSku);
		gs.addNewsGoodsProperty(goods_sku.getAdd_property_list(),goodSku.getId());
		gs.addOldGoodsProperty(goods_sku.getPropertyNameValue_list(),goodSku.getId());
		String filePath ="D:\\linux\\file\\resources\\image\\";
		String fileName =randomID.createRandomID()+"_"+goods_sku.getGoods_id()+file.getOriginalFilename();
		int status =uploadGoodsImage(file.getBytes(), filePath, fileName);
		System.out.println(status);
		String image_url="http://192.168.6.128:8088/filepath/"+fileName;
		goodsImages goods_image=new goodsImages(goodSku.getId(),image_url,0);
		is.addImage(goods_image);
		response.sendRedirect("/ECS_Goods/manageGoodsList");
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
	public void addGoodsSpuInfo(@ModelAttribute goodsSpu goods_spu,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println(goods_spu.toString());
		 String  data=auth.getAuther(request);
		    if(data.equals("index")) {
		    	response.sendRedirect("/ECS_Goods/index");
		    } 
		    RequestResult o= auth.getBusiness(Integer.parseInt(data));
		  JSONObject jo=JSONObject.parseObject(o.getResult_object().toString());
		  int storeid=Integer.parseInt(jo.get("store_id").toString());
		  goodsCategory gc=new goodsCategory(randomID.createRandomID(),
					goods_spu.getGoods_family_id(),goods_spu.getGoods_category());
			gcs.addGoodsCategory(gc);
		goods g=new goods(randomID.createRandomID(),goods_spu.getGoods_name(),
				goods_spu.getGoods_title(),storeid,gc.getId(),new Date());
		gs.addGoods(g);
		response.sendRedirect("/ECS_Goods/manageGoodsSku");
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
