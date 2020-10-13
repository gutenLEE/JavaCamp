import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClientThread extends Thread {
	// 클라이언트에서 접속을 요청한 횟수만큼 객체가 생성된다. 
	// ┌> 100명의 클라이언트가 접속해도 list는 한개만 있다. static 이니까.
	static List<PrintWriter> list =  // static 으로 선언. 모든 스레드에서 사용 가능. 채팅 참여하는 클라이언트들의 모든 메세지를 접근해야 하기 때문에.
			Collections.synchronizedList(new ArrayList<PrintWriter>());
	
	Socket socket;
	PrintWriter writer;
	
	PerClientThread(Socket socket){
		this.socket = socket;
		
		try {
			writer = new PrintWriter(socket.getOutputStream()); // 통신용 객체 생성
			list.add(writer);                                   // 리스트에 통신용 객체 등록.
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void run() {
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream())); // 수신용 객체
			name = reader.readLine();                                // 수신. 새롭게 접속한 사람의 대화명
			
			sendAll("#" + name + "님이 들어오셨습니다.");            
			
			while(true) {
				String str = reader.readLine();                      // 메세지 수신.
				if(str == null)
					break;
				sendAll(name + ">" + str);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			list.remove(writer);
			sendAll("#" + name + "님이 나가셨습니다.");
			try {
				socket.close();
			}
			catch(Exception ignored) {
				
			}
		}
	}
	private void sendAll(String str) {
		
		for(PrintWriter writer : list) { // list에는 송신용 객체가 저장되어 있음
			// 하나씩 불러와서 송신. => 모든 클라이언트들에게 데이터 송신.
			writer.println(str);
			writer.flush();
		}
	}
}
