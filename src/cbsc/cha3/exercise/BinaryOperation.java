package cbsc.cha3.exercise;

import java.util.Random;

// 尝试策略模式实现开闭原则
// import java.util.Random;

public abstract class BinaryOperation {
	private int left_operand=0, right_operand=0;
	private char operator='+';
  	private int value=0;
	
  	private int getValidOperand(Constraints rule){
  		Random random = new Random();
		return random.nextInt(rule.getUpper()+1);
  	}
	protected void generateBinaryOperation(char anOperator, Constraints rule) {
	    int left, right;
		left = getValidOperand(rule);
		do {
   			right = getValidOperand(rule);	
		} while (!(rule.checkCalculation(left,right)));
		left_operand = left;
		right_operand = right;
		value = calculate(left,right);
		operator = anOperator;	
	}
  	abstract int calculate(int left, int right);
  	
	public int getLeftOperand(){return left_operand;}
	public int getRightOperand(){return right_operand;}
	public char getOperator(){return operator;}
	public int getResult(){return value;}

	public boolean equals (BinaryOperation anOperation) {  // 要使用 getOperator()
		return 	left_operand == anOperation.getLeftOperand() &
				right_operand == anOperation.getRightOperand() &
				operator == anOperation.getOperator();			
	}
	public String toString(){
		return ""+left_operand+getOperator()+right_operand;
	}
	public String asString(){
		return toString()+"=";
	}
	public String fullString(){
		return toString()+"="+getResult();
	}  
	
	public static void main(String[] args) {
		BinaryOperation bop;
        System.out.println("test1:constructor('-')");   
        int column=1;  
        for (int i=0; i<40; i++){
        	bop = new SubstractOperation();
        	if (column > 5){
        		System.out.print("\n");
				column = 1;
			}
        	System.out.print(""+(i+1)+"."+"   ");
        	System.out.print(bop.fullString()+"\t");
			column++;	
        }
	}
}
class AdditionOperation extends BinaryOperation {
	AdditionOperation() {	
		generateBinaryOperation('+', new AdditionConstraints());		
	}
	int calculate(int left, int right){
		return left+right;
	}
}
class SubstractOperation extends BinaryOperation {
	SubstractOperation() {	
		generateBinaryOperation('-', new SubstractConstraints());		
	}
	int calculate(int left, int right){
		return left-right;
	}
}
