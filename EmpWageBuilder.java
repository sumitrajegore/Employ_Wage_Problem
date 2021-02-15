//EmpWageBuilderBuilder Ability to get total wage when queried by company
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

interface IComputeEmpWage {                //if its public needs to be created in another file
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}

class CompanyEmpWage {
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maximumHoursPerMonth;
	public int totalWage;
	public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) { 

		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maximumHoursPerMonth = maximumHoursPerMonth;
	}
	public void setTotalEMpWage(int totalWage) {

		this.totalWage=totalWage;
	}
	public String toString() {

		return "\nTotal Employee Wage for "+company+" is "+totalWage+"\n";
	}
}

public class EmpWageBuilder implements IComputeEmpWage {

	public static final int isFullTime=1;
	public static final int isPartTime=2;

	private ArrayList<CompanyEmpWage> empList;
	private Map<String,CompanyEmpWage> empWageMap;
	public EmpWageBuilder() {

		empList=new ArrayList<>();
		empWageMap=new HashMap<>();
	}
	@Override
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {

		CompanyEmpWage empWage = new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		empList.add(empWage);
		empWageMap.put(company,empWage);
	}

	@Override
	public void computeEmpWage() {

            		for(int i=0;i<empList.size();i++) {
			empList.get(i).setTotalEMpWage(this.computeEmpWage(empList.get(i)));
			System.out.println(empList.get(i));
		}

	}
	@Override
	public int getTotalWage(String company) {

		return empWageMap.get(company).totalWage;
	}

	private  int computeEmpWage(CompanyEmpWage companyEmpWage) {

	     int empHours = 0, totalEmpHours = 0, totalWorkingDays = 1;
             while(totalEmpHours<=companyEmpWage.maximumHoursPerMonth && totalWorkingDays<companyEmpWage.numOfWorkingDays){
             int check = (int) (Math.floor(Math.random() * 10 ) % 3);
             switch(check){
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
             System.out.println("DAY# "+ totalWorkingDays+"               " +"emp hr : "+ empHours);
             totalWorkingDays += 1;
             }
	     return (totalEmpHours * companyEmpWage.empRatePerHour);

	}
	public static void main(String args[]) {

		EmpWageBuilder employeeWageBuilder = new EmpWageBuilder();
		employeeWageBuilder.addCompanyEmpWage("Amazon", 50, 20, 180);
		employeeWageBuilder.addCompanyEmpWage("Microsoft", 60, 24, 200);
		employeeWageBuilder.addCompanyEmpWage("Flipkart", 20, 26, 230);
		employeeWageBuilder.addCompanyEmpWage("Wipro", 10, 28, 250);
		employeeWageBuilder.addCompanyEmpWage("Accenture", 20, 22, 200);
		employeeWageBuilder.computeEmpWage();
	}
}

