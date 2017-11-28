package com.web.trip.util;

import org.springframework.stereotype.Service;

@Service
public class CategoryInput {

	public String[] configCategory(int state, String city) {
		String[] stateChoice = { "서울특별시", "강원도", "경기도", "경상도", "전라도", "제주도", "충청도" };
		String[] seoulCity = { "강남구", "종로구", "마포구", "중구", "용산구", };
		String[] kangwonCity = {"평창시", "춘천시", "강릉시", "횡성시" ,"양양시"};
		String[] kyunggiCity = {"용인시", "파주시", "의정부시", "수원특별시", "인천광역시" };
		String[] kyungsangCity = { "부산광역시", "거제시", "통영시", "남해시", "대구광역시", "울산광역시" };
		String[] jeonraCity = { "광주광역시", "춘천시", "여수시", "전주시", "남원시"};
		String[] jejuCity = { "제주시", "서귀포시" };
		String[] chungchungCity = { "대전광역시","보령시", "천안시", "청주시" };
		String [] tmp = new String [2];	
		String select = null;
		
		switch(state){
			case 0://서울
				tmp[0] = stateChoice[0];
				for(int i = 0; i < seoulCity.length; i ++) {
					if(city.equals(seoulCity[i])) {
						select = seoulCity[i];
					}
				}
				tmp[1] =select;
				break;
			case 1://강원
				tmp[0] = stateChoice[1];
				for(int i = 0; i < kangwonCity.length; i ++) {
					if(city.equals(kangwonCity[i])) {
						select = kangwonCity[i];
					}
				}
				tmp[1] =select;
				break;
			case 2://경기
				tmp[0] = stateChoice[2];
				for(int i = 0; i < kyunggiCity.length; i ++) {
					if(city .equals(kyunggiCity[i])) {
						select = kyunggiCity[i];
					}
				}
				tmp[1] =select;
				break;
			case 3://경상
				tmp[0] = stateChoice[3];
				for(int i = 0; i < kyungsangCity.length; i ++) {
					if(city.equals(kyungsangCity[i])) {
						select = kyungsangCity[i];
					}
				}
				tmp[1] =select;
				break;
			case 4://전라
				tmp[0] = stateChoice[4];
				for(int i = 0; i < jeonraCity.length; i ++) {
					if(city.equals(jeonraCity[i])) {
						select = jeonraCity[i];
					}
				}
				tmp[1] =select;
				break;
			case 5://제주
				tmp[0] = stateChoice[5];
				for(int i = 0; i < jejuCity.length; i ++) {
					if(city.equals(jejuCity[i])) {
						select = jejuCity[i];
					}
				}
				tmp[1] =select;
				break;
			case 6://충청
				tmp[0] = stateChoice[6];
				for(int i = 0; i < chungchungCity.length; i ++) {
					if(city.endsWith(chungchungCity[i])) {
						select = chungchungCity[i];
					}
				}
				tmp[1] =select;
				break;
			}
		System.out.println("도 :"+tmp[0]+"/ 시 : "+tmp[1]);
		return tmp;
	}
}
