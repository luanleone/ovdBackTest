package com.ovd.projetoteste.api;


import com.ovd.projetoteste.dto.VeiculoDto;
import com.ovd.projetoteste.service.VeiculoService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

/**
 * Created by Luan
 * on 26/09/2016.
 */

@Path("veiculo")
public class VeiculoApi {

    @Context
    private SecurityContext context;

    /**
     * Lista o(s) iten(s) de acordo com o filtro passado por parametro.
     *
     * @return lista
     **/
    @GET
    @Path("listar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<VeiculoDto> listar() {
        return new VeiculoService().listarVeiculosDto();
    }

    /**
     * Salva ou atualiza objeto passado por parametro.
     *
     * @param objeto veiculo
     */
    @POST
    @Path("salvar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void salvar(VeiculoDto objeto) {
        new VeiculoService().inserirVeiculo(objeto);
    }

    /**
     * Salva ou atualiza objeto passado por parametro.
     *
     * @param lista
     */
    @POST
    @Path("salvarList")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void salvarList(List<VeiculoDto> lista) {
        new VeiculoService().inserirVeiculoLista(lista);
    }

}
