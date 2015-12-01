/*

* Author: Duvvuri *

*Problem 1:
Given a list of people with their birth and end years (all between 1900 and 2000),
find the year with the most number of people alive.

*Coding language:
Java

*Solution description and time complexity analysis:
ReadMe.txt

*Input Sample:
*inputsample.txt

*Editor:
Eclipse Kepler

*Compiler:
*JavaSE:1.7


*****PS: INPUT THROUGH COMMAND LINE(NO EXTERNAL INPUT FILES NEEDED)*** 

 */

package problem1;

import java.util.ArrayList;
import java.util.Scanner;

public class yearWithPeopleAlive {
	
	public static void main(String[] args){
		
		//Creating an array list of persons
		ArrayList<person> persons = new ArrayList<person>();
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		boolean exit = true;
		System.out.println("Enter 0 to exit");
		
		while(exit){			
			
			//Reading birth year 
			System.out.println("Enter birth year");
			int birthyear = sc1.nextInt();
			
			//Reading death year
			System.out.println("Enter death year");
			int deathyear = sc2.nextInt();
			
			//If the birth year is less than 1900 or greater than 2000 or if death year is less than birth year, we cannot add 
			//anymore person objects.
			if(birthyear <= 1900 || deathyear >= 2000 || deathyear < birthyear){
				System.out.println("Birth year OR Death year is invalid !! Can't add any more objects");
				exit = false;
			}
			else{
				//Else add the person object with birth and death years to the arraylist that we created.
				persons.add(new person(birthyear, deathyear));
			}
		}
		
		maxYear m = new maxYear();		
		System.out.println("Year with max people alive is : "+ m.year(persons));
		
	}
}

class maxYear{
	
	public int year(ArrayList<person> persons){
		
		int[] aliveYears = new int[100];
		
		for(person person:persons){
			
			//creating buckets that has the count of birth and death years
			aliveYears[person.birthYear-1900]++;
			aliveYears[person.deathYear-1900]--;
			
		}
		
		int max = aliveYears[0];
		int index = 0;
		int population = 0;
		
		//Going through all the buckets to find the bucket with max birth count.
		for(int i=0; i<aliveYears.length; i++){
			population = population+aliveYears[i];
			
			if(population>max){
				max = population;
				index = i;
			}
			
		}
		
		if(max == 0 && index == 0){
			return 0;
		}
		
		else{
			return index+1900;
		}
		
	}
}

class person{
	public int birthYear;
	public int deathYear;
	
	person(int birthyear, int deathyear){
		this.birthYear = birthyear;
		this.deathYear = deathyear;
	}
	
}