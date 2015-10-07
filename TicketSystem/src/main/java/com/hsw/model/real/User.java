/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hsw.model.real;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */
public class User {

    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private List<Role> roles;

    public User(String userName, String password, String email, String firstName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        roles = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void addRole(Role r) {
        this.roles.add(r);
    }

    public void removeRole(Role r) {
        this.roles.remove(r);
    }

    public void removeRole(int index) {
        this.roles.remove(index);
    }
}
