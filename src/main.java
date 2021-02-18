public class main {

    public static void main(String[] args) {
        // list length
        int listLength = 30;
        double[][] list = new double[listLength][2];
        double[][] list2 = new double[listLength][2];
        // initial list,list[0][0] = point0 x , list[0][1] = point0 y
        for (int i = 0; i < listLength; i++) {
            int x = -1000 + (int) (Math.random() * ((1000 - (-1000)) + 1));
            int y = -1000 + (int) (Math.random() * ((1000 - (-1000)) + 1));
            list[i][0] = x;
            list[i][1] = y;
            list2[i][0] = x;
            list2[i][1] = y;
        }
        // check
        for (int i = 0; i < listLength; i++) {
            System.out.print("Point_" + i + ": " + list[i][0] + ", ");
            System.out.println(list[i][1]);
        }
        BruteForce2d bf2d = new BruteForce2d();

        bf2d.findPairs(list);
        System.out.println("Result for Brute Force:");
        System.out.println("Point_: " + list[bf2d.p1][0] + ", " + list[bf2d.p1][1]);
        System.out.println("Point_: " + list[bf2d.p2][0] + ", " + list[bf2d.p2][1]);
        System.out.println("Min_Distance " + bf2d.min_distance);

        System.out.println("=====================");
        // check
        for (int i = 0; i < listLength; i++) {
            System.out.print("Point_" + i + ": " + list2[i][0] + ", ");
            System.out.println(list2[i][1]);
        }
        DivideConquer dc = new DivideConquer();
        dc.sort(list, 0, list.length - 1);
        for (int i = 0; i < listLength; i++) {
            System.out.println("Point_" + i + ": " + list[i][0] + ", " + list[i][1]);
        }
    }
}
