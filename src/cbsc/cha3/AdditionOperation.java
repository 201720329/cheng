package cbsc.cha3;
// 
public class AdditionOperation extends BinaryOperation_3_2 {
	public AdditionOperation() {	
		generateBinaryOperation('+');		
	}
	public boolean checkingCalculation(int anInteger){
		return anInteger <= UPPER;
	}
	int calculate(int left, int right){
		return left+right;
	}
}