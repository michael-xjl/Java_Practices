package com.example.java8.enu;

public class Swimmer {

	enum AnimalClasses{
		MAMAL{
			public boolean hasFins(){return false;}
			}, 
		FISH{
			public boolean hasFins(){return false;}
			}, 
		BIRD{
			public boolean hasFins(){return false;}
			};
		
		
		private AnimalClasses(){};
		
		public abstract boolean hasFins();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(AnimalClasses.MAMAL);
	}

}
