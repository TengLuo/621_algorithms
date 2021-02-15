import java.util.Arrays;

public class BruteForce {
    double min_distance = 999999999;
    Point p1, p2;

    // Question 1 part a, b
    // using brute-force finding closet path
    public double distance(Point p1, Point p2) {
        double dist = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        return dist;
    }

    public void findPairs(Point[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (i != j) {
                    Point temp1 = list[i];
                    Point temp2 = list[j];
                    double tempDist = distance(list[i], list[j]);
                    if (tempDist <= this.min_distance) {
                        this.min_distance = tempDist;
                        this.p1 = temp1;
                        this.p2 = temp2;
                    }
                }
            }
        }
        System.out.println(this.p1.x + " " + p1.y);
        System.out.println(this.p2.x + " " + p2.y);
        System.out.println(this.min_distance);
    }

    public static void main(String[] args) {
        BruteForce bf = new BruteForce();
        // create array with 30 point object
        Point[] points = new Point[30];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point();
            System.out.print("Point" + i + ": " + points[i].x + ",");
            System.out.println(points[i].y);
        }
        bf.findPairs(points);


    }
}
