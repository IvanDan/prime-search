package util.prime;

public class PrimeCheck {
  public static int check(int number) {
    if (number == 1)
      return 0;
    int flag = 1;
    for (int i = 2; i <= number / 2; i++) {
      if (number % i == 0) {
        flag = 0;
        break;
      }
    }
    return flag;
  }
}
