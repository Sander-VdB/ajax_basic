<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
{ headings: ["Naam", "BTW"],
  customers: [
  <c:forEach var="customer" items="${customers}" varStatus="status">
    ["${customer.naam}","${customer.btw}"]
    <c:if test="${!status.last}">,</c:if>
  </c:forEach>
  ]
}
