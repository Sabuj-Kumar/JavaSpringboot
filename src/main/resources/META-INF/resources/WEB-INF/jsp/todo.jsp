      <%@ include file="common/header.jspf" %>
      <%@ include file="common/navigation.jspf" %>
      <div class="container">
      <h1> Enter Todo Details </h1>
      <hr>
      <form:form method="post" modelAttribute="todo">
      
         <fieldSet class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
         </fieldSet>
     
         <fieldSet class="mb-3">
            <form:label path="localDate">Local Date</form:label>
            <form:input type="text" path="localDate" required="required"/>
            <form:errors path="localDate" cssClass="text-warning"/>
         </fieldSet>
         
         <form:input type="hidden" path="id"/>
         <form:input type="hidden" path="done"/>
         <input type="submit" class="btn btn-success"/>
      </form:form>
      </div>
      
    <%@ include file="common/footer.jspf" %>
<script type="text/javascript">
       $('#localDate').datepicker({
         format: 'yyyy-mm-dd',
         startDate: '-3d'
      });
 </script>

