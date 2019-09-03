<%@ page language="java"  pageEncoding="utf-8"%>
<!-- 导入JSTL标准标签库  c（core）标签-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			.boss{
				width: 600px;
				height: 400px;
				background-color: white;
				border: 2px solid black;
				position: absolute;
				left: 641px;
				top: 250px;
			}
			.box1{
				width: 600px;
				height: 25px;
				border: 2px solid black;
				border-left: none;
				border-top: none;
				
			}
			.box2{
				width: 600px;
				height: 25px;
				border: 2px solid black;
				border-left: none;
				border-top: none;
				
			}
			.a4{
				
				border: 2px solid black;
			/*	margin-left: 90px;*/
				margin-top: 20px;
			}
			span{
				margin-left: 20px;
			}
			.input3{
				width: 100px;
				background-color: white;
				border-color: black;
				
				position: absolute;
				left: 27px;
				top: 350px;
			}
			.input4{
				width: 100px;
				background-color: white;
				border-color: black;
				position: absolute;
				left: 188px;
				top: 350px;
			}
			.input5{
				border: none;
				background-color: white;
				position: absolute;
				top: 5px;
				right: 10px;
				
			}
			.input5:focus{
				display: none;
			}
			.tab{
				margin:20px;
				width:94%;
				border:1px solid #222;
				border-collapse: collapse;
			}
			.tab th{
				background: rgba(0,0,0,0.5);
			}
			.datalist:hover{
				background: rgba(0,0,0,0.2);
			}
			.tab th,
			.tab td{
				border-top: 0;
				border-bottom: 0;
				border-right: 1px solid #222;
			}
		</style>
	</head>
	<body>
		<div class="boss">
			<div class="box1">AMONIC Airlines Automation System</div>
			<div class="box2">Add user Exit</div>
			<div class="box3">
				<form>
					<div class="box4">
						<input type="submit" value="×" class="input5"/>
					</div>
					<span>office:</span>
					<select class="a4" id="selectOffice">
							<option value="0">all offices</option>
<!-- 								遍历 -->
							<c:forEach items="${offices}" var="office">	
								<option value="${office.officeID}">${office.officeName }</option>
							</c:forEach>
					</select>
					
					<table class="tab">
						<tr>
							<th>Name</th>
							<th>Last Name</th>
							<th>Age</th>
							<th>User Role</th>
							<th>Email Address</th>
							<th>Office</th>
						</tr>
						<c:forEach items="${users}" var="u" varStatus="stat">
							<c:choose>
								<c:when test="${u.user.active == 1}">
									<tr style="background-color: #0f0" class="datalist" data-index="${stat.index}" data-active="${u.user.active }" data-email="${u.user.email}">
								</c:when>
								<c:otherwise>
									<tr style="background-color: #f00" class="datalist" data-index="${stat.index}" data-active="${u.user.active }" data-email="${u.user.email}">
								</c:otherwise>
							</c:choose>
								<td>${u.user.firstName }</td>
								<td>${u.user.lastName }</td>
								<td>${u.age }</td>
								<td>${u.user.role }</td>
								<td>${u.user.email }</td>
								<td>${u.office.officeName }</td>
							</tr>
						</c:forEach>
						
					</table>
					
					<input type="button" value="Change Role" onclick="location.href='3.html'"  class="input3"/>
					<input type="button" value="Enable/Disable Login" id="input4"  class="input4"/>
				</form>
			</div>
		</div>
		<script>
			//为下拉列表设置value，如果在列表中有对应的项，则默认选中该项
			document.getElementById('selectOffice').value='${officeID}';
			
			document.getElementById('selectOffice').addEventListener('change', function(){
				//获取被选择的officeID
				var id = this.value;
				
				//页面跳转
				location.href='doQueryByOffice.jsp?officeID='+id;
			});
			
			/****点击列表项背景高亮****/
			var index = -1;
			//获取所有的数据列表项对应dom对象(标签、元素)
			var dataList = document.querySelectorAll('.datalist');
			for(var i = 0;i<dataList.length;i++){				
				dataList[i].addEventListener('click', function(){
					if(index != -1){
						//还原之前被选中的列表项的背景
						dataList[index].style.backgroundColor='';
					}
					//记录被点击的列表项对应的索引 data-* h5
					index = this.dataset.index;
					this.style.backgroundColor='#ddd';
				});
			}
			
			//为(禁用/启用)按钮绑定点击事件
			document.getElementById('input4').addEventListener('click', function(){
				if(index != -1){					
					//获取需要修改状态的邮箱
					var email = dataList[index].dataset.email;
					//获取用户的账户状态
					var active = dataList[index].dataset.active;
					//获取选择的officeID(页面跳转回来时保留选择的office)
					var officeID = document.getElementById('selectOffice').value;
					if(window.confirm('Are Your Sure?')){
						location.href='doChangeState.jsp?email='+email+'&active='+active+'&officeID='+officeID;
					}
				}else{
					alert('Please Select User');
				}
			})
		</script>
	</body>
</html>
