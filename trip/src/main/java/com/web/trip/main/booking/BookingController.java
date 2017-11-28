package com.web.trip.main.booking;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.trip.main.booking.service.BookingMapper;
import com.web.trip.util.ControllerMessage;

@Controller
public class BookingController {

	@Autowired
	private BookingMapper bookingMapper;

	ModelAndView mav = new ModelAndView();

	@Autowired
	private ControllerMessage cm;

	@RequestMapping(value = "booking_index", method = RequestMethod.GET)
	public ModelAndView indexBooking(HttpServletRequest arg0) throws Exception {
		int prod_num = ServletRequestUtils.getIntParameter(arg0, "prod_num");
		return new ModelAndView("main/booking/index", "prod_num", prod_num);
	}
}
