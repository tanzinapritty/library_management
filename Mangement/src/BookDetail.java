import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BookDetail extends JFrame{
	private JLabel lbl1,lbl2,lbl3,lbl4;
	private JTextField txt1,txt2,txt3,txt4;
	private JButton btn,btnBack;
	private DataAccess d = new DataAccess();

	
	BookDetail(){
		setBounds(400,200,400,400);
		setTitle("Book Detail");
		setLayout(null);     
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		intiComponents();
	}
	
	public void intiComponents() {
		
		lbl1 = new JLabel("Book ID");
		lbl1.setBounds(30,15,100,40);
		add(lbl1);
		
		lbl2 = new JLabel("Book Name");
		lbl2.setBounds(30,75,100,40);
		add(lbl2);
		
		lbl3 = new JLabel("Book Amount");
		lbl3.setBounds(30,135,100,40);
		add(lbl3);
		
		lbl4 = new JLabel("Book Price");
		lbl4.setBounds(30,195,100,40);
		add(lbl4);
		
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
		//txt3.setToolTipText("");
		
		txt4 = new JTextField("");
		txt4.setBounds(130,195,200,40);
		add(txt4);
		//txt4.setToolTipText("");
		
		btnBack = new JButton("Back");
		btnBack.setBounds(60,250,120,40);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBack){
					setVisible(false);
				   ViewBooks b= new ViewBooks();
					b.setVisible(true);
				}
			}
		});
		this.add(btnBack);
		
		
		
		btn = new JButton("Confirm");
		btn.setBounds(200,250,120,40);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btn){
					String bookId = txt1.getText();
					String bookName = txt2.getText();
					int bookAmount = Integer.parseInt(txt3.getText());
					int bookPrice = Integer.parseInt(txt4.getText());
					
					boolean b = d.addNewBook( bookId , bookName, bookAmount, bookPrice);
					setVisible(false);
					ViewBooks bo = new ViewBooks();
					bo.setVisible(true);
				}
			}
		});
		add(btn);
	}
	
}
