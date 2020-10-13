import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//ClientExample is a pair of ServerExample1
// 서버를 먼저 구동시켜 놓는 방법
// 서버 측 
public class ServerExample1 {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();         // accept 서버는 대기상태. 클라이언트에서 메세지가 들어오는 순간 accept가 연결 수락. => 소켓 만들어서 socket에 저장.
			InputStream in = socket.getInputStream(); // 수신용 객체
			OutputStream out = socket.getOutputStream(); // 통신용 객체
			
			byte arr[] = new byte[100]; // 클라이언트에서 온 메세지 크기만큼 읽어들이겠따.
			in.read(arr);                        // 수신
			System.out.println(new String(arr)); // 출력
			
			String str = "hello client";
			out.write(str.getBytes());     // 클라이언트에게 응답한다. str을 바이트타입으로 변환하여 전송.
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
