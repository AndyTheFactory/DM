/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzycmeans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.battelle.clodhopper.Cluster;

/**
 *
 * @author Dell
 */
public class IncomeData extends Data{
    public IncomeData(String filename) throws FileNotFoundException, IOException {
        super(filename);
        cluster_fields.clear();
        cluster_fields.add("NY AGI of All Returns");
        cluster_fields.add("Taxable Income of All Returns");
        normalization=new double[]{1,1};
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
            
            outfile.write("plot \""+clusterFileName.replace("\\", "/")+"\" using 2:3:4 with points palette pt 3 title \"Income Tax Data\"");
            outfile.newLine();
            
            outfile.close();
        } catch (IOException ex) {
            Logger.getLogger(WeightData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
