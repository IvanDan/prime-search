package util.number;

import java.sql.SQLException;

public interface NumberDAO {
  String NumberTable = "numeri";
  String NumberAttribute = "numero";
  String NumberIsPrimeAttribute = "primo";

  boolean addNumber(NumberDTO number) throws SQLException;

  boolean updateNumber(NumberDTO number) throws SQLException;

  NumberDTO getNumber(int num) throws SQLException;

  int isPrime(int num) throws SQLException;

  NumberDTO searchNumberForCheck() throws SQLException;
}
