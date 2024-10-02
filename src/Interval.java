public class Interval {
  private int lowerTime;
  private int higherTime;

  public Interval(int lowerTime, int higherTime) {
    this.lowerTime = lowerTime;
    this.higherTime = higherTime;
  }

  public int getLowerTime() {
    return lowerTime;
  }

  public int getHigherTime() {
    return higherTime;
  }

  public double generateNormalInterval(PseudoRandom random) {
    return this.lowerTime + (this.higherTime - this.lowerTime) * random.getNextRandom();
  }
}