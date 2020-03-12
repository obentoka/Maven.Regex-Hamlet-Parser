import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String findHameletAndReplace(String inputString){
        String[] words = inputString.split(" ");
        StringBuilder retString = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            retString.append(changeHamletToLeon(words[i]));
            if(i != words.length-1)
                retString.append(" ");
        }
        return retString.toString();
    }

    public String findHoratioAndReplace(String inputString){
        String[] words = inputString.split(" ");
        StringBuilder retString = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            retString.append(changeHoratioToTariq(words[i]));
            if(i != words.length-1)
                retString.append(" ");
        }
        return retString.toString();
    }

    public String changeHamletToLeon(String inputString){
        String leon = "leon";
        Pattern hamlet = Pattern.compile("[hH][aA][mM][lL][eE][tT]");
        Matcher m = hamlet.matcher(inputString);
        if(m.matches()){
            if(inputString.charAt(1) == 'A')
                leon = leon.toUpperCase();
            else if(inputString.charAt(0) == 'H')
                leon = "Leon";
            return leon;
        }
        return inputString;
    }

    public String changeHoratioToTariq(String inputString){
        String tariq = "tariq";
        Pattern hamlet = Pattern.compile("[hH][oO][rR][aA][tT][iI][oO]");
        Matcher m = hamlet.matcher(inputString);
        if(m.matches()){
            if(inputString.charAt(1) == 'O')
                tariq = tariq.toUpperCase();
            else if(inputString.charAt(0) == 'H')
                tariq = "Tariq";
            return tariq;
        }
        return inputString;
    }

    public void parseLeonTariq(File fileParsingTo) throws IOException {
        String retString = "";
        FileWriter fw = new FileWriter(fileParsingTo);
        Pattern hamlet = Pattern.compile("Hamlet");
        Matcher ham = hamlet.matcher(hamletData);
        retString = ham.replaceAll("Leon");

        Pattern hamlet2 = Pattern.compile("HAMLET");
        ham = hamlet2.matcher(retString);
        retString = ham.replaceAll("LEON");

        Pattern horatio = Pattern.compile("Horatio");
        ham = horatio.matcher(retString);
        retString = ham.replaceAll("Tariq");

        Pattern horatio2 = Pattern.compile("HORATIO");
        ham = horatio2.matcher(retString);
        retString = ham.replaceAll("TARIQ");

        fw.write(retString);
        fw.close();
    }
}
