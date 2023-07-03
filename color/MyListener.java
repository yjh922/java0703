package org.sp.app0703.color;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//왼쪽 프레임에서 발생하는 액션이벤트를 감지하는 리스너
public class MyListener implements ActionListener{
	LeftFrame leftFrame;//null
	RightFrame rightFrame;//null
	
	//MyListener인 나를 new 연산자로 메모리에 올리는 자는 생성자의 매개변수로
	//LeftFrame의 인스턴스를 전달해 달라.
	//이때 LeftFrame의 주소값을 넘겨받았기 때문에 LeftFrame의 변수로는
	//원본 객체를 제어할 수 있다(call by reference)
	public MyListener(LeftFrame leftFrame) {
		System.out.println("넘겨받은 leftFrame값"+leftFrame);
		//아래처럼 새롭게 생성하지 말고 기존의 좌측창의 주소값을 얻어오자
		this.leftFrame  = leftFrame;
		leftFrame.bt_open.setBackground(Color.black);
	}
	
	//사용자들이 클릭을 누르면 아래의 메서드가 자동으로 호출된다. 콜백메서드
	public void actionPerformed(ActionEvent e) {
		//사용자가 발생시킨 액션이벤트는 ActionEvent 객체의 인스턴스화되어
		//이 메서드로 전달되어 진다. 따라서 개발자가 이 ActionEvent 의 인스턴스로부터
		//각종 이벤트 정보들을 얻어낼 수 있다.
		System.out.println(e);
		Object obj= e.getSource();//사용자가 누른 컴포넌트를 반환
		
		//사용자가 누른 버튼이 좌측프레임이 보유한 bt_open이라면..
		if(obj==leftFrame.bt_open) {
			
			//우측에 친구창 띄우기
			//주소값을 보관하는 이유? 추후에 제어하려고
			rightFrame=new RightFrame(leftFrame);
		}else if(obj==leftFrame.bt_red) {
			System.out.println("빨간색 눌렀어");
			//이미 태어난 우측창의 색상을 변경
			rightFrame.p.setBackground(Color.red);
		}else if(obj==leftFrame.bt_orange) {
			System.out.println("주황색 눌렀어");
			rightFrame.p.setBackground(Color.orange);
		}else if(obj==leftFrame.bt_yellow) {
			System.out.println("노란색 눌렀어");
			rightFrame.p.setBackground(Color.yellow);
		}
		
		
	}
}
