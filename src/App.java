import java.util.Random;

public class App {
    public static void main(String[] args) {
        // SparceMatrixLIL
        Random rand = new Random();
        SparseMatrixLIL a = new SparseMatrixLIL(1000,1000);
        a.set(1,1,1.0);
        System.out.println(a.get(1, 1));
        a.set(1,1,2.0);
        System.out.println(a.get(1, 1));
        a.zero(1, 1);
        System.out.println(a.get(1, 1));
        for ( int i =0;i<10;i++){
            a.set(i, i, rand.nextDouble());
        }
        for ( int i =0;i<10;i++){
            System.out.println(a.get(i, i));
        }
        System.out.println(a);
        System.out.println(a.isEmpty());
        a.clear();
        System.out.println(a.isEmpty());
        System.out.println(a);
        //////////////////////////////////////////////
        
        
        // SparseMatrixDOK
        SparseMatrixDOK b = new SparseMatrixDOK(1000, 1000);
        System.out.println(b.get(1, 1));
        b.set(1, 2,1e-6);
        b.set(1, 1,1.0);
        System.out.println(b.get(1, 1));
        System.out.println(b);
        for ( int i =0;i<10;i++){
            b.set(1, 10-i, rand.nextDouble());
        }
        for ( int i =0;i<10;i++){
            System.out.println(b.get(i, i));
        }
        System.out.println(b);
        System.out.println(b);
        System.out.println(b.isEmpty());
        b.clear();
        System.out.println(b.isEmpty());
        System.out.println(b);
    }
}
