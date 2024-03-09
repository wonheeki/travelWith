//	LeeValidChecker.js >> 유효성 검사

//	뭔가 문제가 되면(의도한 대로 이루어지지 않으면) true,
//	정상적이면(내가 의도한대로 소비자가 나오면) false 인 컨셉

//	<input> 태그에서 아무것도 안썼으면 true, 뭐라도 썼으면  false

function isEmpty(input) {
	return (!input.value);
}

//	parameter에 <input>, 글자 수 넣었을 때
//	그 글자 수 보다 적으면 true, 그 글자 수 이상이면 false
function atLeastLetter(input, len) {
	return (input.value.length < len);
}

//	<input>을 넣었을 때
//	한글 / 특수문자가  적혀있다면 true, 없다면 false
function containsAnother(input) {
	let pass = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@._";
	
	let iv = input.value;
	for (let i = 0; i < iv.length; i++) {
		if (pass.indexOf(iv[i]) == -1) {	//	pass에 있는 내용 중에 내가 쓴게 없으면
			return true;
		}
	}
	return false;
}

//	<input> x 2 넣었을 때(비번, 비번확인용) 
//	서로 내용이 다르면 true, 같으면 false
function notEqualPw(input1, input2) {
	return (input1.value != input2.value);
}

//	<input>, 문자열 세트 넣었을 때
//	없으면 true, 있으면 false (입력한 pw에 지정한 문자열이 없는 경우)
function notContains(input, passSet) {
	let iv = input.value;
	for(let i = 0; i < passSet.length; i++) {
		if(iv.indexOf(passSet[i]) != -1) {
			return false;
		}
	}
	return true;
}

//	<input>에
//	숫자 아닌게 있으면 true, 없으면  false
function isNotNumber(input) {
	return isNaN(input.value);
}

//	<input>, 확장자 넣었을때
//	확장자명이 아니면 true, 맞으면 false
function isNotType(input, type) {
	// .gif, .png, .jpg, ...
	type = "." + type;
	return (input.value.indexOf(type) == -1);
}