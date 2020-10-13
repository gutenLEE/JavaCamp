import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderThread extends Thread {
	
	Socket socket; //
	
	SenderThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 키보드로 입력 받은것을 전송한다.
			PrintWriter writer = new PrintWriter(socket.getOutputStream()); // 
			
			while(true) {
				String str = reader.readLine(); // 
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
