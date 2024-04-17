package com.learning.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.Address;

@RestController
public class StreamController {

	private static final String KARNATAKA = "Karnataka";
	static List<Address> addressList = Arrays.asList(
			Address.builder().area("whitefield").country("INDIA").locality("mailoor").houseNo("2122").pincode(560066)
					.state("Karnataka").street("main road").build(),
			Address.builder().area("nallurhalli").country("INDIA").locality("mailoor").houseNo("2122").pincode(560066)
					.state("Karnataka").street("main road").build(),
			Address.builder().area("old city").country("INDIA").locality("mailoor").houseNo("2122").pincode(585403)
					.state("Karnataka").street("main road").build(),
			Address.builder().area("ganj").country("INDIA").locality("mailoor").houseNo("2122").pincode(585403)
					.state("Andhra").street("main road").build());

	List<List<Address>> nestedList = Arrays.asList(addressList);

	@GetMapping("/stream")
	public void stream() {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 9, 7, 8, 6, 5, 1, 0);
		// creating a stream
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 9, 7, 8, 6, 5, 1, 0);
		List<Integer> intList = stream.collect(Collectors.toList());

		DoubleStream d = list.stream().mapToDouble(i -> i);
		d.forEach(i -> {
			System.out.println(i);
		});

		// to get the size
		System.out.println(addressList.stream().count());

		// to filter
		List<Address> adList = addressList.stream().filter(a -> a.getState().equalsIgnoreCase(KARNATAKA))
				.collect(Collectors.toList());

		// to iterate
		adList.stream().forEach(a -> {

			System.out.println(a.getArea());
		});

		//

		int sum = addressList.stream().map(a -> a.getPincode()).reduce(0, (a, b) -> (a + b));
		System.out.println(sum);
	}

	@GetMapping("/flatmap")
	public void flatMap() {

		// Before flattening : [[1, 2, 3], [4, 5], [6, 7, 8]]

		// After flattening : [1, 2, 3, 4, 5, 6, 7, 8]

		nestedList.stream().flatMap(x -> x.stream().map(a -> a.getArea())).collect(Collectors.toList()).forEach(x -> {
			System.out.println(x);
		});

		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(4, 5, 6);
		List<Integer> list3 = Arrays.asList(7, 8, 9);

		List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

		List<Integer> listOfAllIntegers = listOfLists.stream().flatMap(x -> x.stream()).collect(Collectors.toList());

		System.out.println(listOfAllIntegers);

	}

	@GetMapping("/comparator")
	public void comparator() {
		List<Address> sortedAddressList = addressList.stream().sorted((a, b) -> a.getArea().compareTo(b.getArea()))
				.collect(Collectors.toList());
		List<Address> sorByPincode = addressList.stream().sorted(Comparator.comparingInt(Address::getPincode))
				.collect(Collectors.toList());
		sortedAddressList.forEach(x -> {

			System.out.println(x.getArea() + " " + x.getPincode());

		});
		List<Address> sortbyArea = addressList.stream().sorted(Comparator.comparing(Address::getState))
				.collect(Collectors.toList());

		Stream<String> area = sortbyArea.stream().map(x -> x.getArea()).distinct();
		area.forEach(x -> {
			System.out.println(x + "---");
		});
	}

	@GetMapping("/groupby")
	public void groupBy() {
		Map<String, List<Address>> grpbyState = addressList.stream().collect(Collectors.groupingBy(Address::getState));

		grpbyState.entrySet().forEach(x -> {

			x.getValue().stream().forEach(y -> {

				System.out.println(y.getArea());
			});

		});

	}

	@GetMapping("/sortMap")
	public void sortMap() {

		Map<String, Integer> unsortMap = new HashMap<>();
		unsortMap.put("z", 10);
		unsortMap.put("b", 5);
		unsortMap.put("a", 6);
		unsortMap.put("c", 20);
		unsortMap.put("d", 1);
		unsortMap.put("e", 7);
		unsortMap.put("y", 8);
		unsortMap.put("n", 99);
		unsortMap.put("g", 50);
		unsortMap.put("m", 2);
		unsortMap.put("z", 9);

		Map<String, Integer> sortMapByKey = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		
		Map<String, Integer> byvalue = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldv,newv)->oldv,LinkedHashMap::new));
		byvalue.entrySet().stream().forEach(x->{
			System.out.println(x);
		});
		System.out.println("=============");
		Map<String, Integer> byvalueR = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldv,newv)->oldv,LinkedHashMap::new));
		byvalueR.entrySet().stream().forEach(x->{
			System.out.println(x+" rev");
		});
	}
}
