package model;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConection {

    private static SqlConection instance = null;
    private static final String URL = "jdbc:jtds:sqlserver://DESKTOP-7D6FVNH;database=myBands;user=mybandsuser";
    private static final String USER = "USERNAME";
    private static final String PASS = "PASSWORD";
    private static Connection connection = null;

    private SqlConection(){}

    public static SqlConection getInstance(){
        if(instance == null)
            instance = new SqlConection();
        return instance;
    }

    public Connection getConnection() {
        if(connection == null)
            connection = connect();
        return connection;
    }

    private Connection connect(){
        Connection conn = null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
