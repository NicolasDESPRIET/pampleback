package com.pamplemousse.pampleback.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public final class User implements Serializable {
    private static final long serialVersionUID = 346733376635L;

    /**
     * Long id.
     */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
    private Long id;

    /**
     * String name.
     */
    @NotBlank
    @NotNull
    @Column(name = "user_name")
    private String name;

    /**
     * String password.
     */
    @NotBlank
    @NotNull
    @Column(name = "user_password")
    private String password;

    /**
     * Type type.
     */
    @NotBlank
    @NotNull
    @JoinColumn(name = "user_type_id", referencedColumnName = "type_id")
    @ManyToOne
    private Type type;

    /**
     * String societe.
     */
    @Column(name = "user_societe")
    private String societe;

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
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * getter name.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * setter name.
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * getter password.
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter Password.
     * @param password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * getter type.
     * @return Type type
     */
    public Type getType() {
        return type;
    }

    /**
     * setter Type.
     * @param type
     */
    public void setType(final Type type) {
        this.type = type;
    }

    /**
     * getter societe.
     * @return String societe
     */
    public String getSociete() {
        return societe;
    }

    /**
     * setter societe.
     * @param societe
     */
    public void setSociete(final String societe) {
        this.societe = societe;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((societe == null) ? 0 : societe.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        User other = (User) obj;
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
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (societe == null) {
            if (other.societe != null) {
                return false;
            }
        } else if (!societe.equals(other.societe)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", societe=" + societe + ", type="
                + type + "]";
    }
}
