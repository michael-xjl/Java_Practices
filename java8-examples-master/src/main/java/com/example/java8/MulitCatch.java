package com.example.java8;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.management.RuntimeErrorException;

public class MulitCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
//			throw new IOException();
			throw new RuntimeException("rethrow this exception from IO: ");
		}
//		catch(FileNotFoundException | IOException ex)
		catch( Exception ex)
		{
			System.out.println(ex);
			
//			e = new RuntimeException();             // DOES NOT COMPILE
		}
	}

	
	void throwRuntimeExcp()
	{
		throw new RuntimeException();
	}
}
