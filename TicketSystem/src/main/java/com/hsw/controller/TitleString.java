/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hsw.controller;

/**
 *
 * @author Jonas
 */
public enum TitleString {

    SELF("Meine Tickets"), ALL("Alle Tickets"), OPEN("Offene Tickets"), CLOSED("Geschlossene Tickets");
    private final String title;

    private TitleString(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
