package util.number;

public class NumberDTO {
  private int num;
  private int isPrime;

  public NumberDTO(int num, int isPrime) {
    this.num = num;
    this.isPrime = isPrime;
  }

  public int getIsPrime() {
    return isPrime;
  }

  public void setIsPrime(int isPrime) {
    this.isPrime = isPrime;
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
