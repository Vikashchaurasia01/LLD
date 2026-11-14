public class ECommerceApp {
    public static void main(String[] args) throws Exception {
        System.out.println("====== Facade Design Pattern Demo ======");

        // Client interacts with a simple facade, not with all subsystem
        OrderFacade orderFacade = new OrderFacade();

        // Place an order with one call to facade
        String productId = "P12345";
        double amount = 99.99;
        String paymentMethod = "Credit Card";
        orderFacade.placeOrder(productId, amount, paymentMethod);

        // place another order with one call to facade
        orderFacade.placeOrder("P67890", 49.99, "PayPal");
    }
}
