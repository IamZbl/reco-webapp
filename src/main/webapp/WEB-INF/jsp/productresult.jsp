<%@taglib prefix="c" uri="/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

<h2>Product Information</h2>
   <table>
    <tr>
        <td>Name:</td>
        <td><c:out value="${productAppObject.name}" /></td>
    </tr>
    <tr>
        <td>Product Code:</td>
        <td><c:out value="${productAppObject.productCode}" /></td>
    </tr>
    <tr>
        <td>Category:</td>
        <td><c:out value="${productAppObject.category}" /></td>
    </tr>
	<tr>
        <td>Engine:</td>
        <td><c:out value="${productAppObject.engine}" /></td>
    </tr>
  <tr>
        <td>Milage:</td>
        <td><c:out value="${productAppObject.milage}" /></td>
    </tr>
	  <tr>
        <td>Year:</td>
        <td><c:out value="${productAppObject.year}" /></td>
    </tr>
	  <tr>
        <td>Max Passenger:</td>
        <td><c:out value="${productAppObject.maxp}" /></td>
    </tr>
	 <tr>
        <td>Country:</td>
        <td><c:out value="${productAppObject.country}" /></td>
    </tr>
	 <tr>
        <td>Notes:</td>
        <td><c:out value="${productAppObject.notes}" /></td>
    </tr>
    
</table>  
<h2>Recommended Products</h2>
 <table border="1">
 <tr>
      <th>Name</th>
      <th>Product Code</th>
	  <th>Category</th>
	  <th>Engine</th>
	  <th>Milage</th>
	   <th>Year</th>
	  <th>Max Passenger</th>
	  <th>Country</th>
	  <th>Notes</th>
      </tr>
      <c:forEach items="${recommendedProductAppObjects}" var="current">
        <tr>
          <td><c:out value="${current.name}" /></td>
          <td><c:out value="${current.productCode}" /></td>
		  <td><c:out value="${current.category}" /></td>
		  <td><c:out value="${current.engine}" /></td>
          <td><c:out value="${current.milage}" /></td>
          <td><c:out value="${current.year}" /></td>
          <td><c:out value="${current.maxp}" /></td>
          <td><c:out value="${current.country}" /></td>
          <td><c:out value="${current.notes}" /></td>
        </tr>
        
      </c:forEach>
    </table>

	 <br/>
   <br/>
    <td><a href='/reco-webapp/product.do' >Home</a></td>
</body>
</html>