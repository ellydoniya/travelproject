package com.web.trip.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.web.trip.admin.service.AdminMapper;
import com.web.trip.util.ControllerMessage;

@Controller
public class ShopController {
	private ModelAndView mav = new ModelAndView();

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private ControllerMessage cm;

//	// ==============<<<<쇼핑몰 관련>>>========================
//	@RequestMapping(value = "shop_category_insert", method = RequestMethod.GET)
//	public String viewShopCategoryInsert() {
//		return "admin/shop_category_insert";
//	}// 쇼핑몰 카테고리 등록
//
//	@RequestMapping(value = "shop_category_insert", method = RequestMethod.POST)
//	public ModelAndView insertShopCategory(@ModelAttribute ShopCategoryDTO dto) {
//		int res = adminMapper.insertShopCategory(dto);
//		String[] msg = { "쇼핑몰 카테고리 등록 완료! 목록으로 이동합니다!", "쇼핑몰 카테고리 등록 실패! 등록페이지로 이동합니다." };
//		String[] url = { "admin/shop_categroy_list", "admin/shop_category_insert" };
//		return cm.resMassege(res, msg, url);
//	}
//
//	// 쇼핑몰 카테고리 목록
//	@RequestMapping(value = "shop_category_list")
//	public ModelAndView listShopCategory() {
//		List<ShopCategoryDTO> list = adminMapper.listShopCategory();
//		mav.addObject("shopCategory", list);
//		return mav;
//	}// 쇼핑몰 카테고리 삭제
//
//	@RequestMapping(value = "shop_category_delete")
//	public ModelAndView deleteShopCategory(int shop_cate_num) {
//		int res = adminMapper.deleteShopCategory(shop_cate_num);
//		String[] msg = { "쇼핑몰 카테고리 삭제 완료! 목록으로 이동합니다!", "쇼핑몰 카테고리 삭제 실패! 목록으로 이동합니다." };
//		String[] url = { "admin/shop_categroy_list", "admin/shop_category_edit?shop_cate_list" };
//		return cm.resMassege(res, msg, url);
//	}
//
//	// 쇼핑몰 카테고리 수정
//	@RequestMapping(value = "shop_category_edit", method = RequestMethod.GET)
//	public ModelAndView vieweditShopCategory(@RequestParam int shop_cate_num) {
//		ShopCategoryDTO dto = adminMapper.getShopCategory(shop_cate_num);
//		mav.addObject("getShopCategory", dto);
//		mav.setViewName("admin/shop_category_eidt");
//		return mav;
//	}
//
//	@RequestMapping(value = "shop_category_edit", method = RequestMethod.POST)
//	public ModelAndView editShopCategory(@ModelAttribute ShopCategoryDTO dto, BindingResult result) {
//		int res = adminMapper.editShopCategory(dto);
//		String[] msg = { "쇼핑몰 카테고리 수정 완료! 목록으로 이동합니다!", "쇼핑몰 카테고리 수정 실패! 수정페이지로 이동합니다." };
//		String[] url = { "admin/shop_categroy_list",
//				"admin/shop_category_edit?shop_cate_num=" + dto.getShop_cate_num() };
//		return cm.resMassege(res, msg, url);
//	}
//
//	// 쇼핑몰 상품 목록
//	@RequestMapping(value = "shop_prod_list")
//	public ModelAndView listShopProduct() {
//		List<ShopProductDTO> list = adminMapper.listShopProduct();
//		mav.addObject("shopProductList", list);
//		mav.setViewName("admin/shop_prod_list");
//		return mav;
//	}
//
//	// 쇼핑몰 상품 등록
//	@RequestMapping(value = "shop_prod_insert", method = RequestMethod.GET)
//	public String viewshopInsert() {
//		return "admin/shop_prod_insert";
//	}
//
//	@RequestMapping(value = "shop_prod_insert", method = RequestMethod.POST)
//	public ModelAndView ShopProdInsert(@ModelAttribute ShopProductDTO dto) {
//		int res = adminMapper.insertShopProd(dto);
//		String msg[] = { "쇼핑몰 상품 등록 완료! 쇼핑몰 리스트 페이지로 이동합니다.", "쇼핑몰 상품 등록 실패! 쇼핑몰 등록 페이지로 이동합니다." };
//		String url[] = { "admin/shop_prod_list", "admin/shop_prod_insert" };
//		return cm.resMassege(res, msg, url);
//	}
//
//	// 쇼핑몰 상품 삭제
//	@RequestMapping(value = "shop_prod_delete")
//	public ModelAndView deleteShopProduct(@RequestParam String shop_prod_num) {
//		int res = adminMapper.deleteShopProd(Integer.parseInt(shop_prod_num));
//		String msg[] = { "쇼핑몰 상품 삭제 완료! 쇼핑몰 리스트 페이지로 이동합니다.", "쇼핑몰 삭제 실패! 쇼핑몰 상세보기 페이지로 이동합니다." };
//		String url[] = { "admin/shop_prod_list", "admin/shop_prod_view?shop_prod_num=" + shop_prod_num };
//		return cm.resMassege(res, msg, url);
//	}
//
//	// 쇼핑몰 상품 상세보기
//	@RequestMapping(value = "shop_prod_view")
//	public ModelAndView viewShopProduct(@RequestParam String shop_prod_num) {
//		ShopProductDTO dto = adminMapper.getProduct(Integer.parseInt(shop_prod_num));
//		mav.addObject("getShopProduct", dto);
//		mav.setViewName("admin/shop_prod_view");
//		return mav;
//	}
//
//	// 쇼핑몰 상품 수정
//	@RequestMapping(value = "shop_prod_edit", method = RequestMethod.GET)
//	public ModelAndView viewEditShopProduct(@RequestParam String shop_prod_num) {
//		ShopProductDTO dto = adminMapper.getProduct(Integer.parseInt(shop_prod_num));
//		mav.addObject("getShopProduct", dto);
//		mav.setViewName("admin/shop_prod_edit");
//		return mav;
//	}
//
//	@RequestMapping(value = "shop_prod_edit", method = RequestMethod.POST)
//	public ModelAndView editShopProduct(@ModelAttribute ShopProductDTO dto) {
//		int res = adminMapper.editShopProduct(dto);
//		String msg[] = { "쇼핑몰 상품 수정 완료! 상품 상세보기 페이지로 이동합니다.", "쇼핑몰 상품 수정 실패! 상품 수정 페이지로 이동합니다." };
//		String url[] = { "admin/shop_prod_view?shop_prod_num=" + dto.getShop_prod_num(),
//				"admin/shop_prod_edit?shop_prod_num=" + dto.getShop_prod_num() };
//		return cm.resMassege(res, msg, url);
//	}
}
