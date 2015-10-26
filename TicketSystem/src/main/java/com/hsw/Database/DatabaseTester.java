/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hsw.Database;

import com.mysql.jdbc.Connection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Array;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author simon
 */
public class DatabaseTester {

    private static EntityManagerFactory emf;
    private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    private Connection makeConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean databaseExsists(String name) {
        Connection conn = makeConnection();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            String sql;
            sql = "SHOW DATABASES";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(name)) {
                    rs.close();
                    stmt.close();
                    conn.close();
                    System.out.println("Gefunden");
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Nicht Gefunden");
        return false;

    }

    public void create(String name) {
        Connection conn = makeConnection();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("Database/" + name).getFile());
            //URL url = new URL("File:\\C:\\Users\\simon\\Documents\\NetBeansProjects\\Ticketverwaltung\\TicketSystem\\DB\\ticketverwaltung_database.sql");
            String[] sql = readData(file).split(";");
            for (int i = 0; i < sql.length; i++) {
                System.out.println(sql[i]);
                stmt.execute(sql[i]);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String readData(File file) {
        FileReader fr;
        BufferedReader br;
        String ret = "";
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String zeile;
            zeile = br.readLine();
            ret = ret + verbessern(zeile);
            while (zeile != null) {
                zeile = br.readLine();
                ret = ret + verbessern(zeile);
            }

            fr.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei " + file.getName());
            System.out.println(e.toString());
        }
        return ret;
    }

    public String verbessern(String s) {
        String ret = "";
        if (!(s == null || s.isEmpty())) {
            for (int i = 0; i < s.toCharArray().length - 1; i++) {
                if ((s.charAt(i) == '-' && s.charAt(i + 1) == '-') || (s.charAt(i) == '/' && s.charAt(i + 1) == '*')) {
                    return ret;
                }
                ret = ret + s.charAt(i);
            }
            ret = ret + s.charAt(s.toCharArray().length - 1);
        }
        return ret;
    }
}
