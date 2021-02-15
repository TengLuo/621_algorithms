import java.util.Arrays;

public class BruteForce2d {
    double min_distance = 999999999;
    int p1, p2;

    // Question 1 part a, b
    // using brute-force finding closet path
    public double distance(double[] p1, double[] p2) {
        double dist = Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
        return dist;
    }

    public void findPairs(double[][] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (i != j) {
                    double[] p1 = list[i];
                    double[] p2 = list[j];
                    double tempDist = distance(p1, p2);
                    if (tempDist <= this.min_distance) {
                        this.min_distance = tempDist;
                        this.p1 = i;
                        this.p2 = j;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BruteForce2d bf2d = new BruteForce2d();
        // list length
        int listLength = 30;
        double[][] list = new double[listLength][2];
        // initial list,list[0][0] = point0 x , list[0][1] = point0 y
        for (int i = 0; i < listLength; i++) {
            int x = -1000 + (int) (Math.random() * ((1000 - (-1000)) + 1));
            int y = -1000 + (int) (Math.random() * ((1000 - (-1000)) + 1));
            list[i][0] = x;
            list[i][1] = y;
        }
        // check
        for (int i = 0; i < listLength; i++) {
            System.out.print("Point_" + i + ": " + list[i][0] + ", ");
            System.out.println(list[i][1]);
        }
        bf2d.findPairs(list);
        System.out.println("====================");
        System.out.println("Point_" + bf2d.p1 + ": " + list[bf2d.p1][0] + ", " + list[bf2d.p1][1]);
        System.out.println("Point_" + bf2d.p2 + ": " + list[bf2d.p2][0] + ", " + list[bf2d.p2][1]);
        System.out.println("Min_Distance" + bf2d.min_distance);
    }
}
