package org.cbsoft.framework;

import java.util.Map;

/**
 * Created by maiams on 04/07/16.
 */
public interface DataFormatter {
    byte[] formatData(Map<String, Object> props);
}
