package util.database;

import util.number.NumberDTO;

public interface DBHelper {
  String URL = "jdbc:postgresql://localhost/myDatabase";
  String USER = "postgres";

  /**
   * Questo metodo aggiunge un numero al database
   *
   * @param number il numero da aggiungere
   * @return <code>true</code> se l'inserimento va a buon fine, <code>false</code> altrimenti
   */
  boolean addNumber(int number);

  boolean updateNumber(NumberDTO number);

  NumberDTO getNumber(int number);

  int isPrime(int number);

  NumberDTO searchNumberForCheck();
}
