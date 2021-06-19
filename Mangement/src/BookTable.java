import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class BookTable extends AbstractTableModel{	
		private String[] colNames = {"Book ID","Book Name","Amount","Price"};
		private ArrayList<Book> book = new ArrayList<Book>();
		
		public BookTable(String key) {
			String query = "select * from book";
			if(!key.equals(""))
				query = query + " where bookName like '%"+key+"%'";
			
			DataAccess da = new DataAccess();
			book = da.GetBook(query);
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
			return book.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			if(book.size()==0)
				return null;		
			try
			{
				Book b = book.get(row);
				switch(col)
				{
					case 0:
						return b.bookId;
					case 1:
						return b.bookName;
					case 2:
						return b.bookAmount;
					case 3:
						return b.bookPrice;
					//case 4:
						//return b.type;
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

