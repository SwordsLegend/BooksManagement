package Windos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Book_return extends JFrame{
	private JTextField textField;

	public Book_return() {
		setTitle("图书归还");
		setVisible(true);
		setBounds(100, 100, 450, 200);
		setLocation(1270,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(20, 21, 387, 47);
		getContentPane().add(panel);
		
		JLabel lblisbn = new JLabel("\u8BF7\u8F93\u5165\u8FD8\u4E66\u4E66\u53F7\uFF08ISBN\uFF09\uFF1A");
		lblisbn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblisbn.setBounds(10, 10, 156, 27);
		panel.add(lblisbn);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(176, 13, 156, 21);
		panel.add(textField);
		
		JButton btnNewButton = new JButton("\u5F52\u8FD8");
		btnNewButton.setIcon(new ImageIcon(Book_return.class.getResource("/images/reset.png")));
		btnNewButton.setBounds(314, 107, 93, 23);
		getContentPane().add(btnNewButton);
		

		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(b_return()){
				JOptionPane.showMessageDialog(null,"还书成功啦！！"); 
			}
	} 
	 });	
}

     public Boolean b_return() {
	  boolean result = false;
	           Connection conn = null;
	           LocalDate ld=LocalDate.now();
	         try {	        
	           conn = Login.getCon();  //建立数据库连接
	           String sqlupdate=null;        
	           sqlupdate = "update  lend  set rtn='"+ld+"'"
	           		+ " where ISBN ="+textField.getText()
	           		+"  and rtn is null";
	          PreparedStatement stmt = conn.prepareStatement(sqlupdate);   //会抛出异常   
	          int i = stmt.executeUpdate();           
	          if (i==1) {
	              result = true;
	          
	          }} catch (SQLException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	           } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
	               try {
	                   conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
	              } catch(SQLException e) {
	                   e.printStackTrace();
	              }
	          }
	          
	          return result;   
	
}
     }
