import java.util.ArrayList;

public class Student {

    final String name;
    final String id;
    ArrayList<Double> grades;

    public Student(String name, String id, ArrayList<Double> grades) {
        this.name=name;
        this.id=id;
        this.grades=grades;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade){
        try{
            grades.add(grade);
        }
        catch(Exception e){

        }
    }

    public void showStudent(){
        System.out.println("Name: "+name+"\nID: "+id+"\nGrades: "+grades);
    }


}
