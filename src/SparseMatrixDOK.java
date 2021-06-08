import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SparseMatrixDOK implements SparseMatrix {
    private int r , c;
  
    private class ElementPos implements Comparable<ElementPos>{
        private int row,col;
        public ElementPos(int row,int col){
            this.row = row;
            this.col = col;
        }
        @Override
        public int compareTo(SparseMatrixDOK.ElementPos o) {
            if(this.row>o.row){
                return 1;
            }
            else if(this.row<o.row){
                return -1;
            }
            else{
                if(this.col>o.col){
                    return 1;
                }
                else if(this.col<o.col){
                    return -1;
                }
            }
            return 0;
        }
    }
    private TreeMap<ElementPos,Double> map;
    public SparseMatrixDOK(int r, int c){
        map = new TreeMap<ElementPos,Double>();
        this.r = r;
        this.c = c;
    }
    public int rowCount(){
        return this.r;
    }
    public int colCount(){
        return this.c;
    }
    public double get(int r, int c){
        Double check = map.get(new ElementPos(r, c));
        if(check!=null){
            return check;
        }
        return 0.0;
    }
    public void set(int r, int c, double element){
       this.map.put(new ElementPos(r, c), element);  
    }
    public void zero(int r, int c){
        this.map.remove(new ElementPos(r, c));
    }
    public void clear(){
        this.map.clear();
    }
    public boolean isEmpty(){
        return this.map.isEmpty();
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");
        Set<ElementPos> keys = map.keySet();
        for (ElementPos k : keys){
            Double val = map.get(k);
            s.append("("+k.row+", "+ k.col+": "+ val+")");
        }
        s.append("]");
        return s.toString();
    }
}
