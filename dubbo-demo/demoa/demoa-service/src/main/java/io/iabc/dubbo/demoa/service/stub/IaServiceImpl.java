package io.iabc.dubbo.demoa.service.stub;

import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.iabc.demo.share.common.domain.Person;
import io.iabc.dubbo.demoa.share.service.IaService;

/**
 * TODO
 *
 * @author <a href="mailto:h@iabc.io">shuchen</a>
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-25 22:07
 */
@Service(protocol = { "rest", "dubbo" }, timeout = 10000)
public class IaServiceImpl implements IaService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements:

    @Override
    public String echoSimple(String msg) {
        return msg;
    }

    @Override
    public String echoSimple2(String msg, Integer randomTime) {
        if (randomTime == null) {
            throw new NullPointerException("test:randomTime is null");
        }

        return msg;
    }
    
    @Override
    public Person echoComplex(Person person) {
        return person;
    }
    
    @Override
    public Person echoComplex2(Person person, Integer randomTime) {
        while (randomTime-- > 0) {
            Math.random();
        }
        return person;
    }
    
    @Override
    public List<Person> echoListPerson(List<Person> persons) {
        return persons;
    }
    
    @Override
    public Map<String, Person> echoMapPerson(Map<String, Person> persons) {
        return persons;
    }

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------
}
