package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    Stack<String> ops = new Stack<>();
    Stack<Double> vals = new Stack<>();


    public Double evaluate(String unos) {
        System.out.println("UNOS JE: " + unos);
        for (String s : unos.split(" ")) {
            //   System.out.println(s);
            if (s.equals("(")) ;
            else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals("sqrt"))
                ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+"))
                    v = vals.pop() + v;
                else if (op.equals("-"))
                    v = vals.pop() - v;
                else if (op.equals("*"))
                    v = vals.pop() * v;
                else if (op.equals("/"))
                    v = vals.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);

                vals.push(v);

            } else if (s.equals(" "))
                continue;
            else {

                try {
                    double h = Double.parseDouble(s);
                    vals.push(h);
                } catch (Exception e) {
                    throw new RuntimeException("Neispravan izraz!");
                }
            }
        }

        return vals.pop();
    }
}
