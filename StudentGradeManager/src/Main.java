import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static GradeManager manager;
    public static void main(String[] args) {


        //Creating default list





        //first stateslll
        String fileName;
        loop:
        while(true){
            System.out.println("What would you like to do?");
            System.out.println("1:load default file");
            System.out.println("2:load another file");
            System.out.println("3:open file editing");
            try{
                switch(Integer.parseInt(scanner.nextLine())){
                    case 1:
                        writeDefaultFile();
                        seeFile("defaultText.txt");
                        System.out.println("Loading file...");
                        break;
                    case 2:
                        try {
                            // Read the entire file content into a String
                            fileName = scanner.nextLine();
                            Path filePath = Paths.get(fileName+".txt");
                            fileToArray(filePath);

                        } catch (Exception e) {

                        }
                        break;
                    case 3:
                        if(manager==null){
                            break;
                        }
                        break loop;
                    case 4:
                        System.exit(0);
                    default:
                        break;
                }
            }catch(Exception e){

            }
        }


        //second state

        String nameStudent;
        int idStudent;
        ArrayList<Double> grades;
        String fileSaveName;
        loop2:
        while(true){
            System.out.println("What would you like to do?");
            System.out.println("1:add student");
            System.out.println("2:remove student");
            System.out.println("3:See students list");
            System.out.println("4:save program");
            System.out.println("5:exit program");
            try{
                switch(Integer.parseInt(scanner.nextLine())){
                    case 1:
                        System.out.println("Student name:");
                        nameStudent = scanner.nextLine();

                        System.out.println("Student id:");
                        idStudent = Integer.parseInt(scanner.nextLine());


                        grades = new ArrayList<>();

                        System.out.println("Would you like to add a grade?");
                        while(scanner.nextLine().toLowerCase().equals("yes")){
                            System.out.print("Enter the grade:");
                            grades.add(Double.parseDouble(scanner.nextLine()));
                            System.out.println("Would you like to add another grade?");

                        }

                        manager.addStudent(new Student(nameStudent,idStudent,grades));

                        break;
                    case 2:
                        System.out.println("Write student id:");
                        idStudent=Integer.parseInt(scanner.nextLine());
                        manager.removeStudent(idStudent);
                        break;
                    case 3: manager.showStudents();break;
                    case 4:
                        System.out.println("Write name to save the file:");
                        fileSaveName = scanner.nextLine();
                        saveFile(fileSaveName);
                        break;
                    case 5:break loop2;
                    default:break;
                }
            }catch(Exception e){
                System.out.println("An error has ocurred");
            }
        }





    }



    /*
    public static void loadFile(){
        try {
          BufferedReader reader = new BufferedReader(new FileReader("defaultext.txt"));
          String line;
          while((line = reader.readLine())!= null) {

          }
          reader.close();
         }catch(IOException e){
          e.printStackTrace();
        }
    }
     */

    //ready
    public static void seeFile(String fileName){
        Path filePath = Paths.get(fileName);

        try {
            // Read the entire file content into a String
            String content = Files.readString(filePath);
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }



    }


    //ready
    public static void writeDefaultFile(){

        StringBuilder content = new StringBuilder();
        manager = new GradeManager();

        manager.addStudent(new Student("Guillermo",2345,new double[]{85.6,78.2,55.5}));
        manager.addStudent(new Student("Pedro",2346,new double[]{99.5,60.2,44.5}));

        content.append(new Student("Guillermo",2345,new double[]{85.6,78.2,55.5}).toString())
                .append("\n");
        content.append(new Student("Pedro",2346,new double[]{99.5,60.2,44.5}).toString())
                .append("\n");




        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("defaultText.txt"));
            writer.write(content.toString());
            writer.close();
        }catch(IOException e){

        }
    }



    public static void fileToArray(Path file){

        try {
            // Read the entire file content into a String
            Path filePath = Paths.get(file.toString().toString());
            String content = Files.readString(filePath);

            manager = new GradeManager();

            for(String line : content.split("\n")){
                manager.addStudent(new Student(line));
            }

            System.out.println("Successfully loaded!.");
            seeFile(file.getFileName().toString());


        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");

        }
    }




    public static void saveFile(String filename){

        try {
             BufferedWriter writer = new BufferedWriter(new FileWriter(filename+".txt"));
             writer.write(manager.toString());
             writer.close();
             System.out.println("Successfully saved!.");
        }catch(IOException e){
            e.printStackTrace();
        }

    }




}