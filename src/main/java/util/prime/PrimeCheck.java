package util.prime;

public class PrimeCheck {
  public boolean check(int number) {
    boolean flag = false;
    for (int i = 2; i <= number / 2; i++) {
      if (number % i == 0) {
        flag = true;
        break;
      }
    }
    return !flag;
  }
}
