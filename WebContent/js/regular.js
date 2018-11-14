
	
$(" [name='title']").on("blur",checkTitle);
$(" [name='createDate']").on("blur",checkCreateDate);
$(" [value='提交']").on("click",check);

/* 判断是否可以提交 */
var flag1=false;
var flag2=false;

/* 题目检验 */
function checkTitle(){
	var title=$(" [name='title']").val().trim();
	if(title == ""){
		alert('文档名称不能为空！');
		flag1=false;
	}else{
		flag1=true;
	}
}
/* 日期验证 */
function checkCreateDate(){
	var date = $("[name='createDate']").val().trim();
	if(date==""){
		alert('上传日期不能为空！');
		flag2=false;
		
	}else{
		flag2 = /^[0-9]{4}-(([0][0-9])|([1-9])|([1][0-2]))-(([0][1-9])|([1-9])|([1-2][0-9])|([3][0-1]))$/.test(date);
		
		if(!flag2){
			alert("请输入正确的日期");
		}
	}
}


function check(){
	checkTitle();
	checkCreateDate();
	if(!(flag1&&flag2)){
		return false;
	}else{
		return confirm('确认提交？');
	}
}