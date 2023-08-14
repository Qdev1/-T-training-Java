
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    //check ngoại lệ của kiểu int
    int Check(String mess, int min, int max) {
        int num;
        do {
            System.out.print(mess);
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.println("Out of range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Value of matrix is digit");
            }
        } while (true);
    }

    //nhập từng  phần tử vao matrix 
    void inputMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = Check("Enter matrix[" + (i + 1) + "][" + (j + 1) + "]:", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
    }

    // hàm in ra ma trận kết quả
    void printMatrix(int[][] a) {
        if (a == null) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("[" + a[i][j] + "]");
            }
            System.out.println("");
        }
    }

    //hàm  cộng hai ma trận
    int[][] addMatrix(int[][] a1, int[][] a2) {
        System.out.println("day la add matrix");
        if (a2.length != a1.length || a2[0].length != a1[0].length) //kiem tra xem 2 ma tran co cung size khong
        {
            return null;
        }
        int[][] res = new int[a1.length][a1[0].length];
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[0].length; j++) {
                res[i][j] = a1[i][j] + a2[i][j];
            }
        }
        return res;
    }

    int[][] subMatrix(int[][] a1, int[][] a2) {
        System.out.println("day la ham submatrix");
        if (a2.length != a1.length || a2[0].length != a1[0].length)//kiem tra xem 2 ma tran co cung size khong
        {
            return null;
        }
        int[][] res = new int[a1.length][a1[0].length];
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[0].length; j++) {
                res[i][j] = a1[i][j] - a2[i][j];
            }
        }
        return res;
    }

    //hàm nhân hai ma trận
    int[][] mulMatrix(int[][] a1, int[][] a2) {//mxn nxa
        //nếu mà cột của ma trận 1 có size khác với size hàng của ma trận 2 thì ko thể nhân dc
        if (a1[0].length != a2.length) {
            return null;
        }
        int[][] res = new int[a1.length][a2[0].length];
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2[0].length; j++) {
                for (int k = 0; k < a1[0].length; k++) {//nhân từng phần tử trên dòng của ma trận 1 với cột của ma trận 2
                    res[i][j] += a1[i][k] * a2[k][j];// xong cộng cộng hết lại 
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int choice;

        do {
            System.out.println("=== Calculator program ===");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            choice = m.Check("Your choice: ", 1, 4);
            switch (choice) {
                case 1: {

                    System.out.println("-------- Addition --------");
                    int[][] Matrix1 = new int[m.Check("Enter row matrix 1: ", 1, Integer.MAX_VALUE)][m.Check("Enter col matrix 1: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix1);
                    int[][] Matrix2 = new int[m.Check("Enter row matrix 2: ", 1, Integer.MAX_VALUE)][m.Check("Enter col matrix 2: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix2);
                    System.out.println("-------- Result --------");
                    m.printMatrix(Matrix1);
                    System.out.println("+");
                    m.printMatrix(Matrix2);
                    System.out.println("=");
                    int[][] res1=m.addMatrix(Matrix1, Matrix2);
                    if (res1 == null) {
                        System.out.println("Can't add 2 matrix different size");
                    } else {
                      m.printMatrix(res1);
                    }

                    break;
                }
                case 2: {
                    System.out.println("-------- Subtraction --------");
                    int[][] Matrix1 = new int[m.Check("Enter row matrix 1: ", 1, Integer.MAX_VALUE)][m.Check("Enter col matrix 1: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix1);
                    int[][] Matrix2 = new int[m.Check("Enter row matrix 2: ", 1, Integer.MAX_VALUE)][m.Check("Enter col matrix 2: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix2);
                    System.out.println("-------- Result --------");
                    m.printMatrix(Matrix1);
                    System.out.println("-");
                    m.printMatrix(Matrix2);
                    System.out.println("=");
                    int[][] res2;
                    if (m.subMatrix(Matrix1, Matrix2) == null) {
                        System.out.println("Can't sub 2 matrix different size");
                    } else {
                        res2 = m.subMatrix(Matrix1, Matrix2);
                    }

                    break;
                }
                case 3: {
                    System.out.println("-------- Multiplication --------");
                    int[][] Matrix1 = new int[m.Check("Enter row matrix 1: ", 1, Integer.MAX_VALUE)][m.Check("Enter col matrix 1: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix1);
                    int[][] Matrix2 = new int[m.Check("Enter row matrix 2: ", 1, Integer.MAX_VALUE)][m.Check("Enter col matrix 2: ", 1, Integer.MAX_VALUE)];
                    m.inputMatrix(Matrix2);
                    System.out.println("-------- Result --------");
                    m.printMatrix(Matrix1);
                    System.out.println("*");
                    m.printMatrix(Matrix2);
                    System.out.println("=");
                    int[][] res;
                    if (m.subMatrix(Matrix1, Matrix2) == null) {
                        System.out.println("Can't sub 2 matrix different size");
                    } else {
                        res = m.subMatrix(Matrix1, Matrix2);
                    }
                    break;
                }
                default:
                    break;
            }
        } while (choice != 4);
    }
}
