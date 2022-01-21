package com.pamplemousse.pampleback.dto;

import java.util.List;

public class QcmToClientNoRDto {
    /**
     * Long id.
     */
    private Long id;

    /**
     * String name.
     */
    private String name;

    /**
     * String description.
     */
    private String description;

    /**
     * String author.
     */
    private String author;

    /**
     * List<QuestionNoResponseDto> qcmQuestion.
     */
    private List<QuestionNoResponseDto> qcmQuestion;

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
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter description.
     * @return String description
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
     * @return String author
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
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter qcmQuestion.
     * @return List<QuestionNoResponseDto> qcmQuestion
     */
    public List<QuestionNoResponseDto> getQcmQuestion() {
        return qcmQuestion;
    }

    /**
     * setter qcmQuestion.
     * @param qcmQuestion
     */
    public void setQcmQuestion(List<QuestionNoResponseDto> qcmQuestion) {
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
        QcmToClientNoRDto other = (QcmToClientNoRDto) obj;
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
        return "QcmToClientNoRDto [author=" + author + ", description=" + description + ", id=" + id + ", name=" + name
                + ", qcmQuestion=" + qcmQuestion + "]";
    }
    
}
