package com.pamplemousse.pampleback.dto;

public class QcmFromClientDto {
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
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        QcmFromClientDto other = (QcmFromClientDto) obj;
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
        return "QcmFromClientDto [author=" + author + ", description=" + description + ", name=" + name + "]";
    }

}
