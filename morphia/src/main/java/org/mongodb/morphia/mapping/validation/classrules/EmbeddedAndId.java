package org.mongodb.morphia.mapping.validation.classrules;


import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.mapping.MappedClass;
import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.mapping.validation.ClassConstraint;
import org.mongodb.morphia.mapping.validation.ConstraintViolation;
import org.mongodb.morphia.mapping.validation.ConstraintViolation.Level;

import java.util.Set;

/**
 * A constraint to check that {@code @Embedded} types don't specify an {@code @Id} field
 */
public class EmbeddedAndId implements ClassConstraint {

    @Override
    public void check(final Mapper mapper, final MappedClass mc, final Set<ConstraintViolation> ve) {
        if (mc.getEmbeddedAnnotation() != null && mc.getIdField() != null) {
            ve.add(new ConstraintViolation(Level.FATAL, mc, getClass(),
                String.format("@%s classes cannot specify a @Id field", Embedded.class.getSimpleName())));
        }
    }

}
