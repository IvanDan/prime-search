package main;

import util.database.DBHelperImpl;
import util.thread.PrimeChecker;

import java.sql.SQLException;
import java.util.concurrent.Semaphore;

public class Main {

  public static void main(String[] args) throws SQLException, InterruptedException {
    DBHelperImpl dbh = DBHelperImpl.createDBHelper("postgres");
    Semaphore sem = new Semaphore(1);
    PrimeChecker[] checkers = new PrimeChecker[1000];

    for (int i = 0; i < checkers.length; i++)
      checkers[i] = new PrimeChecker(dbh, sem);
    for (int i = 0; i < checkers.length; i++)
      checkers[i].join();
  }
}
