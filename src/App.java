import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class App {

  public static void main(String[] args) {
    try {
      Yaml yaml = new Yaml();
      InputStream inputData = new FileInputStream("model.yml");

      Map<String, Object> data = yaml.load(inputData);

      // Analisa os intervalos
      Map<String, Interval> intervals = new HashMap<>();
      Map<String, Map<String, Object>> intervalData = (Map<String, Map<String, Object>>) data.get("intervals");
      for (Map.Entry<String, Map<String, Object>> entry : intervalData.entrySet()) {
        String name = entry.getKey();
        Map<String, Object> values = entry.getValue();
        intervals.put(name, new Interval(toDouble(values.get("start")), toDouble(values.get("end"))));
      }

      // Analisa as filas
      Map<String, SimulationQueue> queues = new HashMap<>();
      Map<String, Map<String, Object>> queueData = (Map<String, Map<String, Object>>) data.get("queues");
      for (Map.Entry<String, Map<String, Object>> entry : queueData.entrySet()) {
        String name = entry.getKey();
        Map<String, Object> values = entry.getValue();
        Interval interval = intervals.get(values.get("interval"));
        Integer capacity = toDouble(values.get("capacity") == null ? -1 : values.get("capacity")).intValue();
        SimulationQueue queue = new SimulationQueue(name, toDouble(values.get("servers")).intValue(), capacity,
            interval);
        queues.put(name, queue);
      }

      // Analisa as rotas
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

      // Cria o scheduler
      Interval arrivalInterval = intervals.get(data.get("arrivalInterval"));
      int quantRandomNumbers = (int) data.get("quantRandomNumbers");

      Double startTime = toDouble(data.get("startTime"));
      String startQueue = (String) data.get("startQueue");
      Scheduler scheduler = new Scheduler(arrivalInterval, quantRandomNumbers);

      // Adiciona os filas no scheduler
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