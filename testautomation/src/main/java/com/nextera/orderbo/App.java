package com.nextera.orderbo;

interface Executable{
	int execute(int a, int b);
}


class Runner {
	public void run(Executable e){
		System.out.println("Executing code block...");
		int value= e.execute(12,13);
		System.out.println("return value is "+value);
	}
	
}
public class App {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		int c=100;
		Runner runner = new Runner();
		runner.run(new Executable(){
				public int execute(int a, int b) {
				System.out.println(" hello there");
				return a+b+c;
			}
			
		});
		
		System.out.println("++++++++++++++++++++++++++++");
		runner.run((a,b) -> {
			System.out.println("hello there..");
			return a+b+c;
			}
		);
	
	}
	

}
