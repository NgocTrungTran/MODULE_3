<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSP - Hello World</title>
</head>
<body>
<h2>fmt:formatNumber example</h2>
<c:set var="accountBalance" value="12345.6789" />
<h3>accountBalance=<c:out value="${accountBalance}"/></h3>

The Account Balance can be displayed using various ways:

<p>
  formatNumber (type='currency'):
  <strong>
    <fmt:formatNumber value="${accountBalance}" type="currency"/>
  </strong>
</p>
<p>
  formatNumber (type='number', maxIntegerDigits= '4'):
  <strong>
    <fmt:formatNumber type="number" maxIntegerDigits="4" value="${accountBalance}" />
  </strong>
</p>
<p>
  formatNumber (type='number', maxFractionDigits= '5'):
  <strong>
    <fmt:formatNumber type="number" maxFractionDigits="5" value="${accountBalance}" />
  </strong>
</p>
<p>
  formatNumber (type='number', groupingUsed= 'false'):
  <strong>
    <fmt:formatNumber type="number" groupingUsed="false" value="${accountBalance}" />
  </strong>
</p>
<p>
  formatNumber (type='percent', maxIntegerDigits= '3'):
  <strong>
    <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${accountBalance}" />
  </strong>
</p>
<p>
  formatNumber (type='percent', maxIntegerDigits= '10'):
  <strong>
    <fmt:formatNumber type="percent" minFractionDigits="10" value="${accountBalance}" />
  </strong>
</p>
<p>
  formatNumber (type='number', pattern= '###.###E0'):
  <strong>
    <fmt:formatNumber type="number" pattern="###.###E0" value="${accountBalance}" />
  </strong>
</p>
<p>
  Account Balance in USA (fmt:setLocale value='en_US'):
  <br/>
  formatNumber (type='currency'):
  <fmt:setLocale value="en_US"/>
  <strong>
    <fmt:formatNumber value="${accountBalance}" type="currency"/>
  </strong>
<p>
  Account Balance in Canada (fmt:setLocale value='fr_CA'):
  <br/>
  formatNumber (type='currency'):
  <fmt:setLocale value="fr_CA"/>
  <strong>
    <fmt:formatNumber value="${accountBalance}" type="currency"/>
  </strong>
</body>
</html>