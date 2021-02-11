class TotalEmpWageBuilder {

    final int isFullTime = 1;
    final int isPartTime = 2;
    private int empRatePerHour;
    private int totalDays;
    private int totalHours;
    private String company;
    private int totalSalary;

         TotalEmpWageBuilder(String company, int empRatePerHour, int totalDays, int totalHours) {
              this.company = company;
              this.empRatePerHour = empRatePerHour;
              this.totalDays = totalDays;
              this.totalHours = totalHours;
              }
    public void calculate() { 
        int hours = 0;
        int days = 0; 
        int salary = 0;
        int empHours;
        while(hours<=totalHours && days<totalDays) {
            int check = (int) (Math.floor(Math.random() * 10) %3 );
                switch(check) {
                case isPartTime:
                        empHours = 4;
                        break; 
                case isFullTime:
                        empHours = 8;
                        break;
                default :
                        empHours = 0;
                }
             hours += empHours;
             days += 1;
             salary = empRatePerHour * empHours;
             totalSalary = totalSalary + salary;
             System.out.println("Day#: " + days +"            " + "Emp Hr : " +empHours);
             }
        }
        public String toString() {
        return "Total Employee wage for " + company +" is " + (totalSalary);
     }
}
public class EmpWageBuilder {

        public static void main(String args[]) {
	        TotalEmpWageBuilder Amazon = new TotalEmpWageBuilder("Amazon", 20, 20, 100);
		Amazon.calculate();
		System.out.println(Amazon);
	        TotalEmpWageBuilder tcs = new TotalEmpWageBuilder("tcs", 20, 20, 100);
		tcs.calculate();
		System.out.println(tcs);
                TotalEmpWageBuilder ibm = new TotalEmpWageBuilder("ibm", 20, 20, 100);
                ibm.calculate();
                System.out.println(ibm);

        }
}
