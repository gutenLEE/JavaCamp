import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClientThread extends Thread {
	// Ŭ���̾�Ʈ���� ������ ��û�� Ƚ����ŭ ��ü�� �����ȴ�. 
	// ��> 100���� Ŭ���̾�Ʈ�� �����ص� list�� �Ѱ��� �ִ�. static �̴ϱ�.
	static List<PrintWriter> list =  // static ���� ����. ��� �����忡�� ��� ����. ä�� �����ϴ� Ŭ���̾�Ʈ���� ��� �޼����� �����ؾ� �ϱ� ������.
			Collections.synchronizedList(new ArrayList<PrintWriter>());
	
	Socket socket;
	PrintWriter writer;
	
	PerClientThread(Socket socket){
		this.socket = socket;
		
		try {
			writer = new PrintWriter(socket.getOutputStream()); // ��ſ� ��ü ����
			list.add(writer);                                   // ����Ʈ�� ��ſ� ��ü ���.
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void run() {
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream())); // ���ſ� ��ü
			name = reader.readLine();                                // ����. ���Ӱ� ������ ����� ��ȭ��
			
			sendAll("#" + name + "���� �����̽��ϴ�.");            
			
			while(true) {
				String str = reader.readLine();                      // �޼��� ����.
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
			sendAll("#" + name + "���� �����̽��ϴ�.");
			try {
				socket.close();
			}
			catch(Exception ignored) {
				
			}
		}
	}
	private void sendAll(String str) {
		
		for(PrintWriter writer : list) { // list���� �۽ſ� ��ü�� ����Ǿ� ����
			// �ϳ��� �ҷ��ͼ� �۽�. => ��� Ŭ���̾�Ʈ�鿡�� ������ �۽�.
			writer.println(str);
			writer.flush();
		}
	}
}
