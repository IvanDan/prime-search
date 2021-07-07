package main;

import util.database.DBHelperImpl;
import util.thread.PrimeChecker;

import java.sql.SQLException;
import java.util.concurrent.Semaphore;

public class Main {

  public static void main(String[] args) throws SQLException, InterruptedException {
    DBHelperImpl dbh = DBHelperImpl.createDBHelper("postgres");
    Semaphore sem = new Semaphore(1);
    PrimeChecker[] checkers = new PrimeChecker[10];

//    Eratostene eratostene = new Eratostene();
//    ArrayList list = eratostene.findPrime(999999);
//    System.out.println(list);

    // check if there are no numbers in busy state (-2)
    dbh.changeStatus(-1);

//    for (int i = 100001; i < 200000; i++)
//      dbh.addNumber(200000);
    for (int i = 0; i < checkers.length; i++)
      checkers[i] = new PrimeChecker(dbh, sem);
    for (int i = 0; i < checkers.length; i++)
      checkers[i].join();
  }
}
