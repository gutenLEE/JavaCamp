import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample2 {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();         // accept 서버는 대기상태. 클라이언트에서 메세지가 들어오는 순간 accept가 연결 수락. => 소켓 만들어서 socket에 저장.
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 수신 객체 생성. 
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
			String str = reader.readLine(); // 행 단위로 읽기.
			System.out.println(str);
			
			writer.println("hello Client");
			writer.flush();                 // 행 버퍼에 담겨져서 전송될때, 행 버퍼를 강제로 비우고 싶을 때. 
											// 버퍼가 다 차야 비워지기 때무넹. 
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();   // 포트 닫기
			}
			catch(Exception ignored) {
			}
			try {
				serverSocket.close(); // 서버 소켓 닫기.
			}
			catch(Exception ignored) {
				
			}
		}
		
	}

}
