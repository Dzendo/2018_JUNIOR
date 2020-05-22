/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapexample;

/**
 *
 * @author LV
 */
public class WebSiteUser
{
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
 
    public WebSiteUser(String email, String firstName, String lastName, String phone) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
 
    public String getEmail() {
        return email;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public String getPhone() {
        return phone;
    }
}
