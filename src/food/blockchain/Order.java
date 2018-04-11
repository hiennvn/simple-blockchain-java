package food.blockchain;

/**
 *
 * @author hien
 */
public class Order {
    public String customer;
    public String details;
    public long total;
    
    public Order(String customer, String details, long total) {
        this.customer = customer;
        this.details = details;
        this.total = total;
    }
    
    public String getString() {
        return String.format(
                "Customer [%s] has ordered [%s], total [%d] VND",
                this.customer,
                this.details,
                this.total);
    }
}
