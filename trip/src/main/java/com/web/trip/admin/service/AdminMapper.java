package com.web.trip.admin.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.trip.model.ShopCategoryDTO;
import com.web.trip.model.ShopProductDTO;
import com.web.trip.model.TravelBookingDTO;
import com.web.trip.model.TravelCategory;
import com.web.trip.model.TravelMemberDTO;
import com.web.trip.model.TravelPackageDTO;
import com.web.trip.model.TravelProductDTO;

@Service
public class AdminMapper {
	@Autowired
	private SqlSession sqlSession;
	//멤버리스트
	public List<TravelMemberDTO> listMember(){
		return sqlSession.selectList("listMember");
	}
	//getMember
	public TravelMemberDTO getMember(int member_num) {
		return sqlSession.selectOne("getMember",member_num);
	}
	//멤버 정보 수정
	public int editMember(TravelMemberDTO dto) {
		return sqlSession.update("editMember",dto);
	}
	//멤버 삭제!(이메일 인증과 시간 통과 후에만)
	public int deleteMember(int member_num) {
		return sqlSession.delete("deleteMember",member_num);
	}
	//멤버 예약 리스트
	public List<TravelBookingDTO> booking_list(int member_id){
		return sqlSession.selectList("booking_list",member_id);
	}
	//여행지역 카테고리 목록
	public List<TravelCategory> listTravelCategory(){
		return sqlSession.selectList("listTravelCategory");
	}
	//여행지역 카테고리 등록
	public int insertTravelCategory(TravelCategory dto) {
		return sqlSession.insert("insertTravelCategory",dto);
	}
	//여행지역 카테고리 삭제
	public int deleteTravelCategory(int tCate_num) {
		return sqlSession.delete("deleteTravelCategory",tCate_num);
	}
	//getCategory
	public TravelCategory getTravelCategory(int tCate_num) {
		return sqlSession.selectOne("getTravelCategory",tCate_num);
	}
	//여행지역 카테고리 수정
	public int editTravelCategory(TravelCategory dto) {
		return sqlSession.update("editTravelCategory",dto);
	}
	//여행 상품 등록
	public int insertTravelProduct(TravelProductDTO dto) {
		return sqlSession.insert("insertTravelProduct",dto);
	}
	//여행 상품 삭제
	public int deleteTravelProduct(int prod_num) {
		return sqlSession.delete("deleteTravelProduct",prod_num);
	}
	//여행 상품 목록
	public List<TravelProductDTO> listTravelProduct(){
		return sqlSession.selectList("listTravelProduct");
	}
	//getTravelProduct
	public TravelProductDTO getTravelProduct(int prod_num) {
		return sqlSession.selectOne("getTravelProduct",prod_num);
	}
	//여행 상품 수정 
	public int editTravelProduct(TravelProductDTO dto) {
		return sqlSession.update("editTravelProduct",dto);
	}
	//패키지 상품 리스트
	public List<TravelPackageDTO> listPackage(){
		return sqlSession.selectList("listPackage");
	}
	//패키지 상품 등록
	public int insertPackage(TravelPackageDTO dto) {
		return sqlSession.insert("insertPackage",dto);
	}
	//getPackage
	public TravelPackageDTO getPackage(int pack_num) {
		return sqlSession.selectOne("getPackage",pack_num);
	}
	//패키지 상품 수정
	public int editPackage(TravelPackageDTO dto) {
		return sqlSession.update("editPackage",dto);
	}
	//패키지 상품 삭제
	public int deletePackage(int pack_num) {
		return sqlSession.delete("deletePackage",pack_num);
	}
	//쇼핑몰 카테고리 등록
	public int insertShopCategory(ShopCategoryDTO dto) {
		return sqlSession.insert("insertShopCategory",dto);
	}
	//쇼핑몰 카테고리 목록
	public List<ShopCategoryDTO> listShopCategory(){
		return sqlSession.selectList("listShopCategory");
	}
	public int deleteShopCategory(int shop_cate_num) {
		return sqlSession.delete("deleteShopCategory",shop_cate_num);
	}
	//getCategory
	public ShopCategoryDTO getShopCategory(int shop_cate_num) {
		return sqlSession.selectOne("getShopCategory",shop_cate_num);
	}
	//쇼핑몰 카테고리 수정
	public int editShopCategory(ShopCategoryDTO dto) {
		return sqlSession.update("editShopCategory",dto);
	}
	//쇼핑몰 상품 목록
	public List<ShopProductDTO> listShopProduct(){
		return sqlSession.selectList("listShopProduct");
	}
	//쇼핑몰 상품 등록
	public int insertShopProd(ShopProductDTO dto) {
		return sqlSession.insert("insertShopProduct", dto);
	}
	//쇼핑몰 상품 삭제
	public int deleteShopProd(int shop_prod_num) {
		return sqlSession.delete("deleteShopProduct", shop_prod_num);
	}
	//get shopProduct
	public ShopProductDTO getProduct(int shop_prod_num){
		return sqlSession.selectOne("getProduct", shop_prod_num);
	}
	//쇼핑몰 상품 수정
	public int editShopProduct(ShopProductDTO dto) {
		return sqlSession.update("editShopProduct", dto);
	}
}
