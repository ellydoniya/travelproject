package com.web.trip.util;

import org.springframework.stereotype.Service;

@Service
public class CategoryInput {

	public String[] configCategory(int state, int city) {
		String[] stateChoice = { "서울특별시", "강원도", "경기도", "경상도", "전라도", "제주도", "충청도" };
		String[] seoulCity = { "강남구", "", "", "", "", };
		String[] kangwonCity = {"평창", "춘천","강릉","횡성"};
		String[] kyunggiCity = { "용인", "파주" };
		String[] kyungsangCity = { "부산", "거제", "통영", "남해", "대구", "울산" };
		String[] jeonraCity = { "광주", "춘천", "여수", "전주", };
		String[] jejuCity = { "제주", "서귀포" };
		String[] chungchungCity = { "보령", "대전", "천안", "청주" };
		String [] tmp = new String [2];	
		String select = null;
		
		switch(state){
			case 0://서울
				tmp[0] = stateChoice[0];
				for(int i = 0; i < seoulCity.length; i ++) {
					if(city == i) {
						select = seoulCity[i];
					}
				}
				tmp[1] =select;
			case 1://강원
				tmp[0] = stateChoice[1];
				for(int i = 0; i < kangwonCity.length; i ++) {
					if(city == i) {
						select = kangwonCity[i];
					}
				}
				tmp[1] =select;
			case 2://경기
				tmp[0] = stateChoice[2];
				for(int i = 0; i < kyunggiCity.length; i ++) {
					if(city == i) {
						select = kyunggiCity[i];
					}
				}
				tmp[1] =select;
			case 3://경상
				tmp[0] = stateChoice[3];
				for(int i = 0; i < kyungsangCity.length; i ++) {
					if(city == i) {
						select = kyungsangCity[i];
					}
				}
				tmp[1] =select;
			case 4://전라
				tmp[0] = stateChoice[4];
				for(int i = 0; i < jeonraCity.length; i ++) {
					if(city == i) {
						select = jeonraCity[i];
					}
				}
				tmp[1] =select;
			case 5://제주
				tmp[0] = stateChoice[5];
				for(int i = 0; i < jejuCity.length; i ++) {
					if(city == i) {
						select = jejuCity[i];
					}
				}
				tmp[1] =select;
			case 6://충청
				tmp[0] = stateChoice[6];
				for(int i = 0; i < chungchungCity.length; i ++) {
					if(city == i) {
						select = chungchungCity[i];
					}
				}
				tmp[1] =select;
			}
		System.out.println("도 :"+tmp[0]+"시 : "+tmp[1]);
		return tmp;
	}
}
