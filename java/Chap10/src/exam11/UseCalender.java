package exam11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UseCalender {

	public static void main(String[] args) {
		
		
		//현재 날짜
		//Calendar today = new Calender(); <- 이런식으로 불러 올수 없게 되어있음. 다른것과는 다르다 
		
		
		Calendar today = Calendar.getInstance();

		//년, 월, 일 구하기
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) +1;
		int day = today.get(Calendar.DATE);
		System.out.println(year +"."+ month +"."+ day); 
		
		
		
		// 시, 분 , 초 구하기
		int hour = today.get(Calendar.HOUR_OF_DAY);  //0~23
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		
		System.out.println(hour +":"+ minute +":"+ second); 
		
		// 요일 구하기
		String[] DAY_OF_WEEK = {"일", "월", "화", "수", "목", "금", "토"};
		
		System.out.println("오늘은 "+DAY_OF_WEEK[ today.get(Calendar.DAY_OF_WEEK)-1]+"요일 입니다."); //1->일, 2->월 ....7->토
		
		
		//특정 날짜 설정하기
		today.set(2014, 7, 27); // 2014년 8월 27일
		
		//년, 월, 일 구하기
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH) +1;
		day = today.get(Calendar.DATE);
		System.out.println(year +"."+ month +"."+ day); 
				
				
				
		// 시, 분 , 초 구하기
		hour = today.get(Calendar.HOUR_OF_DAY);  //0~23
		minute = today.get(Calendar.MINUTE);
		second = today.get(Calendar.SECOND);
			
		System.out.println(hour +":"+ minute +":"+ second); 
				
		// 요일 구하기
		//String[] DAY_OF_WEEK = {"일", "월", "화", "수", "목", "금", "토"};
			
		System.out.println("오늘은 "+DAY_OF_WEEK[ today.get(Calendar.DAY_OF_WEEK)-1]+"요일 입니다."); //1->일, 2->월 ....7->토
		
		
		//Date
		
		Date now = new Date();
		System.out.println("현재 시간 : "+ now.toString());
		
		now = today.getTime();  // Date타입으로 변경
		System.out.println(now); //->today를 2014년 8월 27일로 해놨기 때문에 다르게 출력됨
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH:mm:ss a");
		
		
		//today =  Calendar.getInstance();    -> 두코드 다 날짜 오늘로 초기화
		//now = today.getTime();
		
		String date =  sdf.format(now);
		
		System.out.println(date);
		
		// Calendar -> Date 변환
		Date d1 = new Date(today.getTimeInMillis());    // Date(Long date)
				
		// Date -> Calendar 변환
		Date d2 = new Date();
		Calendar cal =  Calendar.getInstance(); 
		cal.setTime(d2);
		
		
		
		
	}

}
