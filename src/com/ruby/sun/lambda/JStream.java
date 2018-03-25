package com.ruby.sun.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JStream {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		int max = list.stream().reduce(1, Integer::max);//.reduce(Integer::max);
		int sum = list.stream().reduce(0, (a,b)->a+b);
		System.out.println(sum);
		/*List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
		//List<Integer> list = 
				words.stream()
									.map(String::length)
									.forEach(System.out::println);
									//.collect(Collectors.toList());
*/		
		/*List<Transaction> list = new ArrayList<Transaction>();
		Optional<Transaction> result ;
		list.stream()
			.filter(transaction -> transaction.getType()==Transaction.GROCERY)
			.findAny()
			.ifPresent(System.out::println);*/
		
		/*List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> result = numbers.stream()
			.filter(num -> num%2==0)
			.map(num -> num*num)
			.limit(2)
			.collect(Collectors.toList());
		System.out.println(result.toString());*/
		
		/*List<Transaction> list = new ArrayList<Transaction>();
		List<Integer> groceryIdList = list.stream()
				.filter(transaction -> transaction.getType()==Transaction.GROCERY)
				.sorted(Comparator.comparing(Transaction::getValue).reversed())
				.map(Transaction::getId)
				.collect(Collectors.toList());*/
	}
}

class Transaction{
	public static int GROCERY = 1;
	int id;
	int type;
	double value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
}
