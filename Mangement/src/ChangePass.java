//import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ChangePass extends JFrame {
	
	private JTextField textfield1;
	private JLabel lvl1;
	private JButton btn1;
	private String id;
	private DataAccess d = new DataAccess();
	
	
	
	ChangePass(String id){
		System.out.println("I hae created change pass frame with " + id);
		this.id = id;
	     initComponents();
	}
	private void initComponents(){
		setTitle("ChangePass");
		setBounds(300,200,300,300);    
		setLayout(null); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1=new JButton("Change Password");    
		btn1.setBounds(50,150,150,30);
		add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn1)
			{
				System.out.println("I am here right now");
				try {
				
				System.out.println("Database connect");
				String query = "UPDATE admin SET password='" + textfield1.getText()+ "' where id='"+id+"'";
				System.out.println(query);
				 d.stat.executeUpdate(query);
				 if (true)
					{
						JOptionPane.showMessageDialog(null,"Password Changed.");
						new Login().setVisible(true);
						dispose();
						

					 }
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid ID");
					}
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
		
		lvl1= new JLabel("New Password");
		lvl1.setBounds(40,100,130,30);
		add(lvl1);
		
		textfield1= new JTextField();
		textfield1.setBounds(130,100,130,30);
		add(textfield1);
	}
}