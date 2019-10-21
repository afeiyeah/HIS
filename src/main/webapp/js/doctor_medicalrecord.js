$(function(){
	//初始化该医生当天的挂号信息
	$.ajax({
		type:"post",
		url:"getPatientDataByDoc",
		data:{},
		dataType:"json",
		success:function(msg){
			for(var i=0;i<msg.length;++i){
				if(msg[i].visited_type==1||msg[i].visited_type==2){
					status="正常";
				}else{
					status="已退号";
				}
				if(msg[i].visited_type==1){
					$("#data_table1").append("<tr class='first_table' data-pid='"+msg[i].patient_ID+"'><td>"+msg[i].patient_ID+"</td><td>"+msg[i].patient_name+"</td>"+
							"<td>"+msg[i].patient_gender+"</td><td>"+msg[i].patient_birth+"</td><td>"+msg[i].patient_identity+"</td>"+
							"<td>"+msg[i].level.register_level_name+"</td><td>"+status+"</td><td>"+msg[i].department.department_name+"</td><td>"+msg[i].doctor.doctor_name+"</td></tr>")
						
				}else if(msg[i].visited_type==2){
					$("#data_table2").append("<tr><td>"+msg[i].patient_ID+"</td><td>"+msg[i].patient_name+"</td>"+
							"<td>"+msg[i].patient_gender+"</td><td>"+msg[i].patient_birth+"</td><td>"+msg[i].patient_identity+"</td>"+
							"<td>"+msg[i].level.register_level_name+"</td><td>"+status+"</td><td>"+msg[i].department.department_name+"</td><td>"+msg[i].doctor.doctor_name+"</td></tr>")
						
				}
			}
		}
	});
	//未看诊列表的每一行绑定单击事件，跳转页面
	$(document).on("click",".first_table",function(){
		var pid=$(this).attr("data-pid");
		location.href="doctor_regmedicalrecord.html?pid="+pid;
	});
	
	//
	$("#div1_2").click(function(){
		location.href="doctor_checkitem.html";
	});
	$("#div1_3").click(function(){
		location.href="doctor_examineitem.html";
	});
	$("#div1_4").click(function(){
		location.href="doctor_result.html";
	});
})