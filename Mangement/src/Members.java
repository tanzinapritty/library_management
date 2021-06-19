import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.mysql.jdbc.Statement;

public class Members extends JFrame {
	
	private JPanel upperPanel,lowerPanel;
	private static JTextField txtSearch;
	private JButton btnSearch,btnAdd,btnEdit,btnDelete,btnBack,btnAll;
	private static JTable tblUsers;
	private static DataAccess d = new DataAccess();
	
	public Members() {
		setBounds(40,20,730,700);
		setTitle("Members");
		setLayout(null);     
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		upperPanel = new JPanel(new FlowLayout());
		upperPanel.setBorder(new LineBorder(Color.black, 1));
		upperPanel.setBounds(5, 5,700, 40);
		add(upperPanel);
		
		lowerPanel = new JPanel(null);
		lowerPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Member List"));
		lowerPanel.setBounds(5, 50, 700, 600);
		add(lowerPanel);
				
		this.AddUpperComponent();
		this.AddLowerComponent();
		
	}
	
private void AddUpperComponent() {
		
	    btnAll = new JButton("All");
	    this.upperPanel.add(btnAll);
	    
		
		txtSearch = new JTextField(25);
		this.upperPanel.add(txtSearch);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				populateTable();
			}
		});
		this.upperPanel.add(btnSearch);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnAdd){
					setVisible(false);
					MemberDetail md = new MemberDetail();
					md.setVisible(true);
				}
			}
		});
		this.upperPanel.add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int row = tblUsers.getSelectedRow();

				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "Please Select A Row First");
					return;
				}
				
				int id = (int)tblUsers.getValueAt(row, 0);
				JOptionPane.showMessageDialog(null, id);
				txtSearch.setText((String)tblUsers.getValueAt(row, 1));
			}
		});
		this.upperPanel.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			String id;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				d.deleteMember();
			}
		});
		this.upperPanel.add(btnDelete);	
		
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBack){
					setVisible(false);
					HomePage h = new HomePage();
					h.setVisible(true);
				}
			}
		});
		this.upperPanel.add(btnBack);
	}
	
	
	private void AddLowerComponent() {
		tblUsers = new JTable();
		tblUsers.setBackground(Color.cyan);
		JScrollPane pane = new JScrollPane();
		pane.setBounds(5, 15, 690,580);
		lowerPanel.add(pane);
		pane.setViewportView(tblUsers);
		this.populateTable();
	}

	public static void populateTable() {
		
		UserTable model = new UserTable(txtSearch.getText());
		tblUsers.setModel(model);
	}

}