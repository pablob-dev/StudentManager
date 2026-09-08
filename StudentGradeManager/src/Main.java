import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        //Creating default list





        //first state

        loop:
        while(true){
            System.out.println("What would you like to do?");
            System.out.println("1:load file");
            System.out.println("2:exit program");
            try{
                switch(scanner.nextInt()){
                    case 1:
                        writeDefaultFile();
                        seeFile();
                        System.out.println("Loading file...");
                    case 2:
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
        loop2:
        while(true){
            System.out.println("What would you like to do?");
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
    public static void seeFile(){
        Path filePath = Paths.get("defaultText.txt");

        try {
            // Read the entire file content into a String
            String content = Files.readString(filePath);
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }


    //ready
    public static void writeDefaultFile(){

        GradeManager manager = new GradeManager();
        manager.addStudent(new Student("Guillermo",2345,new double[]{85.6,78.2,55.5}));
        manager.addStudent(new Student("Pedro",2346,new double[]{99.5,60.2,44.5}));




        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("defaultText.txt"));
            writer.write(manager.toString());
            writer.close();
        }catch(IOException e){
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