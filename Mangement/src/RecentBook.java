import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class RecentBook extends JFrame {
	
	private JPanel lowerPanel;
	private static JTable tblIssue;
	private static JTextField txtSearch;
	
	public RecentBook() {
		setBounds(400,200,700,800);
		setTitle("Issued");
		setLayout(null);     
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lowerPanel = new JPanel(null);
		lowerPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2),"Issue List"));
		lowerPanel.setBounds(5, 10, 670, 730);
		add(lowerPanel);
				
		this.AddLowerComponent();
		
	}
	

	private void AddLowerComponent() {
		
		tblIssue = new JTable();
		tblIssue.setBackground(Color.cyan);
		
		JScrollPane pane = new JScrollPane();
		pane.setBounds(10, 15, 650, 700);
		lowerPanel.add(pane);
		pane.setViewportView(tblIssue);
		//this.populateTable();
		
	}

	public static void populateTable() {
		
		IssueTable model = new IssueTable(txtSearch.getText());
		tblIssue.setModel(model);
	}
	
}