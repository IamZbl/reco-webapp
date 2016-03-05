<%@taglib prefix="core" uri="/core" %>

<html>
<head>
    <title>Product</title>
</head>
<body>

<h2>Products:</h2>
  
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
	  <th>Action</th>
      </tr>
      <core:forEach items="${productAppObjects}" var="current">
        <tr>
          <td><core:out value="${current.name}" /></td>
          <td><core:out value="${current.productCode}" /></td>
		  <td><core:out value="${current.category}" /></td>
		  <td><core:out value="${current.engine}" /></td>
          <td><core:out value="${current.milage}" /></td>
          <td><core:out value="${current.year}" /></td>
          <td><core:out value="${current.maxp}" /></td>
          <td><core:out value="${current.country}" /></td>
          <td><core:out value="${current.notes}" /></td>
		   <td><a href='/reco-webapp/findProduct.do?query=${current.productCode}' >Edit</a></td>
		    <td><a href='/reco-webapp/findProductWithReco.do?query=${current.productCode}' >Details</a></td>
		<!-- <td><input type="button" name="Edit" value="Edit" onclick='productEdit("${current.productCode}")' /></td>-->
		</tr>
        
      </core:forEach>
    </table>
<br/>
<br/>
<a href='/reco-webapp/newProduct.do' >Add New Product</a>
</body>
</html>