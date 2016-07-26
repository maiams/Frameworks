package org.cbsoft.framework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
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


    public void generateFile(String filename, Object obj){
        byte[] bytes = df.formatData(getPropertiesList(obj));

        try {
            bytes = pp.postProcess(bytes);
            FileOutputStream fileout = new FileOutputStream(filename);
            fileout.write(bytes);
            fileout.close();
        } catch (Exception e) {
            throw new RuntimeException("Problems writing the file",e);
        }

    }

    private Map<String,Object> getPropertiesList(Object obj) {
        Map<String,Object> props = new HashMap<String, Object>();
        Class<?> clazz = obj.getClass();
        for(Method m: clazz.getMethods()){
            if(isAllowedGetter(m)) {
                try {
                    Object value = m.invoke(obj);
                    String getterName = m.getName();
                    String propName =  getterName.substring(3,4).toLowerCase()+getterName.substring(4);
                    props.put(propName, value);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot retrieve properties", e);
                }

            }
        }
        return props;
    }

    private boolean isAllowedGetter(Method m) {
        return m.getName().startsWith("get")
                && m.getParameterTypes().length == 0
                && m.getReturnType() != void.class
                && !m.getName().equals("getClass")
                && !m.isAnnotationPresent(DontIncludeOnFile.class);
    }

}
