package util.number;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NumberDAOImpl implements NumberDAO {
  private Connection con;

  public NumberDAOImpl(Connection c) {
    this.con = c;
  }

  @Override
  public boolean addNumber(NumberDTO number) throws SQLException {
    String quearyAdd = "insert into " + NumberTable +
        " (" + NumberAttribute + ") values(" + number.getNum() + ");";
    Statement stmt = con.createStatement();
    boolean res = stmt.executeUpdate(quearyAdd) > 0;
    return res;
  }

  @Override
  public boolean updateNumber(NumberDTO number) throws SQLException {
    String queryUpdate = "update " + NumberTable + " set " + NumberIsPrimeAttribute + " = " + number.isPrime() +
        " where " + NumberAttribute + " = " + number.getNum() + ";";
    Statement stmt = con.createStatement();
    boolean bool = stmt.executeUpdate(queryUpdate) > 0;
    return bool;
  }

  @Override
  public NumberDTO getNumber(int num) throws SQLException {
    String querySearch = "select * from " + NumberTable + " where " + NumberAttribute + " = " + num + ";";
    Statement stmt = con.createStatement();
    ResultSet resultSet = stmt.executeQuery(querySearch);
    if (resultSet == null)
      return null;
    if (resultSet.next()) {
      return new NumberDTO(resultSet.getInt(NumberAttribute), resultSet.getInt(NumberIsPrimeAttribute));
    } else
      return null;
  }

  @Override
  public int isPrime(int num) throws SQLException {
    String querySearch = "select " + NumberIsPrimeAttribute + " from " + NumberTable + " where " + NumberAttribute + " = " + num + ";";
    Statement stmt = con.createStatement();
    ResultSet resultSet = stmt.executeQuery(querySearch);
    if (resultSet == null)
      return -1;
    if (resultSet.next()) {
      return resultSet.getInt(NumberIsPrimeAttribute);
    } else
      return -1;
  }

  @Override
  public NumberDTO searchNumberForCheck() throws SQLException {
    String querySearch = "select * from " + NumberTable + " where " + NumberIsPrimeAttribute + " = -1 order by " + NumberAttribute + ";";
    Statement stmt = con.createStatement();
    ResultSet resultSet = stmt.executeQuery(querySearch);
    if (resultSet == null)
      return null;
    if (resultSet.next()) {
      return new NumberDTO(resultSet.getInt(NumberAttribute), resultSet.getInt(NumberIsPrimeAttribute));
    } else
      return null;
  }
}
