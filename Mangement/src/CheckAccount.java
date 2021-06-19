import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

public class CheckAccount extends JFrame {
	
	private JTextField textfield1;
	private JLabel lvl1;
	private JButton btn1;
	DataAccess da = new DataAccess();
	public CheckAccount(DataAccess da)
	{
		this.da=da;
	}

	CheckAccount(){ 
	     initComponents();
	}
	private void initComponents(){
		setTitle("CheckAccount");
		setBounds(300,200,300,300);    
		setLayout(null); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1=new JButton("Ok");    
		btn1.setBounds(100,150,60,30);
		btn1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn1)
				{
					try {
					
					System.out.println("Database connect");
					String query = "select id from admin where id='"+textfield1.getText()+"'";
					System.out.println(query);
					 ResultSet  res = da.stat.executeQuery(query);
					 String get_id="";
					 System.out.println(res.toString());
					 while(res.next())
						{
							get_id=res.getString(1);
						}
					 System.out.println(get_id);
					 if (get_id.equals(textfield1.getText()))
						{
							JOptionPane.showMessageDialog(null,"Perrmission Granted");
							new ChangePass(get_id).setVisible(true);
							dispose();
							
		
						 }
						else
						{
							JOptionPane.showMessageDialog(null,"Invalid ID");
						}
					 
					// setVisible(false);
					// ChangePass d = new ChangePass(get_id);
					// d.setVisible(true);
				}
					catch (Exception ex) 
					{
						JOptionPane.showMessageDialog( null,"Some Error Occured");
						System.out.println("Some Error Occured");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Input error");
				}
			}
		});
		add(btn1);
		
		lvl1= new JLabel("ID");
		lvl1.setBounds(70,100,30,30);
		add(lvl1);
		
		textfield1= new JTextField();
		textfield1.setBounds(100,100,90,30);
		add(textfield1);
	}
	
}