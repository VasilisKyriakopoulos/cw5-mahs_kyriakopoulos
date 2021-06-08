import java.util.Random;

public class App {
    public static void main(String[] args) {
        SparseMatrixLIL a = new SparseMatrixLIL(1000,1000);
        Random rand = new Random();
        for ( int i =0;i<10;i++){
            a.set(rand.nextInt(9), rand.nextInt(9), rand.nextDouble());
        }

        for ( int i =0;i<10;i++){
            System.out.println(a.get(rand.nextInt(9), rand.nextInt(9)));
        }
        System.out.println(a);
        System.out.println(a.isEmpty());
        a.clear();
        System.out.println(a.isEmpty());
        System.out.println(a);
    }
}
