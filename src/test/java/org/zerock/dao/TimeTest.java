package org.zerock.dao;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TimeTest {


    @Test
    public void testNow() throws Exception {

        Class.forName("org.mariadb.jdbc.Driver");

        @Cleanup Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost/webdb",
                "webuser", "webuser");

        @Cleanup PreparedStatement ptmt = con.prepareStatement("select now()");
        @Cleanup ResultSet resultSet = ptmt.executeQuery();

        resultSet.next();

        System.out.println(resultSet.getString(1));
    }

}
