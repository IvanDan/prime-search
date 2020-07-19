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
  public NumberDTO getNumber(int num) throws SQLException {
    String querySearch = "select * from " + NumberTable + " where " + NumberAttribute + " = " + num + ";";
    Statement stmt = con.createStatement();
    ResultSet resultSet = stmt.executeQuery(querySearch);
    if (resultSet == null)
      return null;
    if (resultSet.next()) {
      return new NumberDTO(resultSet.getInt(NumberAttribute), resultSet.getBoolean(NumberIsPrimeAttribute));
    } else
      return null;
  }
}
