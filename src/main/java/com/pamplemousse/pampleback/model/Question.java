package com.pamplemousse.pampleback.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public final class Question implements Serializable {
    private static final long serialVersionUID = 687575998L;

    /**
     * long id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "q_id")
    private long id;

    /**
     * String ennonce.
     */
    @Column(name = "q_enonce")
    private String enonce;

    /**
     * Response response.
     */
    @ElementCollection
    @Column(name = "response_value")
    @MapKeyColumn(name = "response_text")
    private Map<String, Integer> responses = new HashMap<String, Integer>();

    /**
     * getter id.
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * setter id.
     * @param id
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * getter ennonce.
     * @return ennonce
     */
    public String getEnonce() {
        return enonce;
    }

    /**
     * setter ennonce.
     * @param ennonce
     */
    public void setEnonce(final String enonce) {
        this.enonce = enonce;
    }

    /**
     * getter responses.
     * @return responses
     */
    public Map<String, Integer> getResponses() {
        return responses;
    }

    /**
     * setter responses.
     * @param responses
     */
    public void setResponses(final Map<String, Integer> responses) {
        this.responses = responses;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((enonce == null) ? 0 : enonce.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((responses == null) ? 0 : responses.hashCode());
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
        Question other = (Question) obj;
        if (enonce == null) {
            if (other.enonce != null) {
                return false;
            }
        } else if (!enonce.equals(other.enonce)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (responses == null) {
            if (other.responses != null) {
                return false;
            }
        } else if (!responses.equals(other.responses)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Question [enonce=" + enonce + ", id=" + id + ", responses=" + responses + "]";
    }
    
}
