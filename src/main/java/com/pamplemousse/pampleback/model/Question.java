package com.pamplemousse.pampleback.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public final class Question implements Serializable {
    private static final long serialVersionUID = 687575998L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "q_id")
    private long id;

    @Column(name = "q_ennonce")
    private String ennonce;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "q_r_id", referencedColumnName = "r_id")
    private Response response;

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
    public void setId(long id) {
        this.id = id;
    }

    /**
     * getter ennonce.
     * @return ennonce
     */
    public String getEnnonce() {
        return ennonce;
    }

    /**
     * setter ennonce.
     * @param ennonce
     */
    public void setEnnonce(String ennonce) {
        this.ennonce = ennonce;
    }

    /**
     * getter response.
     * @return response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * setter response.
     * @param response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ennonce == null) ? 0 : ennonce.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((response == null) ? 0 : response.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Question other = (Question) obj;
        if (ennonce == null) {
            if (other.ennonce != null)
                return false;
        } else if (!ennonce.equals(other.ennonce))
            return false;
        if (id != other.id)
            return false;
        if (response == null) {
            if (other.response != null)
                return false;
        } else if (!response.equals(other.response))
            return false;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Question [ennonce=" + ennonce + ", id=" + id + ", response=" + response + "]";
    }
    
}
