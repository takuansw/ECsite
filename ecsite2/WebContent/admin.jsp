<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者画面</title>


<style>

body {

	margin:0;
	padding:0;
	text-align: center;
	font-size: 12px;
	}


#header {
	width: 100%;
	height: 80px;
	background-color: black;

	}



#top {
 	margin: 30px auto;
 	width: 780px;
 	border: 1px solid #333;
 	}


#main {
		width: 780px;
		height: 426px;
		margin: 0 auto;

	}



h3 {
	margin-bottom: 20px;
	}


#form {
	border: 1px dashed #333;

	width: 300px;
	margin: 0 auto;
	margin-bottom: 50px;
	padding: 30px 0px;

}


#left {
 	float: left;
	width: 50%;
	text-align: center;
	}





#right {
 	float: right;
	width: 50%;
	text-align: center;
	}


#back {
	clear: both;

}


 #footer {

 	width: 100%;
	height: 80px;
	background-color: black;


 }











</style>


</head>


<body>



	<div id = "header">
	</div>



	<div id = "top">
		<p>管理者画面</p>
	</div>



	<div id = "main">

		<div id = "left">

			<h3>商品管理</h3>

			<div id = form>

				<form action = "ItemCreateAction">
					<input type = submit value = "新規登録">
				</form>

					<br><br>

				<form action = "ItemListAction">
					<input type = submit value = "一覧">
				</form>

			</div>


		</div>




		<div id = "right">

			<h3>ユーザー管理</h3>


			<div id = form>

				<form action = "UserCreateAction">
					<input type = submit value = "新規登録">
				</form>

					<br><br>

				<form action = "UserListAction">
					<input type = submit value = "一覧">
				</form>


			</div>

			<%-- <div id = "back">
			ホーム画面へ戻る場合は
			<a href = "<s:url action = 'GoHomeAction' /> ">こちら</a>

			</div> --%>


		</div>


		<div id = "back">
			ホーム画面へ戻る場合は
			<a href = "<s:url action = 'GoHomeAction' /> ">こちら</a>

		</div>






	</div>






	<div id = "footer">

	</div>






</body>
</html>