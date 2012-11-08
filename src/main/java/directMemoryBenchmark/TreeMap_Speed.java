package directMemoryBenchmark;


import java.util.Map;
import java.util.TreeMap;

public class TreeMap_Speed {

    public static void main(String[] args) {
        Map m = new TreeMap();

        long t = System.currentTimeMillis();
        int max = 1000000;
        for(int i=0;i<max;i++){
            m.put(i, new byte[1024]);
        }

        for(int i=0;i<max;i++){
            if(m.get(i) == null)
                throw new InternalError();

        }
        System.out.println(System.currentTimeMillis()-t);
        System.exit(0);

    }
}
