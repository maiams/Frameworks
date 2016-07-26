package org.cbsoft.framework;

import java.io.IOException;


/**
 * Created by maiams on 04/07/16.
 */
public interface PostProcessor {
    byte[] postProcess(byte[] bytes) throws IOException;
}
