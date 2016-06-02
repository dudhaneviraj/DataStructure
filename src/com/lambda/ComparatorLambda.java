package com.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Person{
	String firstName;
	String lastName;
	
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person(int id,String firstName,String lastName)
	{
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void print()
	{
		System.out.println(firstName+" : "+lastName);
	}
	
}




public class ComparatorLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Person> ls=new ArrayList<>();
		
		Person p1=new Person(1,"Viraj","XYZ");
		
		Person p2=new Person(2,"Viraj","XYZ");
		
		Person p3=new Person(3,"Viraj","XYZ");
		
		Person p4=new Person(4,"Joshi","XYZ");
		
		Person p5=new Person(5,"Milind","XYZ");
		ls.add(p1);
		ls.add(p2);
		ls.add(p3);
		ls.add(p4);
		ls.add(p5);
		
		for(Person p:ls)
			p.print();
		System.out.println("Sorted");
		
		//Sort By Id Integer
		Collections.sort(ls,(p11,p12) -> p11.getId()-p12.getId());
		
		//Sort By FirstName
		Collections.sort(ls,(p11,p12) -> p11.getFirstName().compareTo(p2.getFirstName()));
		for(Person p:ls)
			p.print();

		ls.stream().filter(p-> p.getFirstName().equals("Viraj")).map(p-> p.getId()+"").distinct().forEach(p->System.out.println(p));
		Predicate<String> pred=p->p.length()>0;
		
		ls.stream().filter(p->p.getFirstName().equals("Viraj")).collect(Collectors.toList());
		
		ls.stream().forEach(p->System.out.println(p.getId()));

		
		Map<String,Integer> map=new HashMap<>();
		
		map.put("Viraj",1);
		map.put("Jay",2);
		map.put("Hnan",3);
		map.put("GH",3);
		map.put("Vijay",4);
		map.entrySet()
        .stream()
        .filter(p -> p.getKey().equals("Viraj"))
        .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		//map.entrySet().stream().filter(e->e.getKey().equals("Viraj")).collect(Collectors.toMap());
		
		map.entrySet().stream().filter(p->p.getKey().equals("Viraj")).collect(Collectors.toMap(p -> p.getKey(),p->p.getValue()));
	
		map.entrySet().stream().filter(p->p.getKey().equals("Hnan")).forEach(p->System.out.println(p.getKey()+":"+p.getValue()));
		
		
		Map<Integer, Person> mapList=ls.stream().collect(Collectors.toMap(t->t.getId(),t->t));
		
		mapList.entrySet().stream().sorted((k1,k2)->k2.getKey()-k1.getKey()).forEach(p->System.out.println(p.getKey()+":"+p.getValue().getFirstName()));
		
		map.entrySet().stream().filter(p10->p10.getValue()>2).map(p11->p11.getKey()).sorted((t11,t12)->t11.compareTo(t12)).forEach(p111->System.out.println(p111));
		
	}
}
