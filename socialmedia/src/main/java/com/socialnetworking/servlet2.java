package com.socialnetworking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serv2")
public class servlet2 extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String newusernameString = req.getParameter("newusername");
        String emailString = req.getParameter("emailname");
        String dobString = req.getParameter("DOB");
        String phonenoString = req.getParameter("phoneno");
        String newpasswordString = req.getParameter("newpassword");
        PrintWriter out = res.getWriter();
        Connection con = null;
        

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sai", "root", "root");
            PreparedStatement p = con.prepareStatement(
                "insert into loginIndex(username, email, dob, phoneno, password) values(?, ?, ?, ?, ?)"
            );
            p.setString(1, newusernameString);
            p.setString(2, emailString);
            p.setString(3, dobString);
            p.setString(4, phonenoString);
            p.setString(5, newpasswordString);
            p.executeUpdate();
            res.sendRedirect("Index.html");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
