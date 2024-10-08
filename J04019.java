import java.lang.*;
import java.text.DecimalFormat;
import java.util.*;
class Point{
    private double x;
    private double y;
    public Point(){

    }
    public Point(double x , double y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return x + " " + y;
    }
    public static Point nextPoint(Scanner sc) {
        return new Point(sc.nextDouble(), sc.nextDouble());
    }
    public double distance(Point other){
        return (double)Math.sqrt(Math.pow(x-other.x,2) + Math.pow(y-other.y, 2));
    }

}


class Triangle{
    private Point A;
    private Point B;
    private Point C;
    public Triangle(Point a , Point b, Point c){
        A = a;
        B = b;
        C = c;
    }

    public boolean valid(){
        double a = B.distance(C);
        double b = A.distance(C);
        double c = A.distance(B);
        if(a + b > c && b + c > a && c + a > b) return true;
        return false;
    }
    
    public String getPerimeter(){
        double a = B.distance(C);
        double b = A.distance(C);
        double c = A.distance(B);
        return String.format("%.3f",a + b + c);
    }

}

public class J04019{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}