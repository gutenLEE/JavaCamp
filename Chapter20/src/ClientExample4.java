import java.net.Socket;

//멀티 채팅 코드
public class ClientExample4 {

	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println(
					"Usage: java ClientExample4 <user-name>");
			return;
		}
		try {
			Socket socket = new Socket("192.168.0.93", 9002);
			
			Thread thread1 = new SenderThread2(socket, args[0]);
			Thread thread2 = new ReceiverThread(socket);
			
			thread1.start();
			thread2.start();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
