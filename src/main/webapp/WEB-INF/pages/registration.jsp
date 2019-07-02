<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>RegistrationPage</title>
    <script src="/script/form_validation.js"></script>
</head>
<body>
    <div class="registration-form-div">
        <h3><spring:message code="Registration.sen"/></h3>
        <springForm:form action="/sign up" method="POST" modelAttribute="User" enctype="multipart/form-data">
            <div class="form-group">
                <spring:bind path="name">
                <spring:message code="name.sen"/>:
                <springForm:input path="name" type="text" pattern="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$"
                                  title="Should not contain anything superfluous"
                                  cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                  id="nameForm" placeholder="Veronica" cssStyle="width: 45%"/>
                <springForm:errors path="name" id="nameError" cssClass="errormsg" />
                </spring:bind>
            </div>
             <div class="form-group">
                 <spring:bind path="sername">
                 <spring:message code="sername.sen"/>:
                 <springForm:input path="sername" type="text" pattern="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$"
                                   title="Should not contain anything superfluous"
                                   cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                   id="sernameForm" placeholder="Vitrovich" cssStyle="width: 65%"/>
                 <springForm:errors path="sername" id="sernameError" cssClass="errormsg" />
                 </spring:bind>
             </div>
             <div class="form-group">
                 <spring:bind path="middlename">
                 <spring:message code="middlename.sen"/>:
                 <springForm:input path="middlename" type="text" pattern="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$"
                                   title="Should not contain anything superfluous"
                                   class="form-control ${status.error ? 'is-invalid' : ''}"
                                   id="middlenameForm" placeholder="Valerivna" cssStyle="width: 65%"/>
                 <springForm:errors path="middlename" id="middlenameError" cssClass="errormsg" />
                 </spring:bind>
             </div>
             <div class="form-group">
                 <spring:bind path="phone">
                 <spring:message code="Telephone.number.sen"/>:
                 <springForm:input path="phone" type="text"  title="Must contain twelve digits" pattern="^[1-9]\d{11}$"
                                   class="form-control ${status.error ? 'is-invalid' : ''}"
                                   id="phoneForm" placeholder="380XXXXXXXXX" cssStyle="width: 33%"/>
                 <springForm:errors path="phone" id="phoneError" cssClass="errormsg" />
                 </spring:bind>
             </div>
             <div class="form-group">
                 <spring:bind path="email">
                 <spring:message code="email.sen"/>:
                 <springForm:input path="email" type="text" pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,3}$"
                             title="Must contain real email" class="form-control ${status.error ? 'is-invalid' : ''}"
                             id="emailForm" placeholder="example121@gmail.com" cssStyle="width: 65%"/>
                 <springForm:errors path="email" id="emailError" cssClass="errormsg" />
                 </spring:bind>
             </div>
             <div class="form-group">
                 <spring:bind path="address.city">
                 <spring:message code="city.sen"/>:
                 <springForm:input path="address.city" type="text" pattern="^[a-zA-Z]+(?:[\s-][a-zA-Z]+)*$"
                                   title="Must contain city name" class="form-control ${status.error ? 'is-invalid' : ''}"
                                   id="addressCityForm" placeholder="New-York" cssStyle="width: 45%"/>
                 <springForm:errors path="address.city" id="addressCityError" cssClass="errormsg" />
                 </spring:bind>
             </div>
            <div class="form-group">
                <spring:bind path="address.street">
                <spring:message code="street.sen"/>:
                <springForm:input path="address.street" type="text" pattern="^[a-zA-Z]+(?:[\s-][a-zA-Z]+)*$"
                                  title="Must contain street name" class="form-control ${status.error ? 'is-invalid' : ''}"
                                  id="addressStreetForm" placeholder="Great Jones" cssStyle="width: 45%"/>
                <springForm:errors path="address.street" id="addressStreetError" cssClass="errormsg" />
                </spring:bind>
            </div>
           <div class="form-group">
                <spring:bind path="address.house">
                <spring:message code="house.sen"/>:
                <springForm:input path="address.house" type="text" pattern="^\d+[a-zA-Z]{0,1}$"
                                  title="Must contain house number" class="form-control ${status.error ? 'is-invalid' : ''}"
                                  id="addressHouseForm" placeholder="32A" cssStyle="width: 15%"/>
                <springForm:errors path="address.house" id="addressHouseError" cssClass="errormsg" />
                </spring:bind>
            </div>
             <div class="form-group">
                 <spring:bind path="address.apartment">
                <spring:message code="apartment.sen"/>:
                <springForm:input path="address.apartment" type="text" title="Must contain apartment number" pattern="\d*"
                                  class="form-control ${status.error ? 'is-invalid' : ''}"
                                  id="address.apartmentForm" placeholder="123" cssStyle="width: 15%"/>
                <springForm:errors path="address.apartment" id="address.apartmentError" cssClass="errormsg" />
                 </spring:bind>
            </div>
            <div class="form-group">
                <spring:bind path="login">
                <spring:message code="login.sen"/>:
                <springForm:input path="login" type="text" pattern="^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\d.-]{1,20}$"
                                  title="The size should be from 2 to 20 inclusive"
                                  class="form-control ${status.error ? 'is-invalid' : ''}"
                                  id="loginForm" placeholder="Veronica123" cssStyle="width: 62%"/>
                <springForm:errors path="login" id="loginError" cssClass="errormsg" />
                </spring:bind>
            </div>
            <div class="form-group">
            <spring:bind path="password">
                <spring:message code="password.sen"/>:
                <springForm:input path="password" type="password"
                                  title="The size should be not less then 6 and contain
                                   at least one upper case English letter and one digit" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,}$"
                                  class="form-control ${status.error ? 'is-invalid' : ''}"
                                  id="passwordForm" placeholder="Ydf4ss2f5j" cssStyle="width: 62%"/>
                <springForm:errors path="password" id="passwordError" cssClass="errormsg" />
            </spring:bind>
            </div>
            <div class="form-group">
                    Confirm password:
                    <input type="password" placeholder="Ydf4ss2f5j" class="form-control" id="confirmPasswordForm" style="width: 62%"/>
            </div>
             <input type="submit" id="submitForm" class="btn btn-primary" value=<spring:message code="Submit.but"/>>
         </springForm:form>
     </div>

 </body>
 </html>
