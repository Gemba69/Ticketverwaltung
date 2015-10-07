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
public class Comment {

    private String comment;
    private User commentIssuer;

    public Comment(String comment, User commentIssuer) {
        this.comment = comment;
        this.commentIssuer = commentIssuer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getCommentIssuer() {
        return commentIssuer;
    }

    public void setCommentIssuer(User commentIssuer) {
        this.commentIssuer = commentIssuer;
    }

}
