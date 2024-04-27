package com.stefanini.lab.resources;

import java.util.Optional;

import org.hibernate.mapping.List;

import com.stefanini.lab.entity.ClienteEntity;
import com.stefanini.lab.entity.dto.ClientDto;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("client")
@Produces("application/json")
@Consumes("application/json")
public class ClienteResource {

    @POST
    @Transactional
    public Response insert(ClientDto req) {
        Optional<ClienteEntity> optionalClient = ClienteEntity.find("clientName=?1", req.getClientName())
                .firstResultOptional();
        optionalClient.ifPresentOrElse(x -> {
            System.out.println("Client já cadastrado!");
        }, () -> {
            ClienteEntity client = new ClienteEntity();
            client.setClientName(req.getClientName());
            client.setDocClient(req.getDocClient());
            client.persist();
        });
        return Response.ok(ClienteEntity.findAll().list())
                .encoding("UTF-8")
                .build();
    }

}
