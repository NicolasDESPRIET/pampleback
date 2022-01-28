package com.pamplemousse.pampleback.dto;

import java.util.List;

import com.pamplemousse.pampleback.model.User;

public class ParcoursToClientDto {
    private Long id;

    private Double time;

    private String date;

    private String note;

    private int nbSucces;
    
    private int nbFailed;

    private List<QuestionNoResponseDto> nbBlank; 

    private QcmParcourDto qcm;

    private User stagiaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public List<QuestionNoResponseDto> getNbBlank() {
        return nbBlank;
    }

    public void setNbBlank(List<QuestionNoResponseDto> nbBlank) {
        this.nbBlank = nbBlank;
    }

    public QcmParcourDto getQcm() {
        return qcm;
    }

    public void setQcm(QcmParcourDto qcm) {
        this.qcm = qcm;
    }

    public User getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(User stagiaire) {
        this.stagiaire = stagiaire;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nbBlank == null) ? 0 : nbBlank.hashCode());
        result = prime * result + nbFailed;
        result = prime * result + nbSucces;
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((qcm == null) ? 0 : qcm.hashCode());
        result = prime * result + ((stagiaire == null) ? 0 : stagiaire.hashCode());
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
        ParcoursToClientDto other = (ParcoursToClientDto) obj;
        if (date == null) {
            if (other.date != null) {
                return false;
            }
        } else if (!date.equals(other.date)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
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
        if (qcm == null) { 
                return false;
        } else if (!qcm.equals(other.qcm)) {
            return false;
        }
        if (stagiaire == null) {
            if (other.stagiaire != null) {
                return false;
            }
        } else if (!stagiaire.equals(other.stagiaire)) {
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
        return "ParcourToClientDto [date=" + date + ", id=" + id + ", nbBlank=" + nbBlank + ", nbFailed=" + nbFailed
                + ", nbSucces=" + nbSucces + ", note=" + note + ", qcm=" + qcm + ", stagiaire=" + stagiaire + ", time="
                + time + "]";
    }
    
}
