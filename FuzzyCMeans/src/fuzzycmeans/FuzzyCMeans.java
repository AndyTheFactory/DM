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
import org.battelle.clodhopper.tuple.TupleList;
public class FuzzyCMeans {

    /**
     * @param args the command line arguments
     */
    static FuzzyCMeansClusterer getClusterer(TupleList tuples){
        FuzzyCMeansParams params;
        FuzzyCMeansParams.Builder builder = new FuzzyCMeansParams.Builder()
    			.clusterCount(10)
    			.maxIterations(100)
    			.fuzziness(2)
    			.epsilon(0.001)
    			.workerThreadCount(1)
    			.clusterSeeder(new RandomSeeder(System.currentTimeMillis(), new Random()))
    			.distanceMetric(new EuclideanDistanceMetric());

        params = builder.build();
        return new FuzzyCMeansClusterer(tuples, params);          
        
    }
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        System.out.print("Reading Weight Data...");
        WeightData wd=new WeightData("c:\\Projects\\DM\\data\\weightlifting_350k.txt");
        
        wd.ReadTupleList();
        
        System.out.println("Clustering...");
        FuzzyCMeansClusterer fuzzyC = getClusterer(wd.inputTuples);          

        Thread worker = new Thread(fuzzyC);
        worker.start();

        List<Cluster>  clusters = fuzzyC.get();

        System.out.println("Clustering done!");
        if (fuzzyC.getTaskOutcome() == TaskOutcome.SUCCESS) {
              System.out.println("Saving Cluster files");

              wd.WriteClusterInfo(clusters);
              wd.WriteClusteredData(clusters);
              
          }else{
              System.err.println(fuzzyC.getErrorMessage());
          }
        
        System.out.print("Reading Weight Data...");
        WeatherData weatherd=new WeatherData("c:\\Projects\\DM\\data\\weather_data_sandiego.txt");
        
        weatherd.ReadTupleList();
        
        System.out.println("Clustering...");
        fuzzyC = getClusterer(weatherd.inputTuples);          

        Thread worker2 = new Thread(fuzzyC);
        worker2.start();

        clusters = fuzzyC.get();

        System.out.println("Clustering done!");
        if (fuzzyC.getTaskOutcome() == TaskOutcome.SUCCESS) {
              System.out.print("Saving Cluster files");
              weatherd.WriteClusterInfo(clusters);
              weatherd.WriteClusteredData(clusters);
              
          }else{
              System.err.println(fuzzyC.getErrorMessage());
          }
          
    }
    private void test(){
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

    }
}
