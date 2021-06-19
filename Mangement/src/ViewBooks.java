import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ViewBooks extends JFrame {
	
	private JPanel upperPanel,lowerPanel;
	private static JTextField txtSearch;
	private JButton btnSearch,btnAdd,btnEdit,btnDelete,btnBack,btnAll;
	private static JTable tblBook;
	
	public ViewBooks() {
		setBounds(40,20,730,700);
		setTitle("Books");
		setLayout(null);     
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		upperPanel = new JPanel(new FlowLayout());
		upperPanel.setBorder(new LineBorder(Color.black, 1));
		upperPanel.setBounds(5, 5, 700, 40);
		add(upperPanel);
		
		lowerPanel = new JPanel(null);
		lowerPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Book List"));
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
					BookDetail bd = new BookDetail();
					bd.setVisible(true);
				}
			}
		});
		this.upperPanel.add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int row = tblBook.getSelectedRow();

				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "Please Select A Row First");
					return;
				}
				
				int id = (int)tblBook.getValueAt(row, 0);
				JOptionPane.showMessageDialog(null, id);
				txtSearch.setText((String)tblBook.getValueAt(row, 1));
			}
		});
		this.upperPanel.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
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
		tblBook = new JTable();
		tblBook.setBackground(Color.cyan);	
		JScrollPane pane = new JScrollPane();
		pane.setBounds(5, 15, 690, 580);
		lowerPanel.add(pane);
		pane.setViewportView(tblBook);	
		this.populateTable();
	}

	public static void populateTable() {
		
		BookTable model = new BookTable(txtSearch.getText());
		tblBook.setModel(model);
	}
	
}