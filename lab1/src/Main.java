import java.util.Date;

public class Main {
    public static void main(String[] args){
        Main prog = new Main();
        prog.run();
    }

    private double calcA(double x, double y){
        double a;
        a = (2 * Math.cos(x - Math.PI / 6)) / ((1 / 2) + Math.pow(Math.sin(y), 2));

        return a;
    }

    //perjgq09jg0q3j54g
    private double calcB(double z){
        double b;
        b = 1 + (Math.pow(z, 2) / (3 + Math.pow(z, 2) / 5));

        return b;
    }

    private void printDate(){
        Date d = new Date();
        System.out.printf("Сьогодні %1$te-%1$tB-%1$tY\n", d);
    }

    private  void print(double a, double b){
        System.out.println("a="+a);
        System.out.println("b="+b);
    }

    private void run(){
        double x = 1.426;
        double y = -1.220;
        double z = 3.5;
        double a = calcA(x, y);
        double b = calcB(z);

        print(a, b);
        printDate();
    }
}