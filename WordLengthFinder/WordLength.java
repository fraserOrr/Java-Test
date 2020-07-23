package WordLengthPackage;


import java.io.*;
import java.util.*;
import java.text.DecimalFormat;



/*

		Assumptions)
					1. 1 leter symbols such as "&" are counted as a word
					2. removed *
					3. For the example Chapter 3 the 3 is treated as a seperate number
					4. Removed ?!"()*&%$£
*/

public class WordLength{
	public static void main(String[] args)throws Exception{
		
		Evaluate(args[0]);
	}
	public static void Evaluate(String fileName) throws Exception{
		
		// 				file Reading

		//Variable Decleration 
		
		BufferedReader in = null;
		String line = null;
		int wordCount = 0;

		ArrayList<Integer> completeIntList = new ArrayList<Integer>();
		ArrayList<UniqueIndex> uniqueIntArrayList = new ArrayList<UniqueIndex>();

		DecimalFormat df = new DecimalFormat("0.000");
		//try catch for buffer reader
		try{
			in = new BufferedReader(new FileReader(fileName));
			
		}catch(Exception e){
			System.out.println("File Reader Error");
		}finally{
			
			// do each line in buffer
			while( (line = in.readLine()) != null){
			
			// line split for individual words 
			String[] splitLine = line.split(" ");
			for(String word:splitLine){

				//regex for removing assumed replacable characters 
				word = word.replaceAll("[,*. ?!\"()*&%$£ ]" ,"");
				word = word.replaceAll(" " ,"");

				// removing empty spaces
				int currentWordLength = word.length();
				if(currentWordLength == 0){

				}else{


				wordCount += 1;

			

				// Word Sorting
				
				//System.out.println(currentWordLength);

				// check to see if array is empty 
				if(uniqueIntArrayList.isEmpty()){
					UniqueIndex tempIndex = new UniqueIndex(currentWordLength);
					uniqueIntArrayList.add(tempIndex);
				}else{
					// if array is not empty then check to see what elements are contained in array
					//boolean variable for check result
					Boolean checkResult = false;
					for(UniqueIndex checkerIndexTemp:uniqueIntArrayList){
						if(currentWordLength == checkerIndexTemp.name){
							checkResult = true ;
							// the index already contains this wor length, increment counter
							uniqueIntArrayList.get(uniqueIntArrayList.indexOf(checkerIndexTemp)).count += 1;
							
						}else{
							
						}

					}

					if(checkResult == false){
						// if the word length is not yet contained in the array then add it 
						UniqueIndex tempIndex = new UniqueIndex(currentWordLength);
						uniqueIntArrayList.add(tempIndex);
					}
						
					
				}
			}	
			}


			}
		}
		// collect outputs for display
		double avgWordLength = FindAvgWordLength(uniqueIntArrayList, wordCount);
		String medianWordLength = FindMedianNumber(uniqueIntArrayList);
		//Format Output
		System.out.println("Word count = "+wordCount);
		System.out.println("Average Word Length = " + df.format(avgWordLength));
		
		// uses collection and the comprable implementation in UniqueIndex to sort by the word length
		  Collections.sort(uniqueIntArrayList);
		  // prints content of unique index 
		for(UniqueIndex temp:uniqueIntArrayList){
			System.out.println(temp.toString());
		}
		System.out.println(medianWordLength);
		
	}

	public static double FindAvgWordLength(ArrayList<UniqueIndex> uniqueIntArrayList, int wordCount ){
		int totalCharacters = 0;
		for(UniqueIndex checkerIndexTemp:uniqueIntArrayList){
			totalCharacters = totalCharacters + (checkerIndexTemp.name * checkerIndexTemp.count);
		}
		
		double result = ((double)totalCharacters/wordCount);
		return(result);
	}

	public static String FindMedianNumber(ArrayList<UniqueIndex> uniqueIntArrayList){
		int mostOccuringWord = 0;
		String medianNumbers = "";
		for(UniqueIndex checkerIndexTemp:uniqueIntArrayList){
			if(checkerIndexTemp.count > mostOccuringWord){
				mostOccuringWord = checkerIndexTemp.count;
				String s = Integer.toString(checkerIndexTemp.name);
				medianNumbers = s;
			}else if(checkerIndexTemp.count == mostOccuringWord){
				String s = Integer.toString(checkerIndexTemp.name);
				medianNumbers = medianNumbers + " & " + s;
			}
		}
		return("The most Frequently occuring word length is " + mostOccuringWord + ", for word lengths of " + medianNumbers );
	}

	

	
}
