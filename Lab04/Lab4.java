import java.util.Arrays;

public class Lab4 {   
    public static void main(String[] args) throws IllegalTrioException { 
	Sandwich veggie = new Sandwich("Veggie Hummus Sandwich",2.75);
	Sandwich club = new Sandwich("Club Sandwich", 2.75);
	Sandwich turkey = new Sandwich("Uptown Turkey Sandwich", 1.25);
	Sandwich ham = new Sandwich("Parisian Ham and Brie Sandwich", 2.25);
	Salad spinach = new Salad("Spinach Salad",1.25);
	Salad coleslaw = new Salad("Coleslaw", 1.25);
	Salad med = new Salad("Mediterranean Salad", 2.25);
	Salad chix = new Salad("Chicken Caesar Salad", 1.75);
	Drink orange = new Drink("Orange Soda", 1.25);
	Drink cap = new Drink("Cappuccino", 3.50);
	// Ex1 
	System.out.println(veggie.getName()+ " " + veggie.getPrice());
	System.out.println(club.getName()+ " " + club.getPrice());
	System.out.println(spinach.getName()+ " " +
	            spinach.getPrice());
	System.out.println(coleslaw.getName()+ " " +
			    coleslaw.getPrice());
	System.out.println(orange.getName()+ " " + orange.getPrice());
	System.out.println(cap.getName()+ " " + cap.getPrice());

	//Ex2
	Trio trio1 = new Trio(ham, med, orange);
	System.out.println(trio1.getName());
	System.out.println(trio1.getPrice());
	Trio trio2 = new Trio(club,chix,cap);
	System.out.println(trio2.getName());
	System.out.println(trio2.getPrice());	   
	
	/*
	//Ex3
	Trio trio3 = new Trio(turkey, coleslaw, orange);
	System.out.println(trio3.getName());
	System.out.println(trio3.getPrice());
	*/

	//Ex4
	Trio trio4 = new Trio(turkey, spinach, cap);
	Trio trio5 = new Trio(ham, med, orange);
	Trio trio6 = new Trio(veggie, chix, cap);

	Trio[] trioos = {trio1, trio2, trio4, trio5, trio6};
	for (int i = 1; i < trioos.length; i++) {
		System.out.println(trioos[i].compareTo(trioos[i-1]));
	}
    }
}
