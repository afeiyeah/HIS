$(function(){
	$("#loginBtn").click(function(){
		$.ajax({
			type:"post",
			url:"userlogin",
			data:$("#form1").serialize(),
			dataType:"json",
			success:function(msg){
				if(msg.result=="登录失败"){
					alert(msg.result);
				}else{
					var role= $("#role").val();
					if(role==1){
						location.href="outpatient_register.html";
					}else{
						location.href="doctor_medicalrecord.html";
					}
				}
			}
		});
	})
})