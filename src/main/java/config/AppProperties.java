package config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Propiedades de la app. Prefijo: app.*
 * Ej.: app.orders.max-items=100
 */
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private final Orders orders = new Orders();

    public Orders getOrders() {
        return orders;
    }

    public static class Orders {
        private int maxItems = 100;

        public int getMaxItems() {
            return maxItems;
        }
        public void setMaxItems(int maxItems) {
            this.maxItems = maxItems;
        }
    }
}



