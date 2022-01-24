package com.pamplemousse.pampleback.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "parcour")
public class Parcour implements Serializable {
    private static final long serialVersionUID = 74817258L;

    /**
     * long id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parcour_id")
    private Long id;

    /**
     * Double time.
     */
    @NotBlank
    @NotNull
    @Column(name = "parcour_time")
    private Double time;

    /**
     * Date date.
     */
    @NotBlank
    @NotNull
    @Column(name = "parcour_date")
    private Date date;

    /**
     * Long note.
     */
    @NotBlank
    @NotNull
    @Column(name = "parcour_note")
    private String note;

    /**
     * int nb_succes.
     */
    @Column(name = "parcour_nb_succes")
    private int nbSucces;

    /**
     * int nb_failed.
     */
    @Column(name = "parcour_nb_failed")
    private int nbFailed;

    /**
     * int nb_blank.
     */
    @Column(name = "parcour_nb_blank")
    private int nbBlank;

    /**
     * Qcm qcm.
     */
    @Column(name = "parcour_qcm")
    private Long qcmId;

    /**
     * User stagiaire.
     */
    @Column(name = "parcour_stagiaire")
    private Long stagiaireId;

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
     * getter time.
     * @return time.
     */
    public Double getTime() {
        return time;
    }

    /**
     * setter time.
     * @param time
     */
    public void setTime(Double time) {
        this.time = time;
    }

    /**
     * getter date.
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * setter date.
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * getter note.
     * @return note.
     */
    public String getNote() {
        return note;
    }

    /**
     * setter note.
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * getter nbSucces.
     * @return nbSucces
     */
    public int getNbSucces() {
        return nbSucces;
    }

    /**
     * setter nbSucces.
     * @param nbSucces
     */
    public void setNbSucces(int nbSucces) {
        this.nbSucces = nbSucces;
    }

    /**
     * getter nbFailed.
     * @return nbFailed
     */
    public int getNbFailed() {
        return nbFailed;
    }

    /**
     * setter nbFailed.
     * @param nbFailed
     */
    public void setNbFailed(int nbFailed) {
        this.nbFailed = nbFailed;
    }

    /**
     * getter nbBlank.
     * @return nbBlank
     */
    public int getNbBlank() {
        return nbBlank;
    }

    /**
     * setter nbBlank.
     * @param nbBlank
     */
    public void setNbBlank(int nbBlank) {
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
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + nbBlank;
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
        Parcour other = (Parcour) obj;
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
        if (nbBlank != other.nbBlank) {
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
        return "Parcour [date=" + date + ", id=" + id + ", nbBlank=" + nbBlank + ", nbFailed=" + nbFailed
                + ", nbSucces=" + nbSucces + ", note=" + note + ", qcm=" + qcmId + ", stagiaire=" + stagiaireId + ", time="
                + time + "]";
    }
}
