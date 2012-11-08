package directMemoryBenchmark;

import java.util.TreeMap;

public class TreeMap_Overhead {

    public static void main(String[] args) {
        TreeMap m = new TreeMap();

        long t = System.currentTimeMillis();
        long counter = 0;

        while(true){
            counter++;
            m.put(counter,counter);
            if(counter%1000000==0){
                System.out.println(""+counter);
            }
        }

    }
}
