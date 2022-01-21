package com.pamplemousse.pampleback.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "qcm")
public class Qcm implements Serializable {
    private static final long serialVersionUID = 74817258L;

    /**
     * long id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qcm_id")
    private Long id;

    /**
     * string name.
     */
    @NotBlank
    @Column(name = "qcm_name")
    private String name;

    /**
     * string description.
     */
    @Column(name = "qcm_description")
    private String description;

    /**
     * string author.
     */
    @NotNull
    @Column(name = "qcm_author")
    private String author;

    /**
     * List<Question> qcmQuestion;
     */
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "qcm_question_id", referencedColumnName = "qcm_id")
    private List<Question> qcmQuestion;

    /**
     * getter id.
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * setter id.
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter description.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter author.
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * setter author.
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * setter qcmQuestion
     * @return List<Question>
     */
    public List<Question> getQcmQuestion() {
        return qcmQuestion;
    }

    /**
     * setter qcmQuestion.
     * @param qcmQuestion
     */
    public void setQcmQuestion(List<Question> qcmQuestion) {
        this.qcmQuestion = qcmQuestion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((qcmQuestion == null) ? 0 : qcmQuestion.hashCode());
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
        Qcm other = (Qcm) obj;
        if (author == null) {
            if (other.author != null) {
                return false;
            }
        } else if (!author.equals(other.author)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (qcmQuestion == null) {
            if (other.qcmQuestion != null) {
                return false;
            }
        } else if (!qcmQuestion.equals(other.qcmQuestion)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Qcm [author=" + author + ", description=" + description + ", id=" + id + ", name=" + name
                + ", qcmQuestion=" + qcmQuestion + "]";
    }

}
