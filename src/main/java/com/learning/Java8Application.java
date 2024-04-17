package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.model.Address;

@SpringBootApplication
public class Java8Application implements CommandLineRunner {

	

	public static void main(String[] args) {
		List<Address> addressList = new ArrayList<>();
		SpringApplication.run(Java8Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(addressList.size());

	}

}
