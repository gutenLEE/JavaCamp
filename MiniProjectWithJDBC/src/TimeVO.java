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
	
	// start ��ư �̺�Ʈ���� ������ ��ü �ʱⰪ.
	TimeVO(String id){
		
//        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
//        Calendar cal = Calendar.getInstance();
//        String StartTime = null;
//        StartTime = formatter.format(cal.getTime());
//        
//        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy��MM��dd��");
//        Calendar cal2 = Calendar.getInstance();
//        String today = null;
//        today = formatter.format(cal.getTime());
//        System.out.println(today);
		System.out.println("timevo ������ ������ ����");
	}
}
