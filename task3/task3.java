import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class task3 {

    public static void main(String[] args) {
        try {
            Scanner s1 = new Scanner(new File(args[0] + "\\Cash1.txt"));
            Scanner s2 = new Scanner(new File(args[0] + "\\Cash2.txt"));
            Scanner s3 = new Scanner(new File(args[0] + "\\Cash3.txt"));
            Scanner s4 = new Scanner(new File(args[0] + "\\Cash4.txt"));
            Scanner s5 = new Scanner(new File(args[0] + "\\Cash5.txt"));

            ArrayList<Float> kass = new ArrayList<>();
            ArrayList<Float> savekass = new ArrayList<>();

            for(int i = 0; i < 16; i++){
                s1.useLocale(Locale.US);
                s2.useLocale(Locale.US);
                s3.useLocale(Locale.US);
                s4.useLocale(Locale.US);
                s5.useLocale(Locale.US);
                float x = s1.nextFloat(), x1 = s2.nextFloat(), x2 = s3.nextFloat(), x3 = s4.nextFloat(), x4 = s5.nextFloat();
                float Sum = x + x1 + x2 + x3 + x4;
                savekass.add(Sum);
                kass.add(Sum);
            }
            Collections.sort(kass);
            for(int i = 0; ;i++){
                if(kass.get(15).equals(savekass.get(i))){
                    System.out.println(i + 1);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
