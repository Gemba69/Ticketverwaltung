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
public class Tag {

    private String tagName;
    private String tagDesc;

    public Tag(String tagName, String tagDesc) {
        this.tagName = tagName;
        this.tagDesc = tagDesc;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }
}
