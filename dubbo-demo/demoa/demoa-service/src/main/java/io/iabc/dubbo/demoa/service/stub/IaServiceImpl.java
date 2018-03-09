package io.iabc.dubbo.demoa.service.stub;

import com.alibaba.dubbo.config.annotation.Service;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.iabc.demo.share.common.domain.Person;
import io.iabc.dubbo.demoa.share.dto.CookiesDTO;
import io.iabc.dubbo.demoa.share.service.IaService;

/**
 * TODO
 *
 * @author <a href="mailto:h@iabc.io">shuchen</a>
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-25 22:07
 */
@Path("ia")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
@Service(protocol = { "rest", "dubbo" }, timeout = 10000)
public class IaServiceImpl implements IaService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements: 
    @GET
    @Path("cookies")
    @Override
    public String cookies(@BeanParam CookiesDTO cookiesDTO) {
        return cookiesDTO.toString();
    }

    @GET
    @Path("echoSimple")
    @Override
    public String echoSimple(@QueryParam("msg") String msg) {
        return msg;
    }

    @GET
    @Path("echoSimple2")
    @Override
    public String echoSimple2(@QueryParam("msg") String msg, @QueryParam("random") Integer randomTime) {
        if (randomTime == null) {
            throw new NullPointerException("test:randomTime is null");
        }

        return msg;
    }

    @POST
    @Path("echoComplex")
    @Override
    public Person echoComplex(Person person) {
        return person;
    }

    @POST
    @Path("echoComplex2")
    @Override
    public Person echoComplex2(Person person, Integer randomTime) {
        while (randomTime-- > 0) {
            Math.random();
        }
        return person;
    }

    @POST
    @Path("echoListPerson")
    @Override
    public List<Person> echoListPerson(List<Person> persons) {
        return persons;
    }

    @POST
    @Path("echoMapPerson")
    @Override
    public Map<String, Person> echoMapPerson(Map<String, Person> persons) {
        return persons;
    }

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------
}
