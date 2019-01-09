/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzycmeans;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Dell
 */
public class WeatherData extends Data{
    
    public WeatherData(String filename) throws FileNotFoundException, IOException {
        super(filename);
        cluster_fields.clear();
        cluster_fields.add("humidity");
        cluster_fields.add("pressure");
        cluster_fields.add("temperature");
        
        
    }
    
}
