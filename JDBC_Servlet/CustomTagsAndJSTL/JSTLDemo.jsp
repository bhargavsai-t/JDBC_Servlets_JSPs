<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>JSTL Demo</title>
    </head>
    <body>
        <c:out value="${10+9}" />
        <br />
        <c:set var="score" scope="session" value="${100}"></c:set>
        Score:
        <c:out value="${score}" />
        <br />
        <c:if test="${score>=80 }">
            <p>Hello</p>
        </c:if>
        <%
        List<string> studentNames = new ArrayList<>();
            studentNames.add("Sri Rama");
            studentNames.add("Sita Rama");
            studentNames.add("Laxmana Rama");
            studentNames.add("Hanumath Rama");
            request.setAttribute("studentNames", studentNames);
            %>
            <c:choose>
                <c:when test="${score>80}">
                    <p>O Grade</p>
                </c:when>
                <c:when test="${score>=70}">
                    <p>A+ Grade</p>
                </c:when>
                <c:when test="${score>50}">
                    <p>A Grade</p>
                </c:when>
                <c:otherwise>
                    <p>Fail</p>
                </c:otherwise>
            </c:choose>
            <c:remove var="score" />
            Score:
            <c:out value="${score}" /><br />
            <br />
            <c:foreach var="i" begin="1" end="5">
                <c:out value="${i}" /><br />
            </c:foreach>
            <c:foreach var="studentName" items="${studentNames}">
                <c:out value="${studentName}" /><br />
            </c:foreach>
            <c:set var="accountBalance" value="12345.5678" />
            <fmt:parsenumber var="i" type="number" value="${accountBalance}" />
            AccountBalance: <c:out value="${i}" /><br />
            Formatted Number: <fmt:formatnumber value="${accountBalance}"
                type="currency" /><br />
            Formatted Number: <fmt:formatnumber value="${accountBalance}"
                type="number" maxFractionDigits="2" /><br />
            Formatted Number: <fmt:formatnumber value="${accountBalance}"
                type="number" maxIntegerDigits="2" /><br />
            Formatted Number: <fmt:formatnumber value="${accountBalance}"
                type="percent" /><br />
            <c:set var="myDate" value="12-07-2019" />
            <fmt:parsedate var="parseDate" value="${myDate}"
                pattern="dd-mm-yyyy" />
            ParseDate: <c:out value="${parseDate}" />
        </body>
    </html>