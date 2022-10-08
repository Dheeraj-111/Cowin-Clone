<!-- /*
    (___)
    (o o)_____/
     @@ `     \  
      \ ____, /
      //    //  
     ^^    ^^ */ -->

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

    <style>
        /* Switcher CSS Start */

        .switch-button {
            width: 550px;
            height: 40px;
            text-align: center;
            transform: translate3D(-50%, -50%, 0);
            margin-left: 35%;
            margin-top: 5%;
            cursor: pointer;
            transition: 0.3s ease all;
            border: 1px solid rgb(0, 0, 0);
        }

        .switch-button-case {
            display: inline-block;
            background: none;
            width: 49%;
            height: 100%;
            color: rgb(0, 0, 0);

            border: none;
            transition: 0.3s ease all;
            text-transform: uppercase;
            letter-spacing: 5px;
            padding-bottom: 1px;
            font-weight: 200;
        }

        .switch-button-case:hover {
            color: rgb(9, 15, 75);
            cursor: pointer;

        }

        .switch-button-case:focus {
            outline: none;
        }

        .switch-button .active {
            color: #000000;
            background-color: rgb(8, 12, 61);
            position: absolute;
            left: 0;
            top: 0;
            width: 50%;
            height: 100%;
            z-index: -1;
            transition: 0.3s ease-out all;
        }

        .switch-button .active-case {
            color: #ffffff;
        }

        /* Switcher CSS Close */
        
        
        
        
table {
    position: relative;
    bottom:20%;
  border: 1px #a39485 solid;
  font-size: 0.9em;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.25);
  width: 90%;
  margin:auto;
  margin-bottom:2%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
  
}

th {
  text-align: left;
}

thead {
  font-weight: bold;
  color: #fff;
  background: #73685d;
}

td,
th {
  padding: 1em 0.5em;
  vertical-align: middle;
}

td {
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
  background: #fff;
}

a {
  color: #73685d;
}

@media all and (max-width: 768px) {
  table,
  thead,
  tbody,
  th,
  td,
  tr {
    display: block;
  }

  th {
    text-align: right;
  }

  table {
    position: relative;
    padding-bottom: 0;
    border: none;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  }

  thead {
    float: left;
    white-space: nowrap;
  }

  tbody {
    overflow-x: auto;
    overflow-y: hidden;
    position: relative;
    white-space: nowrap;
  }

  tr {
    display: inline-block;
    vertical-align: top;
  }

  th {
    border-bottom: 1px solid #a39485;
  }

  td {
    border-bottom: 1px solid #e5e5e5;
  }
}


/*Table CSS End*/
    </style>
    
    

<link rel="stylesheet" href="userstyle.css">

</head>

<body style="background-color: white;">

  <nav style="  width: 100%; height: auto; padding-top: 5px; padding-bottom: 5px; margin: auto;  background-color: rgb(7, 17, 63);">
        <span > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<img style="margin: 5px; "  width="30px" src="images/coronavirus.png" alt="logo">  <span style=" margin: 0px; height: 10px; color: rgb(255, 255, 255); position: relative; top: 2px;; ">WINNING &nbsp; AGAINST &nbsp; COVID - 19 <span></span>
        <span style="float: right; color: rgb(255, 255, 255); padding-right: 150px; position: relative; top: 8px;"> <a style="color: white; text-decoration: none;" href="home/home.html">&nbsp;HOME&nbsp; </a> | <a style="color: white; text-decoration: none;" href="login.jsp"> &nbsp;USER LOGIN&nbsp; </a> | <a style="color: white; text-decoration: none;" href="hospiLogin.jsp">&nbsp;HOSPITAL LOGIN&nbsp; </a> | <a style="color: white; text-decoration: none;" href="logout">&nbsp;LOGOUT&nbsp; </a> </span>
    </nav>
    </span>
    <span>
        <nav style=" width: 100%; height: auto; padding-top: 2px; padding-bottom: 2px; margin: auto;  background-color: rgb(255, 255, 255);">
            <span style="font-weight: bolder ; font-size: 30px; color: rgb(0, 0, 0); " >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="images/coronavirus_logo-2-833x321.jpg" width="10%" alt="">  <span></span  ></span>
            
        </nav>
        </span>
    
        
            <!-- main-footer -->
            <footer class="main-footer">
                <div class="shape-layer" ></div>
                <div class="anim-icon">
                    
                    <div class="icon icon-2 rotate-me" style="background-image: url(images/anim-icon-3.png);"></div>
                    <div class="icon icon-3 rotate-me" style="background-image: url(images/anim-icon-6.png);"></div>
                    <div class="icon icon-4 rotate-me" style="background-image: url(images/anim-icon-6.png); width: 300px; height: 300px;"></div>
                    <div class="icon icon-5 rotate-me" style="background-image: url(images/anim-icon-4.png); "></div>
    
    
    
    
                    <span>

    <br><br><br><br>
    

    
    <%    String button=(request.getParameter("but"));
    
    
         if(session.getAttribute("username")==null)
            {  
                response.sendRedirect("login.jsp");
            }
     
     
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
     }
     catch(ClassNotFoundException e)
     {
         System.out.println("Error in loading drivers");
     }
     
     String user=(String)session.getAttribute("username");
     
     String dob=null;
     String Hname=null;
     int dose=0;
     int id=0;
     String name=null;
     String aadhar=null;
     String uname=null;
     
     
            try
     {
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
             PreparedStatement ps = con.prepareStatement("select * from user where username=?");
             ps.setString(1, user);
             
             ResultSet rs=ps.executeQuery();
             
             if(rs.next()==true)
             {
                 PreparedStatement pss = con.prepareStatement("select * from user where username=?");
                 pss.setString(1, user);
             
                 ResultSet rsss=pss.executeQuery();
                
                 name=rs.getString("Name");
                 aadhar=rs.getString("aadharno");
                 dob=rs.getString("dob");
                 Hname=rs.getString("Hname");
                 dose=rs.getInt("dose");
                 id=rs.getInt("User_ID");
                 uname=rs.getString("username");
                
                 }
                 
                
         }
            catch(SQLException e)
             {
                 System.out.println("Error in sql statement");
             } 
    session.setAttribute("username",uname);
    session.setAttribute("dose", dose);
    
     %>
    
    
    
    
        <fieldset style=" background-color: white; border: 1px solid rgb(255, 0, 0);
    width: 80%;
    height: auto;
    margin:auto;">

        <div>
            <br>
            <span style="padding-left: 52px;">  &nbsp; <span
                    style=" color: rgb(10, 18, 66); padding:0%; margin: 0%; font-weight: 600; font-size: 25px; "> <button style="margin-left: 0%;
                    margin-top: -15%;
                
                    font-size: 16px;
                    
                    cursor: pointer;
                    padding: 5px;
                    border-radius: 5px;
                    
                    font-weight: 700;
                    background: transparent;
                    color: #002060!important;
                    border: 1px solid #002060;
                    "><a href="welcome.jsp"><img src="images/arrow.png" width="25px" alt="Backward" ></a></button>&nbsp;&nbsp;Book
                    Appointment FOR Vaccination</span></span>
        </div>
        <br>
        <br>
        <div style="font-size: 13px; padding-left: 52px;">The slots availability data displayed in the pincode or district search is
            provided by the state govt and private hospitals. Cowin does not create this data, the data accuracy, or
            guarantee that it is the most recent data available from the data provider.</div>
            <br>

        <div class="switch-button"><span class="active"></span>
            <button class="switch-button-case left active-case">Search By Pin</button>
            <button class="switch-button-case right">Search By District</button>
        </div>



        <!-- Switcher Content -->

        

        <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3" >

            <div class="row login__form" style="display: block;">
                <form action="slot"  accept-charset="UTF-8">
<br>                
                    <div class="form-group col-md-4">
                        
                        <label for="inputPincode" style="margin-left: -100px;">Pincode</label><br>
                        <input type="number" name="pincode" id="" placeholder="Pincode" style="padding: 4%; padding-right: 35%; margin-left: -100px;">
                    </div>
                    <div class="form-group col-md-4">
                        <button style=" position: relative;
                                right: 10%;
                                margin-top: 15%;
                    
                        font-size: 16px;
                        
                        cursor: pointer;
                        padding: 5px;
                        border-radius: 5px;
                        
                        font-weight: 700;
                        background: transparent;
                        color: #002060!important;
                        border: 1px solid #002060;
                        "name="search" value="pin">Search</button>
                        <br><br>
                    </div>

                </form>
            </div>
        </div>
<br>
 
        <div class="row register__form" style="display: none;">
            <div id="registration-form-wrapper">
                <form action="slot"  accept-charset="UTF-8">
                
                    <div class="form-group col-md-4">
                        <label for="inputState" style="margin-left: 16%;">State</label>
                        <span >
                        <select name ="state" class="form-control" id="inputState" style="margin-left: 16%;"></span>                            <option value="SelectState">Select State</option>
                            <option value="Andra Pradesh">Andra Pradesh</option>
                            <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                            <option value="Assam">Assam</option>
                            <option value="Bihar">Bihar</option>
                            <option value="Chhattisgarh">Chhattisgarh</option>

                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputDistrict" style="margin-left: 16%;">District</label>
                        <select name="district" class="form-control" id="inputDistrict" style="margin-left: 16%;">
                            <option value="">-- select one -- </option>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <button style="
                                position:relative;
                                right:-20%;
                                margin-top:6%;
                                
                    
                        font-size: 16px;
                        
                        cursor: pointer;
                        padding: 5px;
                        border-radius: 5px;
                        
                        font-weight: 700;
                        background: transparent;
                        color: #002060!important;
                        border: 1px solid #002060;
                        " name="search" value="dist">Search</button>
                    </div>
                </form>
            </div>
        </div>
        

    
<% 
    
    String dist=(String)session.getAttribute("item");
    
    
    


try
{
Class.forName("com.mysql.jdbc.Driver");
}
catch(Exception e)
{
System.out.println("Error in loading drivers");
}

                       
                        try
			{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
                        
			PreparedStatement ps=con.prepareStatement("select * from hospital where Hdistrict=?");
			ps.setString(1,dist);
			ResultSet rs=ps.executeQuery();
                        
                        
                            %>
                            
                                <%
                                    if(rs.next()){ %>
                                    
                                     
                                    
                                    
                                    <form action="pinslot">
                                        <input type="text" name="but1" value="<% out.println(dose);%>" style="display:none;" >
                            <table style="color:Red">
                                <thead>
                            <tr>
                                <th>Select</th>
                                <th>S.No.</th>
                                <th>Hospital Name</th>
                                <th>District</th>
                                <th style="padding: 0.5em 0.5em;">Slots Available</th>
                                <th>Hospital Pin</th>
                                </tr>
                            </thead>
        
                            <% 

                        PreparedStatement qs=con.prepareStatement("select * from hospital where Hdistrict=?");
                        qs.setString(1,dist);
			ResultSet rss=qs.executeQuery();
                        int count = 1;
                        while(rss.next())
			{
                            %>
                        
                            <tr>
                                <td><input type="radio" name="same" value="<%= rss.getString("Hname")%>"></td>
                                <td><%out.println(count);%></td>
                                <td><%= rss.getString("Hname")%></td>
                                <td><%= rss.getString("Hdistrict")%></td>
                                <td><%=rss.getInt("Hslots")%></td>
                                <td><%=rss.getInt("Hpin")%></td>
                            </tr>
                            <%count++;%>
                            
                            
                        <%
                            }
                            %>
                            <br><br><br>
                            
                            </table>
                                    
                                    <input type="submit" value="Submit" style=" margin-bottom: 0;
                                           
                    
                    font-size: 16px;
                    
                    cursor: pointer;
                    padding: 10px;
                    border-radius: 5px;
                    text-align: center;
                    font-weight: 700;
                    background: transparent;
                    color: #002060!important;
                    border: 1px solid #002060;
                    margin:45%;
                    margin-top:0%;
                    margin-bottom:0%;
                    " >
                                    </form>
                                    <br>
                                    
                                    </fieldset>
                            
                                    <%
			}
                        }
                        
                        
                        
			catch(SQLException e)
			{
			out.println("Error in sql statement");
			}




			
%>
                           
                
    <script>

        "use strict";

        $(".register__form").hide();


        var switchButton = document.querySelector(".switch-button");
        var switchBtnRight = document.querySelector(".switch-button-case.right");
        var switchBtnLeft = document.querySelector(".switch-button-case.left");
        var activeSwitch = document.querySelector(".active");

        function switchLeft() {
            switchBtnRight.classList.remove("active-case");
            switchBtnLeft.classList.add("active-case");
            activeSwitch.style.left = "0%";
            $(".login__form").show();
            $(".register__form").hide();
        }

        function switchRight() {
            switchBtnRight.classList.add("active-case");
            switchBtnLeft.classList.remove("active-case");
            activeSwitch.style.left = "50%";
            $(".register__form").show();
            $(".login__form").hide();

        }

        switchBtnLeft.addEventListener(
            "click",
            function () {
                switchLeft();
            },
            false
        );

        switchBtnRight.addEventListener(
            "click",
            function () {
                switchRight();
            },
            false
        );

    </script>

<!-- Update Profile JS -->

<script>
    var AndraPradesh = ["Anantapur", "Chittoor"];
    var ArunachalPradesh = ["Anjaw", "Changlang"];
    var Assam = ["Baksa", "Barpeta"];
    var Bihar = ["Araria", "Arwal"];
    var Chhattisgarh = ["Balod", "Baloda Bazar"];
    
    $("#inputState").change(function () {
      var StateSelected = $(this).val();
      var optionsList;
      var htmlString = "";
    
      switch (StateSelected) {
        case "Andra Pradesh":
          optionsList = AndraPradesh;
          break;
        case "Arunachal Pradesh":
          optionsList = ArunachalPradesh;
          break;
        case "Assam":
          optionsList = Assam;
          break;
        case "Bihar":
          optionsList = Bihar;
          break;
        case "Chhattisgarh":
          optionsList = Chhattisgarh;
          break;
      }
    
      for (var i = 0; i < optionsList.length; i++) {
        htmlString =
          htmlString +
          "<option value='" +
          optionsList[i] +
          "'>" +
          optionsList[i] +
          "</option>";
      }
      $("#inputDistrict").html(htmlString);
    });
    </script>
    
  


</body>

</html>