package structural.proxy.dynamic;

import structural.proxy.inheritanceBase.MetricsCollector;

public class Main {
    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        MetricsCollector metricsCollector = (MetricsCollector) proxy.createProxy(new MetricsCollector());
    }
}
