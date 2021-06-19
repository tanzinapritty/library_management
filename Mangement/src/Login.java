import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame {
	
	private JTextField textfield1;
	private JPasswordField Passwordfield2;
	private JButton btn3,btn4;
	private JLabel lbl1,lbl2;
	private DataAccess d = new DataAccess();
	private String id;
	
	
	
	Login()
	{ 
	     initComponents();
	    
	}
	private void initComponents()
	{
		setTitle("Login");
		setBounds(300,200,350,400);    
		setLayout(null);    
		//setVisible(true);    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		lbl1 = new JLabel("ID");    
		lbl1.setBounds(30,80,100,50);
		add(lbl1);
		
		lbl2=new JLabel("Password");    
		lbl2.setBounds(30,150,100,50);
		add(lbl2);
		
		btn3=new JButton("Login");    
		btn3.setBounds(200,220,100,50);
		
		btn3.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				boolean b = false;
				try {
					System.out.println("Checking login credentials.");
					String loginID = textfield1.getText();
					id = loginID;
					b = d.login(textfield1.getText(), Passwordfield2.getText());
				} catch (Exception except) {
					System.out.println(except.getMessage());
					System.out.println("Password:" + Passwordfield2.getText());
					System.out.println(textfield1.getText());
				}
				if(b){
					setVisible(false);
					HomePage h = new HomePage(id);
					h.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Your credentials are wrong.");
				}
			}
		});
		add(btn3);
		
		btn4=new JButton("Forgot Password");    
		btn4.setBounds(30,220,150,50);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b = false;
				if(e.getSource()==btn4){
					setVisible(false);
					CheckAccount c = new CheckAccount();
					c.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Your credentials are wrong.");
				}
			}
		}
			
		);
		add(btn4);
		
			    
		textfield1= new JTextField();
		textfield1.setBounds(150, 80, 150, 50);
		add(textfield1);
		
		Passwordfield2= new JPasswordField();
		Passwordfield2.setBounds(150, 150, 150, 50);
		add(Passwordfield2);
		
		         
		textfield1.setBackground(Color.cyan);
		Passwordfield2.setBackground(Color.cyan);
	
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO:
	}
	
	
}