package utcluj.isp.curs3.liste.maps;

import java.util.ArrayList;

public class GradesManagerSystem {

    private ArrayList<Student> list = new ArrayList<>();


    public void addStudent(Student s){
        list.add(s);
    }

    public Student searchByName(String name){
        for(Student s: list)
            if(s.getName().equals(name))
                return s;

        return null;
    }

}
