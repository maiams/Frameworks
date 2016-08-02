package org.cbsoft.application;

import org.cbsoft.framework.FormatterImplementation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by maiams on 01/08/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@FormatterImplementation(UppercaseFormatter.class)
public @interface Uppercase {
}
