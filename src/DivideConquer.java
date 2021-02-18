
public class DivideConquer {
    // sort with x axis = 0 , sort with y axis = 1
    public int sort_by_axis = 1;
    private double[][] listX, listY;

    public void sort(double[][] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // handle left
            sort(nums, low, mid);
            // handle right
            sort(nums, mid + 1, high);
            // merge
            merge(nums, low, mid, high);
        }
    }

    private void merge(double[][] nums, int low, int mid, int high) {
        // define temp array
        double[][] temp = new double[high - low + 1][2];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // find smaller one and add to temp
        while (i <= mid && j <= high) {
            if (nums[i][sort_by_axis] <= nums[j][sort_by_axis])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        // handle long part
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        // assign back to original array
        for (int t = 0; t < temp.length; t++) {
            nums[t + low] = temp[t];
        }
    }

    private void sort_list(double[][] list) {
        this.listX = new double[list.length][2];
        this.listY = new double[list.length][2];
        for (int i = 0; i < list.length; i++) {
            listX[i][0] = list[i][0];
            listX[i][1] = list[i][1];
            listY[i][0] = list[i][0];
            listY[i][1] = list[i][1];
        }
        // sort by x axis
        this.sort_by_axis = 0;
        sort(listX, 0, listX.length - 1);
        // sort by y axis
        this.sort_by_axis = 1;
        sort(listY, 0, listY.length - 1);
    }

    public static void main(String[] args) {
        DivideConquer dc = new DivideConquer();
        // list length
        int listLength = 30;
        double[][] list = new double[listLength][2];
        for (int i = 0; i < listLength; i++) {
            int x = -1000 + (int) (Math.random() * ((1000 - (-1000)) + 1));
            int y = -1000 + (int) (Math.random() * ((1000 - (-1000)) + 1));
            list[i][0] = x;
            list[i][1] = y;
        }

        // initial list,list[0][0] = point0 x , list[0][1] = point0 y
        dc.sort_list(list);
        // check
        for (int i = 0; i < listLength; i++) {
            System.out.println("Point_" + i + ": " + list[i][0] + ", " + list[i][1]);
        }
        for (int i = 0; i < listLength; i++) {
            System.out.println("Point_" + i + ": " + dc.listX[i][0] + ", " + dc.listX[i][1]);
        }
        for (int i = 0; i < listLength; i++) {
            System.out.println("Point_" + i + ": " + dc.listY[i][0] + ", " + dc.listY[i][1]);
        }
    }
}
