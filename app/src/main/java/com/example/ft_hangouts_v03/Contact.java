package com.example.ft_hangouts_v03;

public class Contact {
    int     id;
    String  firstName;
    String  lastName;
    String  phoneNr;
    String  email;
    String  street;

    public Contact() {}

    public Contact(int id, String firstName, String lastName, String phoneNr, String email, String street)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
        this.email = email;
        this.street = street;
    }

    public Contact(String firstName, String lastName, String phoneNr, String email, String street)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
        this.email = email;
        this.street = street;
    }

    public void setId(int id)               { this.id = id; }

    public void setFirstName(String name)   { this.firstName = name; }

    public void setLastName(String name)    { this.lastName = name; }

    public void setPhoneNr(String nr)       { this.phoneNr = nr; }

    public void setEmail(String email)      { this.email = email; }

    public void setStreet(String street)    { this.street = street; }

    public int  getId()             { return this.id; }

    public String getFirstName()    { return this.firstName; }

    public String getLastName()     { return this.lastName; }

    public String getPhoneNr()      { return this.phoneNr; }

    public String getEmail()        { return this.email; }

    public String getStreet()       { return this.street; }

}
