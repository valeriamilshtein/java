package com.group.rest;

import com.group.entity.League;
import com.group.service.LeagueService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/league")
public class LeagueResource { //LeagueResource has URL of league

    @EJB
    private LeagueService LeagueService;

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service is working!").build();
    }

    //Create League
    @POST
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Response createLeague(League league) {
        LeagueService.addToList(league);
        return Response.status(Response.Status.CREATED).entity(league).build();
    }

//    //Add Team to the League
//    @GET
//    @Produces({APPLICATION_JSON})
//    public Response getAllTeams() {
//        return Response.ok().entity(teamService.getTeamList()).build();
//    }
}

