import java.util.PriorityQueue;

public class Scheduler {
  private Interval arrivalInterval;
  private Interval departureInterval;
  private PseudoRandom random;
  private SimulationQueue simulationQueue;
  private PriorityQueue<Event> eventQueue;

  public Scheduler(SimulationQueue simulationQueue, Interval arrivalInterval, Interval departureInterval) {
    this.simulationQueue = simulationQueue;
    this.arrivalInterval = arrivalInterval;
    this.departureInterval = departureInterval;
    this.eventQueue = new PriorityQueue<>();
    createPseudoRandom();
  }

  public void start(double initialArrivalTime) {
    eventQueue.add(new Event(initialArrivalTime, EventType.ARRIVAL));

    for (int i = 0; i < 100000; i++) {
      executeNextEvent();
    }

    // Acumular o tempo do último estado após o último evento
    simulationQueue.accumulateFinalStateTime();

    // Após a simulação, calcular e imprimir as distribuições de probabilidade
    printStateProbabilities();
  }

  public void printStateProbabilities() {
    double totalTime = simulationQueue.getGlobalTime();
    double[] stateTimes = simulationQueue.getCapacityTimes();

    System.out.println("State\tTime Accumulated\tProbability");
    for (int i = 0; i < stateTimes.length; i++) {
        double probability = stateTimes[i] / totalTime;
        System.out.printf("%d\t%.2f\t\t%.4f%n", i, stateTimes[i], probability);
    }
}

  private void createPseudoRandom() {
    double seed = 0; // Initial seed value
    double a = 1664525; // Multiplier
    double c = 1013904223; // Increment
    double m = Math.pow(2, 32);

    this.random = new PseudoRandom(seed, a, c, m);
  }

  public void scheduleNextArrival(double currentTime) {
    double nextArrivalTime = currentTime + arrivalInterval.generateNormalInterval(random);
    eventQueue.add(new Event(nextArrivalTime, EventType.ARRIVAL));
  }

  public void scheduleNextDeparture(double currentTime) {
    double nextDepartureTime = currentTime + departureInterval.generateNormalInterval(random);
    eventQueue.add(new Event(nextDepartureTime, EventType.DEPARTURE));
  }

  public void executeNextEvent() {
    if (!eventQueue.isEmpty()) {
      Event nextEvent = eventQueue.poll();
      double currentTime = nextEvent.getTime();

      if (nextEvent.getType() == EventType.ARRIVAL) {
        System.out.println("Handling arrival at time: " + currentTime);

        simulationQueue.simulateArrival(currentTime);

        if (simulationQueue.getCurrentOccupancy() <= simulationQueue.getNumServers()) {
          scheduleNextDeparture(currentTime);
        }

        scheduleNextArrival(currentTime);
      } else if (nextEvent.getType() == EventType.DEPARTURE) {
        System.out.println("Handling departure at time: " + currentTime);

        simulationQueue.simulateDeparture(currentTime);

        if (simulationQueue.getCurrentOccupancy() >= simulationQueue.getNumServers()) {
          scheduleNextDeparture(currentTime);
        }
      }
    }
  }

  public static class Interval {
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

  private class Event implements Comparable<Event> {
    private double time;
    private EventType type;

    public Event(double time, EventType type) {
      this.time = time;
      this.type = type;
    }

    public double getTime() {
      return time;
    }

    public EventType getType() {
      return type;
    }

    @Override
    public int compareTo(Event other) {
      return Double.compare(this.time, other.time);
    }
  }

  private enum EventType {
    ARRIVAL, DEPARTURE
  }
}
