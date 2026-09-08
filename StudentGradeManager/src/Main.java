import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static StringBuilder data = new StringBuilder();
    public static void main(String[] args) {


    }




    public static void loadFile(){
        try {
          BufferedReader reader = new BufferedReader(new FileReader("\\FilesWriter\\Students.txt"));
          String line;
          while((line = reader.readLine())!= null) {
            data.append(line + "\n");
          }
          reader.close();
         }catch(IOException e){
          e.printStackTrace();
        }
    }

    public static void writeFile(String data){

    }

    public static void saveFile(){

        try {
             BufferedWriter writer = new BufferedWriter(new FileWriter("\\FilesWriter\\Students.txt"));
             writer.write(data.toString());
             writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }









    }


}