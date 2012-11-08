package directMemoryBenchmark;

import org.mapdb.*;

import java.util.Map;

public class MapDB_Overhead {

    public static void main(String[] args) {
        DB db = DBMaker
                .newDirectMemoryDB()
                .transactionDisable()
                .make();

        Map m = db.getTreeMap("test");

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
