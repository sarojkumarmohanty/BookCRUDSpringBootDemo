<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Entry Form</title>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>  
<script src = "https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>  
<script src = "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>  
<script src = "https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>  
 
<link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css">  
</head>
<body>

	<div class="container" style="margin-top:30px">

		<div>
			<c:if test="${not empty book}">
				<p class="alert alert-success">Book is saved with Id : ${book.bookId} </p>
			</c:if>
		</div>

		<h3 class="text-primary">Book Entry Form</h3>
		<form class="form-group" method="post" action="./saveBook"
			id="saveBookform" enctype="multipart/form-data">
			<input type="hidden" name="bookId" id="bookId" value="${uBook.bookId}">
			<div class="row">
				<div class="col-md-4">
					<lable class="text-warning font-weight-bold">Title<sup
						class="text-danger">*</sup></lable>
					<input type="text" name="title" id="titleId" class="form-control" value="${uBook.title}">
				</div>
				<div class="col-md-3">
					<lable class="text-warning font-weight-bold">Book Image</lable>
					<input type="file" name="bookImagePath" id="bookImageId" value="${uBook.bookImagePath}"
						>
				</div>
				<div class="col-md-4">
					<lable class="text-warning font-weight-bold">Author Name<sup
						class="text-danger">*</sup></lable>
					<input type="text" name="authorName" id="authorNameId"
						class="form-control" value="${uBook.authorName}">
				</div>

			</div>


			<div class="row">
				<div class="col-md-4">
					<lable class="text-warning font-weight-bold">Publisher Id<sup
						class="text-danger">*</sup></lable>
					<input type="text" name="publisherId" id="publisherId"
						class="form-control" value="${uBook.publisherId}">
				</div>
				<div class="col-md-3">
					<lable class="text-warning font-weight-bold">Publication
					Date</lable>
					<input type="text" name="publicationDate" id="publicationDateId"
						class="form-control date dp" value="${uBook.publicationDate}">
				</div>
				<div class="col-md-4">
					<lable class="text-warning font-weight-bold">Price</lable>
					<input type="text" name="price" id="priceId" class="form-control" value="${uBook.price}">
				</div>
			</div>
			
			<div class="text-center " style="margin-top:25px">
				<input type="submit" class="btn btn-success" <c:if test="${uBook ne null}">value='Update'</c:if>> <input
					class="btn btn-warning" type="reset" value="Reset">
			</div>
		</form>


		${uBook}
		<div class="h3"></div>
		<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Sl#</th>
							<th>Book Id</th>
							<th>Title</th>
							<th>Author Name</th>
							<th>Publisher Id</th>
							<th>Publication Date</th>
							<th>Price</th>
							<th>BookImage</th>
							<th>Action</th>
						</tr>
					
					</thead>
					<tbody>
						<c:forEach var="bl" items="${bookList}" varStatus="counter">
						<tr>
							<td>${counter.count}</td>
							<td>${bl.bookId}</td>
							<td>${bl.title}</td>
							<td>${bl.authorName}</td>
							<td>${bl.publisherId}</td>
							<td><fmt:formatDate pattern="dd/MM/yy" value="${bl.publicationDate}" /></td>
							<td>${bl.price}</td>
							<td><a href="http://localhost:8080/BookCrud/download?file_path=${bl.bookImagePath}">${bl.bookImagePath}</a></td>
							<td><a href="http://localhost:8080/BookCrud/updateBook?bookId=${bl.bookId}">update</a></td>
						</tr>
						</c:forEach>
					
					</tbody>
				
				
				</table>
		<c:forEach var="v" begin="0" end="${total/2-1}" step="1">
			<a class="btn btn-success" href="http://localhost:8080/BookCrud/bookEntryForm?pageNo=${v}">${v+1} &nbsp;</a>
		</c:forEach> 
	</div>

</body>

<script type="text/javascript">


$(document).ready(function() {
	$(".dp").datetimepicker({
        "format": "DD-MM-YYYY" /* HH:mm:ss */

    });
});
 


</script>
</html>