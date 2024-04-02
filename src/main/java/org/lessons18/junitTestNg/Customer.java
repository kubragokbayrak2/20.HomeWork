package org.lessons18.junitTestNg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Customer {
    private int id;
    private String firstname;
    private String lastname;
    private String email;

    public Customer(String firstname) {
        this.firstname = firstname;
    }

    public Customer(String firstname, String email) {
        this.firstname = firstname;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }
}
