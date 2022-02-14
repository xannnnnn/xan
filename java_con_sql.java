package sql_java;
import java.sql.*;
import java.sql.SQLException.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class java_con_sql extends JFrame implements ItemListener,ActionListener{
	
    public JLabel Jlab_Menu =new JLabel("請選擇要執行的動作:");
    String[] menu= {"說明","查詢","更新","新增","刪除"};
    public JComboBox<String> cbo = new JComboBox<>(menu);
    public JTextArea lblShow = new JTextArea("警告:此作品僅用作展示程式能力，使用至投資不論營利或虧損皆與本人無關。\n");
    
    public JScrollPane JSP = new JScrollPane(lblShow);
	public JButton btn=new JButton("確定");
	
	
	public static void main(String[] args) {
		java_con_sql d = new java_con_sql();
	}
    	
	public java_con_sql(){//按鈕及視窗佈局
		this.setTitle("殖利率計算器");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(50,50,235,400);
		this.setLayout(null);
		
		JPanel panMenu=new JPanel();
		add(panMenu);
		panMenu.setBounds(10,10,120,50);
		panMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
		panMenu.add(Jlab_Menu);
		panMenu.add(cbo);
		cbo.addItemListener(this);
		
		JPanel panBtn = new JPanel();
		add(panBtn);
		panBtn.setBounds(140,80,85,50);
		panBtn.setLayout(new FlowLayout(FlowLayout.LEFT));
		panBtn.add(btn);
		btn.addActionListener(this);
		
		lblShow.setLineWrap(true);
		add(JSP);
		JSP.setBounds(10,140,200,200);
		JSP.setBorder(BorderFactory.createLineBorder(Color.red));
		setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e) {
		
		Object show=cbo.getSelectedItem();
		int index=cbo.getSelectedIndex();
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		 String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		 String DB_URL = "jdbc:mysql://XXX.XXX.XXX.XXX:3306/stock?useUnicode=true&characterEncoding=utf8&connectTimeout=0&socketTimeout=0";
	     String USER = "root";
	     String PASS = "123456";
		
	     
    	 JPanel myPanel = new JPanel();
    	 JPanel verify = new JPanel();
    	 try {
			Class.forName(JDBC_DRIVER);
			lblShow.append("成功載入JDBC\n");
		
    	 }catch(ClassNotFoundException ce) 
		{
			lblShow.append("JDBC沒有驅動程式\n"+ce.getMessage());
			return ;
		}
		
		//以上載入JDBC
		try {
			
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
           lblShow.append("成功載入資料庫...\n");
           Statement stmt = conn.createStatement();
           
           
           String select_sql="SELECT * FROM stock.deposit WHERE Numbering ='";;
       	   String select_sql2="' ORDER BY Year DESC";
        	
		if(e.getSource()==btn) {
				
			  ArrayList<String> user_input = new ArrayList<String>();
			  
			  JTextField user = new JTextField(5);
			  JTextField password = new JTextField(5);
			  JTextField wField = new JTextField(5);
		      JTextField xField = new JTextField(5);
		      JTextField yField = new JTextField(5);
		      JTextField zField = new JTextField(5);
		      ArrayList<String> Numbering = new ArrayList<String>();
		      ArrayList<String> Name = new ArrayList<String>();
		    	 ArrayList<String> Year = new ArrayList<String>();
		    	 ArrayList<Integer> Interest = new ArrayList<Integer>();
		      
			Object keyO=cbo.getSelectedItem();	
			String keyS = String.valueOf(keyO);
			
			
			switch(keyS) {
			
			case "查詢":{
				
					  myPanel.add(new JLabel("股票編號:"));
				      myPanel.add(wField);
				      
				      myPanel.add(new JLabel("當前價格:"));
				      myPanel.add(xField);
				      
            		
				      int result = JOptionPane.showConfirmDialog(null, myPanel,"查詢或計算殖利率", JOptionPane.OK_CANCEL_OPTION);
				      	if(!wField.getText().equals("")&&!xField.getText().equals("")){
							
							user_input.add(wField.getText());
							user_input.add(xField.getText());	
							ResultSet rs = stmt.executeQuery(select_sql+user_input.get(0)+select_sql2);
							while(rs.next()){
		            			Numbering.add(rs.getString("Numbering"));
		            			Name.add(rs.getString("Name"));
		            			Year.add(rs.getString("Year"));
		            			Interest.add(rs.getInt("Interest"));
		            		}
							if(Numbering.contains(user_input.get(0))==true) {
	 
							int ttl=0;//五年加總
			            	float average_Interest;
			            	
			            	lblShow.append("編號 "+"  股票名稱 "+" 年份 "+"  除權息\n");
			            	for (int i = 0; i < Year.size(); i++) {
			                    lblShow.append(Numbering.get(i)+"  "+Name.get(i)+"  "+Year.get(i)+"  "+Interest.get(i)+"\n");
			                    ttl=ttl+Interest.get(i);  
			                    }
			            	average_Interest=ttl/Year.size();
			            	lblShow.append("近五年平均配股配息: "+average_Interest+"\n");
			            	
			            	
			            	double share_price=Double.parseDouble(user_input.get(1));
			            	 share_price=share_price*1000;
			            	double Yield =average_Interest/share_price;
			            	Yield=Yield*100;
			            	
			            	BigDecimal bd = new BigDecimal(Yield).setScale(2, RoundingMode.HALF_UP);
			                double YieldD = bd.doubleValue();
			            	lblShow.append("平均殖利率: "+YieldD+"\n");
			            	
			            	if(Yield>9) {
			            		lblShow.append("你一定輸入錯誤，不然就是股票有問題，你自己看著辦。─┐(´д`)┌─\n");
			            		break;
			            	}
			            	if(Yield>6 || Yield>8) {
			            		lblShow.append("手刀搶購!\n");
			            		break;
			            	}
			            	if(Yield>5 || Yield>6) {
			        		lblShow.append("普通!\n");
			        		break;
			        	}
			            	if(Yield<5) {
			            		lblShow.append("不建議購買!\n");
			            		break;
			            	}
						}
							JOptionPane.showMessageDialog(null, "資料庫沒有此股票,請查明後重新填寫!");
				      	}
				       else {
							JOptionPane.showMessageDialog(null, "有空格沒填,請重新填寫!");

						}
				break;
			}//查詢
		/*---------------------------------------------------------------------------------------------------------------------------------------------------------*/	
			case "更新":{

				String update_sql1="UPDATE stock.deposit SET Year='";
            	String update_sql2="', Interest='";
            	String update_sql3="' WHERE Numbering='";
            	String update_sql4="' and Year='";
            	String [] a=new String[4];
            	
            	verify.add(new JLabel("帳號:"));
            	verify.add(user);
			      
            	verify.add(new JLabel("密碼:"));
            	verify.add(password);
            	
            	int result1 = JOptionPane.showConfirmDialog(null, verify,"驗證身分...", JOptionPane.OK_CANCEL_OPTION);
				if(user.getText().equals("root")&&password.getText().equals("123456")){
					        	
            	  myPanel.add(new JLabel("股票編號:"));
			      myPanel.add(wField);
			      
			      myPanel.add(new JLabel("(舊)年份:"));
			      myPanel.add(xField);
			      
			      myPanel.add(new JLabel("(新)年份:"));
			      myPanel.add(yField);
			      
			      myPanel.add(new JLabel("(新)利息:"));
			      myPanel.add(zField);
			      int result = JOptionPane.showConfirmDialog(null, myPanel,"更新資料...", JOptionPane.OK_CANCEL_OPTION);
			      if(!wField.getText().equals("")&&!xField.getText().equals("")&&!yField.getText().equals("")&&!zField.getText().equals("")){
						
						a[0]=wField.getText();
						a[1]=xField.getText();
						a[2]=yField.getText();
						a[3]=zField.getText();
						
						int zz=stmt.executeUpdate(update_sql1+a[2]+update_sql2+a[3]+update_sql3+a[0]+update_sql4+a[1]+"'");
						if(zz==1) {
							lblShow.append("更新成功! 修改了: "+zz+"筆資料");
						}else {
							lblShow.append("更新失敗! 請查明資料後重新修改");
						}
			      }
			      else {
						JOptionPane.showMessageDialog(null, "更新失敗!有空格沒填,請重新填寫!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "避免資料混亂，僅供設計者修改資料!");
				}
				break;
			}//更新
		/*---------------------------------------------------------------------------------------------------------------------------------------------------------*/	
			case "新增":{
				String InsertInto_sql1="INSERT INTO stock.deposit (Numbering,Name,Year,Interest) VALUES ('";
            	String [] a=new String[4];
            	
            	verify.add(new JLabel("帳號:"));//這是對話
            	verify.add(user);//這是輸入框
			      
            	verify.add(new JLabel("密碼:"));
            	verify.add(password);
            	
            	int result1 = JOptionPane.showConfirmDialog(null, verify,"驗證身分...", JOptionPane.OK_CANCEL_OPTION);
				if(user.getText().equals("root")&&password.getText().equals("123456")){
          	  	  myPanel.add(new JLabel("股票編號:"));//這是對話
			      myPanel.add(wField);//這是輸入框		  
			      
			      myPanel.add(new JLabel("名稱:"));
			      myPanel.add(xField);
			      
			      myPanel.add(new JLabel("年份:"));
			      myPanel.add(yField);
			      
			      myPanel.add(new JLabel("利息:"));
			      myPanel.add(zField);
			      int result = JOptionPane.showConfirmDialog(null, myPanel,"新增資料...", JOptionPane.OK_CANCEL_OPTION);
			      if(!wField.getText().equals("")&&!xField.getText().equals("")&&!yField.getText().equals("")&&!zField.getText().equals("")){
						
						a[0]=wField.getText();
						a[1]=xField.getText();
						a[2]=yField.getText();
						a[3]=zField.getText();
						//INSERT INTO stock.deposit (Numbering,Name,Year,Interest) VALUES ('2884','玉山金', '1996', 1300)
						int zz=stmt.executeUpdate(InsertInto_sql1+a[0]+"','"+a[1]+"','"+a[2]+"',"+a[3]+")");
						
							lblShow.append("新增成功! 新增了: "+zz+"筆資料");
			      }
			      else {
						JOptionPane.showMessageDialog(null, "新增失敗!有空格沒填,請重新填寫!");
					}
			      }else {
						JOptionPane.showMessageDialog(null, "避免資料混亂，僅供設計者修改資料!");
					}
				break;
			}//新增
		/*---------------------------------------------------------------------------------------------------------------------------------------------------------*/	
			case "刪除":{
				//DELETE FROM stock.deposit WHERE Numbering ='2884' AND Year='1996';
				String Delete_sql="DELETE FROM stock.deposit WHERE Numbering ='";
            	String Delete_sql1="' AND Year='";
            	String [] a=new String[4];
            	
            	
            	verify.add(new JLabel("帳號:"));//這是對話
            	verify.add(user);//這是輸入框
			      
            	verify.add(new JLabel("密碼:"));
            	verify.add(password);
            	
            	int result1 = JOptionPane.showConfirmDialog(null, verify,"驗證身分...", JOptionPane.OK_CANCEL_OPTION);
				if(user.getText().equals("root")&&password.getText().equals("123456")){
					
            	  myPanel.add(new JLabel("股票編號:"));//這是對話
			      myPanel.add(wField);//這是輸入框
			      
			      myPanel.add(new JLabel("年份:"));
			      myPanel.add(xField);
			      
			      int result = JOptionPane.showConfirmDialog(null, myPanel,"刪除資料...", JOptionPane.OK_CANCEL_OPTION);
			      if(!wField.getText().equals("")&&!xField.getText().equals("")){
						
						a[0]=wField.getText();
						a[1]=xField.getText();

						int zz=stmt.executeUpdate(Delete_sql+a[0]+Delete_sql1+a[1]+"'");
						if(zz==1) {
							lblShow.append("刪除成功! 刪除了: "+zz+"筆資料");
						}else {
							lblShow.append("刪除失敗! 資料庫沒有此筆資料，請查明資料後重新刪除。");
						}
			      }
			      else {
						JOptionPane.showMessageDialog(null, "刪除失敗!有空格沒填,請重新填寫!");
					}
			      }else {
						JOptionPane.showMessageDialog(null, "避免資料混亂，僅供設計者修改資料!");
					}
				break;
			}//刪除
			case "說明":{
				lblShow.append( "此程式僅供私人使用，此軟體只用於展示程式能力所以目前資料庫僅收集2884(玉山金)，2886(兆豐金)，0056(元大高股息)\n"
						+ "後續功能及資料擴充視情況而定。\nヽ( ^∀^)ﾉ\n");
				
				break;
			}
		/*---------------------------------------------------------------------------------------------------------------------------------------------------------*/	
			}//switch	
		}//btn		
        stmt.close();
        conn.close();		
		}
		catch(SQLException se){
        // 处理 JDBC 错误
			lblShow.append("錯誤訊息"+se);
//        se.printStackTrace();
    }
		catch(Exception e1){
        // 处理 Class.forName 错误
        e1.printStackTrace();
    }	
	}//事件處理(介面)
}//class
