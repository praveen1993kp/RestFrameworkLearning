package com.api.base;

import com.api.utils.ConfigLoader;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

    /**
     * Request or Response Spec Builder
     */


    public static RequestSpecification getRequestSpec(){
        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName(ConfigLoader.getInstance().getUserName());
        auth.setPassword(ConfigLoader.getInstance().getPass());
      return new  RequestSpecBuilder().setBaseUri(ConfigLoader.getInstance().getBaseURI()).
               setAuth(auth).
               setContentType(ContentType.JSON)
               .log(LogDetail.ALL).build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                        expectContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }

}
