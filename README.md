# Springboot Hello world

* 터미널에서 git clone https://github.com/tkyoon/springboot.git

* 내려받은 폴더로 이동 >> cd springboot

* /gradle.properties 파일에서 java.home 설정 (\는 안됨)
    <pre><code>
    org.gradle.java.home=C:/Dev/java/jdk-15
    </code></pre>

* vscode java 설정

    메뉴에서 파일 > 기본설정 > 설정 (단축키 Ctrl + ,)
    
    java.home 검색 > setting.json에서 편집 클릭

    경로 추가 : C:/Dev/java/jdk-15  

* 서버 실행

    .\gradlew bootRun

    Spring Boot Dashborad에 컨테이너가 올라 오려면 시간이 좀 걸림

* 소스 hot deploy를 적용하려면 Spring Boot Dashborad에서 debugger로 실행

* http://localhost:8080 접속


* Entity 생성할 경우 toString() 설정 Object형 log를 쌓기 위해
[참조] https://its-easy.tistory.com/19