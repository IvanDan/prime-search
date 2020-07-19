package util.thread;

import util.database.DBHelperImpl;
import util.number.NumberDTO;
import util.prime.PrimeCheck;

import java.util.concurrent.Semaphore;

public class PrimeChecker extends Thread {
  private DBHelperImpl dbHelper;
  private Semaphore sem;

  public PrimeChecker(DBHelperImpl dbHelper, Semaphore sem) {
    this.dbHelper = dbHelper;
    this.sem = sem;
    start();
  }

  @Override
  public void run() {
    NumberDTO numberToCheck;
    do {
      try {
        sem.acquire();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      numberToCheck = dbHelper.searchNumberForCheck();
      if (numberToCheck != null) {
        numberToCheck.setIsPrime(-2);
        sem.release();

        numberToCheck.setIsPrime(PrimeCheck.check(numberToCheck.getNum()));
        dbHelper.updateNumber(numberToCheck);
      } else
        sem.release();
    } while (numberToCheck != null);
  }
}
