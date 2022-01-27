<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREATE ADRESS</title>
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
<h2>CREATE ADRESS</h2>
        <form action="createadress" method="post">
            <table>

                <tr>
                    <td>
                        <label for="adress">Adress:</label>
                    </td>
                    <td><input type="text" id="adress" name="adress"></td>
                </tr>

                <tr>
                    <td><label for="state">State:</label></td>
                    <td><input type="text" id="state" name="state"></td>
                </tr>

                <tr>
                    <td><label for="pin">Contact Number:</label></td>
                    <td><input type="number" id="pin" name="pin"></td>
                </tr>


                <tr>
                    <td><label for="branchId"> BranchId:</label></td>
                    <td><input type="number" id="branchId" name="branchId" value="<%=request.getParameter("branchId") %>" readonly="readonly"></td>
                </tr>

                    <td colspan="2" > <input type="submit" value="submit"> </td>
                </tr>

            </table>

        </form>
<%} 
 else 
{ %>
<%@include file="login.jsp" %>
<%} %>
</body>
</html>