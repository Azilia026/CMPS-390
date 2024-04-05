import java.util.Scanner;
import java.io.*;
public class fileIn {
    String fname;
    public fileIn() {
        getFileName();
    }

    public String readString(){
        DataInputStream in;
        String name;
        try {
            in = new DataInputStream(new FileInputStream(fname));
            name = in.readLine();
            in.close();
            return name;
        }
        catch(IOException e){
            System.out.println("Error " + e);
        }
        return "jello";
    }

    public void readFileContents(){
        boolean looping;
        DataInputStream in;
        String line;
        int j, len;

        try {
            in = new DataInputStream(new FileInputStream(fname));

            looping = true;
            while(looping) {
                if (null == (line = in.readLine())) {
                    looping = false;
                    in.close();
                }
                else {
                    //System.out.println("line = "+line);
                    j = 0;
                    len = line.length();
                    for(j=0;j<len;j++){
                        //System.out.println("line["+j+"] ="+line.charAt(j));
                    }
                }
            }
        }

        catch(IOException e) {
            System.out.println("Error " + e);
        }
    }

    @SuppressWarnings("resource")
    public void getFileName(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter file name please.");
        fname = in.nextLine();
        System.out.println("You entered "+fname);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args){
        System.out.println("WELCOME");
        fileIn f = new fileIn();
        System.out.println("Bye-bye!");
    }
}
