import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            System.out.println("3:exit program");
            try{
                switch(scanner.nextInt()){
                    case 1:
                        writeDefaultFile();
                        seeFile("defaultText.txt");
                        System.out.println("Loading file...");
                        break;
                    case 2:
                        scanner.nextLine();
                        fileName = scanner.nextLine();
                        Path filePath = Paths.get(fileName+".txt");

                        try {
                            // Read the entire file content into a String
                            fileToArray(filePath);
                            System.out.println("An error occurred while reading the file.");
                        } catch (Exception e) {
                            System.out.println("An error occurred while reading the file.");
                            e.printStackTrace();
                        }
                        seeFile(fileName + ".txt");
                        break;
                    case 3:
                        break loop;
                    default:
                        scanner.nextLine();
                        break;
                }
            }catch(Exception e){
                scanner.nextLine();
            }
        }


        //second state
        /*
        String fileName;
        loop2:
        while(true){
            System.out.println("What would you like to do?");
            System.out.println("1:add student");
            System.out.println("2:exit program");
            try{
                switch(scanner.nextInt()){
                    case 1:
                        scanner.nextLine();
                        fileName = scanner.nextLine();
                        Path filePath = Paths.get(fileName+".txt");

                        try {
                            // Read the entire file content into a String
                            fileToArray(filePath);
                            System.out.println("An error occurred while reading the file.");
                        } catch (Exception e) {
                            System.out.println("An error occurred while reading the file.");
                            e.printStackTrace();
                        }
                        break;
                    case 2:break;
                    case 3:break;
                    case 4:
                        break loop2;
                    default:break;
                }
            }catch(Exception e){

            }
        }
        */




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
            e.printStackTrace();
        }

        System.out.println(manager.toString());

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
            e.printStackTrace();
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


        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

    }



    /*
    public static void saveFile(){

        try {
             BufferedWriter writer = new BufferedWriter(new FileWriter("\\FilesWriter\\Students.txt"));
             writer.write(data.toString());
             writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

     */


}