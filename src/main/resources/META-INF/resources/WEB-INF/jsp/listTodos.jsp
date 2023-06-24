<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
  <div class="container">
      <h1> Your Todo List </h1>
      <hr>
      <table class="table">
       <thead>
          <tr>
             <th>Id</th>
             <th>Name</th>
             <th>Description</th>
             <th>LocalDate</th>
             <th>Done</th>
             <th>Delete</th>
             <th>Update</th>
          </tr>
       </thead>
       <tbody>
          <c:forEach items="${todos}" var="todo">
            <tr>
             <td>${todo.id}</td>
             <td>${todo.userName}</td>
             <td>${todo.description}</td>
             <td>${todo.localDate}</td>
             <td>${todo.done}</td>
             <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning"> Delete </a> </td>
             <td> <a href="update-todo?id=${todo.id}" class="btn btn-success"> Update </a> </td>
          </tr>
          </c:forEach>
       </tbody>
      </table>
      <a href="add-todo" class="btn btn-success"> Add Todos</a>
      </div>
<%@ include file="common/footer.jspf" %>
      
      
      
      
      