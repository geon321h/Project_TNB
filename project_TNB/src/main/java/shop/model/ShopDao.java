package shop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Shop_Paging;

@Component("myShopDao")
public class ShopDao {
	
	private String namespace = "shop.model.Shop";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<ShopBean> search_shop(Shop_Paging pageInfo, Map<String, Object> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		List<ShopBean> lists = new ArrayList<ShopBean>();
		lists = sqlSessionTemplate.selectList(namespace+".search_shop",map,rowBounds);
		return  lists;
	}
	
	public int search_count(Map<String, Object> map) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".search_count",map);
		return  cnt;
	}

	public List<SearchBean> getServiceList() {
		List<SearchBean> lists = new ArrayList<SearchBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getServiceList");
		return  lists;
	}

	public List<CategoryBean> getCategoryList() {
		List<CategoryBean> lists = new ArrayList<CategoryBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getCategoryList");
		return  lists;
	}

	public ShopBean getShopInfo(String shop_id) {
		ShopBean shop = sqlSessionTemplate.selectOne(namespace+".getShopInfo",shop_id);
		return shop;
	}

	public List<String> getShopImage(String shop_id) {
		List<String> lists = new ArrayList<String>();
		lists = sqlSessionTemplate.selectList(namespace+".getShopImage",shop_id);
		return  lists;
	}

	public List<ServiceBean> getShopService(String shop_id) {
		List<ServiceBean> lists = new ArrayList<ServiceBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getShopService",shop_id);
		return  lists;
	}

	public List<GuideBean> getShopGuide(String shop_id) {
		List<GuideBean> lists = new ArrayList<GuideBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getShopGuide",shop_id);
		return  lists;
	}

	public List<ShopRoomBean> getShopRoom(Map<String, Object> map) {
		List<ShopRoomBean> lists = new ArrayList<ShopRoomBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getShopRoom",map);
		return  lists;
	}

	public List<ShopRoomBean> getRoomImage(String shop_id) {
		List<ShopRoomBean> lists = new ArrayList<ShopRoomBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getRoomImage",shop_id);
		return  lists;
	}

	public List<String> getKeyword(String keyword) {
		List<String> lists = new ArrayList<String>(); 
		lists = sqlSessionTemplate.selectList(namespace+".getKeyword",keyword);
		return  lists;
	}

	public List<ShopBean> getShopByRegion(Map<String, Object> map) {
		RowBounds rowBounds = new RowBounds(0,8);
		List<ShopBean> lists = new ArrayList<ShopBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getShopByRegion",map,rowBounds);
		return  lists;
	}
	
	
	

}
