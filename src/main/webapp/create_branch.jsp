<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREATE BRANCH</title>
</head>
<body>


<body>
<body>

    <style>
          body{
            background-color: rgb(191, 226, 226);
        }
        table,
        th,
        td {
            border-collapse: collapse;
        }

        th,
        td {
            padding: 15px;
        }
    </style>



    </head>

    <body>

<%  String status=(String)session.getAttribute("status");
if(status == null){ %>
<%@ include file="adminnav.jsp" %>
        <h2>CREATE branch</h2>
        <form action="createbranch" method="post">
            <table>

                <tr>
                    <td>
                        <label for="name">Name:</label>
                    </td>
                    <td><input type="text" id="name" name="name"></td>
                </tr>

                <tr>
                    <td><label for="place">Place</label></td>
                    <td><input type="text" id="place" name="place"></td>
                </tr>

                <tr>
                    <td><label for="mail">Mail</label></td>
                    <td><input type="text" id="mail" name="mail"></td>
                </tr>
                
                 <tr>
                    <td>
                        <label for="name">Hospital_id</label>
                    </td>
                    <td><input type="number" id="hospital_id" name="hospital_id" value="<%=request.getParameter("hospitalId") %>" readonly="readonly"></td>
                </tr>
                 <tr>
                    <td colspan="2" > <input type="submit" value="submit"> </td>
                </tr>
            </table>

        </form>



    </body>

<%} 
 else 
{ %>
<%@include file="login.jsp" %>
<%} %>
</body>
</html>