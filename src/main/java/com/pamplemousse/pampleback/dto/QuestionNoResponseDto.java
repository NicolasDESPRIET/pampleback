package com.pamplemousse.pampleback.dto;

import java.util.List;

public class QuestionNoResponseDto {
    /**
     * id.
     */
    private Long id;

    /**
     * ennonce of the question.
     */
    private String ennonce;

    /**
     * list of response without values.
     */
    private List<String> responsesList;

    /**
     * getter of id.
     * @return id
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
    public void setEnnonce(final String ennonce) {
        this.ennonce = ennonce;
    }

    /**
     * getter responseList.
     * @return responsesList
     */
    public List<String> getResponsesList() {
        return responsesList;
    }

    /**
     * setter responsesList.
     * @param responsesList
     */
    public void setResponsesList(final List<String> responsesList) {
        this.responsesList = responsesList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ennonce == null) ? 0 : ennonce.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((responsesList == null) ? 0 : responsesList.hashCode());
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
        QuestionNoResponseDto other = (QuestionNoResponseDto) obj;
        if (ennonce == null) {
            if (other.ennonce != null) {
                return false;
            }
        } else if (!ennonce.equals(other.ennonce)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (responsesList == null) {
            if (other.responsesList != null) {
                return false;
            }
        } else if (!responsesList.equals(other.responsesList)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "QuestionNoResponseDto [ennonce=" + ennonce + ", id=" + id + ", responses=" + responsesList + "]";
    }

}
