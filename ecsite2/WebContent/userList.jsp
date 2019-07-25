<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />

	<meta name="description" content="" />
	<meta name="keywords" content="" />

	<title>UserList</title>

	<style type="text/css">


	body {
		margin: 0;
		padding: 0;
		line-height: 1.6;
		letter-spacing: 1px;
		font-family: Verdana,Helvetica, sans-serif;
		font-size: 12px;
		color: #333;
		background: #fff;
	}


	table {
		text-align: center;
		margin: 0 auto;
	}


	#top {
		width: 780px;
		margin: 30px auto;
		border: 1px solid #333;
	}

	#header {
		width: 100%;
		height: 80px;
		background-color: black;
	}


	#main {
		width: 100%;
		height: 500px;
		text-align: center;
	}


	#footer {
		width: 100%;
		height: 80px;
		background-color: black;
		clear: both;
	}


	 text-right {
		display: inline-block;
		text-align: right;
		}

	</style>
</head>
<body>


	<div id = "header">
		<div id = "pr">
		</div>
	</div>




	<div id = "main">

		<div id = "top">
			<p>UserList</p>
		</div>


		<div>

				<h3>ユーザー情報は以下になります。</h3>



				<table border = "1">
					<tr>

						<th>ログインID</th>
						<th>ログインPASS</th>
						<th>ユーザー名</th>
						<th>登録日時</th>
						<th style = "padding: 0px 12px;">詳細</th>

					</tr>


					<s:iterator value = "userList">
					<tr>

						<td><s:property value = "loginId" /></td>
						<td><s:property value = "loginPass" /></td>
						<td><s:property value = "userName" /></td>
						<td><s:property value = "insertDate" /></td>
						<td><a href = "

							<s:url action = 'UserDetailsAction'>
								<s:param name= "loginId" value = "%{loginId}"/>
							</s:url>">詳細へ
							</a>
						</td>
					</tr>
					</s:iterator>


				</table>


				<br>

				<div>
					<s:form action = "UserListDeleteConfirmAction">

						<s:submit value = "削除" />

					</s:form>

				</div>




				<div id = "text-right">

					<p>管理者画面へ戻る場合は<a href = "<s:url action = 'AdminAction'/>">こちら</a></p>

				</div>










		</div>
	</div>





	<div id = "footer">
		<div id = "pr">
		</div>
	</div>
</body>
</html>





























