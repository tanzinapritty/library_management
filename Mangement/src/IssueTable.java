import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class IssueTable extends AbstractTableModel {
	
	private String[] colNames = {"Book Id","Book Name","Issue Id","Issue Date","Period"};
	private ArrayList<Issue> issue = new ArrayList<Issue>();
	
	public IssueTable(String key) {
		String query = "select * from issuebook";
		if(!key.equals(""))
			query = query + " where bookName like '%"+key+"%'";
		
		DataAccess da = new DataAccess();
		issue = da.GetIssue(query);
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colNames.length;
	}
	
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return colNames[col];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return issue.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		if(issue.size()==0)
			return null;
		
		
		try
		{
			Issue i = issue.get(row);
			switch(col)
			{
				case 0:
					return i.bookId;
				case 1:
					return i.bookName;
				case 2:
					return i.issueId;
				case 3:
					return i.issueDate;
				case 4:
					return i.period;
				
				default:
					return null;
			}
			
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	
	

}
