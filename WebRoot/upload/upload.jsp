<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<input type="file" id="uploadFile" name="uploadFile" onchange="uploadImage();" multiple/>
<div id="imgDiv">
</div>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
 <script type="text/javascript">
        function uploadImage() {
        //判断是否有选择上传文件
            var imgPath = $("#uploadFile").val();
            if (imgPath == "") {
                alert("请选择上传图片！");
                return;
            }
            //判断上传文件的后缀名
            var strExtension = imgPath.substr(imgPath.lastIndexOf('.') + 1);
            if (strExtension != 'jpg' && strExtension != 'gif'
            && strExtension != 'png' && strExtension != 'bmp') {
                alert("请选择图片文件");
                return;
            }
            $.ajaxFileUpload({
                type: "POST",
                secureuri:false,
                fileElementId : 'uploadFile', 
                url: '<%=basePath%>file/upload',
                data:{username:'${user.username}'},
                cache: false,
                success: function(data) {
                    alert("上传成功");
                	alert("data:"+data);
                    $("#imgDiv").empty();
                    $("#imgDiv").html(data);
                    $("#imgDiv").show();
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("上传失败，请检查网络后重试");
                }
            });
        }
    </script>
