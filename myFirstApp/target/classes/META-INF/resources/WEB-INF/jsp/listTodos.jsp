  <%@include file ="common/header.jspf" %>
 <%@include file ="common/navigation.jspf" %>
    
    <div class ="container">
       
        <h1>your todos</h1>
        <table class="table">
        <thead>
        <tr>
	        
	        <th>Description</th>
	        <th>TargetDate</th>
	        <th>Is Done?</th>
	         <th></th>
	         <th></th>
	        
        </tr>
        </thead>
        <tbody>
         <c:forEach  items ="${todos}" var ="todos">
         <tr>
	        
	        <td>${todos.description}</td>
	        <td>${todos.targetDate}</td>
	        <td>${todos.done}</td>
	        <td><a href="delete-todo?id=${todos.id}" class ="btn btn-warning"> delete</a></td>
	        <td><a href="update-todo?id=${todos.id}" class ="btn btn-success"> update</a></td>
        </tr>
         </c:forEach>
         </tbody>
        </table>
        <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div> 
        <%@include file ="common/footer.jspf" %>