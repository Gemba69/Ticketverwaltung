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
public class Ticket {

    private int ticketId;
    private int ticketPrio;
    private String ticketName;
    private String ticketDesc;
    private User ticketIssuer;
    private User ticketAuthor;
    private Status ticketStatus;
    private List<Comment> comments;
    private List<Tag> tags;

    public Ticket(int ticketId, String ticketName, String ticketDesc, User ticketAuthor) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.ticketDesc = ticketDesc;
        this.ticketAuthor = ticketAuthor;
        comments = new ArrayList<>();
        tags = new ArrayList<>();
        ticketPrio = 3;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketPrio() {
        return ticketPrio;
    }

    public void setTicketPrio(int ticketPrio) {
        this.ticketPrio = ticketPrio;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketDesc() {
        return ticketDesc;
    }

    public void setTicketDesc(String ticketDesc) {
        this.ticketDesc = ticketDesc;
    }

    public User getTicketIssuer() {
        return ticketIssuer;
    }

    public void setTicketIssuer(User ticketIssuer) {
        this.ticketIssuer = ticketIssuer;
    }

    public User getTicketAuthor() {
        return ticketAuthor;
    }

    public void setTicketAuthor(User ticketAuthor) {
        this.ticketAuthor = ticketAuthor;
    }

    public Status getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Status ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

}
