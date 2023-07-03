package org.sp.app0703.chat3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener, KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p;
	JTextField t;
	JButton bt;
	ChatB chatB;
	ChatC chatC;
	
	public ChatA() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p =new JPanel();
		t = new JTextField(16);
		bt = new JButton("open");
		
		add(scroll);
		p.add(t);
		p.add(bt);
		add(p, BorderLayout.SOUTH);
		
		setBounds(200,100,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(this);
		t.addKeyListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		chatB=new ChatB();
		chatC=new ChatC();
		
		chatB.setChatA(this);
		chatB.setChatC(chatC);
		
		chatC.setChatA(this);
		chatC.setChatB(chatB);
		
		
	}

	public void keyTyped(KeyEvent e) {	
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_ENTER) {
			//System.out.println("엔터");
			String msg=t.getText();
			area.append(msg+"\n");
			t.setText("");
			
			chatB.area.append(msg+"\n");
		
			
			chatC.area.append(msg+"\n");
			
		}
	}
	
	public static void main(String[] args) {
		new ChatA();
	}
}
