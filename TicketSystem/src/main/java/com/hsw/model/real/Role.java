/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hsw.model.real;

/**
 *
 * @author jonas
 */
public class Role {

    private String roleName;
    private String roleDesc;
    
    public Role(String roleName, String roleDesc) {
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    
}
