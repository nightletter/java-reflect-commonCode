### 리플렉션을 통해 Enum으로 작성된 공통코드를 Response 해보자

--------- 

기존 공통코드들을 디비에서 관리하는 방식으로 코딩을 했지만 Enum을 사용해서도 충분히 가능할 것 같아서 언젠간 써먹지 않을까 싶어 커밋함.

- 참조
  - https://mvnrepository.com/artifact/org.reflections/reflections


- 시행착오
  - Reflections 생성자에 PREFIX 넣어주는 것, 패키지 스캔의 대상이 달라짐.
