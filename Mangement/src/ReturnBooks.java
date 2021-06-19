import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ReturnBooks extends JFrame {
	private JLabel lbl1, lbl2, lbl3;
	private JTextField txt1, txt2, txt3;
	private JButton btn,btnBack;
	private DataAccess d = new DataAccess();

	ReturnBooks() {
		setBounds(300, 100, 500, 330);
		setTitle("Enter Details");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}

	private void initComponents() {

		lbl1 = new JLabel("Issue ID");
		lbl1.setBounds(60, 30, 100, 40);
		add(lbl1);

		lbl2 = new JLabel("Return Date");
		lbl2.setBounds(60, 90, 100, 40);
		add(lbl2);

		lbl3 = new JLabel("Confirm Password");
		lbl3.setBounds(60, 150, 150, 40);
		add(lbl3);

		txt1 = new JTextField("");
		txt1.setBounds(180, 30, 200, 40);
		add(txt1);
		txt1.setToolTipText("Enter Issue No.");

		txt2 = new JTextField("");
		txt2.setBounds(180, 90, 200, 40);
		add(txt2);
		txt2.setToolTipText("DD/MM/YY");

		txt3 = new JTextField("");
		txt3.setBounds(180, 150, 200, 40);
		add(txt3);
		txt3.setToolTipText("Enter Member Password");

		btn = new JButton("Confirm");
		btn.setBounds(115, 210, 100, 50);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn) {
					boolean b = d.insertReturnBook(txt1.getText(), txt2.getText(), txt3.getText());
					if (b) {
						setVisible(false);
						ViewBooks bo = new ViewBooks();
						bo.setVisible(true);
					} else {
						System.out.println("this user or book don't exist");
					}

				}
			}
		});

		add(btn);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(235, 210, 100, 50);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBack){
					setVisible(false);
					HomePage h = new HomePage();
					h.setVisible(true);
				}
			}
		});
		add(btnBack);
	}
}