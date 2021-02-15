
//Ability to manage emp wage of multiple companies using array
class TotalWage {
	
	public final String company;
	public final int empRatePerHour; 
	public final int numOfWorkingDays;
	public final int maximumHoursPerMonth;
	public int totalWage;
    public TotalWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth)
    {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maximumHoursPerMonth = maximumHoursPerMonth;
	}
	public void setTotalEmpWage(int totalWage) {
		
		this.totalWage = totalWage;
	} 
	public String toString() {
		return "\nTotal Employee Wage for " +company+ " is " +totalWage;
	}
}
    public class EmpWageBuilder {
    	
        public static final int isFullTime = 1;
	public static final int isPartTime = 2;
	private int numOfCompany; 
	private TotalWage[] empWageArray;
	
	public EmpWageBuilder() {
  
		empWageArray=new TotalWage[5];
	}
	private void addCompanyEmpWage( String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {

		empWageArray[numOfCompany]=new TotalWage( company, empRatePerHour, numOfWorkingDays, maximumHoursPerMonth);
		numOfCompany++;
	}
    private int calculate(TotalWage a) {
		
		int empHours = 0;
		int totalEmpHours = 0; 
		int totalWorkingDays = 1;
                while(totalEmpHours <= a.maximumHoursPerMonth && totalWorkingDays <= a.numOfWorkingDays) {

                int check = (int) (Math.floor(Math.random() * 10 ) % 3);
                  switch (check) {
                    case isPartTime: 
                          empHours = 4;
                          break;
                    case isFullTime:
                          empHours = 8;
                          break;
                    default :
                          empHours = 0;
                }
             totalEmpHours += empHours;
             System.out.println("day# "+totalWorkingDays +"           "+"Emp hr :" +empHours);
             totalWorkingDays += 1;
             } 
       return totalEmpHours * a.empRatePerHour;
   }
	private void computeEmpWage() {
		
		        for(int i=0;i<numOfCompany;i++) {
			empWageArray[i].setTotalEmpWage(this.calculate(empWageArray[i]));
			System.out.println(empWageArray[i]);
		    }
	}
	
	public static void main(String args[]) {

		EmpWageBuilder obj = new EmpWageBuilder();
		obj.addCompanyEmpWage("Amazon", 10, 20, 180);
		obj.computeEmpWage();
		}
}
