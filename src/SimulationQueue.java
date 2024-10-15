import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulationQueue {
	private int numServers;
	private int capacity;
	private double lastEventTime;
	private double[] capacityTime;
	private int currentOccupancy;

	private int accLoss;
	private Interval serviceInterval;
	private String id;
	private Map<String, Double> routing; // <FilaDestino, Probabilidade>

	public SimulationQueue(String id, int numServers, int capacity, Interval serviceInterval,
			Map<String, Double> routing) {
		if (capacity == -1) {
			capacity = 1_000_000;
		}

		this.numServers = numServers;
		this.capacity = capacity;
		this.lastEventTime = 0;
		this.capacityTime = new double[capacity + 1];
		this.currentOccupancy = 0;

		this.id = id;
		this.accLoss = 0;
		this.serviceInterval = serviceInterval;
		this.routing = routing;
	}

	public SimulationQueue(String id, int numServers, int capacity, Interval serviceInterval) {
		if (capacity == -1) {
			capacity = 1_000_000;
		}

		this.numServers = numServers;
		this.capacity = capacity;
		this.lastEventTime = 0;
		this.capacityTime = new double[capacity + 1];
		this.currentOccupancy = 0;
		this.id = id;
		this.accLoss = 0;
		this.serviceInterval = serviceInterval;
		this.routing = new HashMap<String, Double>();
	}

	public void addRouting(String id, Double prob) {
		routing.put(id, prob);
	}

	public void simulateArrival(double currTime) {
		// System.out.println("-> " + id + " currentOccupancy: " + currentOccupancy);
		// System.out.println("-> " + id + " " + Arrays.toString(capacityTime) + "\n");
		capacityTime[currentOccupancy] += (currTime - lastEventTime);
		lastEventTime = currTime;
		currentOccupancy++;
	}

	public void simulateDeparture(double currTime) {
		// Process a departure event
		// globalTime = currTime;
		if (currentOccupancy <= 0) {
			// System.out.println("-> " + id + " Queue is empty" + "\n");
			return;
		}

		capacityTime[currentOccupancy] += currTime - lastEventTime;
		lastEventTime = currTime;
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

	public String getId() {
		return id;
	}

	public String getNextQueue(double rand) {
		double sum = 0;
		double selectedProb = 0;

		for (Double prob : routing.values()) {
			sum += prob;
			if (rand <= sum) {
				selectedProb = prob;
				break;
			}
		}

		for (Map.Entry<String, Double> entry : routing.entrySet()) {
			if (entry.getValue() == selectedProb) {
				return entry.getKey();
			}
		}

		return null;
	}

	public List<Double> getCapacityTimes() {
		return Arrays.asList(Arrays.stream(capacityTime).boxed().toArray(Double[]::new));
	}

	public int getCapacity() {
		return capacity;
	}

	public int getAccLoss() {
		return accLoss;
	}

	public void incLoss() {
		accLoss++;
		// System.out.println("-> " + id + " Fila " + id + " perdeu " + accLoss + "
		// eventos");
	}

	@Override
	public String toString() {
		return "SimulationQueue [id=" + id + " ]";
	}
}
