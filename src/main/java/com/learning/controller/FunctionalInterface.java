package com.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunctionalInterface {

	@GetMapping("/lambda")
	public void lambdaExample() {
		Operator<Integer> add = (a, b) -> a + b;

		System.out.println(add.process(1, 2));
		Addition ad = (a, b) -> a + b + 10;

		System.out.println(ad.addition(10, 0));

		Calculator<Integer, Integer, String> cal = (a, b) -> "the sum is " + (a + b);

		System.out.println(cal.addition(1, 2));
		Interface1 in1;
		in1 = () -> System.out.println("compare of interface1");
		in1.compare();
		in1 = () -> {
			System.out.println("logs of interface 1 implemented customly");
			Interface1.info();
		};

		in1.log();

	}

}

interface Operator<T> {

	T process(T a, T b);
}

interface Calculator<A, B, C> {

	C addition(A a, B b);
}

interface Addition {
	int addition(int a, int b);
}

interface Interface1 {
	public void compare();

	default void log() {
		System.out.println("interface1 log default method");
	}

	public static void info() {
		System.out.println("interface 1 info");
	}
}

interface Interface2 {
	void compare(int a, int b);

	default void log() {
		System.out.println("interface2  logs");

	}

	public static void info() {
		System.out.println("interface 2 complete info");
	}
}
