package br.com.fiap.domain.resources;

import br.com.fiap.Main;
import br.com.fiap.domain.dto.ProdutoDTO;
import br.com.fiap.domain.entity.transportavel.Produto;
import br.com.fiap.domain.service.ProdutoService;
import br.com.fiap.infra.security.resources.Resource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.Objects;

@Path("/produto")
public class ProdutoResource implements Resource<ProdutoDTO, Long> {

    @Context
    private UriInfo uriInfo;

    ProdutoService service = ProdutoService.build( Main.PERSISTENCE_UNIT );


    @GET
    @Override
    public Response findAll() {
        return Response.ok( service.findAll().stream().map( ProdutoDTO::of ).toList() ).build();
    }


    @GET
    @Path("/{id}")
    @Override
    public Response findById(@PathParam("id") Long id) {

        Produto produto = service.findById( id );

        if (Objects.isNull( produto )) return Response.status( 404 ).build();

        return Response.ok( ProdutoDTO.of( produto ) ).build();


    }

    @POST
    @Override
    public Response persist(ProdutoDTO p) {

        var produto = ProdutoDTO.of( p );

        Produto persisted = service.persist( produto );

        if (Objects.isNull( persisted )) return Response.status( 400 ).build();

        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI uri = ub.path( String.valueOf( persisted.getId() ) ).build();

        return Response.created( uri ).entity( ProdutoDTO.of( persisted ) ).build();
    }

}
