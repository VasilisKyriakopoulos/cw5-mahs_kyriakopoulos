import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SparseMatrixLIL implements SparseMatrix {
    private ArrayList<LinkedList>matrix ;
    private int r , c;

    private class ElementInfo{
        private int col;
        private double value;
        public ElementInfo(int col,double value){
            this.col = col;
            this.value = value;
        } 
    }

    public SparseMatrixLIL(int r, int c){
        this.r = r;
        this.c = c;
        this.matrix= new ArrayList<LinkedList>();
        for(int i = 0;i<r ;i++){
            this.matrix.add(new LinkedList<ElementInfo>());
        }
    }
    public int rowCount(){
        return this.r;
    }
    public int colCount(){
        return this.c;
    }
    public double get(int r, int c){
        if (r>this.r || c>this.c){
            throw  new IndexOutOfBoundsException("Row or Column given was out of bounds");
        }
        LinkedList<ElementInfo> list = this.matrix.get(r);
        Iterator<ElementInfo> iter = list.iterator();
        while(iter.hasNext()){
            ElementInfo element = iter.next();
            if(element.col ==c){
                return element.value;
            }
        }
        return 0;
    }
    public void set(int r, int c, double element){
        if (r>this.r || c>this.c)
        {
            throw  new IndexOutOfBoundsException("Row or Column given was out of bounds"); 
        }
        else{
            double error = 1e-5;
            if(Math.abs(element) < error){
                zero(r,c);
            }
            else{
            LinkedList<ElementInfo> list = this.matrix.get(r);
            list.add(new ElementInfo(c,element));
            }
        }
    }
    public void zero(int r, int c){
        if (r>this.r || c>this.c)
        {
            throw  new IndexOutOfBoundsException("Row or Column given was out of bounds"); 
        }
        else{
            LinkedList<ElementInfo> list = this.matrix.get(r);
            list.remove(c); 
        }
    }
    public void clear(){

    }
    public boolean isEmpty(){
        return true;
    }
    public String toString(){
        return "LIL";
    }
}
