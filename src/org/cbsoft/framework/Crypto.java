package org.cbsoft.framework;

import java.io.IOException;

/**
 * Created by maiams on 04/07/16.
 */
public class Crypto implements PostProcessor{

    private Integer delay;

    public Crypto(Integer delay) {
        this.delay = delay;
    }

    @Override
    public byte[] postProcess(byte[] bytes) throws IOException {
        byte[] newBytes = new byte[bytes.length];
        for(int i=0;i<bytes.length;i++){

            newBytes[i]= (byte) ((bytes[i]+delay) % Byte.MAX_VALUE);
        }
        return newBytes;
    }
}
