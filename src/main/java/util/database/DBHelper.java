package util.database;

public interface DBHelper {
  final String URL = "jdbc:postgresql://localhost/myDatabase";
  final String USER = "postgres";

  /**
   * Questo metodo aggiunge un numero al database
   *
   * @param number il numero da aggiungere
   * @return <code>true</code> se l'inserimento va a buon fine, <code>false</code> altrimenti
   */
  boolean addNumber(int number);
}
