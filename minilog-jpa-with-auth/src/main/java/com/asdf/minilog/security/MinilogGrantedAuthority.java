package com.asdf.minilog.security;

import org.springframework.security.core.GrantedAuthority;

import com.asdf.minilog.entity.Role;

public class MinilogGrantedAuthority implements GrantedAuthority {
    private final Role role;

    public MinilogGrantedAuthority(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.name();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MinilogGrantedAuthority) {
            return role.equals(((MinilogGrantedAuthority) obj).role);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return role.hashCode();
    }

    @Override
    public String toString() {
        return this.role.name();
    }

}
