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
import com.web.trip.model.TravelBookingDTO;
import com.web.trip.model.TravelMemberDTO;
import com.web.trip.util.ControllerMessage;

@Controller
public class MemberController {

	private ModelAndView mav = new ModelAndView();
	
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private ControllerMessage cm;
	
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
	
}
