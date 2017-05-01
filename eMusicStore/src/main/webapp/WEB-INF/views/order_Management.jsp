<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container-wrapper">
    <div class="container" ng-app = "orderApp">
        <div class="page-header">
            <h1>Order Management Page</h1>

            <p class="lead">This is the Order management page.</p>
        </div>
        <table class="table table-striped table-hover" ng-controller="orderCtrl">
            <thead>
            <tr class="bg-success">
                <th>User Name</th>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Shipping</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:forEach items="${pOrders}" var="pOrder">
            <c:if test="${pOrder.status eq false}">
                <tr id="${pOrder.id}">
                    <td>${pOrder.customerName}</td>
                    <td>${pOrder.productname}</td>
                    <td>${pOrder.quantity}</td>
                    <td>${pOrder.shippingAdress}</td>
                    <td><p class="text text-info">Pending</p></td>
                    <td><a href="#" class="btn btn-success"
                           ng-click="acceptOrder(${pOrder.customerid},${pOrder.id}, ${pOrder.productid});"><span
                                class="glyphicon glyphicon-ok"></span>Accept</a>
                    </td>
                </tr>
            </c:if>
            </c:forEach>
        </table>
        
        <script src="<c:url value="/resources/js/controller.js" /> "></script>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
