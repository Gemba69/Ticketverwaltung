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
public class Project {

    private Integer projectId;
    private String projectName;
    private String projectDesc;
    private User projectOwner;
    private List<Ticket> tickets;

    public Project(Integer projectId, String projectName, String projectDesc, User projectOwner) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.projectOwner = projectOwner;
        tickets = new ArrayList<>();
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public User getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(User projectOwner) {
        this.projectOwner = projectOwner;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
