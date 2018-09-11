package org.mongodb.morphia;


import org.bson.Document;
import org.mongodb.morphia.annotations.PostLoad;
import org.mongodb.morphia.annotations.PostPersist;
import org.mongodb.morphia.annotations.PreLoad;
import org.mongodb.morphia.annotations.PrePersist;
import org.mongodb.morphia.mapping.Mapper;


/**
 * Interface for intercepting @Entity lifecycle events
 */
public interface EntityInterceptor {
    /**
     * @param ent      the entity being processed
     * @param document the Document form of the entity
     * @param mapper   the Mapper being used
     * @see PostLoad
     */
    default void postLoad(final Object ent, final Document document, final Mapper mapper) {

    }

    /**
     * @param ent      the entity being processed
     * @param document the Document form of the entity
     * @param mapper   the Mapper being used
     * @see PostPersist
     */
    default void postPersist(final Object ent, final Document document, final Mapper mapper) {

    }

    /**
     * @param ent      the entity being processed
     * @param document the Document form of the entity
     * @param mapper   the Mapper being used
     * @see PreLoad
     */
    default void preLoad(final Object ent, final Document document, final Mapper mapper) {

    }

    /**
     * @param ent      the entity being processed
     * @param document the Document form of the entity
     * @param mapper   the Mapper being used
     * @see PostPersist
     */
    default void prePersist(final Object ent, final Document document, final Mapper mapper) {

    }

    /**
     * @param ent      the entity being processed
     * @param document the Document form of the entity
     * @param mapper   the Mapper being used
     * @see PrePersist
     * @deprecated use {@link #prePersist(Object, Document, Mapper)} instead
     */
    @Deprecated
    default void preSave(final Object ent, final Document document, final Mapper mapper) {
        prePersist(ent, document, mapper);
    }
}
