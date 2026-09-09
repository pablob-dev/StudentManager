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


    public Student(String line){


        this.name = line.split("=")[1].split(",")[0];
        this.id = Integer.parseInt(line.split(",")[1].split("=")[1].trim());

        grades = new ArrayList<>();
        for(int i=0; i<line.split("=")[5].split(",").length;i++){
            grades.add(Double.parseDouble(line.split("=")[5].split(",")[i]));
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

        StringBuilder sb = new StringBuilder();

        for(double grade : grades){
            sb.append(grade).append(",");
        }

        return "Student Name=" + name + ",id=" + id + ",grades=" + sb;
    }


}
