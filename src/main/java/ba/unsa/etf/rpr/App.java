package ba.unsa.etf.rpr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ExpressionEvaluator e = new ExpressionEvaluator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            try {
                System.out.println("Unesite izraz: ");
                String k = reader.readLine();
                String[] unos = k.split(" ");
                int param = 0;
                boolean paramBool;
                for (int i = 0; i < unos.length; i++) {
                    String reg = "([0-9]*).*([0-9]*)";
                    paramBool = Pattern.matches(reg, unos[i]);
                    if (paramBool)
                        continue;
                    else if (unos[i].equals("("))
                        continue;
                    else if (unos[i].equals("+"))
                        continue;
                    else if (unos[i].equals("-"))
                        continue;
                    else if (unos[i].equals("*"))
                        continue;
                    else if (unos[i].equals("/")) continue;
                    else if (unos[i].equals("sqrt")) continue;
                    else if (unos[i].equals(")")) continue;

                    System.out.println("Nesipravni parametri!");
                    param = 1;
                }
                if (param == 0) {
                    System.out.println(e.evaluate(k));
                    break;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (RuntimeException message) {
                System.out.println("RuntimeException: ");
                message.printStackTrace();
            }
        }
    }
}
