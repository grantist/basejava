<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.javops.webapp.model.ContactType" %>
<%@ page import="com.javops.webapp.model.ListSection" %>
<%@ page import="com.javops.webapp.model.OrganizationSection" %>
<%@ page import="com.javops.webapp.model.SectionType" %>
<%@ page import="com.javops.webapp.util.DateUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="resume" type="com.javops.webapp.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <form method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <dl>
            <dt>Имя:</dt>
            <dd><input type="text" name="fullName" size=70 value="${resume.fullName}"></dd>
        </dl>

        <h3>Контакты:</h3>
        <c:forEach var="type" items="<%=ContactType.values()%>">
            <dl>
                <dt>${type.title}</dt>
                <dd><input type="text" name="${type.name()}" size=50 value="${resume.getContact(type)}"></dd>
            </dl>
        </c:forEach>
        <hr>
        <c:forEach var="type" items="<%=SectionType.values()%>">
            <c:set var="section" value="${resume.getSection(type)}"/>
            <jsp:useBean id="section" type="com.javops.webapp.model.Section"/>
            <h2><a>${type.title}</a></h2>
            <c:choose>
                <c:when test="${type=='OBJECTIVE'}">
                    <input type='text' name='${type}' size=75 value='<%=section%>'>
                </c:when>
                <c:when test="${type=='PERSONAL'}">
                    <textarea name='${type}' cols=75 rows=5><%=section%></textarea>
                </c:when>

                <c:when test="${type=='QUALIFICATIONS' || type=='ACHIEVEMENT'}">
                    <textarea name='${type}' cols=75
                              rows=5><%=String.join("\n", ((ListSection) section).getItems())%></textarea>
                </c:when>

                <c:when test="${type=='EXPERIENCE' || type=='EDUCATION'}">
                    <c:forEach var="organisation" items="<%=((OrganizationSection) section).getOrganizations()%>"
                               varStatus="counter">
                        <dl>
                            <dt>Организация:</dt>
                            <input type="text" name='${type}' size=70 value="${organisation.homePage.name}">
                        </dl>
                        <dl>
                            <dt>Сайт:</dt>
                            <input type="text" name='${type}url' size=70 value="${organisation.homePage.url}">
                        </dl>
                        <br>
                        <c:forEach var="position" items="${organisation.positions}">
                            <jsp:useBean id="position" type="com.javops.webapp.model.Organization.Position"/>
                            <dl>
                                <dt>Начало работы:</dt>

                                <input type="text" name="${type}${counter.index}startDate" size=10
                                       value="<%=DateUtil.format(position.getStartDate())%>" placeholder="MM/yyyy">
                            </dl>
                            <dl>
                                <dt>Конец работы:</dt>

                                <input type="text" name="${type}${counter.index}endDate" size=10
                                       value="<%=DateUtil.format(position.getEndDate())%>" placeholder="MM/yyyy">
                            </dl>
                            <dl>
                                <dt>Должность:</dt>
                                <input type="text" name='${type}${counter.index}title' size=75
                                       value="${position.title}">
                            </dl>
                            <dl>
                                <dt>Обязанности:</dt>
                                <textarea name="${type}${counter.index}description" rows=5
                                          cols=75>${position.description}</textarea>
                            </dl>
                        </c:forEach>
                    </c:forEach>
                </c:when>
            </c:choose>
        </c:forEach>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>