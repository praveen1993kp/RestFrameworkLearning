package com.api.base;

import static com.api.base.SpecBuilder.getRequestSpec;
import static com.api.base.SpecBuilder.getResponseSpec;
import static com.api.lombokImpl.CreateClassSetter.createTicketRequest;
import static io.restassured.RestAssured.*;

import com.api.utils.ConfigLoader;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;

public class RestResource {

    /**
     * @return
     */
    public Response createIncident() throws JsonProcessingException {
        return given(getRequestSpec()).
                body(createTicketRequest())
                .when()
                .post(ConfigLoader.getInstance().getCreateJIRAEndPoint())
                .then().spec(getResponseSpec())
                .extract().response();
    }

}
