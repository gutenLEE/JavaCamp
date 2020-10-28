import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeVO {
	
	String id, nickName, today, start_time, end_time, study_time;
	
	TimeVO(String id, String nickName, String today, String start_time, 
									String end_time, String study_time){
		this.id = id;
		this.nickName = nickName;
		this.today = today;
		this.start_time = start_time;
		this.end_time = end_time;
		this.study_time = study_time;
	}
	
	// start 버튼 이벤트에서 생성될 객체 초기값.
	TimeVO(String id){
		
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        Calendar cal = Calendar.getInstance();
        String StartTime = null;
        StartTime = formatter.format(cal.getTime());
        
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy년MM월dd일");
        Calendar cal2 = Calendar.getInstance();
        String today = null;
        today = formatter.format(cal.getTime());
        System.out.println(today);
		
		this.id = id;
		this.today = today;
		this.start_time = StartTime;
		System.out.println("timevo 생성자 마지막 라인");
	}
}
