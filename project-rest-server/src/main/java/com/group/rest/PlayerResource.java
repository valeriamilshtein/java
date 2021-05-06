package com.group.rest;

import com.group.entity.Player;
import com.group.entity.PlayerUpdateDto;
import com.group.service.PlayerService;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/players")
public class PlayerResource { //PlayerResource has URL of players

    @EJB
    private PlayerService playerService;

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service is working!").build();
    }

    //Delete Player
    @DELETE
    @Path("{id}")
    @Produces(TEXT_PLAIN)
    public Response deletePlayer(@PathParam("id") long id) {
        playerService.removeFromList(playerService.getById(id));
        return Response.ok().entity("Player deleted!").build();
    }

    //Get all Players by team
    @GET
    @Produces({APPLICATION_JSON})
    public Response getAllPlayers() {
        return Response.ok().entity(playerService.getPlayerList()).build();
    }

    //Update Player data
    @PUT
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Response updatePlayer(PlayerUpdateDto updateDto) {
        if (updateDto.getId() == null || updateDto.getId() == 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\n" +
                            "\t\"ERROR\": \"Please provide correct id!\"\n" +
                            "}").build();
        }
        Player playerToUpdate = playerService.getById(updateDto.getId());
        if (playerToUpdate == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\n" +
                            "\t\"ERROR\": \"No such player!\"\n" +
                            "}").build();
        }
        return Response.ok().entity(playerService.updatePlayer(updateDto, playerToUpdate)).build();
    }

    //Add Player
    @POST
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Response createPlayer(Player player) {
        playerService.addToList(player);
        return Response.status(Response.Status.CREATED).entity(player).build();
    }
}
