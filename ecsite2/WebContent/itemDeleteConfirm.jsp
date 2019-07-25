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


	<script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>  <!--  JQ -->

	<title>商品削除確認</title>

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




	form {
		display: inline-block;
		margin: 0 10px;

	}

	</style>


	<script type = "text/javascript">

		function submitAction(url) {

			$ ("form").attr("action", url);
			$ ("form").submit();
		}

	</script>

</head>
<body>


	<div id = "header">
		<div id = "pr">
		</div>
	</div>




	<div id = "main">
		<div id = "top">
			<p>商品削除確認</p>
		</div>


		<h3>商品ID [<s:property value = "id"/>]の商品を削除します。本当によろしいですか？</h3>



		<form>

			<input type = "button" value = "ＯＫ" onclick = "submitAction('ItemDeleteCompleteAction')" />

			<input type = "button" value = "キャンセル" onclick = "submitAction('ItemDetailsAction')" />



			<s:hidden name = "id" value = "%{id}" />
		<!--  value = "%{}"が使えるのはSタグだけ -->
		</form>



	</div>

	<div id = "footer">
		<div id = "pr">
		</div>
	</div>
</body>
</html>





























