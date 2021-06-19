import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MemberDetail extends JFrame{
	private JLabel lbl1,lbl2,lbl3;
	private JTextField txt1,txt2,txt3;
	private JButton btn,btnBack;
	private DataAccess d = new DataAccess();

	
	MemberDetail(){
		setBounds(400,200,400,350);
		setTitle("Member Detail");
		setLayout(null);     
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		intiComponents();
	}
	
	public void intiComponents() {
		
		lbl1 = new JLabel("ID");
		lbl1.setBounds(30,15,100,40);
		add(lbl1);
		
		lbl2 = new JLabel("Name");
		lbl2.setBounds(30,75,100,40);
		add(lbl2);
		
		lbl3 = new JLabel("Password");
		lbl3.setBounds(30,135,100,40);
		add(lbl3);
		
		
		
		txt1 = new JTextField("");
		txt1.setBounds(130,15,200,40);
		add(txt1);
		txt1.setToolTipText("Enter ID");
		
		txt2 = new JTextField("");
		txt2.setBounds(130,75,200,40);
		add(txt2);
		txt2.setToolTipText("Enter Name");
		
		txt3 = new JTextField("");
		txt3.setBounds(130,135,200,40);
		add(txt3);
		txt3.setToolTipText("Enter any 6 character");
		
		btnBack = new JButton("Back");
		btnBack.setBounds(60,200,120,40);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBack){
					setVisible(false);
				   Members m= new Members();
					m.setVisible(true);
				}
			}
		});
		this.add(btnBack);
		
		
		
		btn = new JButton("Confirm");
		btn.setBounds(200,200,120,40);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btn){
					String id = txt1.getText();
					String name = txt2.getText();
					int password = Integer.parseInt(txt3.getText());
					
					boolean b = d.addNewMember(name, id, password);
					setVisible(false);
					Members m = new Members();
					m.setVisible(true);
				}
			}
		});
		add(btn);
	}
	
}
