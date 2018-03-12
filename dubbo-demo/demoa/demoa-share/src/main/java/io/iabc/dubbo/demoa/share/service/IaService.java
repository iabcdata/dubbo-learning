package io.iabc.dubbo.demoa.share.service;

import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.iabc.demo.share.common.domain.Person;
import io.iabc.dubbo.demoa.share.dto.CookiesDTO;

/**
 * TODO
 *
 * @author <a href="mailto:h@iabc.io">shuchen</a>
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-25 21:15
 */
@Path("ia")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public interface IaService {

    @GET
    @Path("cookies")
    String cookies(@BeanParam CookiesDTO cookiesDTO);

    @GET
    @Path("echoSimple")
    String echoSimple(@QueryParam("msg") String msg);

    @GET
    @Path("echoSimple2")
    String echoSimple2(@QueryParam("msg") String msg, @QueryParam("random") Integer randomTime);

    @POST
    @Path("echoComplex")
    Person echoComplex(Person person);

    @POST
    @Path("echoComplex2")
    Person echoComplex2(Person person, Integer randomTime);

    @POST
    @Path("echoListPerson")
    List<Person> echoListPerson(List<Person> persons);

    @POST
    @Path("echoMapPerson")
    Map<String, Person> echoMapPerson(Map<String, Person> persons);

}
