package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //Aop로 쓸 수 있도록 하는 어노테이션
@Component //컴포넌트 스캔 되어서 등록됨. but SpringConfig에 빈으로 등록하는 것을 더 선호함.
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") //어디에 적용할 것인지를, 우리 hellospring 패키지 하위에는 다 적용하라는 뜻
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: "+joinPoint.toString());
        try {
            Object result = joinPoint.proceed();//다음 메서드로 진행
            return result;
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: "+joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
