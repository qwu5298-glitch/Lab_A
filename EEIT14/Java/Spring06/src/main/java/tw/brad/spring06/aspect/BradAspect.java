package tw.brad.spring06.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BradAspect {
	@Around("@annotation(tw.brad.spring06.annotation.BradAOP)")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("before:" + joinPoint.getSignature().getName());
		Object obj = joinPoint.proceed();
		System.out.println("after:" + joinPoint.getSignature().getName());
		return obj;
	}
}