package directMemoryBenchmark;

import org.apache.directmemory.DirectMemory;
import org.apache.directmemory.cache.CacheService;

public class DM_Overhead {
    public static void main(String[] args) {
        CacheService<Object, Object> m = new DirectMemory<Object, Object>()
                .setNumberOfBuffers( 30 )
                .setSize((int) 1e8)
                .setInitialCapacity( 10000 )
                .setDisposalTime(1000000)
                .setConcurrencyLevel( 4 )
                .newCacheService();

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
