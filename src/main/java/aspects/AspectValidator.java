package aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectValidator {
	
	@Before("execution(* pow(..))")
	public void logBeforePow() {
		System.out.println("Calculator Start");
	}
	@Around(value = "execution(* pow(..)) && args(number, exponent)")
	public Integer logIfIllegalArgsBeforePow(Integer number, Integer exponent) {
		if(number == 0 && exponent == 0)
			System.out.println("For base equals 0 and exponent equals 0 result is not defined");
		return null;
	}
	@AfterReturning(pointcut = "execution(* pow(..))", returning = "result")
	public void logAfterPow(int result) {
		System.out.println("Result has been calculated. Result is " + result);
	}
	@After("execution(* pow(..))")
	public void logAfterPow() {
		System.out.println("Calculator Stop");
	}
}
