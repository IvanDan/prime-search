package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
  private final String url = "jdbc:postgresql://localhost/myDatabase";
  private final String user = "postgres";
  private static DBHelper dbHelper = null;
  private Connection con;
  private NumberDAO numberDAO;

  private DBHelper(String password) throws SQLException {
    con = DriverManager.getConnection(url, user, password);
  }

  public static DBHelper createDBHelper(String password) throws SQLException {
    if (dbHelper == null) {
      dbHelper = new DBHelper(password);
      return dbHelper;
    } else
      return dbHelper;
  }

  private void createNumberDAO() {
    numberDAO = new NumberDAOImpl(con);
  }

  public synchronized boolean addNumber(int number) {
    if (numberDAO == null)
      createNumberDAO();
    try {
      return numberDAO.addNumber(new NumberDTO(number));
    } catch (SQLException e) {
      System.err.println("SQLException in addNumber");
      return false;
    }
  }
}
