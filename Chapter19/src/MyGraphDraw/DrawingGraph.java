package MyGraphDraw;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawingGraph extends JPanel {
	
	int korean, english, math, avg;
	
	public void paint(Graphics g) {
		
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(60, 340, 350, 340); // �׷��� ����
		g.drawLine(60, 80, 60, 340); // �׷��� ����
		
		g.drawRoundRect(250, 25, 100, 50, 12, 12);
		g.drawString("�� ���", 255, 62);
		g.drawString("����", 255, 45);
		g.setColor(Color.BLUE);
		g.fillRect(300, 35, 40, 10);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(300, 55, 40, 10);
		
		g.setColor(Color.BLACK);
		for(int cnt = 1; cnt < 11; cnt++) { // ���� �� �׷��ֱ�
			g.drawString(cnt * 10 + "", 35, 350 - 25 * cnt);
			g.drawLine(60, 345 - 25 * cnt, 345, 345 - 25 * cnt); 
			// x1, y1 : ���� x, y ||| x2, y2 : �� x2, y2 ��ǥ || cnt�� ���� 
		}
		
		if(korean > 0)
			g.fillRect(100,  250 - korean * 2, 10, korean * 2);         // ä���� �����. setColor�� ������ ������ ä����.
		if(english > 0)
			g.fillRect(210, 250 - english, 10, english * 2);
		if(math > 0)
			g.fillRect(310, 250 - math * 2, 10, math * 2);
		if(math > 0)
			g.fillRect(310, 250 - avg * 2, 10, avg * 2);
		
		g.drawString("����", 70, 360);
		g.drawString("����", 140, 360);
		g.drawString("����", 210, 360);
		g.drawString("���", 280, 360);
	}
}
