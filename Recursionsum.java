//sum of natural numbers using recursion
class Recursionsum{
	static int sum(int n){
		if(n==1){
			return 1;
		}else{
			return n+sum(n-1);
		}
	}
	public static void main(String[] args){
        int number=10;
        int result=sum(number);
System.out.println("sum of first"+number+"natural numbers is"+result);
}
}