package org.cbsoft.framework;

import java.lang.annotation.Annotation;

/**
 * Created by maiams on 01/08/16.
 */
public interface ValueFormatter {
    public Object formatValue(Object value);

    public void readAnnotation(Annotation an);
}
