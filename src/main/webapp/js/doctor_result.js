$(function(){
	$("#search").click(function(){
		var pid=$("#pid").val();
		$.ajax({
			type:"post",
			url:"getPatientMRByNo/"+pid,
			data:{},
			dataType:"json",
			success:function(msg){
				if(msg.patient_ID==0){
					alert("系统中不存在该患者");
				}else{
					$("#patient_ID").val(msg.patient_ID);
					$("#patient_name").val(msg.patient_name);
					if(msg.gender=="男"){
						$("#gender1")[0].checked=true;
					}else{
						$("#gender0")[0].checked=true;
					}
					$("#register_date").val(msg.register_date);
					$("#patient_identity").val(msg.patient_identity);
					$("#register_level_id").val(msg.level.register_level_name);
					if(msg.visited_type==1){
						$("#visited_type").html("未诊");
						
					}else{
						$("#visited_type").html("已诊");
						
					}
					if(msg.visited_type==3){
						$("#status").html("退号");
					}else{
						$("#status").html("正常");
					}
					$("#department_id").val(msg.department.department_name);
					$("#doctor_id").val(msg.doctor.doctor_name);
					$("#complaint").html(msg.m.complaint);
					$("#present_illness").html(msg.m.present_illness);
					$("#past_illness").html(msg.m.past_illness);
					$("#primary_diagnosis").html(msg.m.primary_diagnosis);
					$("#medical_record").val(msg.m.medical_record);
				}
				
			}
		});
	})
	
	
	$("#diagnose").click(function(){
		$.ajax({
			type:"post",
			url:"updateMedicalRecord",
			data:$("#form1").serialize(),
			dataType:"json",
			success:function(msg){
				console.log(msg.result);
				location.href="doctor_medicalrecord.html";
			}
		});
	})
	$("#div1_2").click(function(){
		location.href="doctor_checkitem.html";
	});
	$("#div1_3").click(function(){
		location.href="doctor_examineitem.html";
	});
	$("#div1_1").click(function(){
		location.href="doctor_medicalrecord.html";
	});
})