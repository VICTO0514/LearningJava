import java.util.Arrays;

// Collections --> List --> ArrayList Implementation

class MyArrayList<E>{
    private Object[] element;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    protected transient int modCount = 0;
    
    //constructors
    public MyArrayList() {
        element = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    public void ensureCapacity(int capacity) {
        if(capacity > element.length) {
        
        int newCapacity = element.length + (element.length >> 1); //1.5x growth
        
        if(newCapacity < capacity){
            newCapacity = capacity;
        }
        element = Arrays.copyOf(element, newCapacity); //copy to bigger array 
        }
    }
    
    // add
    public boolean add(E e){
        ensureCapacity(size+1);
        element[size++] = e;
        modCount++;
        return true;
    }
    
    // get  
    public E get(int index) {
        rangeCheck(index);
        return (E) element[index];
    }
    
    //size
    public int size(){
        return size;
    }
    
    //remove
    public E remove(int index){
        rangeCheck(index);
        modCount++;
        E oldValue = (E) element[index];
        int numMoved =  size-index-1;
        if(numMoved > 0){
            System.arraycopy(element, index+1, element, index, numMoved);
        }
         element[--size] = null;
            return oldValue;
   }
   
   //isEmpty 
   public boolean isEmpty() {
       return size == 0;
   }
   
   //contains
   public boolean contains(Object o){
       return indexOf(o) >= 0;
   }
   
   //clear
   public void clear() {
       modCount++;
       for(int i=0; i<size; i++){
           element[i] = null;
           size = 0;
       }
   }
    
   public void rangeCheck(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+index+","+"Size: "+size);
        }
    }
    
    public void display(){
        for(int i=0; i<size; i++) {
            System.out.print(element[i]+" ");
        }
         System.out.println();
    }
}

public class CheckMyArrayList {
    public static void main(String[] args) {
    
    MyArrayList<String> a =  new MyArrayList<>();
    a.add("Orange");
    a.add("Apple");
    a.add("Mango");
    a.add("Banana");
    a.add("Grapes");
    
    a.display();
    
    a.remove(2);
    a.display();
    
    System.out.println(a.size());
    System.out.println(a.get(1));
    
    }
}
