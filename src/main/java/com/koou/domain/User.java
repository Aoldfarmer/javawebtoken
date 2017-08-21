package com.koou.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long id;

    private String username;

    private String password;

    private Date loginDate;

    private Date lastPasswordResetDate;

    private String uuid;

    private static final long serialVersionUID = 1L;

    public User(Long id, String username, String password, Date loginDate, Date lastPasswordResetDate, String uuid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.loginDate = loginDate;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.uuid = uuid;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getLoginDate() == null ? other.getLoginDate() == null : this.getLoginDate().equals(other.getLoginDate()))
            && (this.getLastPasswordResetDate() == null ? other.getLastPasswordResetDate() == null : this.getLastPasswordResetDate().equals(other.getLastPasswordResetDate()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getLoginDate() == null) ? 0 : getLoginDate().hashCode());
        result = prime * result + ((getLastPasswordResetDate() == null) ? 0 : getLastPasswordResetDate().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        return result;
    }
}