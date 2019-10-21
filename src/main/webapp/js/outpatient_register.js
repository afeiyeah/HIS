$(function(){
	var pageSize=2;
	var pageNum=1;
	getPageData();
	//生成病历号
	$.ajax({
		type:"post",
		url:"getPatientNo",
		data:{},
		dataType:"json",
		success:function(msg){
			$("#pid").val(msg.pno);
		}
	});
	
	//查询挂号级别
	$.ajax({
		type:"post",
		url:"getLevelData",
		data:{},
		dataType:"json",
		success:function(msg){
			for(var i=0;i<msg.length;++i){
				$("#level").append("<option data-cost='"+msg[i].register_level_price+"' value='"+msg[i].register_level_id+"'>"+msg[i].register_level_name+"</option>")
			}
			
		}
	});
	//查询科室信息
	$.ajax({
		type:"post",
		url:"getDepartmentData",
		data:{},
		dataType:"json",
		success:function(msg){
			for(var i=0;i<msg.length;++i){
				$("#department").append("<option value='"+msg[i].department_id+"'>"+msg[i].department_name+"</option>");
			}
			
		}
	});
	//上一页
	$("#last").click(function(){
		if(pageNum==1){
			alert("当前为第一页数据");
		}else{
			--pageNum;
			getPageData();
			$("#pnum").html(pageNum);
		}
	})
	//下一页
	$("#next").click(function(){
		++pageNum;
		getPageData();
		//$("#pnum").html(pageNum);
	})
	//查询患者信息，每页显示10条，显示第一页的数据
	function getPageData(){
		$.ajax({
			type:"post",
			url:"getPatientData/"+pageSize+"/"+pageNum,
			data:{},
			dataType:"json",
			success:function(msg){
				//如果不是第一页，没有查询到数据
				if(pageNum>1 && msg.length>0){
					$("#pnum").html(pageNum);
				}
				if(pageNum>1&&msg.length==0){
					alert("没有更多数据");
					--pageNum;
				}else{
					$("#data_table tr:not(:first)").empty();
				}
				var status="";
				for(var i=0;i<msg.length;++i){
					if(msg[i].visited_type==1||msg[i].visited_type==2){
						status="正常";
					}else{
						status="已退号";
					}
					$("#data_table").append("<tr><td>"+msg[i].patient_ID+"</td><td>"+msg[i].patient_name+"</td>"+
					"<td>"+msg[i].patient_gender+"</td><td>"+msg[i].patient_birth+"</td><td>"+msg[i].patient_identity+"</td>"+
					"<td>"+msg[i].level.register_level_name+"</td><td>"+status+"</td><td>"+msg[i].department.department_name+"</td><td>"+msg[i].doctor.doctor_name+"</td></tr>")
				}
			}
		});
	}
	
	//年龄和年份换算
	$("#age").blur(function(){
		var age=$("#age").val();
		var cur=new Date();
		var curYear=cur.getFullYear();
		var year=curYear-age;
		$("#year").val(year);
	});
	$("#year").blur(function(){
		var year=$("#year").val();
		var cur=new Date();
		var curYear=cur.getFullYear();
		var age=curYear-year;
		$("#age").val(age);
	});
	//选择科室去变更医生列表
	$("#department").change(function(){
		$.ajax({
			type:"post",
			url:"getDoctorByDept/"+$("#department").val(),
			data:{},
			dataType:"json",
			success:function(msg){
				$("#doctor").empty();
				$("#doctor").append("<option value='-1'>----请选择----</option>");
				for(var i=0;i<msg.length;++i){
					$("#doctor").append("<option value='"+msg[i].doctor_id+"'>"+msg[i].doctor_name+"</option>");
				}
			}
		});
	})
	//选择挂号级别得到应收金额
	$("#level").change(function(){
		var cost=$("#level option:selected").attr("data-cost");
		$("#total").val("0");
		var flag=$("#yes");
		if(flag[0].checked){
			$("#total").val(parseInt(cost)+1);
		}else{
			$("#total").val(parseInt(cost));
		}
		
	})
	//切换是否需要病历本，变更应收金额
	$("#yes").click(function(){
		var cost=$("#level option:selected").attr("data-cost");
		$("#total").val(parseInt(cost)+1);
	});
	$("#no").click(function(){
		var cost=$("#level option:selected").attr("data-cost");
		$("#total").val(parseInt(cost));
	});
	
	//挂号
	$("#regBtn").click(function(){
		$.ajax({
			type:"post",
			url:"savePatient",
			data:$("#form1").serialize(),
			dataType:"json",
			success:function(msg){
				alert(msg);
				location.reload();
			}
		});
	});
	
	//刷新
	$("#div4_1").click(function(){
		pageNum=1;
		getPageData();
		$("#pnum").html(pageNum);
	});
	//退号，跳转页面
	$("#refund").click(function(){
		location.href="outpatient_refund.html";
	});
	//进入门诊收费页面
	$("#div1_2").click(function(){
		location.href="outpatient_pay.html";
	});
	
})