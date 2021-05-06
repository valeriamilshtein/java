package com.group.rest;

import com.group.entity.Team;
import com.group.entity.TeamUpdateDto;
import com.group.service.TeamService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/teams")
public class TeamResource { //TeamResource has URL of teams

    @EJB
    private TeamService teamService;

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service is working!").build();
    }

    //Create Team
    @POST
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Response createTeam(Team team) {
        teamService.addToList(team);
        return Response.status(Response.Status.CREATED).entity(team).build();
    }

      //Add player to the Team
      /*@GET
      @Produces({APPLICATION_JSON})
      public Response getAllPlayers() {
          return Response.ok().entity(playerService.getPlayerList()).build();
   }*/

//    //Add Player
//    @POST
//    @Consumes({APPLICATION_JSON})
//    @Produces({APPLICATION_JSON})
//    public Response createPlayer(Player player) {
//        playerService.addToList(player);
//        return Response.status(Response.Status.CREATED).entity(player).build();
//    }

    //Update Team name
    @PUT
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Response updateTeam(TeamUpdateDto updateDto) {
        if (updateDto.getId() == null || updateDto.getId() == 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\n" +
                            "\t\"ERROR\": \"Please provide correct id!\"\n" +
                            "}").build();
        }
        Team teamToUpdate = teamService.getById(updateDto.getId());
        if (teamToUpdate == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\n" +
                            "\t\"ERROR\": \"No such team!\"\n" +
                            "}").build();
        }
        return Response.ok().entity(teamService.updateTeam(updateDto, teamToUpdate)).build();
    }
}
