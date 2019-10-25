import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class task4 {

    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            ArrayList<Integer> mas = new ArrayList<>();
            ArrayList<Integer> sortmas = new ArrayList<>();
            ArrayList<Integer> counttime = new ArrayList<>();
            ArrayList<Integer> rezult = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < 2; i++) {
                    if (line.charAt(1) == ':') {
                        line = line.substring(0, 1) + line.substring(2);
                        String line1 = "" + line.charAt(0) + line.charAt(1) + line.charAt(2);
                        if (i == 0)
                            line = line.substring(4);
                        mas.add(Integer.parseInt(line1));
                        sortmas.add(Integer.parseInt(line1));
                    } else {
                        if (line.charAt(2) == ':') {
                            line = line.substring(0, 2) + line.substring(3);
                            String line1 = "" + line.charAt(0) + line.charAt(1) + line.charAt(2) + line.charAt(3);
                            if (i == 0)
                                line = line.substring(5);
                            mas.add(Integer.parseInt(line1));
                            sortmas.add(Integer.parseInt(line1));
                        }
                    }
                }
                line = reader.readLine();
            }
            Collections.sort(sortmas);
            for (int i = 0; i < sortmas.size() - 1; i++) {
                while (sortmas.get(i).equals(sortmas.get(i + 1))) {
                    sortmas.remove(i + 1);
                }
            }
            for (int i = 0; i < sortmas.size(); i++) {
                int timenow = sortmas.get(i), count = 0;
                for (int j = 0; j < mas.size(); j++) {
                    if (timenow == mas.get(j) && (j % 2 == 0)) {
                        count++;
                    } else {
                        if (timenow == mas.get(j) && (j % 2 != 0)) {
                            count--;
                        }
                    }
                }
                if (i != 0)
                    count += counttime.get(i - 1);
                counttime.add(count);
            }
            int max = counttime.get(0), count = 0;
            for(int i = 0; i < counttime.size(); i++) {
                if (counttime.get(i) > max) {
                    max = counttime.get(i);
                    count = 1;
                } else {
                    if (counttime.get(i) == max) {
                        count++;
                    }
                }
            }
            for(int i = 0; i < counttime.size() - 1; i++){
                while (counttime.get(i).equals(counttime.get(i + 1))) {
                    counttime.remove(i + 1);
                    sortmas.remove(i + 1);
                }
            }
            for (int j = 0; j < counttime.size(); j++) {
                if (counttime.get(j) == max) {
                    rezult.add(sortmas.get(j));
                    rezult.add(sortmas.get(j + 1));
                }
            }
            for(int i = 0; i <= rezult.size() / 2; i = i + 2){
                if(rezult.get(i) % 100 < 10){
                    System.out.print(rezult.get(i) / 100 + ":0" + rezult.get(i) % 100 + " ");
                } else {
                    System.out.print(rezult.get(i) / 100 + ":" + rezult.get(i) % 100 + " ");
                }
                if(rezult.get(i + 1) % 100 < 10) {
                    System.out.println(rezult.get(i + 1) / 100 + ":0" + rezult.get(i + 1) % 100);
                } else {
                    System.out.println(rezult.get(i + 1) / 100 + ":" + rezult.get(i + 1) % 100 + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
