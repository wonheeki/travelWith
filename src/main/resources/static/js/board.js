const boardNavHandle = (category) => {
    let parentElement = document.querySelector('.category');
    removeClassFromChildren(parentElement, 'hpoint');
    let cate = document.querySelector(`.${category}`);
    cate.classList.add('hpoint');


      axios.get(`${category}.go`)
        .then(response => {
          console.log('Response:', response.data);
          // 데이터를 받아온 후 처리
                      const boardList = document.querySelector('.board_list');
                      // 기존 목록 삭제
                      boardList.innerHTML = '';

                      // 받은 데이터로 목록 생성
                      response.data.forEach(board => {
                          const boardItem = document.createElement('div');
                          boardItem.innerHTML = `
                            <div class="top">
                                                  <div class="num">번호</div>
                                                  <div class="title">제목</div>
                                                  <div class="writer">작성자</div>
                                                  <div class="date">작성일</div>
                                                  <div class="count">조회</div>
                                              </div>
                              <div class="num">${board.rn}</div>
                              <div class="title">
                                  <a href="board.view.go?b_no=${board.b_no}">${board.b_title}</a>
                              </div>
                              <div class="writer">${board.b_writer}</div>
                              <div class="date">${board.b_regDate}</div>
                              <div class="count">${board.b_readCounter}</div>
                          `;
                          boardList.appendChild(boardItem);
                      });
        })
    .catch(error => {
      console.error('Error:', error);
    });
  };

  const removeClassFromChildren = (parent, className) => {
    var children = parent.children;
    for (var i = 0; i < children.length; i++) {
      children[i].classList.remove(className);
    }
  };