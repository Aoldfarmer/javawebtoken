package com.koou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author koou
 * @version 1.0
 * @since 2017-05-07 下午 23:13
 */
@SpringBootApplication
@MapperScan(basePackages = "com.koou.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
