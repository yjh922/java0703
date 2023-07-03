package org.sp.app0703.chat3;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatC extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p;
	JTextField t;
	ChatA chatA;
	ChatB chatB;

	
	public ChatC() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p =new JPanel();
		t = new JTextField(20);
	
		
		add(scroll);
		p.add(t);
		add(p, BorderLayout.SOUTH);
		
		setBounds(500,500,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		t.addKeyListener(this);
	}
	
	public void setChatA(ChatA chatA) {
		this.chatA=chatA;
	}
	
	public void setChatB(ChatB chatB) {
		this.chatB=chatB;
	}


	public void keyTyped(KeyEvent e) {
		
	}


	public void keyPressed(KeyEvent e) {
		
	}


	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_ENTER) {
			String msg=t.getText();
			area.append(msg+"\n");
			t.setText("");
			
			chatA.area.append(msg+"\n");
			
			chatB.area.append(msg+"\n");
		}
	}
	

}
