package structural.proxy.dynamic;

public class MetricsCollector {
    public void recordRequest(String apiName, long responseTime) {
        System.out.println("Record request: " + apiName + ", response time: " + responseTime);
    }
}
