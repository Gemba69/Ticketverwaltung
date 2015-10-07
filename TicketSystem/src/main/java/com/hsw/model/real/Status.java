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
public class Status {

    private String status;
    private String statusDesc;

    public Status(String status, String statusDesc) {
        this.status = status;
        this.statusDesc = statusDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
