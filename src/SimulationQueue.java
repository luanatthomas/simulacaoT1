import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimulationQueue {
  private int numServers;
  private int capacity;
  // private double globalTime;
  private double lastEventTime;
  private double[] capacityTime;
  private int currentOccupancy;

  private int accLoss;
  private Interval serviceInterval;
  private String id;
  private Map<String, Double> routing; // <FilaDestino, Probabilidade>

  public SimulationQueue(String id, int numServers, int capacity, Interval serviceInterval,
      Map<String, Double> routing) {
    this.numServers = numServers;
    this.capacity = capacity;
    // this.globalTime = 0;
    this.lastEventTime = 0;
    this.capacityTime = new double[capacity + 1];
    this.currentOccupancy = 0;

    this.id = id;
    this.accLoss = 0;
    this.serviceInterval = serviceInterval;
    this.routing = routing;
  }

  public void simulateArrival(double currTime) {
    // Process an arrival event
    // globalTime = currTime;
    // if (currentOccupancy >= capacity) {
    // System.out.println("Queue is full");
    // accLoss++;
    // return;
    // }
    System.out.println("currentOccupancy: " + currentOccupancy);
    System.out.println(Arrays.toString(capacityTime));
    capacityTime[currentOccupancy] += (currTime - lastEventTime);
    currentOccupancy++;
  }

  public void simulateDeparture(double currTime) {
    // Process a departure event
    // globalTime = currTime;
    if (currentOccupancy <= 0) {
      System.out.println("Queue is empty");
      return;
    }

    capacityTime[currentOccupancy] += currTime - lastEventTime;
    currentOccupancy--;
  }

  public int getCurrentOccupancy() {
    return currentOccupancy;
  }

  public int getNumServers() {
    return numServers;
  }

  public Interval getServiceInterval() {
    return serviceInterval;
  }

  public String getNextQueue(double rand) {
    Map<Double, String> possibleNext = new HashMap<Double, String>();

    for (String key : routing.keySet()) {

      if (rand <= routing.get(key)) {
        System.out.println("Next queue: " + key);
        possibleNext.put(routing.get(key), key);
      }
    }

    Double k = Collections.min(possibleNext.keySet());
    return possibleNext.get(k);
  }

  public int getAccLoss() {
    return accLoss;
  }

  public void incLoss() {
    accLoss++;
    System.out.println("Fila " + id + " perdeu " + accLoss + " eventos");
  }

  @Override
  public String toString() {
    return "SimulationQueue [id=" + id + "]";
  }

  // @Override
  // public String toString() {
  // return "SimulationQueue [numServers=" + numServers + ", capacity=" + capacity
  // + ", lastEventTime=" + lastEventTime
  // + ", capacityTime=" + Arrays.toString(capacityTime) + ", currentOccupancy=" +
  // currentOccupancy + ", accLoss="
  // + accLoss + ", serviceInterval=" + serviceInterval + ", id=" + id + ",
  // routing=" + routing + "]";
  // }

}
