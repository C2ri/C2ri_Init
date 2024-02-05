# TEAM C2ri Project Settings

## Convention

### 1. Branch

1-1. Git Flow 전략에 따른 Branch Depth

- Master
- Hotfixes
- Release
- Develop
- Feature

1-2. 브랜치 생성 절차

- 첫번째 : Develop 브랜치 생성
- 두번째 : Develop 하위에 Feature 브랜치 생성
- 세번째 : Feature 기능 구현 완료 후, Develop PR
- 네번째 : Develop 전체 테스트 후, Release PR 및 배포
- 다섯번째 : 배포 환경 테스트 후, v.1.0 main 배포

1-3. Branch명 컨벤션

- 브랜치명/파트/기능이름(#깃 이슈넘버)
- ex. feature/FE/Social Login(#1)

### 2. Commit

2-1. 커밋 메세지 컨벤션

- Feat : 구현 내용 (#깃 이슈넘버)
- ex. Feat : 카카오 로그인연동(#1)

### 3. Issue

3-1. 이슈 네이밍 컨벤션

- [파트] 기능 이름

- ex. [FE] Webview Settings

3-2. 이슈 작성 내용

```markdown
### 만들고자 하는 기능

ex) Todo 생성 기능

### 해당 기능을 구현하기 위해 할 일

1.  [ ] Job1
2.  [ ] Job2
3.  [ ] Job3

### 예상 작업 시간

ex) 3h
```

### 4. PR

4-1. PR 메세지 컨벤션

- 커밋과 동일

4-2. 참고할 사항

- 제목에 올바른 이슈 타입 작성하기
- 특정 이슈를 해결할 때, 참고할 이슈 번호를 PR 제목에 넣기
  (예: 'fix #xxx ~ "xxx"는 이슈 번호)
- bug fixes/hotfix일 경우에 변경사항에 테스트한 이미지 등을 첨부하기
- bug fixes/hotfix일 경우에 문서가 추가 혹은 수정되었는지 확인하기

---

## 프로젝트 규칙

### [Frontend]

1. 폴더구조
2. Naming Rule
3. CSS 공통모듈 개발

### [Backend]
