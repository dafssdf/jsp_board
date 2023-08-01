/**
 * 
 */

let $checkMsg = $("#check-id-msg");
let $pwMsg = $("#check-pw-msg");

let $idInput = $('#id');
let $pwInput = $('#password');


$idInput.on('blur',function(){
	let id = $(this).val()
	if($(this).val() == ''){
		$checkMsg.text('아이디를 입력하세요');
	}else{
		
		$.ajax({
			url : 'checkIdOk.me',
			type : 'get',
			data : {"memberId" : $(this).val()},
			success :function(result){
				$checkMsg.text(result);
			}
		});
	}	
});

const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,}$/;

$pwInput.on('blur' , function(){
	if( regex.test( $(this).val() ) ){
		$pwMsg.text('사용가능한 비밀번호');
	}else{
		$pwMsg.html('사용 불가능한 비밀번호 <br> 영어,숫자 특수기호를 포함하여 8글자 이상 작성하세요');
	}
});


$('form').on('submit', function(e){
	e.preventDefault();	// 기본 이벤트를 막아주는 명령어
	
	console.log($('#agree').prop('checked'));
	
	if($('#agree').prop('checked')){
		this.submit(); //서브밋 이벤트를 발생시키는 메소드(폼 요소에 사용해야 함)
	}else{
		alert('약관에 동의해주세요!');
	}
});













