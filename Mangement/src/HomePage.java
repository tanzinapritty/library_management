import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class HomePage extends JFrame{
	private JPanel pnl;
	private JLabel lvl1,lvl2;
	private JTextField textfield1;
	private JPasswordField Passwordfield2;
	private JButton blgt,brcbk,bMbrs,btnIssue,balbk,bibk,brtrn,bCpass,bfditem;
	private String id;
	
	HomePage(){ 
	     initComponents();
	
	}
	
	HomePage(String id) {
		initComponents();
		this.id = id;
	}
	
	private void initComponents(){
		setTitle("Homepage");
		setBounds(100,10,700,720);    
		setLayout(null);    
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnl = new JPanel(null);
		pnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Action"));
		pnl.setBounds(10,200,655,455);
		add(pnl);
		
		lvl1= new JLabel("Welcome");
		lvl1.setBounds(560,5, 80, 30);
		add(lvl1);
		
		lvl2 = new JLabel("To Our Libary");
		lvl2.setBounds(550,35, 80, 30);
		add(lvl2);
		
		blgt=new JButton("logout");    
		blgt.setBounds(10,5,70,20);
		blgt.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==blgt){
					setVisible(false);
					Login l = new Login();
					l.setVisible(true);
				}	
			}
		});
		add(blgt);
		

		bCpass = new JButton("Change Password");
		bCpass.setBounds(10,30,140,20);
		bCpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bCpass){
					setVisible(false);
				   ChangePass c = new ChangePass(id);
					c.setVisible(true);
				}
			}
		});
		this.add(bCpass);
		
		
		btnIssue=new JButton("All Issued");    
		btnIssue.setBounds(20,30,200,200);
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnIssue){
					setVisible(false);
					RecentBook rb = new RecentBook();
					rb.setVisible(true);
				}
			}
		});
		pnl.add(btnIssue);
		
		
		bMbrs=new JButton("All Members");    
		bMbrs.setBounds(230,30,200,200);
		bMbrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bMbrs){
					setVisible(false);
					Members m = new Members();
					m.setVisible(true);
				}
			}
		});
		pnl.add(bMbrs);
		
		balbk=new JButton("All Books");    
		balbk.setBounds(440,30,200,200);
		balbk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == balbk){
					setVisible(false);
					ViewBooks vb = new ViewBooks();
					vb.setVisible(true);
				}
			}
		});
		pnl.add(balbk);
		
		bibk=new JButton("Issue Books");    
		bibk.setBounds(20,240,200,200);
		bibk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bibk){
					setVisible(false);
					IssueBook ib = new IssueBook(id);
					ib.setVisible(true);
				}
			}
		});
		pnl.add(bibk);
		
		brtrn=new JButton("Return Book");
		brtrn.setBounds(230,240,200,200);
		brtrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == brtrn){
					setVisible(false);
					ReturnBooks rb = new ReturnBooks();
					rb.setVisible(true);
				}
			}
		});
		pnl.add(brtrn);
		
		bfditem=new JButton("Food Items");    
		bfditem.setBounds(440,240,200,200);
		pnl.add(bfditem);
		
		/*textfield1.setBackground(Color.cyan);
		Passwordfield2.setBackground(Color.cyan);
		
		btn1.setBackground(Color.blue);
		btn2.setBackground(Color.blue);
		btn3.setBackground(Color.blue);
		btn4.setBackground(Color.blue);*/
	}
	
}