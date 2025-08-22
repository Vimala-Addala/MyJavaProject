package wiremetrics.in;

public class Student {
    private int id;
    private String name;
    private String rollNo;
    private String department;
    private String email;
    private String phone;
    private int marks;

    public Student(int id, String name, String rollNo, String department, String email, String phone, int marks) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.marks = marks;
    }

    public Student(String name, String rollNo, String department, String email, String phone, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.marks = marks;
    }

    public int getId() {
    	return id; 
    }
    public String getName() { 
    	return name; 
    }
    public String getRollNo() { 
    	return rollNo; 
    }
    public String getDepartment() { 
    	return department; 
    }
    public String getEmail() { 
    	return email; 
    }
    public String getPhone() { 
    	return phone; 
    }
    public int getMarks() { 
    	return marks; 
    }

    public void setName(String name) { 
    	this.name = name; 
    }
    public void setRollNo(String rollNo) { 
    	this.rollNo = rollNo; 
    }
    public void setDepartment(String department) { 
    	this.department = department; 
    }
    public void setEmail(String email) { 
    	this.email = email; 
    }
    public void setPhone(String phone) { 
    	this.phone = phone; 
    }
    public void setMarks(int marks) { 
    	this.marks = marks; 
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-10s %-15s %-25s %-15s %-5d", 
            id, name, rollNo, department, email, phone, marks);
    }
}