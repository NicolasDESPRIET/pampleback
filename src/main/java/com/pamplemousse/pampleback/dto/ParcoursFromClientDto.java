package com.pamplemousse.pampleback.dto;

import java.util.List;

public class ParcoursFromClientDto {
    private Double time;

    private String note;

    private int nbSucces;

    private int nbFailed;

    private List<Long> nbBlank;

    private Long qcmId;

    private Long stagiaireId;

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getNbSucces() {
        return nbSucces;
    }

    public void setNbSucces(int nbSucces) {
        this.nbSucces = nbSucces;
    }

    public int getNbFailed() {
        return nbFailed;
    }

    public void setNbFailed(int nbFailed) {
        this.nbFailed = nbFailed;
    }

    public List<Long> getNbBlank() {
        return nbBlank;
    }

    public void setNbBlank(List<Long> nbBlank) {
        this.nbBlank = nbBlank;
    }

    public Long getQcmId() {
        return qcmId;
    }

    public void setQcmId(Long qcmId) {
        this.qcmId = qcmId;
    }

    public Long getStagiaireId() {
        return stagiaireId;
    }

    public void setStagiaireId(Long stagiaireId) {
        this.stagiaireId = stagiaireId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nbBlank == null) ? 0 : nbBlank.hashCode());
        result = prime * result + nbFailed;
        result = prime * result + nbSucces;
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((qcmId == null) ? 0 : qcmId.hashCode());
        result = prime * result + ((stagiaireId == null) ? 0 : stagiaireId.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
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
        ParcoursFromClientDto other = (ParcoursFromClientDto) obj;
        if (nbBlank == null) {
            if (other.nbBlank != null) {
                return false;
            }
        } else if (!nbBlank.equals(other.nbBlank)) {
            return false;
        }
        if (nbFailed != other.nbFailed) {
            return false;
        }
        if (nbSucces != other.nbSucces) {
            return false;
        }
        if (note == null) {
            if (other.note != null) {
                return false;
            }
        } else if (!note.equals(other.note)) {
            return false;
        }
        if (qcmId == null) {
            if (other.qcmId != null) {
                return false;
            }
        } else if (!qcmId.equals(other.qcmId)) {
            return false;
        }
        if (stagiaireId == null) {
            if (other.stagiaireId != null) {
                return false;
            }
        } else if (!stagiaireId.equals(other.stagiaireId)) {
            return false;
        }
        if (time == null) {
            if (other.time != null) {
                return false;
            }
        } else if (!time.equals(other.time)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ParcourFromClientDto [nbBlank=" + nbBlank + ", nbFailed=" + nbFailed + ", nbSucces=" + nbSucces
                + ", note=" + note + ", qcmId=" + qcmId + ", stagiaireId=" + stagiaireId + ", time=" + time + "]";
    }
}
