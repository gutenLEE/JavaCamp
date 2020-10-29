import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;

public class JdbcActionListener implements ActionListener {
	
	JTable table;
	JTextField textField [];
	
	// 등록, 조회 eee
	JdbcActionListener(JTable table, JTextField textField []){
		this.table = table;
		this.textField = textField;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		JdbcConnection jdbc = new JdbcConnection(table, textField);

		if(e.getActionCommand().equals("등록")) {
			
			jdbc.insert();
		}
		else if(e.getActionCommand().equals("조회")) {
			jdbc.selectAll();
		}
		else if(e.getActionCommand().equals("START")) {
			jdbc.timeStart();
		}
	}

}
