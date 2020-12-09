package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import exceptions.InvalidlArgumentValueException;

@Aspect
public class AspectValidator {
	
	@Before("execution(* pow(..))")
	public void logBeforePow() {
		System.out.println("Calculator Start");
	}
	@Around("execution(* pow(..)) && args(number, exponent)")
	public int logAroundExecution(ProceedingJoinPoint jp, int number, int exponent) throws InvalidlArgumentValueException {
		if(number == 0 && exponent == 0) {
			System.out.println("For base equals 0 and exponent equals 0 result is not defined and we are returning 0");
			return 0;
		}
		else if(exponent < 0) {
			throw new InvalidlArgumentValueException("The exponent is smaller than 0"); 
		}
		int result = (int) jp.proceed();
		return result;
	}
	@AfterReturning(pointcut = "execution(* pow(..))", returning = "result")
	public void logAfterPowReturning(int result) {
		System.out.println("Exponential has been calculated. Result is " + result);
	}
	@AfterThrowing(value = "execution(* pow(..))", throwing = "e")
	public void logAfterPowThrowing(InvalidlArgumentValueException e) {
		System.out.println(e.getMessage());
	}
	@After("execution(* pow(..))")
	public void logAfterPow() {
		System.out.println("Calculator Stop");
	}
}
