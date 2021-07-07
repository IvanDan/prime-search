package util.thread;

import util.database.DBHelperImpl;

public class EratostenePrimeChecker extends Thread {
  private DBHelperImpl dbHelper;
  private int maxNum;

  public EratostenePrimeChecker(DBHelperImpl dbHelper) {
    this.dbHelper = dbHelper;
    maxNum = dbHelper.getMaxNum();
    if (maxNum != -1)
      start();
  }

  @Override
  public void run() {
    for (int i = 0; i < maxNum; i++) {
    }
  }
}
