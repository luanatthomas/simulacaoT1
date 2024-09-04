public class SimulationQueue {
  private int numServers;
  private int capacity;
  private double globalTime;
  private double lastEventTime;
  private double[] capacityTime;
  private int currentOccupancy;

  public SimulationQueue(int numServers, int capacity) {
    this.numServers = numServers;
    this.capacity = capacity;
    this.globalTime = 0;
    this.lastEventTime = 0;
    this.capacityTime = new double[capacity + 1];
    this.currentOccupancy = 0;
  }

  public void simulateArrival(double currTime) {
    // Process an arrival event
    globalTime = currTime;
    if (currentOccupancy >= capacity) {
      System.out.println("Queue is full");
      return;
    }
    capacityTime[currentOccupancy] += (globalTime - lastEventTime);
    currentOccupancy++;
  }

  public void simulateDeparture(double currTime) {
    // Process a departure event
    globalTime = currTime;
    if (currentOccupancy <= 0) {
      System.out.println("Queue is empty");
      return;
    }

    capacityTime[currentOccupancy] += globalTime - lastEventTime;
    currentOccupancy--;
  }

  public void accumulateFinalStateTime() {
    capacityTime[currentOccupancy] += globalTime - lastEventTime;
  }

  public double getGlobalTime() {
    return globalTime;
}

public double[] getCapacityTimes() {
    return capacityTime;
}

  public int getCurrentOccupancy() {
    return currentOccupancy;
  }

  public int getNumServers() {
    return numServers;
  }
}
