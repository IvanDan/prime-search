package util.database;

import util.number.NumberDAO;
import util.number.NumberDAOImpl;
import util.number.NumberDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelperImpl implements DBHelper {
  private static DBHelperImpl dbHelper = null;
  private Connection con;
  private NumberDAO numberDAO;

  private DBHelperImpl(String password) throws SQLException {
    con = DriverManager.getConnection(URL, USER, password);
  }

  public static DBHelperImpl createDBHelper(String password) throws SQLException {
    if (dbHelper == null) {
      dbHelper = new DBHelperImpl(password);
      return dbHelper;
    } else
      return dbHelper;
  }

  private void createNumberDAO() {
    numberDAO = new NumberDAOImpl(con);
  }

  @Override
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

  @Override
  public synchronized boolean updateNumber(NumberDTO number) {
    if (numberDAO == null)
      createNumberDAO();
    try {
      return numberDAO.updateNumber(number);
    } catch (SQLException e) {
      System.err.println("SQLException in addNumber");
      return false;
    }
  }


  @Override
  public synchronized NumberDTO getNumber(int number) {
    if (numberDAO == null)
      createNumberDAO();
    try {
      return numberDAO.getNumber(number);
    } catch (SQLException e) {
      System.err.println("SQLException in getNumber");
      return null;
    }
  }

  @Override
  public synchronized int isPrime(int number) {
    if (numberDAO == null)
      createNumberDAO();
    try {
      return numberDAO.isPrime(number);
    } catch (SQLException e) {
      System.err.println("SQLException in getNumber");
      return -1;
    }
  }

  @Override
  public NumberDTO searchNumberForCheck() {
    if (numberDAO == null)
      createNumberDAO();
    try {
      return numberDAO.searchNumberForCheck();
    } catch (SQLException e) {
      System.err.println("SQLException in getNumber");
      return null;
    }
  }
}
