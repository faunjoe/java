package com.faunjoe.app.advice;


import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Date;

public class AspectJBrowserAroundAdvice {

	public Object aroundIntercept(ProceedingJoinPoint pjp, String music, Date date) throws Throwable{
		System.out.println(music + ":" + date);
		encrypt();
		Object retVal = pjp.proceed();
		decrypt();
		return retVal;
	}

	/**
	 * 加密
	 */
	private void encrypt(){
		System.out.println("encrypt ...");
	}

	/**
	 * 解密
	 */
	private void decrypt(){
		System.out.println("decrypt ...");
	}
}
