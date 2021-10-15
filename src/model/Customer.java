package model;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * This is the model Customer class.  This will set up what sorts of information a customer object will have
 * and it will format the email string to include and @.
 */

public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    protected final String emailRegex = "^(.+)@(.+).(.+)$";
    protected final Pattern pattern = Pattern.compile(emailRegex);


    public Customer(String firstName, String lastName, String email){
        super();
        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Error, Invalid email!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Getters
     */
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    /**
     * Setters
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Email: " + email + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(emailRegex, customer.emailRegex) && Objects.equals(pattern, customer.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, emailRegex, pattern);
    }
}
