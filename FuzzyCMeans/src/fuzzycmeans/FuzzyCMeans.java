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
import java.util.Random;
import org.battelle.clodhopper.*;
import org.battelle.clodhopper.distance.DistanceMetric;
import org.battelle.clodhopper.distance.EuclideanDistanceMetric;
import org.battelle.clodhopper.fuzzycmeans.*;
import org.battelle.clodhopper.seeding.*;
public class FuzzyCMeans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FuzzyCMeansParams params=null;
        
        ClusterSeeder seeder = new RandomSeeder(System.currentTimeMillis(), new Random());
        
        DistanceMetric distance=new EuclideanDistanceMetric();

        
        FuzzyCMeansParams.Builder builder = new FuzzyCMeansParams.Builder()
    			.clusterCount(4)
    			.maxIterations(10)
    			.fuzziness(2)
    			.epsilon(0.001)
    			.workerThreadCount(1)
    			.clusterSeeder(seeder)
    			.distanceMetric(distance);

        params = builder.build();
        
    }
    
}
