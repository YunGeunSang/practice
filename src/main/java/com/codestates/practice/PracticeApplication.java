package com.codestates.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // 아래 세 개의 애너테이션을 합친 것, @SpringBootApplication을 뺴고 아래 세개를 붙여도 정상적으로 실행된다
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

}
