import java.util.ArrayList;

/**
 * Created by alex on 09/04/2017.
 */
public class Bank {
    ArrayList<Customer> customers = new ArrayList<Customer>();

    public void addCustomer(Customer customer) {

        customers.add(customer);
    }

    Customer getCustomer(int account) {
        return customers.get(account);
    }

    ArrayList<Customer> getCustomers() {
        return  customers;
    }
}
