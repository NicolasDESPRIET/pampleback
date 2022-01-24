package com.pamplemousse.pampleback.dto;

public class UserFromClientDto {

    /**
     * String name.
     */
    private String name;

    /**
     * string password.
     */
    private String password;

    /**
     * Long typeId.
     */
    private Long typeId;

    /**
     * String societe.
     */
    private String societe;

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
     * setter password.
     * @param password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * getter typeId.
     * @return Long typeId
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * setter typeId.
     * @param typeId
     */
    public void setTypeId(final Long typeId) {
        this.typeId = typeId;
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
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((societe == null) ? 0 : societe.hashCode());
        result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
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
        UserFromClientDto other = (UserFromClientDto) obj;
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
        if (typeId == null) {
            if (other.typeId != null) {
                return false;
            }
        } else if (!typeId.equals(other.typeId)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UserFromClientDto [name=" + name + ", password=" + password + ", societe=" + societe + ", typeId="
                + typeId + "]";
    }
}
