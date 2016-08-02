package org.cbsoft.application;

import org.cbsoft.framework.Prefix;
import org.cbsoft.framework.ValueFormatter;

import java.lang.annotation.Annotation;

/**
 * Created by maiams on 01/08/16.
 */
public class UppercaseFormatter implements ValueFormatter {
    @Override
    public Object formatValue(Object value) {
        return value.toString().toUpperCase();
    }

    @Override
    public void readAnnotation(Annotation an) {
    }
}
