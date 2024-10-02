import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Scheduler {
  private Interval arrivalInterval;
  private PseudoRandom random;
  private Map<String, SimulationQueue> queuesToSimulate;
  // private SimulationQueue simulationQueue;
  private PriorityQueue<Event> eventQueue;

  public Scheduler(Interval arrivalInterval) {
    this.arrivalInterval = arrivalInterval;
    this.eventQueue = new PriorityQueue<>();
    this.queuesToSimulate = new HashMap<>();
    createPseudoRandom();
  }

  public void addQueue(String id, SimulationQueue simulationQueue) {
    queuesToSimulate.put(id, simulationQueue);
  }

  public void start(double initialArrivalTime, String initialQueueId) {
    eventQueue.add(new Event(initialArrivalTime, EventType.ARRIVAL, queuesToSimulate.get(initialQueueId)));

    for (int i = 0; i < 100000; i++) {
      executeNextEvent();
    }
  }

  private void createPseudoRandom() {
    double seed = 0; // Initial seed value
    double a = 1664525; // Multiplier
    double c = 1013904223; // Increment
    double m = Math.pow(2, 32);

    this.random = new PseudoRandom(seed, a, c, m);
  }

  public void scheduleNextArrival(double currentTime, SimulationQueue simulationQueue) {
    double nextArrivalTime = currentTime + arrivalInterval.generateNormalInterval(random);
    eventQueue.add(new Event(nextArrivalTime, EventType.ARRIVAL, simulationQueue));
  }

  public void scheduleNextPassage(double currentTime, SimulationQueue simulationQueue) {
    double nextDepartureTime = currentTime + simulationQueue.getServiceInterval().generateNormalInterval(random);
    eventQueue.add(new Event(nextDepartureTime, EventType.PASSAGE, simulationQueue));
  }

  public void executeNextEvent() {
    if (!eventQueue.isEmpty()) {
      Event currentEvent = eventQueue.poll();
      double currentTime = currentEvent.getTime();
      SimulationQueue queue = currentEvent.getSimulationQueue();

      if (currentEvent.getType() == EventType.ARRIVAL) {
        System.out.println("Handling arrival at time: " + currentTime);

        if (queue.getCurrentOccupancy() < queue.getNumServers()) {
          queue.simulateArrival(currentTime);
          if (queue.getCurrentOccupancy() <= queue.getNumServers()) {
            scheduleNextPassage(currentTime, queue);
          }
        } else {
          queue.incLoss();
        }

        scheduleNextArrival(currentTime, queue);
      } else if (currentEvent.getType() == EventType.PASSAGE) {
        System.out.println("Handling passage at time: " + currentTime);

        String queueId = queue.getNextQueue(random.getNextRandom());
        SimulationQueue nextQueue = queuesToSimulate.get(queueId);

        queue.simulateDeparture(currentTime);

        if (queue.getCurrentOccupancy() >= queue.getNumServers()) {
          scheduleNextPassage(currentTime, queue); // nextPassage
        }

        if (nextQueue != null) {
          if (nextQueue.getCurrentOccupancy() < nextQueue.getNumServers()) {
            nextQueue.simulateArrival(currentTime);
            if (nextQueue.getCurrentOccupancy() <= nextQueue.getNumServers()) {
              scheduleNextPassage(currentTime, nextQueue);
            }
          } else {
            nextQueue.incLoss();
          }
        }
      }
    }
  }

  private class Event implements Comparable<Event> {
    private double time;
    private EventType type;
    private SimulationQueue simulationQueue;

    public Event(double time, EventType type, SimulationQueue simulationQueue) {
      this.time = time;
      this.type = type;
      this.simulationQueue = simulationQueue;
    }

    public double getTime() {
      return time;
    }

    public EventType getType() {
      return type;
    }

    public SimulationQueue getSimulationQueue() {
      return simulationQueue;
    }

    @Override
    public int compareTo(Event other) {
      return Double.compare(this.time, other.time);
    }

    @Override
    public String toString() {
      return "Event [time=" + time + ", type=" + type + ", simulationQueue=" + simulationQueue + "]";
    }

  }

  private enum EventType {
    ARRIVAL, DEPARTURE,
    PASSAGE
  }
}
