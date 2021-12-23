package com.pamplemousse.pampleback.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "responses")
public final class Response implements Serializable {
    private static final long serialVersionUID = 12875295498L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private long id;

    @ElementCollection
    @CollectionTable(name = "response_values", 
      joinColumns = {@JoinColumn(name = "response_id", referencedColumnName = "r_id")})
    @MapKeyColumn(name = "r_text")
    @Column(name = "r_values")
    private Map<String, Integer> values = new HashMap<>();

    /**
     * getter id.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * setter id.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * getter values.
     * 
     * @return mapValues
     */
    public Map<String, Integer> getValues() {
        return values;
    }

    /**
     * setter values.
     * 
     * @param values
     */
    public void setValues(Map<String, Integer> values) {
        this.values = values;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((values == null) ? 0 : values.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Response other = (Response) obj;
        if (id != other.id) {
            return false;
        }
        if (values == null) {
            if (other.values != null) {
                return false;
            }
        } else if (!values.equals(other.values)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Response [id=" + id + ", values=" + values + "]";
    }
}
