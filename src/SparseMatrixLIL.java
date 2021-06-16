import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SparseMatrixLIL implements SparseMatrix{
    private ArrayList<ArrayList>matrix ;
    private int r , c;

    private class ElementInfo  implements Comparable<ElementInfo> {
        private int col;
        private double value;
        public ElementInfo(int col,double value){
            this.col = col;
            this.value = value;
        } 
        public ElementInfo(int col){
            this.col = col;
        } 
        @Override
        public int compareTo(ElementInfo o) {
            if(this.col>o.col){
                return 1;
            }
            else if(this.col<o.col){
                return -1;
            }
            return 0;
        }
       
    }
    
    public SparseMatrixLIL(int r, int c){
        this.r = r;
        this.c = c;
        this.matrix= new ArrayList<ArrayList>();
        for(int i = 0;i<r ;i++){
            this.matrix.add(new ArrayList<ElementInfo>());
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
        ArrayList<ElementInfo> list = this.matrix.get(r);
        int i = Collections.binarySearch(list, new ElementInfo(c));
        if(i>=0){
            return list.get(i).value;
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
            ArrayList<ElementInfo> list = this.matrix.get(r);
            zero(r, c);//in order to delete if we have item on [r,c]
            list.add(new ElementInfo(c,element));
            Collections.sort(list);
            }
        }

    }
    
    public void zero(int r, int c){
        if (r>this.r || c>this.c)
        {
            throw  new IndexOutOfBoundsException("Row or Column given was out of bounds"); 
        }
        else{
            ArrayList<ElementInfo> list = this.matrix.get(r);
            int i = Collections.binarySearch(list, new ElementInfo(c));
            if(i>=0){
                list.remove(i);
            }
            
        }
    }

    public void clear(){
        this.matrix.clear();
    }

    public boolean isEmpty(){
        for(int i=0;i<matrix.size();i++){
            if(matrix.get(i).size()!=0){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");
        for(int i=0;i<matrix.size();i++){
            
            for(int j=0; j<matrix.get(i).size();j++){
                ElementInfo element = (ElementInfo)matrix.get(i).get(j);
                s.append("("+i+", "+ element.col+": "+ element.value+")");
            }
        }
        s.append("]");
        return s.toString();
    }
}
