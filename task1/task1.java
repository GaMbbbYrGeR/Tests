import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class task1 {

    public static void main(String[] args) {
        try {
            File file = new File(args[0] + "\\file1.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            ArrayList<Integer> array = new ArrayList<>();
            String line = reader.readLine();
            double Sum = 0;
            while(line != null){
                int n = Integer.parseInt(line);
                array.add(n);
                Sum += n;
                line = reader.readLine();
            }
            System.out.println(array);
            Collections.sort(array);
            System.out.println(array);
            double m = (double)array.size() * 90 / 100;
            System.out.format("%.2f%n", (double)((array.get((int)m - 1) + array.get((int)m)) / 2));
            if(array.size() % 2 == 0){
                double result = ((double)array.get(array.size() / 2 - 1) + (double)array.get(array.size() / 2)) / 2;
                System.out.format("%.2f%n", result);
            } else {
                System.out.format("%.2f%n", (double)array.get(array.size() / 2));
            }
            System.out.format("%.2f%n", (double)array.get(array.size() - 1));
            System.out.format("%.2f%n", (double)array.get(0));
            System.out.format("%.2f%n", Sum / array.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
