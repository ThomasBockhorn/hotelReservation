package service;

import model.Customer;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Customer service class that sets up addCustomer, getCustomer
 */
public class CustomerService {

    private Customer customer;
    static LinkedList<Customer> customers;

    public CustomerService(){
        customers = new LinkedList<>();
    }

    public void addCustomer(String firstName, String lastName, String email){

       customer = new Customer(firstName, lastName, email);
       customers.add(customer);
    }

    public Customer getCustomer(String customerEmail){

        List<Customer> result = customers.stream()
                .filter(customer -> customerEmail.equals(customer.getEmail()))
                .map( customer -> new Customer(customer.getFirstName(), customer.getLastName(), customer.getEmail()))
                .collect(Collectors.toList());

        return result.iterator().next();
    }

    public String printAllCustomers(){

        String customerList;

        customerList = "List of all Customers: " + "\n";

        for(Customer customer: customers){

            customerList += customer.toString();

        }

        return customerList;
    }
}
