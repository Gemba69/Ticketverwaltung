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

	SELF("Meine Tickets"), ALL("Alle Tickets"), OPEN("Offene Tickets"), CLOSED("Geschlossene Tickets"), INWORK(
			"In Bearbeitung"), SELFOPEN("Meine offenen Tickets"), SELFCLOSED("Meine geschlossenen Tickets"), SELFINWORK(
					"Meine Tickets in Bearbeitung"), PROJECTS("Projekte");
	private final String title;

	private TitleString(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
