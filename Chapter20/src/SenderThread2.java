import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//멀티 채팅 코드

public class SenderThread2 extends Thread {
	
	Socket socket; //
	String name;
	SenderThread2(Socket socket, String name){
		this.socket = socket;
		this.name = name;
	}
	
	public void run() {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 키보드로 입력 받은것을 전송한다.
			PrintWriter writer = new PrintWriter(socket.getOutputStream()); // 
			
			writer.println(name);
			writer.flush();
			
			
			while(true) {
				String str = reader.readLine(); // 메세지 입력 받기.
				if(str.equals("bye"))
					break;
				writer.println(str); // bye가 아니면 송신.
				writer.flush();      // 버퍼 비우기.
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch(Exception ignored) {
				
			}
		}
	}
}
