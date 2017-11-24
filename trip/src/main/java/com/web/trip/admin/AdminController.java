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
import com.web.trip.model.TravelCategory;
import com.web.trip.model.TravelMemberDTO;
import com.web.trip.model.TravelProductDTO;
import com.web.trip.util.CategoryInput;

@Controller
public class AdminController {

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private CategoryInput cateInput;
	ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value="admin_index")
	public String indexAdmin() {
		return "admin/admin_index";
	}
	//==============멤버 리스트 관련======================== 	
	@RequestMapping(value="list_member")
	public ModelAndView list_Member(){
		List<TravelMemberDTO> list = adminMapper.listMember();
		mav.addObject("memberList",list);
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
		if(res>0){
			mav.addObject("msg","카테고리 등록 완료! 카테고리 목록으로 이동합니다.");
			mav.addObject("url","admin/travel_category_list");
		}else {
			mav.addObject("msg","카테고리 등록 실패! 카테고리 등록으로 이동합니다.");
			mav.addObject("url","admin/travel_category_insert");
		}
		mav.setViewName("message"); return mav;
	}
	//여행 지역 카테고리 삭제
	@RequestMapping(value="travel_category_delete")
	public ModelAndView veiwDeleteTravelCategory(int tCate_num) {
		int res = adminMapper.deleteTravelCategory(tCate_num);
		if(res > 0) {
			mav.addObject("msg","카테고리 삭제 완료! 카테고리 목록으로 이동합니다.");
		}else {
			mav.addObject("msg","카테고리 등록 실패! 카테고리 목록으로 이동합니다.");
		}
		mav.addObject("url","admin/travel_category_list");
		mav.setViewName("message");
		return mav;
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
		if(res > 0) {
			mav.addObject("msg","여행 카테고리 수정완료! 여행카테고리 목록 페이지로 이동합니다.");
			mav.addObject("url","admin/travel_category_list");
		}else {
			mav.addObject("msg","여행 카테고리 수정완료! 여행카테고리 목록 페이지로 이동합니다.");
			mav.addObject("url","admin/travel_category_list");
		}
		mav.setViewName("message");
		return mav;
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
		if(res > 0) {
			mav.addObject("msg","여행상품 등록 성공! 리스트 페이지로 이동합니다.");
			mav.addObject("url","admin/tarvel_prod_list");
			mav.setViewName("message");
		}else {
			mav.addObject("msg","여행상품 등록 실패! 여행 상품등록 페이지로 이동합니다.");
			mav.addObject("url","admin/travel_prod_insert");
			mav.setViewName("message");
		}
		return mav;
	}
	//여행 상품 삭제
	@RequestMapping(value="travel_prod_delete")
	public ModelAndView deleteTravelProduct(@RequestParam int prod_num) {
		int res = adminMapper.deleteTravelProduct(prod_num);
		if(res>0) {
			mav.addObject("msg","여행 상품 삭제 완료! 여행상품 목록 페이지로 이동합니다.");
		}else {
			mav.addObject("msg","여행 상품 삭제 실패! 여행상품 목록 페이지로 이동합니다.");
		}
		mav.addObject("url","admin/travel_prod_list");
		mav.setViewName("message");
		return mav;
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
			//고민중	
			}
		
		int res = adminMapper.editTravelProduct(dto);
		if(res>0) {
			mav.addObject("msg","여행상품 수정 완료! 여행상품 목록 페이지로 이동합니다.");
			mav.addObject("url", "admin/travel_prod_list");
		}else {
			mav.addObject("msg","여행상품 수정 실패! 여행상품 수정 페이지로 이동합니다.");
			mav.addObject("url", "admin/travel_prod_edit?prod_num="+dto.getProd_num());
		}
		mav.setViewName("message");
		return mav;
	}
	
	//==============<<<<쇼핑몰  관련>>>========================
	@RequestMapping(value="shop_category_insert", method=RequestMethod.GET)
	public String viewShopCategoryInsert() {
		return "admin/shop_category_insert";
	}//쇼핑몰 카테고리 등록
	@RequestMapping(value="shop_category_insert",method=RequestMethod.POST)
	public ModelAndView insertShopCategory(@ModelAttribute ShopCategoryDTO dto ) {
		int res = adminMapper.insertShopCategory(dto);
		if(res> 0) {
			mav.addObject("msg","쇼핑몰 카테고리 등록 성공! 쇼핑몰 카테고리 목록으로 이동합니다.");
			mav.addObject("url","admin/shop_category_list");
		}else {
			mav.addObject("msg","쇼핑몰 카테고리 등록 실패! 쇼핑몰 카테고리 등록으로 이동합니다.");
			mav.addObject("url","admin/shop_category_insert");
		}
		mav.setViewName("message");	return mav;
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
		if(res >0) {
			mav.addObject("msg","쇼핑몰 카테고리 삭제 성공! 쇼핑몰 카테고리 목록으로 이동합니다.");
		}else {
			mav.addObject("msg","쇼핑몰 카테고리 삭제 실패! 쇼핑몰 카테고리 목록으로 이동합니다.");
		}
		mav.addObject("url","admin/shop_category_list");
		mav.setViewName("message");	return mav;
	}
	
}
