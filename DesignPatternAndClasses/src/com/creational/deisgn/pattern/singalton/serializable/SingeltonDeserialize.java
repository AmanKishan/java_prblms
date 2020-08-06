package com.creational.deisgn.pattern.singalton.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingeltonDeserialize {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SingeltonSerializable singelobjOne = SingeltonSerializable.getSingeltonSerialIzeObj();

		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(singelobjOne);
        out.close();
        
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        
        SingeltonSerializable singelobjTwo = (SingeltonSerializable) in.readObject();
        in.close();
        
        System.out.println("instanceOne hashCode="+singelobjOne.hashCode());
        System.out.println("instanceTwo hashCode="+singelobjTwo.hashCode());
	}
}
