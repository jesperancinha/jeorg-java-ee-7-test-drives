package org.jesperancinha.jtd.jee.teeth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * {@link Entity} and {@link Table} serve two different purposes:
 * {@link Entity}, is responsible for the entity name in named queries
 * {@link Table}, is the table name in the databases
 */
@Entity
@Table
public class Jaw {

    private UUID uuid;

    @Column
    private transient List<Tooth> toothList;

    @OneToMany(fetch = FetchType.EAGER)
    public List<Tooth> getToothList() {
        if (Objects.isNull(toothList)) {
            toothList = new ArrayList<>();
        }
        return toothList;
    }

    public void setToothList(List<Tooth> toothList) {
        this.toothList = toothList;
    }

    @Id
    @Column
    @NotNull
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}

