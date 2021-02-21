package Main;

import java.io.*;

public class Task7 {

    public static void analyzeFile(String filePath) throws IOException {
        BufferedReader br = initializeBufferedReader(filePath);
        int countLines = 0;
        int countWords = 0;
        int countChars = 0;
        String data;
        while((data=br.readLine())!=null){
            countLines++;
            String[] words = data.split("\\s+");
            countWords+=words.length;
            countChars+=data.length();
        }
        System.out.println("File contains "+countLines+" lines, "+countWords+" words, "+
                countChars+" characters.");

    }

    private static BufferedReader initializeBufferedReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        return new BufferedReader(input);
    }
}
