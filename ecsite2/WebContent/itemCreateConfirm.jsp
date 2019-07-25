<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品登録確認</title>


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

	</style>




</head>
<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>




	<div id="main">

		<div id="top">
			<p>ItemCreateConfirm</p>
		</div>


		<div>
			<s:if test="errorMessage != '' ">
				<s:property value = "errorMessage" escape = "false" />
			</s:if>


			<table>
			<s:form action = "ItemCreateCompleteAction">

				<tr>
					<td>
						<label>商品名：</label>
					</td>

					<td>
						<s:property value = "itemName" />
					</td>
				</tr>


				<tr>
					<td>
						<label>商品価格：</label>
					</td>

					<td>
						<s:property value = "itemPrice" />円
					</td>
				</tr>

				<tr>
					<td>
						<label>商品在庫数：</label>
					</td>

					<td>
						<s:property value = "itemStock" />個
					</td>
				</tr>









				<s:submit value="登録" />









			</s:form>

			</table>

		</div>




	</div>





	<div id="footer">
		<div id="pr">
		</div>
	</div>




</body>
</html>