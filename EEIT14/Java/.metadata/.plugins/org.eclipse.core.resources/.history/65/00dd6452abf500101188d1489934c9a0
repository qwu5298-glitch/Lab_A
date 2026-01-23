package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class GiftDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/iii";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL_FIND_ALL = """
			SELECT id, name, feature, addr, tel
			FROM gift
			ORDER BY id
			""";	
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static String[] fieldNames;
	
	public GiftDAO() throws Exception {
		conn = DriverManager.getConnection(URL, USER, PASSWD);
		pstmt = conn.prepareStatement(SQL_FIND_ALL,
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		
		fieldNames = new String[rsmd.getColumnCount()];
		for (int i=0; i<fieldNames.length; i++) {
			fieldNames[i] = rsmd.getColumnLabel(i+1);
		}		
	}
	
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		}catch(Exception e) {
			return 0;
		}
	}
	
	public int getCols() {
		return fieldNames.length;
	}
	
	// 0-base
	public String getData(int row, int col) {
		try {
			rs.absolute(row+1);
			return rs.getString(col+1);
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
	
	
	
	
	
	
	
}

