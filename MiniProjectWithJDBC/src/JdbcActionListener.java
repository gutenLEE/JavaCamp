import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;

public class JdbcActionListener implements ActionListener {
	
	JTable table;
	JTextField textField [];
	
	// ���, ��ȸ eee
	JdbcActionListener(JTable table, JTextField textField []){
		this.table = table;
		this.textField = textField;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		JdbcConnection jdbc = new JdbcConnection(table, textField);

		if(e.getActionCommand().equals("���")) {
			
			jdbc.insert();
		}
		else if(e.getActionCommand().equals("��ȸ")) {
			jdbc.selectAll();
		}
		else if(e.getActionCommand().equals("START")) {
			jdbc.timeStart();
		}
	}

}
