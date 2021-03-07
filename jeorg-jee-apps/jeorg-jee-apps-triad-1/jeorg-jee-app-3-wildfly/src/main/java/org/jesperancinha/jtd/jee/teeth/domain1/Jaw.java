package org.jesperancinha.jtd.jee.teeth.domain1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * {@link Entity} and {@link Table} serve two different purposes:
 * {@link Entity}, is responsible for the entity name in named queries
 * {@link Table}, is the table name in the databases
 */
@Entity(name = "jaw1")
@Table(name = "jaw1")
public class Jaw {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private UUID uuid;

}
