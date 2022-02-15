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
		jtf = new JTextField();   //�Ыؿ�J��
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
		
		this.setTitle("�p�⾹");    //�]�w�������D
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    //�ϥ� System exit ��k�h�X���ε{���C�Ȧb���ε{�����ϥΡC(�����k�W��������)
		   //�w�]���p�U�A�ӭȳQ�]�m�� HIDE_ON_CLOSE�C ::�եΥ��N�w���U�� WindowListener �����۰����øӪ��C
		
		this.setLocationRelativeTo(null);//�]�m����~�����
		this.setSize(256,309);
		this.setBackground(Color.cyan);
		this.setTitle("�p���");
		this.setResizable(false);//�������i���ܤj�p
		this .setVisible(true);
	}
	
	
	
	int OperationalControl=0;													//����B��Ÿ����y�{
	int ClearScreen=0;																//�M����ܮ�
	char signs=0;																		//�B��Ÿ�
	String temporary1="",temporary2="",temporary3="";		//�ƭȦs���
	
	
	public void actionPerformed(ActionEvent e) {//�ƥ�B�z

		temporary3 = jtf.getText();	
		temporary3=temporary2;
		
		if(ClearScreen>1) {		
			temporary2="";
			jtf.setText(temporary2);
			ClearScreen=1;
		}
		
		 for(int i=0;i<10;i++)
			 if(e.getSource() == numBtnarr[i]){//���s�Ʀr0~9��
			 temporary2 = jtf.getText();
			 temporary2=temporary2+String.valueOf(i);
			 jtf.setText(temporary2);
			 
		 }
		
		 if(e.getSource() == numBtnarr[10]){//���s.(�p���I)��
			 temporary2 = jtf.getText();
			 temporary2 += ".";
			 jtf.setText(temporary2);
		 }
		 if(e.getSource() == numBtnarr[11]){//���s%��
			 temporary2 = jtf.getText();
			 
			 double percentage = Double.parseDouble(temporary2);
			 percentage=percentage/100;
			 temporary2 = String.valueOf(percentage);
			 jtf.setText(temporary2);
		 }
			
		if(e.getSource() == funBtnarr[0]){//���s+��
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
		
		if(e.getSource() == funBtnarr[1]){//���s-��
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
		
		
		if(e.getSource() == funBtnarr[2]){//���s*��
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
		
		
		if(e.getSource() == funBtnarr[3]){//���s/��
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
		if(e.getSource() == funBtnarr[4]){  //���sCE��
			
			OperationalControl=0;
			ClearScreen=0;
			signs=0;
			temporary1="";
			temporary2="";
			temporary3="";
			jtf.setText("");   //�]�w���ť� �A���P��M�Ū��N��	
	}
		
		
		if(e.getSource() == funBtnarr[5]){  //���s"="��
			temporary1=deliver(temporary1,temporary2,signs);
			jtf.setText(temporary1);	
		}	
	}//����
	
	
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
			answer="���Ƥ��i��0";
		}
		else if(signs=='/' && a[1]!=0) {
			result = a[0] / a[1];
			answer = String.valueOf(result);
		}
		else {			
			answer="��J���~�A�Э��s��J";
		}
		return answer;
		
	}
	public static void main(String[] args) {
		Computer ABC = new  Computer();
	}
}

