package com.web.trip.main.booking.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingMapper {
	@Autowired
	private SqlSession sqlSession;

	
}
