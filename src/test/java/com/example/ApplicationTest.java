package com.example;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Application;

/**
 * @author TODO
 */
public class ApplicationTest {

	@Test
	public void bootstrapsApplication() {
		new AnnotationConfigApplicationContext(Application.class);
	}
}
