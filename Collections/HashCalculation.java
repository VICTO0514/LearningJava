class HashCalculation{
    public static void main(String[] args){
    
    String key = "ABC";
    int hash = key.hashCode();         // 64578
    int arraySize = 16;
    int index = (arraySize - 1) & hash;
    
    System.out.println("hashCode: " + hash);     // 64578
    System.out.println("Array index: " + index); // 2 (for example)

    }
}
