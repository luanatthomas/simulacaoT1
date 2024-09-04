public class PseudoRandom {
  private double seed;
  private double a;
  private double c;
  private double m;

  public PseudoRandom(double seed, double a, double c, double m) {
    this.seed = seed;
    this.a = a;
    this.c = c;
    this.m = m;
  }

  public double getNextRandom() {
    seed = (a * seed + c) % m;
    return (double) seed / m;
  }
}
