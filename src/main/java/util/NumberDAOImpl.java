package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class NumberDAOImpl implements NumberDAO {
  private Connection con;

  NumberDAOImpl(Connection c) {
    this.con = c;
  }

  @Override
  public boolean addNumber(NumberDTO primeNumber) throws SQLException {
    String quearyAdd = "insert into " + NumberTable +
        " (" + NumberAttribute + ") values(" + primeNumber.getNum() + ");";
    Statement stmt = con.createStatement();
    boolean res = stmt.executeUpdate(quearyAdd) > 0;
    return res;
  }

  @Override
  public NumberDTO getNumber(int num) throws SQLException {
    return null;
  }
}
