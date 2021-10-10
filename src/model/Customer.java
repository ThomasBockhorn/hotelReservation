package model;

import java.util.regex.Pattern;

public class Customer {

    protected String firstName;
    protected String lastName;
    protected String email;
    protected final String emailRegex = "^(.+)@(.+).(.+)$";
    protected final Pattern pattern = Pattern.compile(emailRegex);

    /**
     * This is the class model for customer
     * @param firstName
     * @param lastName
     * @param email
     */

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
}
