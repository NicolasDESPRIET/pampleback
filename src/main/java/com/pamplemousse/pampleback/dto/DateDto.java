package com.pamplemousse.pampleback.dto;

public class DateDto {
    /**
     * string date.
     */
    private String date;

    /**
     * getter Date.
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * setter date.
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
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
        DateDto other = (DateDto) obj;
        if (date == null) {
            if (other.date != null) {
                return false;
            }
        } else if (!date.equals(other.date)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "DateDto [date=" + date + "]";
    }
}
