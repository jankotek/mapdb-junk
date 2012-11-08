package directMemoryBenchmark;

import org.apache.directmemory.DirectMemory;
import org.apache.directmemory.cache.CacheService;

public class DM_Speed {
    public static void main(String[] args) {
        CacheService<Object, Object> m = new DirectMemory<Object, Object>()
                .setNumberOfBuffers( 30 )
                .setSize((int) 1e8)
                .setInitialCapacity( 10000 )
                .setConcurrencyLevel( 4 )
                .setDisposalTime(1000000)
                .newCacheService();

        long t = System.currentTimeMillis();
        int max = 1000000;
        for(int i=0;i<max;i++){
            m.put(i, new byte[1024]);
        }

        for(int i=0;i<max;i++){
            if(m.retrieve(i) == null)
                throw new InternalError();

        }
        System.out.println(System.currentTimeMillis()-t);
        System.exit(0);
    }

}
