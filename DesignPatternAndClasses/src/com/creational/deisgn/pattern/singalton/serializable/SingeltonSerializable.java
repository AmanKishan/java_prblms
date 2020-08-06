package com.creational.deisgn.pattern.singalton.serializable;

import java.io.Serializable;

public class SingeltonSerializable implements Serializable {

	/**
	 * serialVersionUID = 4007493700406977228L;
	 */
	private static final long serialVersionUID = 4007493700406977228L;
	private static SingeltonSerializable singeltonSerializableObj;

	private SingeltonSerializable() {

	}

	public static SingeltonSerializable getSingeltonSerialIzeObj() {

		if (singeltonSerializableObj == null) {
			singeltonSerializableObj = new SingeltonSerializable();
		}
		return singeltonSerializableObj;
	}
	
	/**Resolve singelton pattern destroying
	 * */
	/**The readResolve method is called when ObjectInputStream has 
	 * read an object from the stream and is preparing to return it to the caller. 
	 * ObjectInputStream checks whether the class of the object defines the 
	 * readResolve method. If the method is defined,
	 *  the readResolve method is called to allow the object in the stream
	 *   to designate the object to be returned. The object returned should be
	 *    of a type that is compatible with all uses. 
	 *    If it is not compatible, a ClassCastException will be thrown when the 
	 *    type mismatch is discovered.*/
	
	 protected Object readResolve()
	    {
	        return getSingeltonSerialIzeObj();
	    }

}
