<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--[if IE 8 ]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9 ]> <html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>约练注册</title>


<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<![endif]-->

<link href="css/normalize.css" rel="stylesheet" />
<link href="css/jquery-ui.css" rel="stylesheet" />
<link href="css/jquery.idealforms.min.css" rel="stylesheet"
	media="screen" />

<style type="text/css">
body {
	font: normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;
	color: #222;
	background: url(pattern.png);
	overflow-y: scroll;
	padding: 0 0 0 0;
}

#my-form {
	width: 755px;
	margin: 0 auto;
	border: 1px solid #ccc;
	padding: 3em;
	border-radius: 3px;
	box-shadow: 0 0 2px rgba(0, 0, 0, .2);
}

#comments {
	width: 350px;
	height: 100px;
}
</style>
</head>
<body onload="$('#newsangdiv').hide();$('#oldsangdiv').hide();$('#yidongdiv').hide();">
	<div class="cf"></div>

	<div class="row">

		<div class="eightcol last">

			<!-- Begin Form -->

			<form id="my-form">

				<section name="第一步">
				<div>
					<label>用户名:</label><input id="username" name="username" type="text" />
				</div>
				<div>
					<label>密码:</label><input id="pass" name="password" type="password" />
				</div>
				<div>
					<label>确认密码:</label><input id="repass" name="repassword" type="password" />
				</div>
				<div>
					<label>邮箱:</label><input id="email" name="email"
						data-ideal="required email" type="email" />
				</div>
				<div>
					<label>您是:</label> <label><input type="radio"
						value="coachradio" name="coachradio" onclick="checkstudent(this);"
						checked />教练</label> <label><input type="radio"
						value="studentradio" onclick="checkstudent(this);"
						name="studentradio" />学员</label>
				</div>
				<div>
					<label>出生日期:</label><input name="date" class="datepicker"
						data-ideal="date" type="text" placeholder="月/日/年" />
				</div>
				<div>
					<label>上传头像:</label><input id="file" name="file" multiple
						type="file" />
				</div>
				</section>

				<section name="第二步">
				<div id="coachdiv">
					<div id="subjects">
						<label>科目:</label> <label><input type="checkbox"
							name="subject[]" value="subjecttwo" />科目二</label> <label><input
							type="checkbox" name="subject[]" value="subjectthree" />科目三</label> <label><input
							type="checkbox" name="subject[]" value="subjectsparring" />陪练</label>
					</div>
					<div>
						<div>
							<label>教练证号:</label><input id="coachcardnumber"
								name="coachcardnumber" type="text" />
						</div>
						<div>
							<label>上传教练证图片:</label><input id="coachfile" name="coachfile"
								multiple type="file" />
						</div>
					</div>
				</div>
				<div id="studentdiv" style="display: none;">
					<div>
						<div>
							<label>学员证号:</label><input id="studentcardnumber"
								name="studentcardnumber" type="text" />
						</div>
						<div>
							<label>上传学员证图片:</label><input id="studentfile" name="studentfile"
								multiple type="file" />
						</div>
					</div>
				</div>
				<div>
					<div>
						<label>身份证号:</label><input id="idcardnumber" name="idcardnumber"
							type="text" />
					</div>
					<div>
						<label>上传身份证图片:</label><input id="idcardfile" name="idcardfile"
							multiple type="file" />
					</div>
				</div>
				</section>

				<section id="third" name="第三步">
				<div>
					<label>车辆信息:</label> <label><input id="carnewsang"
						type="checkbox" onclick="clickcartype(this)" name="carnewsang"
						value="carnewsang" />新桑塔纳</label> <label><input id="caroldsang"
						type="checkbox" name="caroldsang" value="caroldsang"
						onclick="clickcartype(this)" />老桑塔纳</label> <label><input
						type="checkbox" name="caryidong" id="caryidong" value="caryidong"
						onclick="clickcartype(this)" />长安逸动</label>
				</div>
				<div id="newsangdiv">
					<label>新桑塔纳车牌号：</label><input type="text" name="newsangnumber" />
				</div>
				<div id="oldsangdiv">
					<label>旧桑塔纳车牌号：</label><input type="text" name="oldsangnumber" />
				</div>
				<div id="yidongdiv">
					<label>长安逸动车牌号：</label><input type="text" name="yidongnumber" />
				</div>
				</section>

				<div>
					<hr />
				</div>

				<div>
					<button type="submit">提交</button>
					<button id="reset" type="button">重置</button>
				</div>

			</form>

			<!-- End Form -->

		</div>

	</div>


	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/jquery.idealforms.js"></script>
	<script type="text/javascript">
		function postDate(){
			if($('#username').val().length==0){
				alert('用户名不能为空');
				return;
			}
			if($('#pass').val().length==0){
				alert('密码不能为空');
				return;
			}
			if($('#repass').val().length==0){
				alert('确认密码不能为空');
				return;
			}
		}
	
	
		function clickcartype(checkbox) {
			if (checkbox.name == "carnewsang") {
				if (checkbox.checked == true) {
					$('#newsangdiv').show();
				} else {
					$('#newsangdiv').hide();
				}
			} else if (checkbox.name == "caroldsang") {
				if (checkbox.checked == true) {
					$('#oldsangdiv').show();
				} else {
					$('#oldsangdiv').hide();
				}
			} else if (checkbox.name == "caryidong") {
				if (checkbox.checked == true) {
					$('#yidongdiv').show();
				} else {
					$('#yidongdiv').hide();
				}
			}
		}
		function checkstudent(radio) {
			console.log("radio:" + radio.checked);
			radio.checked = true;
			if (radio.name == 'coachradio') {
				$("radio[name='studentradio']").checked = false;
				$("#studentdiv").css('display', 'none');
				$("#coachdiv").css('display', '');
				var ulnumber=$("ul li:eq(2)");
				ulnumber.show();
			} else {
				$("radio[name='coachradio']").checked = false;
				$("#coachdiv").css('display', 'none');
				$("#studentdiv").css('display', '');
				var ulnumber=$("ul li:eq(2)");
				ulnumber.hide();
			}
		}

		var options = {

			onFail : function() {
				alert($myform.getInvalid().length + ' invalid fields.')
			},

			inputs : {
				'password' : {
					filters : 'required pass',
				},
				'username' : {
					filters : 'required username',
					data : {
					//ajax: { url:'validate.php' }
					}
				},
				'file' : {
					filters : 'extension',
					data : {
						extension : [ 'jpg' ]
					}
				},
				'comments' : {
					filters : 'min max',
					data : {
						min : 50,
						max : 200
					}
				},
				'states' : {
					filters : 'exclude',
					data : {
						exclude : [ 'default' ]
					},
					errors : {
						exclude : '选择国籍.'
					}
				},
				'langs[]' : {
					filters : 'min max',
					data : {
						min : 2,
						max : 3
					},
					errors : {
						min : 'Check at least <strong>2</strong> options.',
						max : 'No more than <strong>3</strong> options allowed.'
					}
				}
			}

		};
		var $myform = $('#my-form').idealforms(options).data('idealforms');

		$('#reset').click(function() {
			$myform.reset().fresh().focusFirst();
		});

		$myform.focusFirst();
	</script>
	<div style="text-align:center;"></div>
</body>
</html>