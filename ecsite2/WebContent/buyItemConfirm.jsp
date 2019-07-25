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

	<title>buyItemConfirm画面</title>

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

	<script type = "text/javascript">
		function submitAction(url) {

			$('form').attr('action',url);//   formタグに 属性 actionを追加し、= url を追加
			 $('form').submit();     // これで、ただのボタンがsubmitになる ()内にはsubmit時に実行したい処理を書く
		}

	</script>





</head>
<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>


	<div id="main">

		<div id="top">
			<p>BuyItemConfirm</p>
		</div>



		<div>
			<s:form>
				<table>
					<tr>
						<td>
							<span>商品名</span>
						</td>

						<td>             <!--  Action定義したsessionの buyItem_name というキー -->
							<s:property value="session.buyItem_name" />
						</td>
					</tr>

					<tr>
						<td>
							<span>値段</span>
						</td>

						<td>
						<s:property value="session.total_price" />
							<span>円</span>
						</td>
					</tr>

					<tr>
						<td>
							<span>購入個数</span>
						</td>

						<td>
							<s:property value="session.count" />
							<span>個</span>
						</td>
					</tr>

					<tr>
						<td>
							<span>支払い方法</span>
						</td>

						<td>
							<s:property value="session.pay" />
						</td>
					</tr>


					<tr>
						<td><br></td>     <!-- ボタンとの余白を作るため -->
					</tr>




					<tr>

						<td>
						<input type = "button" value = "戻る" onclick = "submitAction('HomeAction')" />
						</td>


						<td>
						<input type = "button" value = "完了" onclick = "submitAction('BuyItemConfirmAction')" />
						</td>

					</tr>     <!-- クリックすると、submitAction()関数が実行される

					 			関数の中身は、① formタグ内に 属性actionをつくり、値を、()内の文字列に変換する
					 			              ② buttonをsubmitに-->


				</table>

			</s:form>

		</div>


		<div>
			<p>前画面に戻る場合は<a href = "<s:url action = 'GoHomeAction'/>">こちら</a></p>
			<p>マイページは<a href = "<s:url action = 'MyPageAction'/>">こちら</a></p>

		</div>

	</div>



	<div id = "footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>