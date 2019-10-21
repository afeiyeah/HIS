$(function(){
	//初始化查询系统中所有检查项目
	$.ajax({
		type:"post",
		url:"getAllCheckItem",
		data:{},
		dataType:"json",
		success:function(msg){
			console.log(msg);
			for(var i=0;i<msg.length;i++){
				$("#checkitem").append("<option value='"+msg[i].checkup_id+"'data-price='"+msg[i].checkup_price+"'>"+msg[i].checkup_name+"</option>")
			}
		}
	});
	$("#search").click(function(){
		var pid=$("#pid").val();
		if(pid==""){
			alert("请输入要查询的病历号")
		}else if(isNaN(pid)){
			alert("病历号必须为数字");
		}else{
			$.ajax({
				type:"post",
				url:"getPatientByNo/"+pid,
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
							$("#status").html("退号")
						}else{
							$("#status").html("正常");
						}
						$("#department_id").val(msg.department.department_name);
						$("#doctor_id").val(msg.doctor.doctor_name);
					}
					
				}
			});
		}
	});
	
	var count=0;
	//选择项目，加入检查项目列表
	$("#checkitem").change(function(){
		var option=$("#checkitem option:selected");

		//如果表格中已经有该检查项目，不进行追加
		var tds=$("#item_data tr").find("td:eq(0)");
		//默认该选项没有被选择过
		flag=false;
		for(var k=0;k<tds.length;k++){
			//如果选择的是请选择，则方法执行结束
			if($(tds[k]).html()==option[0].text||option[0].value==-1){
				flag=true;
				break;
			}
		}
		//表格追加tr
		if(flag==false){
			$("#item_data").append("<tr><td>"+option[0].text+"</td><td><input type='hidden' name='crlist["+count+"].checkup_id' value='"+option[0].value+"'><input type='text' name='crlist["+count+"].checkup_amount' class='amount' value='1'></td><td>"+option.attr("data-price")+"</td><td><img class='trash' src='img/trash_13.1328px_1217857_easyicon.net.png'</td></tr>")

		}
		
	});
	//点击垃圾桶，删除所在行
	$(document).on("click",".trash",function(){
		$(this).parent().parent().remove();
	})
	//变更数量，计算总金额
	$(document).on("blur",".amount",function(){
		var amount=$(this).val();
		if(parseInt(amount)==0||isNaN(amount)){
			alert("请输入正确的数量");
		}else{
			var price=$(this).parent().next().html();
			$(this).parent().next().html(parseInt(price)*parseInt(amount));
		}
	});
	//提交检查申请
	$("#submitItem").click(function(){
		$.ajax({
			type:"post",
			url:"saveCheckItemRecord/"+$("#pid").val()+"/"+$("#doctor_id").val(),
			data:$("#form1").serialize(),
			dataType:"json",
			success:function(msg){
				if(msg.result!="保存成功"){
					alert(msg.result);
				}
				
			}
		});
	})
	$("#div1_1").click(function(){
		location.href="doctor_medicalrecord.html";
	});
	$("#div1_3").click(function(){
		location.href="doctor_examineitem.html";
	});
	$("#div1_4").click(function(){
		location.href="doctor_result.html";
	});
})