package util;

public class NumberDTO {
  private int num;
  private boolean isPrime;

  public NumberDTO(int num, boolean isPrime) {
    this.num = num;
    this.isPrime = isPrime;
  }

  public boolean isPrime() {
    return isPrime;
  }

  public void setPrime(boolean prime) {
    isPrime = prime;
  }

  public NumberDTO(int num) {
    this.num = num;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }
}
