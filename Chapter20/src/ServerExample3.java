import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample3 {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9001);
			// 서버를 먼저 구동해야만 스레드 실행 가능하다.
			socket = serverSocket.accept(); // 클라이언트용 소켓 생성.
			 
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			
			thread1.start();
			thread2.start();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				serverSocket.close();
			}
			catch(Exception ignored) {
			}
		}
	}

}
