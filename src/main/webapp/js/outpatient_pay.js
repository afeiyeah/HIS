$(function(){
	var curP=0;
	//点击search图标，查询患者信息和收费
	$("#search").click(function(){
		var pid=$("#pid").val();
		if(pid==""){
			alert("请输入要查询的病历号")
		}else if(isNaN(pid)){
			alert("病历号必须为数字");
		}else{
			$.ajax({
				type:"post",
				url:"selectPatientByPno/"+pid,
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
					//每次更改患者前清空所有记录
					$("#item_data tr:not(:first)").remove();
					var totalPay=0;
					//追加检查申请记录
					for(var i=0;i<msg.crlist.length;++i){
						var amount=msg.crlist[i].check.checkup_price*msg.crlist[i].checkup_amount;
						
						var status;
						if(msg.crlist[i].payment_status==0){
							status="未缴费";
							$("#item_data").append("<tr><td><input type='checkbox' name='cid'"+msg.crlist[i].record_id+"class='select'></td>"+
									"<td>"+msg.crlist[i].check.checkup_name+"</td>"+
									"<td>"+msg.crlist[i].check.checkup_price+"</td>"+
									"<td>"+msg.crlist[i].checkup_amount+"</td>"+
									"<td class='payCount'>"+amount+"</td>"+
									"<td>"+status+"</td></tr>");
						}else{
							status="已缴费";
							$("#item_data").append("<tr><td><input type='checkbox' disabled='disabled' class='select'></td>"+
									"<td>"+msg.crlist[i].check.checkup_name+"</td>"+
									"<td>"+msg.crlist[i].check.checkup_price+"</td>"+
									"<td>"+msg.crlist[i].checkup_amount+"</td>"+
									"<td>"+amount+"</td>"+
									"<td>"+status+"</td></tr>");
						}
						
						totalPay=amount+totalPay;
					}
					//追加检验记录
					for(var i=0;i<msg.erlist.length;++i){
						var amount=msg.erlist[i].examine.examine_price*msg.erlist[i].examine_amount;
						var status;
						if(msg.erlist[i].payment_status==0){
							status="未缴费";
							$("#item_data").append("<tr><td><input type='checkbox'name='eid'"+msg.crlist[i].record_id+" class='select'></td>"+
									"<td>"+msg.erlist[i].examine.examine_name+"</td>"+
									"<td>"+msg.erlist[i].examine.examine_price+"</td>"+
									"<td>"+msg.erlist[i].examine_amount+"</td>"+
									"<td>"+amount+"</td>"+
									"<td>"+status+"</td></tr>");
						}else{
							status="已缴费";
							$("#item_data").append("<tr><td><input type='checkbox' disabled='disabled' class='select'></td>"+
									"<td>"+msg.erlist[i].examine.examine_name+"</td>"+
									"<td>"+msg.erlist[i].examine.examine_price+"</td>"+
									"<td>"+msg.erlist[i].examine_amount+"</td>"+
									"<td class='payCount'>"+amount+"</td>"+
									"<td>"+status+"</td></tr>");
						}
						
						totalPay=amount+totalPay;
					}
					$("#totalPay").html(totalPay);
					curP=0;
					$("#currentPay").html(curP);
				}
				
			});
		}
	});
	//全选
	$(document).on("click","#selectAll",function(){
//		var flag=$("#selectAll").is(":checked");
//		$(".select").prop("checked",flag);
//		if($(this).is(":checked")){
//		
//		}
		var chks =$(".select");
		var payCountTd = $(".payCount");
		var total=0;
		if($(this)[0].checked==true){
			for(var i=0;i<chks.length;i++){
				chks[i].checked = true;
			}
			for(var j=0;j<payCountTd.length;j++){
				total = total + parseFloat($(payCountTd[j]).html());
			}
			$("#currentPay").html(total);
		}else{
			for(var i=0;i<chks.length;i++){
				chks[i].checked = false;
			}
			$("#currentPay").html(0);
		}
	});
	//在每一行的复选框上绑定单击事件
	$(document).on("click",".select",function(){
		var a=$("#currentPay").html();
		console.log(a);
		var b=$(this).parent().next().next().next().next().html();
		console.log(b);
		if($(this)[0].checked==true){
			$("#currentPay").html(parseFloat(a)+parseFloat(b));
		}else{
			$("#currentPay").html(parseFloat(a)-parseFloat(b));
		}

	});
	//收费
	$("#submitItem").click(function(){
		var checks=$(".select");
		var flag=false;
		for(var k=0;k<checks.length;k++){
			if(checks[k].checkes==true){
				flag=true;
			}
		}
		if(!flag){
			alert("没有选中的项目");
		}else{
			$.ajax({
				type:"post",
				url:"payItems",
				data:$("#form1").serialize(),
				dataType:"json",
				success:function(msg){
					alert(msg.result);
					location.reload();
				}
			})
		}
	})
})