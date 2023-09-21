/*
스프링

어노테이션 -> 자바소스코드에 추가하는 표식, 메타데이터의 비중이 가장 큼

IoC -> 제어의 역전 외부에서 관리하는 객체를 가져와 사용
스프링은 스프링 컨테이나가 객체를 관리,제공하는 역할을 함
public class A {
    @Autowired
    private B b; -> 이때 b에는 객체를 외부에서 받아와 할당! new로 안줌!
}

DI - 의존성주입
어떤클래스가 다른 클래스에 의존한다
@AutoWired 라는 어노테이션은 스프링 컨테이너에 있는 빈이라는 것을 주입
빈 -> 스프링 컨테이너가 관리하는 객체!

왜 생성해서 줄까? -> 전역으로 사용해야하는 애들이라 그럼!!

스프링컨테이너 -> 빈을 생성하고 생명주기를 관리, 

빈 -> MyBean이라는 클래스에 @Component 어노테이션을 붙이면 MyBean클래스가 빈으로 등록
빈의 이름은 클래스의 첫글자를 소문자로 바꿔 관리 -> myBean

@Component
public class MyBean {}

관점지향프로그래밍 -> AOP 
관심을 기준으로 모듈화 -> 

PSA -> 이식 가능한 추상화 서비스 

@SpringBootApplication -> java의 main() 메서드라 생각하기

여기 어노테이션 안에는 
@SpringBootConfiguration, 
    스프링 부트 관련 설정을 나타냄 @Configuration을 상속받음!, 
@ComponentScan, 
    사용자가 등록한 빈을 읽고 등록!, (@Configuration, @Repository, @controller, @Service)
@EnableAutoConfiguration
    스프링 부트 자동 구성을 활성화, 스프링 부트의 메타파일을 읽고 정의된 설정들을 자동으로 구성

이건 다른거
@RestController -> 라우터 역할을 함!
라우터 -> http요청과 메서드를 연결

 * 
 */
