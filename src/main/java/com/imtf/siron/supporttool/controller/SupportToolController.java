package com.imtf.siron.supporttool.controller;

import com.imtf.siron.supporttool.service.SupportToolService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("api/v1/support")
public class SupportToolController {

    @Inject
    SupportToolService supportToolService;

    @GET
    public String getAllSupportToolDetails(){
        return supportToolService.createTempDirectory();
    }
}
