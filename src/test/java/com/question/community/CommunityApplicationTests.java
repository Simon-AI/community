package com.question.community;


import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootTest
// implements ApplicationContextAware
class CommunityApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {

	}

//	@Override
//	public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
//		this.applicationContext = (ApplicationContext) applicationContext;
//	}

}
