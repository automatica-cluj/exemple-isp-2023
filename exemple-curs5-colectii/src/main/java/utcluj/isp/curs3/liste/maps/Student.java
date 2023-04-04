package utcluj.isp.curs3.liste.maps;

import java.util.HashMap;

public class Student {
    private String name;
    private String department;
    private HashMap <String, Double> grades = new HashMap<>();

    public Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public double calculateAvarageGrade(){
        if(grades.size()==0)
            return 0;

        int sum = 0;
        for(Double d: grades.values()){
            sum+=d;
        }
        return sum/grades.size();
    }

    public void addGrade(String clas, double grade){
        grades.put(clas,grade);
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
