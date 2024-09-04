public class App {

  public static void main(String[] args) {
    SimulationQueue simulationQueue = new SimulationQueue(2, 5);
    Scheduler.Interval arrivalInterval = new Scheduler.Interval(2, 5);
    Scheduler.Interval departureInterval = new Scheduler.Interval(3, 5);

    Scheduler scheduler = new Scheduler(simulationQueue, arrivalInterval, departureInterval);
    scheduler.start(2);
  }
}
