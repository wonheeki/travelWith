// function 실행
$(function(){
	searchAddrEvent();
	idCheckEvent();
	nickNameCheckEvent();
	logoutEvent();
	goResign();
	boardUpdate();
	update();
//	commentDelete();
	talkUpdate();
	joinImgUpload();
	fnInit();
});

// 게시판 글수정
function boardUpdate(no,title,txt){

}


// 회원가입 checkValid()
function checkValid() {
		let idBox = document.signup_form.u_id;
		let pwBox = document.signup_form.u_pw;
		let re_pwBox = document.signup_form.u_repw;
		let nicknameBox = document.signup_form.u_nickname;
		let emailBox = document.signup_form.u_email;

		//ID
		if(isEmpty(idBox) || atLeastLetter(idBox, 5) || containsAnother(idBox)){
			alert("아이디는 5~10글자, 한글,특수문자 금지, 필수입력입니다.");
			idBox.value="";
			idBox.focus();
			return false;
		}
		//PW
		if(isEmpty(pwBox) || atLeastLetter(pwBox, 5) || containsAnother(pwBox)){
			alert("비밀번호는 5~15글자, 한글,특수문자 금지, 필수 입력입니다.");
			pwBox.value="";
			pwBox.focus();
			return false;
		}//PW 확인
		if(isEmpty(re_pwBox) || atLeastLetter(re_pwBox, 5) || notEqualPw(pwBox, re_pwBox)){
			alert("비밀번호 확인은 비밀번호와 같아야합니다.");
			re_pwBox.value="";
			re_pwBox.focus();
			return false;
		}//닉네임
		if(isEmpty(nicknameBox)){
			alert("닉네임은 필수입니다. (최대 10글자)");
			nicknameBox.value="";
			nicknameBox.focus();
			return false;
		}//이메일
		if(isEmpty(emailBox)){
			alert("이메일은 필수입니다.");
			emailBox.value="";
			emailBox.focus();
			return false;
		}
		return true;
	}

function checkValidMyInFo() {
	let pwBox = document.updateform.u_pw;
	let re_pwBox = document.updateform.u_repw;
	let nicknameBox = document.updateform.u_nickname;
	let emailBox = document.updateform.u_email;

	//PW
	if(isEmpty(pwBox) || atLeastLetter(pwBox, 5) || containsAnother(pwBox)){
		alert("비밀번호는 5~15글자, 한글,특수문자 금지, 필수 입력입니다.");
		pwBox.value="";
		pwBox.focus();
		return false;
	}//PW 확인
	if(isEmpty(re_pwBox) || atLeastLetter(re_pwBox, 5) || notEqualPw(pwBox, re_pwBox)){
		alert("비밀번호 확인은 비밀번호와 같아야합니다.");
		re_pwBox.value="";
		re_pwBox.focus();
		return false;
	}//닉네임
	if(isEmpty(nicknameBox)){
		alert("닉네임은 필수입니다. (최대 10글자)");
		nicknameBox.value="";
		nicknameBox.focus();
		return false;
	}//이메일
	if(isEmpty(emailBox)){
		alert("이메일은 필수입니다.");
		emailBox.value="";
		emailBox.focus();
		return false;
	}
	return true;
}

// 로그아웃
function logoutEvent(){
	$('#logoutBtn').click(function(){
		let msg = confirm('로그아웃 하시겠습니까?');
		if (msg) {
			location.href = "member.logout";
		}
	});
}
// 회원탈퇴
function goResign(){
	$('#resignBtn').click(function(){
		let msg = prompt('진짜 탈퇴하시겠습니까? (Y/N)');
		if(msg == 'Y'){
			let msg2 = confirm('진짜 탈퇴하시겠습니까?');
			if(msg2){
				location.href="member.resign";
			}
		}
	});
}

// 주소  (우편번호)
function searchAddrEvent(){
	$('#u_addr1, #u_addr2').click(()=>{
		new daum.Postcode({
			oncomplete: function(data) {
	            $('#u_addr1').val(data.zonecode);
	            $('#u_addr2').val(data.roadAddress);
	        }
		}).open();
	});
}
//회원정보 수정
function update(){
	$('#updatebtn').click(()=>{
		alert("회원정보가 수정되었습니다.");
	});
}

// id 중복확인 체크
function idCheckEvent(){
	//alert("바보");
	$('#u_id').keyup(function(){
		let u_id = $(this).val();
		$.getJSON("member.id.check?u_id="+u_id, function(memberJSON){
			if(memberJSON.member[0]==null){
				$('#u_id').css("color","black");
			}else{
				$('#u_id').css("color","red");
				alert("중복된 아이디 입니다.");
			}
		});
	});
}

// 닉네임 중복확인 체크
function nickNameCheckEvent(){
	$('#u_nickname').keyup(function(){
		let u_nickname = $(this).val();
		//alert(u_nickname);
		$.getJSON("member.nickname.check?u_nickname="+u_nickname, function(memberJSON){
			if(memberJSON.member[0]==null){ // 중복 id가 없다 (사용가능!)
				// member[0] -> mapper에서 조건을 걸어줬으므로 조건을 걸어준 nickname이 member[0]이 됨!
				$('#u_nickname').css("color", "black");
			}else{ // 중복 id일 때 (사용불가능!)
				$('#u_nickname').css("color","red");
				alert("중복된 닉네임 입니다.");
			}
		});
	});
}

function talkUpdate(){
	var target = document.querySelectorAll('.btn_open');
	var btnPopClose = document.querySelectorAll('.pop_wrap .btn_close');
	var targetID;

	// 팝업 열기
	for(var i = 0; i < target.length; i++){
	  target[i].addEventListener('click', function(){
	    targetID = this.getAttribute('href');
	    document.querySelector(targetID).style.display = 'block';
	  });
	}

	// 팝업 닫기
	for(var j = 0; j < target.length; j++){
	  btnPopClose[j].addEventListener('click', function(){
	    this.parentNode.parentNode.style.display = 'none';
	  });
	}
}


// 게시글 댓글 삭제
//function commentDelete(no){
//	   if (confirm("진짜로 삭제하시겠습니까?")) {
//	      location.href="board.comment.delete?c_no="+no;
//	   }
//	}
/*function talkUpdate(b_no,txt) {
	txt = prompt("수정할 내용을 적어주십시오.",txt);
	if(txt != null && txt.length > 0){
		location.href = "talk.update?b_no"+b_no+"&b_txt="+txt;
	}
}*/

function commentUpdate(no,txt,b_no) {
//	alert("메렁");
	txt = prompt("수정할 내용을 적어주십시오.",txt);
	if(txt != null && txt.length > 0){
		location.href = "board.comment.update?c_no="+no+"&c_txt="+txt+"&b_no="+b_no;
	}
}


function talkCommentUpdate(no,txt,b_no) {
//	alert("메렁");
		txt = prompt("수정할 내용을 적어주십시오.",txt);
		if(txt != null && txt.length > 0){
			location.href = "talk.comment.update?c_no="+no+"&c_txt="+txt+"&b_no="+b_no;
		}
}

function joinImgUpload(){
	$('#b_photo').change(function(){
		let fileName = $('#b_photo').val();
		$('.uploadName').val(fileName);
	});
}


function frm_check(){
    saveid();
}

function fnInit(){
   var cookieid = getCookie("saveid");
   console.log(cookieid);
   if(cookieid !=""){
       $("input:checkbox[id='saveId']").prop("checked", true);
       $('#logId').val(cookieid);
   }

}

function setCookie(name, value, expiredays) {
   var todayDate = new Date();
   todayDate.setTime(todayDate.getTime() + 0);
   if(todayDate > expiredays){
       document.cookie = name + "=" + escape(value) + "; path=/; expires=" + expiredays + ";";
   }else if(todayDate < expiredays){
       todayDate.setDate(todayDate.getDate() + expiredays);
       document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";";
   }
   
   
   console.log(document.cookie);
}

function getCookie(Name) {
   var search = Name + "=";
   console.log("search : " + search);
   
   if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면 
       offset = document.cookie.indexOf(search);
       console.log("offset : " + offset);
       if (offset != -1) { // 쿠키가 존재하면 
           offset += search.length;
           // set index of beginning of value
           end = document.cookie.indexOf(";", offset);
           console.log("end : " + end);
           // 쿠키 값의 마지막 위치 인덱스 번호 설정 
           if (end == -1)
               end = document.cookie.length;
           console.log("end위치  : " + end);
           
           return unescape(document.cookie.substring(offset, end));
       }
   }
   return "";
}

function saveid() {
   var expdate = new Date();
   if ($("#saveId").is(":checked")){
       expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30);
       setCookie("saveid", $("#logId").val(), expdate);
       }else{
      expdate.setTime(expdate.getTime() - 1000 * 3600 * 24 * 30);
       setCookie("saveid", $("#logId").val(), expdate);
        
   }
}

function test(no) {
//	alert("메렁");
	var value = $('input[name=b_no]').val();
	alert(value);
}