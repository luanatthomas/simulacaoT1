import java.util.HashMap;
import java.util.Map;

public class App {

  public static void main(String[] args) {
    Interval arrivalInterval = new Interval(2, 5);
    Interval departureInterval = new Interval(3, 5);
    Map<String, Double> routing = new HashMap<String, Double>();
    routing.put("-1", 1.);
    SimulationQueue simulationQueue = new SimulationQueue("Q1", 1, 5, departureInterval, routing);

    Scheduler scheduler = new Scheduler(arrivalInterval);
    scheduler.addQueue("Q1", simulationQueue);
    scheduler.start(2, "Q1");
  }
}
