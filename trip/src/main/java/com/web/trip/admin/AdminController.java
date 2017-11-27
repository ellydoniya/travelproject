package com.web.trip.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.web.trip.admin.service.AdminMapper;
import com.web.trip.model.ShopCategoryDTO;
import com.web.trip.model.TravelBookingDTO;
import com.web.trip.model.TravelCategory;
import com.web.trip.model.TravelMemberDTO;
import com.web.trip.model.TravelPackageDTO;
import com.web.trip.model.TravelProductDTO;
import com.web.trip.util.CategoryInput;
import com.web.trip.util.ControllerMessage;

@Controller
public class AdminController {

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private CategoryInput cateInput;
	ModelAndView mav = new ModelAndView();
	@Autowired
	private ControllerMessage cm;
	
	@RequestMapping(value="admin_index")
	public String indexAdmin() {
		return "admin/admin_index";
	}
	//==============멤버 리스트 관련======================== 	
	@RequestMapping(value="travel_member_list")
	public ModelAndView list_Member(){
		List<TravelMemberDTO> list = adminMapper.listMember();
		mav.addObject("memberList",list);
		mav.setViewName("admin/travel_member_list");
		return mav;
	}
	//멤버 정보 수정(고객 요청시에만)
	@RequestMapping(value="travel_member_edit",method=RequestMethod.GET)
	public ModelAndView viewmember_edit(@RequestParam String member_num) {
		TravelMemberDTO dto = adminMapper.getMember(Integer.parseInt(member_num));
		mav.addObject("getMember",dto);
		mav.setViewName("admin/travel_member_edit"); return mav;
	}
	@RequestMapping(value="travel_member_edit",method=RequestMethod.POST)
	public ModelAndView editMember(@ModelAttribute TravelMemberDTO dto) {
		int res = adminMapper.editMember(dto);
		String msg [] = {"멤버 수정 완료! 상세보기 페이지로 이동합니다.","멤버 수정 실패! 수정 페이지로 이동합니다."};
		String url[] =  {"admi/travel_member_view","admin/travel_member_edit?member_num="+dto.getMember_name()};
		return cm.resMassege(res, msg, url);
	}
	//멤버 삭제 (일정 시간이 지나야만 삭제 될 수 있도록 구현하기...)
	@RequestMapping(value="travel_member_delete")
	public ModelAndView deleteMember(@RequestParam String member_num) {
		int res = adminMapper.deleteMember(Integer.parseInt(member_num));
		//이부분에서는 메일 쏴주는 것 고민해보기. 시간 체크해서 쏴주는거 고민해주기.
		return mav;
	}
	//멤버 예약 리스트
	@RequestMapping(value="travel_member_bookingList")
	public ModelAndView member_bookingList(@RequestParam String member_id) {
		List<TravelBookingDTO> list = adminMapper.booking_list(Integer.parseInt(member_id));
		mav.addObject("member_bookingList",list);
		mav.setViewName("admin/travel_member_bookingList");
		return mav;
	}
	//==============<<<여행 지역 카테고리 관련>>>======================== 
	@RequestMapping(value="travel_category_insert", method=RequestMethod.GET)
	public String viewTravelCategory() {
		return "admin/trave_category_insert";
	}
	// 여행 지역 카테고리 등록
	@RequestMapping(value="travel_category_insert",method=RequestMethod.POST)
	public ModelAndView insertCategory(@RequestParam String state, @RequestParam String city) {
		if(state==null || state.trim().equals("") || city==null || city.trim().equals("")) {
			return new ModelAndView("redirect:travel_category_insert");
		}
		// 도, 시가 추가될 시 util에 추가!
		String [] values = cateInput.configCategory(Integer.parseInt(state), Integer.parseInt(city));
		TravelCategory dto = new TravelCategory();
		dto.setTravel_cate_state(values[0]);
		dto.setTravel_cate_city(values[1]);
		int res = adminMapper.insertTravelCategory(dto);
		String [] msg = {"여행 카테고리 등록 완료! 여행 카테고리 목록 페이지로 이동합니다.","여행상품 등록 실패! 여행상품 등록 페이지로 이동합니다."};
		String [] url = {"admin/travel_category_list","admin/travel_category_edit?travel_cate_insert"};
		return cm.resMassege(res, msg, url);
	}
	//여행 지역 카테고리 삭제
	@RequestMapping(value="travel_category_delete")
	public ModelAndView veiwDeleteTravelCategory(int tCate_num) {
		int res = adminMapper.deleteTravelCategory(tCate_num);
		String [] msg = {"여행 카테고리 삭제 완료! 여행 카테고리 목록 페이지로 이동합니다.","여행상품 삭제 실패! 여행상품 목록 페이지로 이동합니다."};
		String [] url = {"admin/travel_category_list","admin/travel_category_edit?travel_cate_list"};
		return cm.resMassege(res, msg, url);
	}
	//여행 지역 카테고리 수정
	@RequestMapping(value="travel_category_edit", method=RequestMethod.GET)
	public ModelAndView viewEditTravelCategory(@RequestParam int tCate_num) {
		TravelCategory dto = adminMapper.getTravelCategory(tCate_num);
		mav.addObject("getCategory",dto);
		mav.setViewName("admin/travel_category_edit"); return mav;
	}
	@RequestMapping(value="travel_category_edit", method=RequestMethod.POST)
	public ModelAndView editTravelCategory(@ModelAttribute TravelCategory dto, BindingResult result) {
		if(result.hasErrors()) {
		//고민중	
		}
		int res = adminMapper.editTravelCategory(dto);
		String [] msg = {"여행 카테고리 수정 완료! 여행 카테고리 목록 페이지로 이동합니다.","여행상품 수정 실패! 여행상품 수정 페이지로 이동합니다."};
		String [] url = {"admin/travel_category_list","admin/travel_category_edit?travel_cate_num="+dto.getTravel_cate_num()};
		return cm.resMassege(res, msg, url);
	}
	//여행지역 카테고리 목록
	@RequestMapping(value="travel_category_list")
	public ModelAndView listTravelCategory() {
		List<TravelCategory> list = adminMapper.listTravelCategory();
		mav.addObject("travelCategory",list);
		mav.setViewName("admin/travel_category_list"); return mav;
	}
	
	//==============<<<<여행 상품  관련>>>======================== 
	@RequestMapping(value="travel_prod_insert", method=RequestMethod.GET)
	public String viewTravelProduct() {
		return "admin/travel_product";
	}
	//여행 상품 등록 
	@RequestMapping(value="travel_prod_insert", method=RequestMethod.POST)
	public ModelAndView insertTravelProduct(TravelProductDTO dto) {
		if(dto.getProd_name()==null || dto.getProd_name().trim().equals("")) {
			mav.addObject("msg","잘못된 접근입니다. 여행상품 등록으로 이동합니다.");
			mav.addObject("url","admin/travel_prod_insert");
			mav.setViewName("message"); return mav;
		}
		int res = adminMapper.insertTravelProduct(dto);
		String [] msg = {"여행상품 등록 완료! 여행상품 목록 페이지로 이동합니다.","여행상품 등록 실패! 여행상품 등록 페이지로 이동합니다."};
		String [] url = {"admin/travel_prod_list","admin/travel_prod_list"};
		return cm.resMassege(res, msg, url);
	}
	//여행 상품 삭제
	@RequestMapping(value="travel_prod_delete")
	public ModelAndView deleteTravelProduct(@RequestParam int prod_num) {
		int res = adminMapper.deleteTravelProduct(prod_num);
		String [] msg = {"여행상품 삭제 완료! 여행상품 목록 페이지로 이동합니다.","여행상품 삭제 실패! 여행상품 목록 페이지로 이동합니다."};
		String [] url = {"admin/travel_prod_list","admin/travel_prod_list"};
		return cm.resMassege(res, msg, url);
	}
	//여행 상품 목록
	@RequestMapping(value="travel_prod_list")
	public ModelAndView listTravelproduct() {
		List<TravelProductDTO> list = adminMapper.listTravelProduct();
		mav.addObject("ProductList",list);
		mav.setViewName("admin/travel_prod_list");
		return mav;
	}
	//여행 상품 수정
	@RequestMapping(value="travel_prod_edit", method=RequestMethod.GET)
	public ModelAndView viewTravelProductEdit(@RequestParam int prod_num) {
		TravelProductDTO dto = adminMapper.getTravelProduct(prod_num);
		mav.addObject("getProduct",dto);
		mav.setViewName("admin/travel_prod_edit");
		return mav;
	}
	@RequestMapping(value="travel_prod_edit", method=RequestMethod.POST)
	public ModelAndView TravelProductEdit(@ModelAttribute TravelProductDTO dto, BindingResult result) {
		if(result.hasErrors()) {
			//고민중...
		}
		int res = adminMapper.editTravelProduct(dto);
		String [] msg = {"여행상품 수정 완료! 여행상품 목록 페이지로 이동합니다.","여행상품 수정 실패! 여행상품 수정 페이지로 이동합니다."};
		String [] url = {"admin/travel_prod_list","admin/travel_prod_edit?prod_num="+dto.getProd_num()};
		return cm.resMassege(res, msg, url);
	}
	
	//==============<<<<패키지 상품  관련>>>========================
	@RequestMapping(value="travel_pack_list")
	public ModelAndView listPackage(){
		List<TravelPackageDTO> list = adminMapper.listPackage();
		mav.addObject("listPackage",list);
		mav.setViewName("admin/travel_pack_list");	return mav;
	}
	//패키지 상품 등록
	@RequestMapping(value="travel_pack_insert",method=RequestMethod.GET)
	public String viewinsertPackage() {
		return "admin/travel_pack_insert";
	}
	@RequestMapping(value="travel_pack_insert",method=RequestMethod.POST)
	public ModelAndView insertPackage(@ModelAttribute TravelPackageDTO dto) {
		int res = adminMapper.insertPackage(dto);
		String msg[] = {"패키지 상품 등록 완료! 패키지 상품 목록으로 이동합니다!","패키지 상품 등록 실패! 등록 페이지로 이동합니다."};
		String url[] = {"admin/travel_pack_list","admin/travel_pack_insert"};
		return cm.resMassege(res, msg, url);
	}
	//패키지 상품 상세보기
	@RequestMapping(value="travel_pack_view")
	public ModelAndView viewPackage(@RequestParam String pack_num) {
		TravelPackageDTO dto = adminMapper.getPackage(Integer.parseInt(pack_num));
		mav.addObject("getPackage",dto);
		mav.setViewName("admin/travel_pack_view"); return mav;
	}
	//패키지 상품 수정
	@RequestMapping(value="travel_pack_edit", method=RequestMethod.GET)
	public ModelAndView viewEditPackage(@RequestParam String pack_num) {
		TravelPackageDTO dto= adminMapper.getPackage(Integer.parseInt(pack_num));
		mav.addObject("editPackage",dto);
		mav.setViewName("admin/travel_pack_edit"); return mav;
	}
	@RequestMapping(value="travle_pack_edit", method=RequestMethod.POST)
	public ModelAndView editPackage(@ModelAttribute TravelPackageDTO dto) {
		int res = adminMapper.editPackage(dto);
		String msg[]= {"패키지 상품 수정 완료! 패키지 상세보기 페이지로 이동합니다.","패키지 상품 수정 실패! 패키지 수정 페이지로 이동합니다."};
		String url[] = {"admin/travel_pack_view?pack_num="+dto.getPack_num(),"admin/travel_pack_edit?pack_num="+dto.getPack_num()};
		return cm.resMassege(res, msg, url);
	}
	//패키지 상품 삭제
	@RequestMapping(value="travel_pack_delete")
	public ModelAndView deletePackage(@RequestParam String pack_num) {
		int res = adminMapper.deletePackage(Integer.parseInt(pack_num));
		String msg[] = {"패키지 상품 삭제 완료! 패키지상품 목록으로 이동합니다.", "패키지 상품 삭제 실패! 패키지 상세보기 페이지로 이동합니다."};
		String url[] = {"admin/travel_pack_list","admin/travel_pack_view?pack_num="+pack_num};
		return cm.resMassege(res, msg, url);
	}
	
	//==============<<<<쇼핑몰  관련>>>========================
	@RequestMapping(value="shop_category_insert", method=RequestMethod.GET)
	public String viewShopCategoryInsert() {
		return "admin/shop_category_insert";
	}//쇼핑몰 카테고리 등록
	@RequestMapping(value="shop_category_insert",method=RequestMethod.POST)
	public ModelAndView insertShopCategory(@ModelAttribute ShopCategoryDTO dto ) {
		int res = adminMapper.insertShopCategory(dto);
		String [] msg = {"쇼핑몰 카테고리 등록 완료! 목록으로 이동합니다!","쇼핑몰 카테고리 등록 실패! 등록페이지로 이동합니다."};
		String [] url = {"admin/shop_categroy_list","admin/shop_category_insert"};
		return cm.resMassege(res, msg, url);
	}
	//쇼핑몰 카테고리 목록
	@RequestMapping(value="shop_category_list")
	public ModelAndView listShopCategory() {
		List<ShopCategoryDTO> list = adminMapper.listShopCategory();
		mav.addObject("shopCategory",list);	return mav;
	}//쇼핑몰 카테고리 삭제
	@RequestMapping(value="shop_category_delete")
	public ModelAndView deleteShopCategory(int shop_cate_num) {
		int res = adminMapper.deleteShopCategory(shop_cate_num);
		String [] msg = {"쇼핑몰 카테고리 삭제 완료! 목록으로 이동합니다!","쇼핑몰 카테고리 삭제 실패! 목록으로 이동합니다."};
		String [] url = {"admin/shop_categroy_list","admin/shop_category_edit?shop_cate_list"};
		return cm.resMassege(res, msg, url);
	}
	//쇼핑몰 카테고리 수정
	@RequestMapping(value="shop_category_edit",method=RequestMethod.GET)
	public ModelAndView vieweditShopCategory(@RequestParam int shop_cate_num) {
		ShopCategoryDTO dto = adminMapper.getShopCategory(shop_cate_num);
		mav.addObject("getShopCategory",dto);
		mav.setViewName("admin/shop_category_eidt");	return mav;
	}
	@RequestMapping(value="shop_category_edit",method=RequestMethod.POST)
	public ModelAndView editShopCategory(@ModelAttribute ShopCategoryDTO dto,BindingResult result) {
		int res = adminMapper.editShopCategory(dto);
		String [] msg = {"쇼핑몰 카테고리 수정 완료! 목록으로 이동합니다!","쇼핑몰 카테고리 수정 실패! 수정페이지로 이동합니다."};
		String [] url = {"admin/shop_categroy_list","admin/shop_category_edit?shop_cate_num="+dto.getShop_cate_num()};
		return cm.resMassege(res, msg, url);
	}
}
