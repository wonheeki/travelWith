var index = 0; // 이미지에 접근하는 인덱스
window.onload = function() {
	slideShow();
}

function slideShow() {
	var i;
	var x = document.getElementsByClassName("slide1"); // slide1에 대한 dom 참조
	for (i = 0; i < x.length; i++) {
		x[i].style.display = "none"; // 처음에 전부 display를 none으로 한다.
	}
	index++;
	if (index > x.length) {
		index = 1; // 인덱스가 초과되면 1로 변경
	}
	x[index - 1].style.display = "block"; // 해당 인덱스는 block으로
	setTimeout(slideShow, 3000); // 함수를 4초마다 호출

}

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('preview').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('preview').src = "";
	}
}

function collapse(element) {
    var before = document.getElementsByClassName("active")[0]               // 기존에 활성화된 버튼
    if (before && document.getElementsByClassName("active")[0] != element) {  // 자신 이외에 이미 활성화된 버튼이 있으면
        before.nextElementSibling.style.maxHeight = null;   // 기존에 펼쳐진 내용 접고
        before.classList.remove("active");                  // 버튼 비활성화
    }
    element.classList.toggle("active");         // 활성화 여부 toggle

    var content = element.nextElementSibling;
    if (content.style.maxHeight != 0) {         // 버튼 다음 요소가 펼쳐져 있으면
        content.style.maxHeight = null;         // 접기
    } else {
        content.style.maxHeight = content.scrollHeight + "px";  // 접혀있는 경우 펼치기
    }
}


function change(element) {
	element.nextElementSibling.style.display='inline-block';
}
