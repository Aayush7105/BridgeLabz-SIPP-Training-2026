class Order {

    private final String orderId;
    private final String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + getOrderId());
        System.out.println("Order Date: " + getOrderDate());
        System.out.println("Status: " + getOrderStatus());
    }
}

class ShippedOrder extends Order {

    private final String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped";
    }

    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Tracking Number: " + getTrackingNumber());
    }
}

class DeliveredOrder extends ShippedOrder {

    private final String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered";
    }

    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Delivery Date: " + getDeliveryDate());
    }
}

public class RetailOrderManagement {

    public static void main(String[] args) {
        Order order = new Order("ORD-101", "2026-06-20");
        ShippedOrder shippedOrder = new ShippedOrder("ORD-102", "2026-06-21", "TRK-88991");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD-103", "2026-06-22", "TRK-88992", "2026-06-24");

        Order[] orders = {order, shippedOrder, deliveredOrder};

        for (Order currentOrder : orders) {
            currentOrder.displayOrderDetails();
            System.out.println();
        }
    }
}
