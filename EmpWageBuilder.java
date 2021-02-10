public class EmpWageBuilder {

      public static void main(String[] args) {
       
           int IS_FULL_TIME = 1;
           System.out.println("\n welcome to employ wage program \n");
		double empCheck = Math.floor(Math.random() * 10 ) % 2 ;
		if (IS_FULL_TIME == empCheck)
		     System.out.println("Employee is Present");
		else
	             System.out.println("Employee is Absent");
     }
}
