package com.creational.deisgn.pattern.singalton;
/*
 * @link https://www.educba.com/design-pattern-interview-questions/ 
 */
public class EagerSingelton {

	
	private static final EagerSingelton  eagerSingeltonObj = new EagerSingelton();

	/** InstantiationError is used not to  destroy singelton using reflection*/
	private EagerSingelton() {

		 if( EagerSingelton.eagerSingeltonObj != null ) {
		        throw new InstantiationError( "Creating of this object is not allowed." );
		    }
	}
	
	public static EagerSingelton  getSingeltonObject() {
		return eagerSingeltonObj;
	}
	
	
}
