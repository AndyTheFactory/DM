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
    }

    
}
