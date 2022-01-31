package de.micronova.openejb.annotations;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Documented
@Retention(RUNTIME)
@Target({ FIELD, TYPE, METHOD, CONSTRUCTOR, PARAMETER })
public @interface TasteQualifier {
    TasteType value();

    final class Literal extends AnnotationLiteral<TasteQualifier> implements TasteQualifier {
        private final TasteType value;

        public Literal(TasteType value) {
            this.value = value;
        }

        @Override
        public TasteType value() {
            return value;
        }
    }
}
