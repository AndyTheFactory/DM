/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzycmeans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.battelle.clodhopper.Cluster;
import org.battelle.clodhopper.tuple.ArrayTupleList;
import org.battelle.clodhopper.tuple.TupleList;
import org.battelle.clodhopper.util.IntIterator;

/**
 *
 * @author Dell
 */
public class WeightData extends Data{
    public WeightData(String filename) throws FileNotFoundException, IOException {
        super(filename);
        cluster_fields.clear();
        cluster_fields.add("Age");
        cluster_fields.add("BestBenchKg");
        normalization=new double[]{1,5};
    }

    @Override
    public void writeGnuPlot(List<Cluster> clusters) {
        String plotFileName=inputFile.getAbsolutePath();
        int i=plotFileName.lastIndexOf(".");
        plotFileName=plotFileName.substring(0, i)+"_gnuplot.plt";
        
        String clusterFileName=inputFile.getAbsolutePath();
        i=clusterFileName.lastIndexOf(".");
        clusterFileName=clusterFileName.substring(0, i)+"_processed"+clusterFileName.substring(i);
        
        BufferedWriter outfile;
        try {
            outfile=new BufferedWriter(new FileWriter(new File(plotFileName)));
            outfile.write("set datafile separator tab\r\n");
            for(Cluster c:clusters)
                outfile.write("set object circle at first "+c.getCenter()[0]*normalization[0]+","+c.getCenter()[1]*normalization[1]+" radius char 1  fillcolor rgb 'red' fillstyle solid  border lt 2 lw 2 front\r\n");
            
            outfile.write("plot \""+clusterFileName.replace("\\", "/")+"\" using 6:7:9 with points palette pt 3 title \"Weightlifting Data\"");
            outfile.newLine();
            
            outfile.close();
        } catch (IOException ex) {
            Logger.getLogger(WeightData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    
}
