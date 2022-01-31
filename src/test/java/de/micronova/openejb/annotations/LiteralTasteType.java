package de.micronova.openejb.annotations;

import javax.enterprise.util.AnnotationLiteral;

public final class LiteralTasteType extends AnnotationLiteral<TasteQualifier> implements TasteQualifier {
    private static final long serialVersionUID = 1L;

    private final TasteType taste;

    public LiteralTasteType(TasteType taste) {
        this.taste = taste;
    }

    @Override
    public TasteType value() {
        return taste;
    }
}

