package com.web.trip.main.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping(value = "booking_index")
	public String indexAdmin() {
		return "main/booking/index";
	}
}
