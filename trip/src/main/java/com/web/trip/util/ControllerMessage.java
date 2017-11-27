package com.web.trip.util;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ControllerMessage {
	
	public ModelAndView resMassege(int res, String[] msg, String[] url) {
		ModelAndView mav = new ModelAndView();
		if(res>0) {
			mav.addObject("msg",msg[0]);
			mav.addObject("url",url[0]);
		}else {
			mav.addObject("msg",msg[1]);
			mav.addObject("url",url[1]);
		}
		mav.setViewName("message");
		return mav;
	}
}
