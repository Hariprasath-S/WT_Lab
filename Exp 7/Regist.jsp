<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import ="java.lang.Class" %>
<%

    String email = request.getParameter("email");
    String name = request.getParameter("name");
    String roll = request.getParameter("rollno");
    String phone = request.getParameter("phone");
    String dept = request.getParameter("dept");

    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
        PreparedStatement ps = conn.prepareStatement("insert into student (name,roll,dept,email,phone) values (?,?,?,?,?); ");
        
        ps.setString(1,name);
        ps.setString(2,roll);
        ps.setString(3,dept);
        ps.setString(4,email);
        ps.setString(5,phone);

        int x = ps.executeUpdate();
        

%>
<!DOCTYPE html>
<head>
    <title>Registration Successfull</title>
    <style>
        body{
            /* background: linear-gradient(to right, #8e2de2, #4a00e0); */
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            font-size: 22px;
            background-color: #8e2de2;
            background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='100%25' height='100%25' viewBox='0 0 1600 800'%3E%3Cg stroke='%23007' stroke-width='63.8' stroke-opacity='0.13' %3E%3Ccircle fill='%238e2de2' cx='0' cy='0' r='1800'/%3E%3Ccircle fill='%238b2be2' cx='0' cy='0' r='1700'/%3E%3Ccircle fill='%238828e2' cx='0' cy='0' r='1600'/%3E%3Ccircle fill='%238526e2' cx='0' cy='0' r='1500'/%3E%3Ccircle fill='%238124e1' cx='0' cy='0' r='1400'/%3E%3Ccircle fill='%237e21e1' cx='0' cy='0' r='1300'/%3E%3Ccircle fill='%237a1fe1' cx='0' cy='0' r='1200'/%3E%3Ccircle fill='%23771de1' cx='0' cy='0' r='1100'/%3E%3Ccircle fill='%23731ae1' cx='0' cy='0' r='1000'/%3E%3Ccircle fill='%236f17e1' cx='0' cy='0' r='900'/%3E%3Ccircle fill='%236b15e1' cx='0' cy='0' r='800'/%3E%3Ccircle fill='%236712e1' cx='0' cy='0' r='700'/%3E%3Ccircle fill='%23630fe0' cx='0' cy='0' r='600'/%3E%3Ccircle fill='%235f0ce0' cx='0' cy='0' r='500'/%3E%3Ccircle fill='%235a09e0' cx='0' cy='0' r='400'/%3E%3Ccircle fill='%235506e0' cx='0' cy='0' r='300'/%3E%3Ccircle fill='%235003e0' cx='0' cy='0' r='200'/%3E%3Ccircle fill='%234a00e0' cx='0' cy='0' r='100'/%3E%3C/g%3E%3C/svg%3E");
            background-attachment: fixed;
            background-size: cover;
        }
        .container { 
            padding: 16px;
            width: 30%;
            margin: 100px auto;
            box-shadow: 0px 10px 30px #210063;
            color: white;
            background-color: #4700b9;
        }
        h2{
            border-bottom: 1px solid;
            padding: 5px;
            text-align: center;
        }
       
        .button{
            font-size: 20px;
            background: transparent;
            border: 2px solid white;
            border-radius: 10px;
            padding: 5px;
            margin-top: 30px;
            width: 96.5%;
            color: white;
            text-decoration: none;
            display: block;
            text-align: center;
        }
        .button:hover{
            background-color: white;
            color: #4a00e0;
            transition: 0.7s;
        }
        
        
    </style>
</head>
<body>
    <div class="container">

<% 
    if(x>0)
        {
%>

    <h2>Registration Successfull!</h2>

<% 
        }
        else {

%>

    <h2>An Eror Occurred</h2>

<% 

        }
        }catch(Exception e){
        out.println(e);
    }

%>

    <div><a href="reg.html" class="button">Back</a></div>
    <div><a href="view.jsp" class="button">View Students</a></div>
    </div>
</body>



