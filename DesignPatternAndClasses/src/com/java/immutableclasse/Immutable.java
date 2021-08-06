package com.java.immutableclasse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Immutable {

	private final int id;
	private final String name;
	private final Map<String, String> map;
	private final List<Integer> list;

	public Immutable(int id, String name, HashMap<String, String> map, List<Integer> list) {

		this.id = id;
		this.name = name;
		/** create deep copy of the object */
		Map<String, String> tempMap = new HashMap<String, String>();

		Iterator<String> itr = map.keySet().iterator();
		String key;
		while (itr.hasNext()) {
			key = itr.next();
			tempMap.put(key, map.get(key));

		}

		this.map = tempMap;
		this.list = new ArrayList<Integer>(list);

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getMap() {
		return this.map;
		//return Collections.unmodifiableMap(this.map);
	}
	
	public List<Integer> getList(){
		return new ArrayList<Integer>(list);
	}
	
	

	@Override
	public String toString() {
		return "Immutable [id=" + id + ", name=" + name + ", map=" + map + "]";
	}

	public static void main(String[] args) {

		HashMap<String, String> map = new HashMap<>();
		map.put("aman", "SpGlobal");
		map.put("Chaitra", "Citiustech");
		int id = 2;
		String name = "Partner";
		List<Integer> list = Arrays.asList(1,2,3);
		
		Immutable im = new Immutable(id, name, map,list);
		
		im.getList().add(3);
		System.out.println(im.getList());
		id = 3;
		name = "NO";
		
		System.out.println(im.getId() == id);
		System.out.println(im.getName() == name);
System.out.println("sds");
		map.put("aman1", "SpGlobal1");
		System.out.println("jkjkjj");		

		System.out.println(im.getMap());
		System.out.println(im.getMap().put("aman", "hello"));//run time error
		System.out.println(im.getMap());
		

	}
}
