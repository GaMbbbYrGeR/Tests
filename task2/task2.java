import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        try {
            Scanner s1 = new Scanner(new File(args[0]));
            Scanner s2 = new Scanner(new File(args[1]));
            ArrayList<Float> arrayX = new ArrayList<>();
            ArrayList<Float> arrayY = new ArrayList<>();
            int k = 0, p = 0;
            while (s1.hasNext()) {
                s1.useLocale(Locale.US);
                float x = s1.nextFloat();
                float y = s1.nextFloat();
                arrayX.add(x);
                arrayY.add(y);
            }

            while (s2.hasNext()) {
                s2.useLocale(Locale.US);
                float x1 = s2.nextFloat();
                float y1 = s2.nextFloat();
//                System.out.print(x1);
//                System.out.println(" " + y1);
                for (int i = 0; i < 4; i++) {
//                    System.out.print(arrayX.get(i));
//                    System.out.println(" " + arrayY.get(i));
                    if (x1 == arrayX.get(i) && y1 == arrayY.get(i)) {
                        System.out.println(0);
                        k = 0;
                        p = 1;
                        break;
                    } else {
                        if (i == 3) {
                            if ((x1 - arrayX.get(i)) * (arrayY.get(0) - arrayY.get(i)) -
                                    (y1 - arrayY.get(i)) * (arrayX.get(0) - arrayX.get(i)) == 0) {
                                k = 1;
                            } else {
                                if ((x1 - arrayX.get(i)) * (arrayY.get(0) - arrayY.get(i)) -
                                        (y1 - arrayY.get(i)) * (arrayX.get(0) - arrayX.get(i)) < 0) {
                                    System.out.println(3);
                                    k = 0;
                                    p = 1;
                                    break;
                                }
                            }
                        } else {
                            if ((x1 - arrayX.get(i)) * (arrayY.get(i + 1) - arrayY.get(i)) -
                                    (y1 - arrayY.get(i)) * (arrayX.get(i + 1) - arrayX.get(i)) == 0) {
                                k = 1;
                            } else {
                                if ((x1 - arrayX.get(i)) * (arrayY.get(i + 1) - arrayY.get(i)) -
                                        (y1 - arrayY.get(i)) * (arrayX.get(i + 1) - arrayX.get(i)) < 0) {
                                    System.out.println(3);
                                    k = 0;
                                    p = 1;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (k == 1) {
                    System.out.println(1);
                } else {
                    if(p == 0) {
                        System.out.println(2);
                    }
                }
                k = 0;
                p = 0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
