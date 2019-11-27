package cbsc.cha3;

import java.io.File;
import java.util.Iterator;
public class ExerciseSheet_3_3_3 {
	private static final short COLUMN_NUMBER=5;
	public void formattedDisplay (Exercise_3_2_3 ex, int columns){
		Iterator<BinaryOperation_3_2> iterator = ex.iterator();
		// 0 < columns 
		int column=1;  
		int count = 1;
		while(iterator.hasNext()){
			if (column > columns){
				print("\n");
				column = 1;
			}
			print(""+count+"."+"   ");
			print((iterator.next()).asString()+"\t");
			count++;
			column++;
		}	
		print("\n");
	}
	public void formattedDisplay2 (Exercise_3_2_3 ex, int columns){
		// Iterator<BinaryOperation_3_2> iterator = ex.iterator();
		int column=1;  
		int count = 1;
		while(ex.hasNext()){
			if (column > columns){
				print("\n");
				column = 1;
			}
			print(""+count+"."+"   ");
			print((ex.next()).asString()+"\t");
			
			count++;
			column++;
		}	
		print("\n");
	}
	public void formattedDisplay (Exercise_3_2_3 ex){
		formattedDisplay (ex,COLUMN_NUMBER);
	}

	private static void print(String str){
		System.out.print(str);
	}
	public static void main(String[] args) {
		ExerciseSheet_3_3_3 sheet = new ExerciseSheet_3_3_3();
		Exercise_3_2_3 exercise = new Exercise_3_2_3();
		Exercise_3_2_3 ex = new Exercise_3_2_3();
		exercise.generateAdditionExercise(26);
		System.out.println("---- generate and display add exercises ----");
		sheet.formattedDisplay2(exercise,4);
		
		System.out.println("---- generate and display exercises ----");
		exercise.generateSubstractExercise(20);
		sheet.formattedDisplay2(exercise,3);
		System.out.println("---- read exercises in a file ----");
		ex=exercise.readCSVExercise(new File("test2.txt"));
		sheet.formattedDisplay(ex,4);
		ex.writeResults(new File("results.txt"));
	}

}
