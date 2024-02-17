import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class stackApps {
    public static void main(String[] args) throws FileNotFoundException{
        VTE letsGo = new VTE();
        File buff = new File("buff.txt");
        Scanner input = new Scanner(buff);
        String line = input.nextLine();
        while(input.hasNextLine()){
            if(line.equals("parentheses tests")){
                System.out.println("parentheses tests:");
                for(int i = 0; i<3; i++){
                    letsGo.validateString(input.nextLine());
                }
                System.out.println("");
            }
            else if(line.equals("postfix equation solving")){
                System.out.println("postfix equation solving:");
                for(int i = 0; i<3; i++){
                    letsGo.evaluateString(input.nextLine());
                }
                System.out.println("");
            }
            else if(line.equals("infix to postfix conversion")){
                System.out.println("infix to postfix conversion:");
                for(int i = 0; i<5; i++){
                    letsGo.translateString(input.nextLine());
                }
                System.out.println("");
            }
            else if(line.equals("full system check")){
                System.out.println("full system check:");
                for(int i = 0; i<6; i++){
                    letsGo.fullCheck(input.nextLine());
                    System.out.println("");
                }
            }
            if(input.hasNextLine()){
                line = input.nextLine();
            }
        }

        input.close();
    }
}
