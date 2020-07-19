package util.number;

import java.sql.SQLException;

public interface NumberDAO {
  String NumberTable = "numeri";
  String NumberAttribute = "numero";
  String NumberIsPrimeAttribute = "primo";

  public boolean addNumber(NumberDTO primeNumber) throws SQLException;

  public NumberDTO getNumber(int num) throws SQLException;
}
