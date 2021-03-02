<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<script type="text/javascript">
	
	 $(document).ready(function(){
			$('#write').submit(function(event) {
				event.preventDefault();
				
				var bName = $("#bName").val();
				var bTitle = $("#bTitle").val();
				var bContent = $("#bContent").val();
				
				console.log(bName);
		        console.log(bTitle);
		        console.log(bContent);
		        console.log($(this).attr("action"));    
		           
				var form = {
						bName : bName,
						bTitle : bTitle,
						bContent : bContent
				};
				
				$.ajax({
					type : "POST",
					url : $(this).attr("action"),
					cache : false,
					contentType:'application/json; charset=utf-8',
					data: JSON.stringify(form),
					success : function(result){
						console.log(result);
						if(result == "SUCCESS"){
							console.log("success");
							$(location).attr('href',"${pageContext.request.contextPath}/restful/");
							
						}
					},
					error : function(e){						
						alert("fail");
						
						console.log(e);
					}										
				});	//ajax			
			});					
		
	   }); // end ready()
	
	</script>
</head>
<body>

<table width="500" cellpadding="0" cellspacing="0" border="1">
      <form id="write" action="${pageContext.request.contextPath}/restful/write" method="POST">
         <tr>
            <td> 이름 </td>
            <td> <input type="text" name="bName" id="bName" size = "50"> </td>
         </tr>
         <tr>
            <td> 제목 </td>
            <td> <input type="text" name="bTitle" id="bTitle" size = "50"> </td>
         </tr>
         <tr>
            <td> 내용 </td>
            <td> <textarea name="bContent" id="bContent" rows="10" ></textarea> </td>
         </tr>
         <tr >
            <td colspan="2"> 
            <button type="submit">작성</button> &nbsp;&nbsp; <a href="${pageContext.request.contextPath}/restful/">목록보기</a></td>
         </tr>
      </form>
   </table>
   
</body>
</html>