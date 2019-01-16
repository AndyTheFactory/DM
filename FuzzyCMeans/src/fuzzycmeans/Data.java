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
import org.battelle.clodhopper.Cluster;
import org.battelle.clodhopper.distance.EuclideanDistanceMetric;
import org.battelle.clodhopper.tuple.ArrayTupleList;
import org.battelle.clodhopper.tuple.TupleList;
import org.battelle.clodhopper.util.IntIterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public abstract class Data {

    String FIELD_DELIM="\t";
    String ID_FIELD="id";

    File inputFile;
    TupleList inputTuples;
    HashMap<Double, Double> tupleMap;
    protected  ArrayList<String> header;
    protected ArrayList<String> cluster_fields;
    double[] normalization;
    public Data(String filename) throws FileNotFoundException, IOException{
        inputFile = new File(filename);
        tupleMap=new HashMap<>();
        inputTuples=null;
        BufferedReader fil=new BufferedReader(new FileReader(inputFile));
        String line=fil.readLine();
        header=new ArrayList<>(Arrays.asList(line.split(FIELD_DELIM)));
        cluster_fields=new ArrayList<>();
        fil.close();
    }
    
    void ReadTupleList() throws FileNotFoundException, IOException{
        BufferedReader fil=new BufferedReader(new FileReader(inputFile));
        tupleMap.clear();

        String line=fil.readLine(); //header

        List<Double> values=new ArrayList<>();
        int nr=0;
        while((line=fil.readLine())!=null){
            String[] fields=line.split(FIELD_DELIM);

            String id=fields[header.indexOf(ID_FIELD)];
            int i=0;
            for(String fld:cluster_fields){
                double val;
                try{
                    val=Double.valueOf(fields[header.indexOf(fld)]);
                    val=val/normalization[i];
                    //if (fld.equals("BestBenchKg")) val/=5;
                }catch(NumberFormatException e){
                    val=0;
                } 
                values.add(val);
                i++;
            }
            tupleMap.put(Double.valueOf(id),(double)nr);
            nr++;
        }
        fil.close();
        
        inputTuples=new ArrayTupleList(cluster_fields.size(),nr,values.stream().mapToDouble(Double::doubleValue).toArray());
    }
    void WriteClusterInfo(List<Cluster> clusters) throws IOException{
        String clusterFileName=inputFile.getAbsolutePath();
        int i=clusterFileName.lastIndexOf(".");
        clusterFileName=clusterFileName.substring(0, i)+"_clusters"+clusterFileName.substring(i);
        
        BufferedWriter cfile=new BufferedWriter(new FileWriter(new File(clusterFileName)));
        
        cfile.write("Nr Clusters: "+clusters.size());
        cfile.newLine();
        cfile.write("Nr Samples: "+tupleMap.size());
        cfile.newLine();
        cfile.newLine();
        for(Cluster c:clusters){
            cfile.newLine();
            cfile.write(String.format("Cluster C%d: ",clusters.indexOf(c)+1));
            cfile.newLine();
            double[] center=c.getCenter();
            for(int j=0;j<center.length;j++)
                cfile.write(String.format("%.5f"+System.lineSeparator(),center[j]*normalization[j]));
            
        }
        cfile.close();
    }
    
    void WriteClusteredData(List<Cluster> clusters) throws IOException{
        String clusterFileName=inputFile.getAbsolutePath();
        int i=clusterFileName.lastIndexOf(".");
        clusterFileName=clusterFileName.substring(0, i)+"_processed"+clusterFileName.substring(i);
        
        BufferedWriter outfile=new BufferedWriter(new FileWriter(new File(clusterFileName)));
        BufferedReader fil=new BufferedReader(new FileReader(inputFile));
        
        String line=fil.readLine(); //header
        outfile.write(line+FIELD_DELIM+"Cluster");
        outfile.newLine();
        
        HashMap<Double,String> clustermap=new HashMap<>();
        for(Cluster c:clusters){
            String cname=String.format("%d", clusters.indexOf(c)+1);
            IntIterator it=c.getMembers();
            
            while (it.hasNext())
                clustermap.put(Double.valueOf(it.getNext()), cname);
        }

        while((line=fil.readLine())!=null){
            String[] fields=line.split(FIELD_DELIM);

            String id=fields[header.indexOf(ID_FIELD)];
            double tupleId=tupleMap.get(Double.valueOf(id));
            outfile.write(line);
            outfile.write(FIELD_DELIM);
            outfile.write(clustermap.get(tupleId));
            outfile.newLine();
        }
        fil.close();
        outfile.close();
    }
    
    /**
     *
     * @param filename
     */
    public abstract void writeGnuPlot(List<Cluster> clusters);
    
    public float getDivergence(List<Cluster> clusters)
    {
        float dist=0;
        EuclideanDistanceMetric m=new EuclideanDistanceMetric();
        for(Cluster c:clusters){
            
            IntIterator it=c.getMembers();
            while (it.hasNext()){

                dist+=m.distance(inputTuples.getTuple(it.getNext(),null), c.getCenter());
            }
                
        }
        return dist;
    }
}
