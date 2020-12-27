<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/stylee.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Student registration</h1>


<div class="container">
            <form class="form-horizontal" role="form" action="StudentController" method="post">
                <h2>Registration Form</h2>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">Full Name</label>
                    <div class="col-sm-9">
                    <input type="hidden" name="id" value="${students.id}">
                        <input type="text" id="firstName" name="sname" value="${students.name}" placeholder="Full Name" class="form-control" autofocus>
                        <span class="help-block">Last Name, First Name, eg.: Smith, Harry</span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">Roll</label>
                    <div class="col-sm-9">
                        <input type="text" id="birthDate" name="roll" value="${students.roll}" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="country" class="col-sm-3 control-label">Grade</label>
                    <div class="col-sm-9">
                        <select id="country" class="form-control" name="grade">
                        <option selected>Choose grade</option>
                            <option value="Nursery"${students.grade=='Nursery'?'selected':''}>Nursery</option>
                            <option value="LKG"${students.grade=='LKG'?'selected':''}>LKG</option>
                            <option value="UKG"${students.grade=='UKG'?'selected':''}>UKG</option>
                            <option value="One"${students.grade=='One'?'selected':''}>One</option>
                            <option value="Two"${students.grade=='Two'?'selected':''}>Two</option>
                            <option value="Three"${students.grade=='Three'?'selected':''}>Three</option>
                            <option value="Four"${students.grade=='Four'?'selected':''}>Four</option>
                            <option value="Five"${students.grade=='Five'?'selected':''}>Five</option>
                            <option value="Six"${students.grade=='Six'?'selected':''}>Six</option>
                            <option value="Seven"${students.grade=='Seven'?'selected':''}>Seven</option>
                            <option value="Eight"${students.grade=='Eight'?'selected':''}>Eight</option>
                            <option value="Nine"${students.grade=='Nine'?'selected':''}>Nine</option>
                            <option value="Ten"${students.grade=='Ten'?'selected':''}>Ten</option>
                        </select>
                    </div>
                </div> <!-- /.form-group -->
                <div class="form-group">
                    <label for="country" class="col-sm-3 control-label">Gender</label>
                    <div class="col-sm-9">
                        <select id="country" class="form-control" name="gender">
                        <option selected>Choose gender</option>
                            <option value="Male"${students.gender=='Male'?'selected':''}>Male</option>
                            <option value="Female"${students.gender=='Female'?'selected':''}>Female</option>
                            <option value="Others"${students.gender=='Others'?'selected':''}>Others</option>
                            
                        </select>
                    </div>
                </div> <!-- /.form-group -->
                
                
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">Register</button>
                    </div>
                </div>
            </form> <!-- /form -->
        </div> <!-- ./container -->

</body>
</html>