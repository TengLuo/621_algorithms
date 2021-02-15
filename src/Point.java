// This class to generate Point object with two attribute x and y
public class Point {
    int x;
    int y;

    public Point() {
        this.x = this.generateNumber();
        this.y = this.generateNumber();
    }

    public int generateNumber() {
        // range from -1000 to 1000
        return -1000 + (int) (Math.random() * ((1000 - (-1000)) + 1));
    }

    public static void main(String[] args) {
        Point p = new Point();
        System.out.println(p.x);
        System.out.println(p.y);
    }
}
