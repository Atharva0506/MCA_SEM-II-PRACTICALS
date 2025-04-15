// 16) Write a JSP program to accept ,insert into database and display the details of College (CollegeID, Coll_Name, Address) in tabular form on browser

college_form.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>College Form</title>
</head>
<body>
    <h2>Enter College Details</h2>
    <form action="insert_college.jsp" method="post">
        College ID: <input type="text" name="collegeID" required><br>
        College Name: <input type="text" name="collName" required><br>
        Address: <input type="text" name="address" required><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>


// insert_college.jsp

<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%
    String collegeID = request.getParameter("collegeID");
    String collName = request.getParameter("collName");
    String address = request.getParameter("address");

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        // Load MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Connect to the database
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CollegeDB", "root", "password");

        // Insert into database
        String sql = "INSERT INTO College (CollegeID, Coll_Name, Address) VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, Integer.parseInt(collegeID));
        pstmt.setString(2, collName);
        pstmt.setString(3, address);
        
        int rowsInserted = pstmt.executeUpdate();

        if (rowsInserted > 0) {
            out.println("<h3>College details added successfully!</h3>");
        }
    } catch (Exception e) {
        out.println("<h3>Error: " + e.getMessage() + "</h3>");
    } finally {
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>

<a href="display_college.jsp">View College List</a>


//display_college.jsp

<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>College List</title>
</head>
<body>
    <h2>College Details</h2>
    <table border="1">
        <tr>
            <th>College ID</th>
            <th>College Name</th>
            <th>Address</th>
        </tr>

        <%
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                // Load MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Connect to the database
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CollegeDB", "root", "password");

                // Execute query
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM College");

                while (rs.next()) {
        %>
                    <tr>
                        <td><%= rs.getInt("CollegeID") %></td>
                        <td><%= rs.getString("Coll_Name") %></td>
                        <td><%= rs.getString("Address") %></td>
                    </tr>
        <%
                }
            } catch (Exception e) {
                out.println("<h3>Error: " + e.getMessage() + "</h3>");
            } finally {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
        %>
    </table>
</body>
</html>

