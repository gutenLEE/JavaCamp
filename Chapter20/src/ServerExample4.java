import java.net.ServerSocket;
import java.net.Socket;

//멀티 채팅 코드

// 이 server 는 메세지 작성 기능은 없고 메세지를 뿌려주는 기능만 있다. 
public class ServerExample4 {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9002);
			
			while(true) { // while 돌린 이유 => 멀티 채팅이니까. 연결 요청이 들어올 때마다 소켓 객체 생성. 스레드 실행.
				Socket socket = serverSocket.accept();
				Thread thread = new PerClientThread(socket); // 클라이언트에서 보낸 메세지가 담겨있는 socket인건가?
				thread.start();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
