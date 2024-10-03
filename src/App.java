import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class App {

  public static void main(String[] args) {
    try {
      Yaml yaml = new Yaml();
      InputStream inputStream = new FileInputStream("model.yml");
      Map<String, Object> data = yaml.load(inputStream);

      // Parse intervals
      Map<String, Interval> intervals = new HashMap<>();
      Map<String, Map<String, Object>> intervalData = (Map<String, Map<String, Object>>) data.get("intervals");
      for (Map.Entry<String, Map<String, Object>> entry : intervalData.entrySet()) {
        String name = entry.getKey();
        Map<String, Object> values = entry.getValue();
        intervals.put(name, new Interval(toDouble(values.get("start")), toDouble(values.get("end"))));
      }

      // Parse queues
      Map<String, SimulationQueue> queues = new HashMap<>();
      Map<String, Map<String, Object>> queueData = (Map<String, Map<String, Object>>) data.get("queues");
      for (Map.Entry<String, Map<String, Object>> entry : queueData.entrySet()) {
        String name = entry.getKey();
        Map<String, Object> values = entry.getValue();
        Interval interval = intervals.get(values.get("interval"));
        SimulationQueue queue = new SimulationQueue(name, toDouble(values.get("servers")).intValue(),
            toDouble(values.get("capacity")).intValue(), interval);
        queues.put(name, queue);
      }

      // Parse routing
      Map<String, Map<String, Double>> routingData = (Map<String, Map<String, Double>>) data.get("routing");
      for (Map.Entry<String, Map<String, Double>> entry : routingData.entrySet()) {
        String queueName = entry.getKey();
        SimulationQueue queue = queues.get(queueName);
        Map<String, Double> routes = entry.getValue();
        System.out.println(routes.entrySet());
        for (Map.Entry<String, Double> route : routes.entrySet()) {
          System.out.println("route.getKey()");
          System.out.println(route.getKey());
          queue.addRouting(route.getKey(), route.getValue());
        }
      }

      // Create scheduler
      Interval arrivalInterval = intervals.get(data.get("arrivalInterval"));

      Double startTime = toDouble(data.get("startTime"));
      String startQueue = (String) data.get("startQueue");
      Scheduler scheduler = new Scheduler(arrivalInterval);

      // Add queues to scheduler
      for (Map.Entry<String, SimulationQueue> entry : queues.entrySet()) {
        scheduler.addQueue(entry.getKey(), entry.getValue());
      }

      scheduler.start(startTime, startQueue);
      scheduler.printStateProbabilities();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static Double toDouble(Object obj) {
    if (obj instanceof Integer) {
      return ((Integer) obj).doubleValue();
    } else if (obj instanceof Double) {
      return (Double) obj;
    } else {
      throw new IllegalArgumentException("Cannot convert object to Double: " + obj);
    }
  }
}