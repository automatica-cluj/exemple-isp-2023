package utcluj.isp.curs3.liste.maps;

public class GradeManagerExample {
    public static void main(String[] args) {
        Student s1 = new Student("AAA","BBB");
        GradesManagerSystem gs  = new GradesManagerSystem();
        gs.addStudent(s1);

        Student x = gs.searchByName("AAA");
        x.setDepartment("AUT");


        System.out.println(gs.searchByName("AAA").calculateAvarageGrade());
    }
}
