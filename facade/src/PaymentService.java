public class PaymentService {
    public boolean makePayment(String productId, double amount) {
        System.out.println("Processing payment of $" + amount + " for product ID: " + productId);
        // Simulate payment processing logic
        return true; // Assume payment is always successful for this example
    }
}
