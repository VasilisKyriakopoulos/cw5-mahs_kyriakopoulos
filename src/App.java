public class App {
    public static void main(String[] args) {
        SparseMatrixLIL a = new SparseMatrixLIL(1000,1000);
        System.out.println(a.colCount());
        System.out.println(a.rowCount());
        for ( int i =0;i<1000;i++){
            a.set(i, i, i+1);
        }
        System.out.println(a.get(430, 400));
    }
}
