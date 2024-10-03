public class PseudoRandom {
  private double seed;
  private double a;
  private double c;
  private double m;

  private int currentIndex;
  private int quantRandomNumbers;

  public PseudoRandom(double seed, double a, double c, double m, int quantRandomNumbers) {
    this.seed = seed;
    this.a = a;
    this.c = c;
    this.m = m;
    this.quantRandomNumbers = quantRandomNumbers;
    currentIndex = 0;
  }

  public double getNextRandom() throws IndexOutOfBoundsException {
    if (currentIndex >= quantRandomNumbers) {
      throw new IndexOutOfBoundsException();
    }
    seed = (a * seed + c) % m;
    currentIndex++;
    return (double) seed / m;
  }

  public boolean hasNext() {
    return currentIndex < quantRandomNumbers;
  }
}
