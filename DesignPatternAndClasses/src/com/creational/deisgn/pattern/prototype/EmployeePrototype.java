package com.creational.deisgn.pattern.prototype;

import java.util.ArrayList;
import java.util.List;


/**
 * Prototype design pattern is used when the Object creation
 *  is a costly affair and requires a lot of time and resources and
 *   you have a similar object already existing.

Prototype pattern provides a mechanism to copy the original
 object to a new object and then modify it according to our needs. 
 Prototype design pattern uses java cloning to copy the object.
 * @author aman_rastogi
 *
 */
public class EmployeePrototype implements Cloneable {
	
	private List<String> empList;
	
	public EmployeePrototype() {
		empList = new ArrayList<>();
	}
	
	public EmployeePrototype(List<String> list) {
		this.empList = list;
	}
	
	public void loadData(){
		//read all employees from database and put into the list
		empList.add("Pankaj");
		empList.add("Raj");
		empList.add("David");
		empList.add("Lisa");
	}
	
	public List<String> getEmpList() {
		return empList;
	}
	
	/**
	 * clone method is overridden to provide a deep copy of the employees list.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException{
			List<String> temp = new ArrayList<>();
			for(String s : this.getEmpList()){
				temp.add(s);
			}
			return new EmployeePrototype(temp);
	}
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		EmployeePrototype emps = new EmployeePrototype();
		emps.loadData();
		EmployeePrototype emps1 =  (EmployeePrototype) emps.clone();
		EmployeePrototype emps2 =  (EmployeePrototype) emps.clone();
		List<String> emplist1 = emps1.getEmpList();
		emplist1.add("aman");
		
		List<String> emplist2 = emps2.getEmpList();
		emplist2.remove("David");
		System.out.println("emps List: "+emps.getEmpList());
		System.out.println("empsNew List: "+emplist1);
		System.out.println("empsNew1 List: "+emplist2);
	}
}
