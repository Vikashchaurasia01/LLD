public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    // Simplified method for clients
    public void placeOrder(String productId, double amount, String paymentMethod) {

        // The following steps are hidden from the client and need to be executed in a specific order
        System.out.println("Placing order for product: " + productId);

        // step 1: Check stock
        if (!inventoryService.checkStock(productId)) {
            System.out.println("Product is out of stock.");
            return;
        }

        // step 2: Make payment
        if (!paymentService.makePayment(productId, amount)) {
            System.out.println("Payment failed.");
            return;
        }

        // step 3: Ship product
        shippingService.shipProduct(productId);

        // step 4: Send confirmation
        notificationService.sendConfirmation(productId);

        System.out.println("Order placed successfully for product: " + productId);
    }
}
