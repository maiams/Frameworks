package org.cbsoft.framework;

import java.util.Map;

/**
 * Created by maiams on 04/07/16.
 */
public class XMLFormatter implements DataFormatter{
    @Override
    public byte[] formatData(Map<String, Object> props) {
        StringBuilder propFileBuilder = new StringBuilder();
        propFileBuilder.append("<properties>");
        for (String prop : props.keySet()) {
            propFileBuilder.append("<" + prop + ">" + props.get(prop) + "</" + prop + ">");
        }
        propFileBuilder.append("</properties>");
        byte[] bytes = propFileBuilder.toString().getBytes();
        return bytes;
    }
}
