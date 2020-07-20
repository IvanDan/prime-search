package util.database;

import util.number.NumberDTO;

public interface DBHelper {
  String URL = "jdbc:postgresql://localhost/myDatabase";
  String USER = "postgres";

  /**
   * @param number the number to add
   * @return <code>true</code> true if added, <code>false</code> otherwise
   */
  boolean addNumber(int number);

  /**
   * @param number the number to be update
   * @return <code>true</code> if successful, <code>false</code> otherwise
   */
  boolean updateNumber(NumberDTO number);

  /**
   * @param number the number to search
   * @return the object of the number searched, null otherwise
   */
  NumberDTO getNumber(int number);

  /**
   * @param number the number of which you want to check whether it is prime or not
   * @return 1 if it is prime, 0 if it is not, and -1 if it has never been checked
   */
  int isPrime(int number);

  /**
   * @return the row of the smallest number that has not yet been checked, null otherwise
   */
  NumberDTO searchNumberForCheck();

  boolean changeStatus(int status);
}
