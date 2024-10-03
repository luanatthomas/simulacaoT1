public class Interval {
  private Double lowerTime;
  private Double higherTime;

  public Interval(Double lowerTime, Double higherTime) {
    this.lowerTime = lowerTime;
    this.higherTime = higherTime;
  }

  public Double getLowerTime() {
    return lowerTime;
  }

  public Double getHigherTime() {
    return higherTime;
  }

  public double generateNormalInterval(PseudoRandom random) {
    return this.lowerTime + (this.higherTime - this.lowerTime) * random.getNextRandom();
  }
}