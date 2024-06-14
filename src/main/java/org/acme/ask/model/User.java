package org.acme.ask.model;

import io.quarkus.security.identity.SecurityIdentity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class User {
    private final String userName;
    private final Set<String> roles;

    public User(SecurityIdentity identity) {
        this.userName = identity.getPrincipal().getName();
        this.roles = identity.getRoles();
    }

    public String getUserName() {
        return userName;
    }
    public Set<String> getRoles() {
        return roles;
    }

    public boolean hasRole(String role){
        return roles.contains(role);
    }
}
