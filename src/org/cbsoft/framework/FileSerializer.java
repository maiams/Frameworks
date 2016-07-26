package org.cbsoft.framework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by maiams on 04/07/16.
 */
public class FileSerializer {

    public FileSerializer(DataFormatter df, PostProcessor pp) {
        this.df = df;
        this.pp = pp;
    }

    private PostProcessor pp;
    private DataFormatter df;


    public void generateFile(String filename, PropertiesGetter propGetter){
        byte[] bytes = df.formatData(propGetter.getPropertiesList());

        try {
            bytes = pp.postProcess(bytes);
            FileOutputStream fileout = new FileOutputStream(filename);
            fileout.write(bytes);
            fileout.close();
        } catch (Exception e) {
            throw new RuntimeException("Problems writing the file",e);
        }

    }

}
