package hello.core.config;

import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class), basePackages = "hello.core"
)
// default = 같은 패키지 및 그 패키지 하위만 검색 범위가 된.
// basePackage = {"hello.core.member", "hello.core.order"} 와 같이 시작 패키지를 여러 개 지정도 가
/* 권장 : 패키지 위치를 지정하지 않고, 설정 정보 클래스를 최상단에 두는 것을 기본으로 한다.
         ex) hell.core
*/
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
