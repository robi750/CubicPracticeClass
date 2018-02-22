package com.cubic.ehr.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.cubic.ehr.main.SampleApplication;

@SpringBootApplication
@ImportResource({ "classpath*:SpringJPA.xml" })
@ComponentScan({ "com.cubic.ehr" })
public class SampleApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleApplication.class, args);
	}

}
