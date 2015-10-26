/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hsw.Database;

/**
 *
 * @author simon
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseTester databaseTester = new DatabaseTester();
        if(!databaseTester.databaseExsists("ticketverwaltung")){
            databaseTester.create("ticketverwaltung");
        }
    }
    
}
