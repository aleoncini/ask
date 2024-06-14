package org.acme.ask.rest;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.ask.model.User;
import org.jboss.resteasy.reactive.NoCache;

@Path("/api/users")
public class UserResource {

    @Inject
    SecurityIdentity identity;

    @GET
    @Path("/me")
    @RolesAllowed("user")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public User me() {
        return new User(identity);
    }

}
