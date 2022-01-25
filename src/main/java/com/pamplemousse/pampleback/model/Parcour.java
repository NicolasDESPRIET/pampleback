package com.pamplemousse.pampleback.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    @ManyToMany
    @JoinTable( name = "P_parcours_Question_link",
    joinColumns = @JoinColumn(name="parcour_id"),
    inverseJoinColumns = @JoinColumn(name = "q_id"))
    private List<Question> nbBlank;

    /**
     * Qcm qcm.
     */
    @NotBlank
    @NotNull
    @JoinColumn(name = "parcour_qcm_id", referencedColumnName = "qcm_id")
    @ManyToOne
    private Qcm qcm;

    /**
     * User stagiaire.
     */
    @NotBlank
    @NotNull
    @JoinColumn(name = "parcour_stagiaire_id", referencedColumnName = "user_id")
    @ManyToOne
    private User stagiaire;

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
    public List<Question> getNbBlank() {
        return nbBlank;
    }

    /**
     * setter nbBlank.
     * @param nbBlank
     */
    public void setNbBlank(List<Question> nbBlank) {
        this.nbBlank = nbBlank;
    }
    

    public Qcm getQcm() {
        return qcm;
    }

    public void setQcm(Qcm qcm) {
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
            if (other.qcm != null) {
                return false;
            }
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
        return "Parcour [date=" + date + ", id=" + id + ", nbBlank=" + nbBlank + ", nbFailed=" + nbFailed
                + ", nbSucces=" + nbSucces + ", note=" + note + ", qcm=" + qcm + ", stagiaire=" + stagiaire + ", time="
                + time + "]";
    }
}
