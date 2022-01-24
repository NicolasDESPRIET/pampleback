package com.pamplemousse.pampleback.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public final class Type implements Serializable {
    private static final long serialVersionUID = 967988323568L;

    /**
     * long id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "type_id")
    private long id;

    /**
     * String name.
     */
    @Column(name = "type_name")
    private String name;

    /**
     * getter id.
     * @return Long id
     */
    public Long getId() {
        return id;
    }

    /**
     * setter id.
     * @param id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * getter name.
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * setter name.
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Type other = (Type) obj;
        if (id != other.id) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Type [id=" + id + ", name=" + name + "]";
    }

}
