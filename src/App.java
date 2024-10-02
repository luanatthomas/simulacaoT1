public class App {

  public static void main(String[] args) {
    Interval arrivalInterval = new Interval(2, 4);
    Interval intervalQ1 = new Interval(1, 2);
    Interval intervalQ2 = new Interval(4, 8);
    Interval intervalQ3 = new Interval(5, 15);
    // Map<String, Double> routing = new HashMap<String, Double>();
    // routing.put("-1", 1.);
    SimulationQueue q1 = new SimulationQueue("Q1", 1, 10000, intervalQ1);
    SimulationQueue q2 = new SimulationQueue("Q2", 2, 5, intervalQ2);
    SimulationQueue q3 = new SimulationQueue("Q3", 2, 10, intervalQ3);

    q1.addRouting("Q2", 0.8);
    q1.addRouting("Q3", 0.2);

    q2.addRouting("Q1", 0.3);
    q2.addRouting("Q3", 0.5);
    q2.addRouting("-1", 0.2);

    q3.addRouting("Q2", 0.7);
    q3.addRouting("-1", 0.3);

    Scheduler scheduler = new Scheduler(arrivalInterval);

    scheduler.addQueue("Q1", q1);
    scheduler.addQueue("Q2", q2);
    scheduler.addQueue("Q3", q3);
    scheduler.start(2, "Q1");
    scheduler.printStateProbabilities();
  }
}
