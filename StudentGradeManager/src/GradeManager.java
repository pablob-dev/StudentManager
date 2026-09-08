import java.util.ArrayList;

public class GradeManager {

    ArrayList<Student>  students;

    public GradeManager(){
        students = new ArrayList<>();
    }

    //add student
    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(int id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId() == id){
                students.remove(i);
            }
        }
    }

    public void updateStudent(int id,Student student){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId() == id){
                students.set(i,student);
            }
        }
    }

    public void showStudents(){
        for(Student student: students){
            System.out.printf("Id:%d Student:%s Grades:",student.getId(),student.getName());
            System.out.println(student.getGrades());
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Student student: students){
            sb.append(student.toString()).append("\n");
        }
        return sb.toString();
    }












}
