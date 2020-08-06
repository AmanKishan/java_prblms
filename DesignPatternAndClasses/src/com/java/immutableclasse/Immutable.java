package com.java.immutableclasse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Immutable {

	private final int id;
	private final String name;
	private final Map<String, String> map;

	public Immutable(int id, String name, HashMap<String, String> map) {

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
		

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getMap() {
		return Collections.unmodifiableMap(this.map);
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
		Immutable im = new Immutable(id, name, map);
		id = 3;
		name = "NO";
		System.out.println(im.getId() == id);
		System.out.println(im.getName() == name);
System.out.println("sds");
		map.put("aman1", "SpGlobal1");
		System.out.println("jkjkjj");		

		System.out.println(im.getMap());
		System.out.println(im.getMap().put("aman", "hello"));//run time error
		

	}
}
