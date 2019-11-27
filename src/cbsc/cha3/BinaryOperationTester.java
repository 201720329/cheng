package cbsc.cha3;

public class BinaryOperationTester {
	public static void main(String[] args) {
		// 设计一：只有一个类，设计二：有两个子类
		BinaryOperation_3_2 bop;
        System.out.println("test1:constructor('+')");   
        for (int i=0; i<10; i++){
        	bop = new AdditionOperation();
        	System.out.println(bop);
        }
        System.out.println("test1:constructor('-')");   
        for (int i=0; i<10; i++){
        	bop = new SubstractOperation();
        	System.out.println(bop);
        }
	}

}
