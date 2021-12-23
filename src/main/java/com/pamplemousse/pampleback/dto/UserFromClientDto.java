package com.pamplemousse.pampleback.dto;

public class UserFromClientDto {

    private String name;

    private String password;

    private Long typeId;

    private String societe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserFromClientDto other = (UserFromClientDto) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (societe == null) {
            if (other.societe != null)
                return false;
        } else if (!societe.equals(other.societe))
            return false;
        if (typeId == null) {
            if (other.typeId != null)
                return false;
        } else if (!typeId.equals(other.typeId))
            return false;
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
