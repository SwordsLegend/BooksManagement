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

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Book_delete extends JFrame{
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Initialize the contents of the frame.
	 */
	public  Book_delete() {
		setTitle("ͼ��ɾ��");
		setVisible(true);
		setBounds(100, 100, 450, 300);
		setLocation(330,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(23, 30, 385, 73);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u4E66\u53F7\uFF08ISBN\uFF09\uFF1A");
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 27, 95, 15);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(101, 24, 125, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.setIcon(new ImageIcon(Book_delete.class.getResource("/images/delete.png")));
		btnNewButton.setBounds(268, 23, 93, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(22, 144, 388, 83);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u4E66\u540D\uFF1A");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		label.setBounds(10, 37, 95, 15);
		panel_1.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 34, 125, 21);
		panel_1.add(textField_1);
		
		JButton button = new JButton("\u5220\u9664");
		button.setIcon(new ImageIcon(Book_delete.class.getResource("/images/delete.png")));
		button.setBounds(269, 33, 93, 23);
		panel_1.add(button);
		
		JLabel lblNewLabel = new JLabel("\u6309\u4E66\u53F7\uFF08ISBN\uFF09\u5220\u9664");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		lblNewLabel.setBounds(22, 10, 143, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6309\u4E66\u540D\u5220\u9664");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(22, 124, 143, 15);
		getContentPane().add(lblNewLabel_1);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(b_delete()){
					JOptionPane.showConfirmDialog(null, "ɾ���ɹ�������",  "�𾴵��û�", JOptionPane.YES_OPTION); 
				}
		} 
		 });	
	}
	
	     public Boolean b_delete() {
		  boolean result = false;
		           Connection conn = null;
		         try {	        
		           conn = Connect_SQL.getCon();  //�������ݿ�����
		           String sqldelete;
		           if(textField.getText()!=null) {
		           sqldelete = "delete from Book(ISBN,Bname,Bprice,Bcomment,Bpublish,Bauthor,Bsort)"
		          		+ "where ISBN ='"+textField.getText()+"'";}
		           else {
		          sqldelete = "delete from Book(ISBN,Bname,Bprice,Bcomment,Bpublish,Bauthor,Bsort)"
				        + "where Bname ='"+textField_1.getText()+"'";}
		          PreparedStatement stmt = conn.prepareStatement(sqldelete);   //���׳��쳣   
            
		          int i = stmt.executeUpdate();           
		          if (i == 1) {
		              result = true;
		          }
		          } catch (SQLException e) {
		              // TODO Auto-generated catch block
		              e.printStackTrace();
		           } finally { //finally���ô��ǲ��ܳ����Ƿ�����쳣����Ҫִ��finally��䣬�����ڴ˴��ر�����
		               try {
		                   conn.close(); //��һ��Connection���Ӻ����һ��Ҫ��������close���������ر����ӣ����ͷ�ϵͳ��Դ�����ݿ���Դ
		              } catch(SQLException e) {
		                   e.printStackTrace();
		              }
		          }
		          
		          return result;        
		}
}