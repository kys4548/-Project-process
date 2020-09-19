# **졸업 프로젝트 ( Hamobee )**

1. URL : (http://hamobee.tk)<br><br>
2. 프로젝트 진행 기간 : 2019.03 ~ 2019.11<br><br>
3. 주요 내용 : 악기 연주자와 공연 주최자를 매칭해주고 그들을 위한 커뮤니티 공간을 제공하는 웹 서비스 프로젝트<br><br>
4. 기술 스택 : Spring, MYSQL, MyBatis, JSP, Jquery, Junit, Git, Naver Cloud Platform<br><br>
5. 서비스 종료 : 2020.10.20<br>
   <br>

- ## **[ What's Hamobee? ]**

  <image src="./readmeImage/hamobee.png" width=300 >

  ### **haydn, Mozart, Beethoven에서 ha, mo, bee를 이어붙여 만든 이름**

  <br>
  반복되는 연주회, 되풀이되는 인력난<br>
  이번에는 어디서 객원을 구하나?<br>

  할 일도 없는데 객원이나 가볼까?<br>
  그런데 어디를 어떻게 찾아가야하지?<br>

  음악에 청춘을 불태우는 이들을 위한 정통 커뮤니티!<br>
  수많은 연주자들이 조화를 이루는 연주회에서 실력을 발휘해보세요.<br>
  관심있는 모든 연주회에 지원하세요!<br>
  당신의 훌륭한 실력을 연주회에서 뽐내세요!<br>
  우리 동네 최고의 연주자가 되세요.<br>

  수퍼 파워 지휘자를 만나보세요<br>
  모든 연주회에는 환상적인 조명이 있습니다<br>
  다양한 친구들을 만날 수 있어요. (겁내지 마세요 주최자여!)<br>
  게시판에서 모집 공고를 작성하세요<br>

  당신만의 커리어를 최고로 이끄는 모험과 도전<br>

  하모비가 이끄는 최고의 공연정보!<br>
  우리 동네 공연들을 정복하고 네임드 연주자, 주최자가 되세요.<br>

  <br><br>

* ## **[ 시연 영상 ]**

  #### 아래 이미지 클릭

  <a href="https://www.youtube.com/watch?v=2JgohB1XEEE" target="_blank"><image src="./readmeImage/preview.png" width = 500></a>

<br/>

- ## **Use Case**

  - #### 비회원은 프로그램을 사용하기 위해 회원 가입을 해야 한다. <br/>

    #### 자신의 ID, password 및 기본정보를 입력해야 한다. <br/>

    #### 기본정보는 사용자 유형(주최자 또는 연주자), 이름, 나이, 성별 및 이메일을 포함한다. <br>

    #### 회원가입을 하면 주최자 혹은 연주자로서 시스템을 사용할 수 있다.<br>

    <image src="./readmeImage/signup.png" width=500>
    <br><br>

  - #### 회원은 ID와password로 로그인해야 한다.<br>

    <image src="./readmeImage/login.png" width=500>
    <br><br>

  - #### 회원은 로그아웃 할 수 있다.<br>

    <image src="./readmeImage/logout.png" width=500>
    <br><br>

  - #### 회원은 이 시스템에서 탈퇴할 수 있다.<br>

    #### 탈퇴와 동시에 시스템 사용 권한은 소멸한다.<br>

    <br>

  - #### 주최자 회원은 모집공고를 등록할 수 있다.<br>

    #### 등록할 때에는 공연정보를 입력해야 한다.<br>

    #### **등록 후 1년이 지난 모집공고는 삭제된다.**<br>

    <image src="./readmeImage/announcement.png" width=500>
    <br><br>

  - #### 주최자 회원은 자신이 등록한 모집공고를 조회할 수 있다.<br>

    #### 조회 결과는 등록 날짜를 기준으로 정렬해서 보여준다.<br>

    #### 조회 리스트 중 하나의 모집공고를 선택하면 해당 세부정보를 출력할 수 있고 조회 리스트 내에서 모집공고를 취소, 수정할 수 있다.<br>

    <image src="./readmeImage/picture1.png" width=500>
    <br><br>

  - #### 연주자 회원은 악기를 선택해서 지원 가능한 모집공고를 검색할 수 있다. <br>

    #### 검색 결과 리스트는 등록날짜로 정렬된다. <br>

    #### 검색 결과 중 원하는 모집을 선택하면 상세정보를 출력할 수 있고 지원할 수도 있다.<br>

    <image src="./readmeImage/picture2.png" width=500>
    <br><br>

  - #### 주자 회원은 자신이 지원했었던 모집공고를 검색할 수 있다.<br>

    <image src="./readmeImage/picture3.png" width=500>
    <br><br>

  - #### 연주자 회원에게 적합한 모집공고를 추천해준다.<br>
    <image src="./readmeImage/picture4.png" width=500>
    <br><br>

- ## 추가된 기능

  - ### **About**

    <image src="./readmeImage/about.png" width=500><br>
    <br>

  - ### **Community And Comment**

    <image src="./readmeImage/community.png" width=500>
    <br><br>
    <image src="./readmeImage/comment.png" width=500>
    <br><br>

- ## 삭제된 기능

  - ### **Mail**

    <image src="./readmeImage/mail.png" width=400><br>
    Local 환경에서는 작동하였지만 실제 Server에서 작동하지 않아 삭제
    <br><br>

- ## Spring 프로젝트 구조
  <br>
  <image src="./readmeImage/picture5.PNG" width=400><br>
