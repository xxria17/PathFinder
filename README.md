# PathFinder

요구사항

- 데이터
    - [https://storage.googleapis.com/mobile_example/data/items.json](https://storage.googleapis.com/mobile_example/data/items.json)
    - 위 json 파일 디코드해서 컨텐츠 목록 가져오기
    - 컨텐츠는 텍스트나 이미지 url
- 화면 요구사항
    - 화면 상단에 이름과 이메일주소
    - 하나의 컨텐츠는 하나의 카드뷰에 표시됨
    - 카드뷰는 화면 중앙에 자리함
        - 카드뷰 높이는 화면 높이의 70프로
        - 카드뷰 좌우에는 20포인트 여백
        - 모서리는 라운드 처리
    - 텍스트 카드뷰
        - 텍스트 길이 길면 상하 스크롤
    - 이미지 카드뷰
        - 이미지 전체 잘림 없이 카드뷰 내에 이미지 비율 맞게 보여져야 함
        - 이미지 컨텐츠 로딩하는데 시간 걸리면 로딩 인디케이터 표시
    - 다양한 화면 크기에 레이아웃이 잘려서는 안됨
    - 화면 회전도 고려
- 편집 기능
    - 화면 하단에 편집 버튼 누르면 편집 페이지로 이동
    - 편집 페이지에서는 컨텐츠 순서 변경, 삭제 등 가능
    - 목록이 편집이 되면 카드뷰 선서에 반영되어야 함
    - 편집된 내용은 앱이 실행중일 때만 유효
