package com.web.trip.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.web.trip.admin.service.AdminMapper;
import com.web.trip.model.TravelPackageDTO;
import com.web.trip.util.ControllerMessage;

@Controller
public class PackageController {
	
	private ModelAndView mav = new ModelAndView();
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private ControllerMessage cm;
	
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
	
}
