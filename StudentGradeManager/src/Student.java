import java.util.ArrayList;

public class Student {

    final String name;
    final int id;
    ArrayList<Double> grades = new ArrayList<>();

    public Student(String name, int id, double[] grades) {
        this.name=name;
        this.id=id;
        for(double grade : grades){
            this.grades.add(grade);
        }

    }

    public String getName() {
        return name;
    }

    public int getId() {
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

    @Override
    public String toString() {
        return "Student Name=" + name + ", id=" + id + ", grades=" + grades + "";
    }


}
