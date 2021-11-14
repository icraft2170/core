package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너")
    void pureContainer(){
        //given
        AppConfig appConfig = new AppConfig();

        //when
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        //then
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체사용")
    void singletonServiceTest(){
        //given
        //when
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        //then
        assertThat(singletonService1).isSameAs(singletonService2);
    }
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainerTest(){
        //given
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        //when
        //then
        assertThat(memberService1).isSameAs(memberService2);
    }



}
