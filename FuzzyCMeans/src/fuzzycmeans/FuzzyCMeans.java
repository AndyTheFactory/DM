/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzycmeans;
/**
 *
 * @author andrei
 */
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import org.battelle.clodhopper.*;
import org.battelle.clodhopper.distance.DistanceMetric;
import org.battelle.clodhopper.distance.EuclideanDistanceMetric;
import org.battelle.clodhopper.fuzzycmeans.*;
import org.battelle.clodhopper.seeding.*;
import org.battelle.clodhopper.task.TaskOutcome;
import org.battelle.clodhopper.tuple.ArrayTupleList;
import org.battelle.clodhopper.tuple.FileMappedTupleList;
import org.battelle.clodhopper.tuple.TupleList;
public class FuzzyCMeans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        // TODO code application logic here
        FuzzyCMeansParams params=null;
        
        ClusterSeeder seeder = new RandomSeeder(System.currentTimeMillis(), new Random());
        
        DistanceMetric distance=new EuclideanDistanceMetric();

        
        TupleList tupleData = new ArrayTupleList(2, 5, new double[]{33,15,10,22,44,6,7,8,9,9});
        

        FuzzyCMeansParams.Builder builder = new FuzzyCMeansParams.Builder()
    			.clusterCount(10)
    			.maxIterations(100)
    			.fuzziness(2)
    			.epsilon(0.001)
    			.workerThreadCount(1)
    			.clusterSeeder(seeder)
    			.distanceMetric(distance);

        params = builder.build();
        
        FuzzyCMeansClusterer fuzzyC = new FuzzyCMeansClusterer(tupleData, params);
        
        Thread t = new Thread(fuzzyC);
        t.start();

        List<Cluster> clusters = null;
        
        try {
            // This blocks!
            clusters = fuzzyC.get();
        } catch (InterruptedException e1) {
            
        } catch (ExecutionException e2) {
          
        }

          if (fuzzyC.getTaskOutcome() == TaskOutcome.SUCCESS) {
              
              
          }else{
              System.err.println(fuzzyC.getErrorMessage());
          }
          
          WineData wd=new WineData("d:\\Work\\Java\\DM\\data\\winemag_150k.txt");
          wd.ReadTupleList();
          fuzzyC = new FuzzyCMeansClusterer(wd.inputTuples, params);          

          Thread worker = new Thread(fuzzyC);
          worker.start();

          clusters = fuzzyC.get();

          if (fuzzyC.getTaskOutcome() == TaskOutcome.SUCCESS) {
              wd.WriteClusterInfo(clusters);
              wd.WriteClusteredData(clusters);
              
          }else{
              System.err.println(fuzzyC.getErrorMessage());
          }
          
    }
    
}
