package computer;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Computer  extends JFrame implements ActionListener{
	
	JButton []numBtnarr = new JButton[12];
	JButton []funBtnarr = new JButton[6];
	JPanel pn1;
	JPanel pn2;
	JTextField jtf = null;
	
	
	
	
	public Computer(){
		jtf = new JTextField();   //創建輸入框
		pn1=new JPanel(new GridLayout(0,3));
		pn2=new JPanel(new GridLayout(0,1));
		this.setLayout(null);
		String numarr[]= {"0","1","2","3","4","5","6","7","8","9",".","%"};
		String funarr[]= {"+","-","*","/","CE","="};

		
		for(int i=0;i<numBtnarr.length;i++) {
			numBtnarr[i]=new JButton(numarr[i]);
			pn1.add(numBtnarr[i]);
			numBtnarr[i].addActionListener(this);

		}
		
		for(int i=0;i<funBtnarr.length;i++) {
			funBtnarr[i]=new JButton(funarr[i]);
			pn2.add(funBtnarr[i]);
			funBtnarr[i].addActionListener(this);	
		}

		
		this.add(jtf);
		this.add(pn1);
		this.add(pn2);
		
		jtf.setBounds(0,0,241,92);
		pn1.setBounds(0,90,180,180);
		pn2.setBounds(180,90,60,180);
		
		this.setTitle("計算器");    //設定視窗標題
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    //使用 System exit 方法退出應用程式。僅在應用程式中使用。(視窗右上的關閉紐)
		   //預設情況下，該值被設置為 HIDE_ON_CLOSE。 ::調用任意已註冊的 WindowListener 物件後自動隱藏該表單。
		
		this.setLocationRelativeTo(null);//設置窗體居中顯示
		this.setSize(256,309);
		this.setBackground(Color.cyan);
		this.setTitle("計算機");
		this.setResizable(false);//視窗不可改變大小
		this .setVisible(true);
	}
	
	
	
	int OperationalControl=0;													//控制運算符號的流程
	int ClearScreen=0;																//清除對話框
	char signs=0;																		//運算符號
	String temporary1="",temporary2="",temporary3="";		//數值存放區
	
	
	public void actionPerformed(ActionEvent e) {//事件處理

		temporary3 = jtf.getText();	
		temporary3=temporary2;
		
		if(ClearScreen>1) {		
			temporary2="";
			jtf.setText(temporary2);
			ClearScreen=1;
		}
		
		 for(int i=0;i<10;i++)
			 if(e.getSource() == numBtnarr[i]){//按鈕數字0~9鍵
			 temporary2 = jtf.getText();
			 temporary2=temporary2+String.valueOf(i);
			 jtf.setText(temporary2);
			 
		 }
		
		 if(e.getSource() == numBtnarr[10]){//按鈕.(小數點)鍵
			 temporary2 = jtf.getText();
			 temporary2 += ".";
			 jtf.setText(temporary2);
		 }
		 if(e.getSource() == numBtnarr[11]){//按鈕%鍵
			 temporary2 = jtf.getText();
			 
			 double percentage = Double.parseDouble(temporary2);
			 percentage=percentage/100;
			 temporary2 = String.valueOf(percentage);
			 jtf.setText(temporary2);
		 }
			
		if(e.getSource() == funBtnarr[0]){//按鈕+鍵
		signs='+';
		ClearScreen+=1;
		
					if(OperationalControl>=1 && temporary3!="") {
						temporary2=temporary3;
						temporary1=deliver(temporary1,temporary2,signs);
						jtf.setText(temporary1);	
			
					}

					else if(OperationalControl>=1) {
						temporary2 = jtf.getText();
						temporary1=deliver(temporary1,temporary2,signs);
						jtf.setText(temporary1);	
				
					}
					if(OperationalControl<1) {
			
						OperationalControl=OperationalControl+2;		
						temporary2 = jtf.getText();
						temporary1=temporary2;
						temporary2="";
						jtf.setText(temporary2);	
					}
			}
		
		if(e.getSource() == funBtnarr[1]){//按鈕-鍵
			signs='-';
			ClearScreen+=1;
			
						if(OperationalControl>=1 && temporary3!="") {
							temporary2=temporary3;
							temporary1=deliver(temporary1,temporary2,signs);
							jtf.setText(temporary1);	
				
						}

						else if(OperationalControl>=1) {
							temporary2 = jtf.getText();
							temporary1=deliver(temporary1,temporary2,signs);
							jtf.setText(temporary1);	
					
						}
						if(OperationalControl<1) {
				
							OperationalControl=OperationalControl+2;		
							temporary2 = jtf.getText();
							temporary1=temporary2;
							temporary2="";
							jtf.setText(temporary2);	
						}
				}
		
		
		if(e.getSource() == funBtnarr[2]){//按鈕*鍵
			signs='*';
			ClearScreen+=1;
			
						if(OperationalControl>=1 && temporary3!="") {
							temporary2=temporary3;
							temporary1=deliver(temporary1,temporary2,signs);
							jtf.setText(temporary1);	
				
						}

						else if(OperationalControl>=1) {
							temporary2 = jtf.getText();
							temporary1=deliver(temporary1,temporary2,signs);
							jtf.setText(temporary1);	
					
						}
						if(OperationalControl<1) {
				
							OperationalControl=OperationalControl+2;		
							temporary2 = jtf.getText();
							temporary1=temporary2;
							temporary2="";
							jtf.setText(temporary2);	
						}
				}
		
		
		if(e.getSource() == funBtnarr[3]){//按鈕/鍵
			signs='/';
			ClearScreen+=1;
			
						if(OperationalControl>=1 && temporary3!="") {
							temporary2=temporary3;
							temporary1=deliver(temporary1,temporary2,signs);
							jtf.setText(temporary1);	
				
						}

						else if(OperationalControl>=1) {
							temporary2 = jtf.getText();
							temporary1=deliver(temporary1,temporary2,signs);
							jtf.setText(temporary1);	
					
						}
						if(OperationalControl<1) {
				
							OperationalControl=OperationalControl+2;		
							temporary2 = jtf.getText();
							temporary1=temporary2;
							temporary2="";
							jtf.setText(temporary2);	
						}
				}
		if(e.getSource() == funBtnarr[4]){  //按鈕CE鍵
			
			OperationalControl=0;
			ClearScreen=0;
			signs=0;
			temporary1="";
			temporary2="";
			temporary3="";
			jtf.setText("");   //設定為空白 ，等同於清空的意思	
	}
		
		
		if(e.getSource() == funBtnarr[5]){  //按鈕"="鍵
			temporary1=deliver(temporary1,temporary2,signs);
			jtf.setText(temporary1);	
		}	
	}//結束
	
	
	public static String deliver(String temporary1,String temporary2,char signs) {
		
		String answer;
		double result = 0.0;
		double[]a = new double[2];
		
		a[0] = Double.parseDouble(temporary1);
		a[1] = Double.parseDouble(temporary2);
		
		
		if(signs == '%') {
			result = a[0] % a[1];
			answer = String.valueOf(result);
		}
		else if(signs == '+') {
			result = a[0] + a[1];
			answer = String.valueOf(result);
		}
		else if(signs == '-') {
			result = a[0] - a[1];
			answer = String.valueOf(result);
		}
		else if(signs == '*') {
			result = a[0] * a[1];
			answer = String.valueOf(result);
		}
		
		else if(signs=='/' && a[1]==0) {
			answer="除數不可為0";
		}
		else if(signs=='/' && a[1]!=0) {
			result = a[0] / a[1];
			answer = String.valueOf(result);
		}
		else {			
			answer="輸入錯誤，請重新輸入";
		}
		return answer;
		
	}
	public static void main(String[] args) {
		Computer ABC = new  Computer();
	}
}

