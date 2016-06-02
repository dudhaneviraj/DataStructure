import java.util.ArrayList;
import java.util.List;

interface  CustomerCareEmployee
{
	public boolean status();
	boolean getCallHandler(int level);
	public boolean getCallHandler();
	public void nextHandler(CustomerCareEmployee e);
	
	public boolean getStatus();
	
	public void setStatus(boolean status);
	
}

class Professional implements CustomerCareEmployee{
	String name;
	boolean status=true;
	CustomerCareEmployee employee;
	int problemLevel=2;
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public CustomerCareEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(CustomerCareEmployee employee) {
		this.employee = employee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public boolean status() {
		if(status)
			return true;
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean getCallHandler(int level) {
			if(level<=problemLevel)
				return true;
			return false;
		
	}

	@Override
	public void nextHandler(CustomerCareEmployee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCallHandler() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
}


class Expert implements CustomerCareEmployee{

	String name;
	boolean status=true;
	CustomerCareEmployee employee;
	
	int problemLevel=3;
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public CustomerCareEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(CustomerCareEmployee employee) {
		this.employee = employee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean status() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean getCallHandler(int level) {
			if(level<=problemLevel)
				return true;
			return false;
		
	}

	@Override
	public void nextHandler(CustomerCareEmployee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCallHandler() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}


class Fresher implements CustomerCareEmployee{

	String name;
	boolean status=true;
	int problemLevel=1;
	
	public String getName() {
		return name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean status() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCallHandler(int level) {
			if(level<=problemLevel)
				return true;
			return false;
		
	}

	@Override
	public void nextHandler(CustomerCareEmployee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCallHandler() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}


class CallHandler{
	
	List<Fresher> freshers=new ArrayList<>();
	List<Professional> professionals =new ArrayList<Professional>();
	List<Expert> experts =new ArrayList<Expert>();
	
	
	
	public CallHandler(int fr,int ex,int pr)
	{
		for(int i=0;i<fr;i++)
			freshers.add(new Fresher());
		for(int i=0;i<ex;i++)
			experts.add(new Expert());
		for(int i=0;i<pr;i++)
			professionals.add(new Professional());
	}
	
	public void getRequest(int level)
	{
		
	}
	
	
	public Fresher getFresher(){
		for(Fresher fresher:freshers)
			if(fresher.isStatus())
				return fresher;
		
		return null;
	}
	
	public Expert getExpert()
	{
		for(Expert expert: experts)
			if(expert.isStatus())
				return expert;
		return null;
	}
	
	
	public Professional getProfessional()
	{
		for(Professional professional:professionals)
			if(professional.isStatus())
				return professional;
		return null;
	}
	
	
	
	public void getCallHandler(int level)
	{
		CustomerCareEmployee employee;
		while(true)
		{
			employee=getFresher();
			if(employee!=null)
				break;
		}
		if(employee.getCallHandler(level))
		{
			System.out.println("Request Handled By: fresher");
			employee.setStatus(false);
			return;
		}
		
		while(true)
		{
			employee=getProfessional();
			if(employee!=null)
				break;
		}
		if(employee.getCallHandler(level))
		{
			System.out.println("Request Handled By: Professional");
			employee.setStatus(false);
			return;
		}
		while(true)
		{
			employee=getExpert();
			if(employee!=null)
				break;
		}
		if(employee.getCallHandler(level))
		{
			System.out.println("Request Handled By: Expert");
			employee.setStatus(false);
			return;
		}

	}
	
}



public class TestAdobe {
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		CallHandler handler=new CallHandler(10, 2, 5);
		handler.getCallHandler(2);
	}

}