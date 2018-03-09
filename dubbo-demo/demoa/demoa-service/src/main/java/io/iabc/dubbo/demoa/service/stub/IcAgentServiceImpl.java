package io.iabc.dubbo.demoa.service.stub;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.iabc.demo.share.common.domain.Person;
import io.iabc.demo.share.common.domain.test.TestPersonFactory;
import io.iabc.dubbo.demoa.share.service.IcAgentService;
import io.iabc.dubbo.democ.share.service.IcService;

/**
 * TODO
 *
 * @author <a href="mailto:h@iabc.io">shuchen</a>
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-25 23:10
 */
@Service(protocol = "dubbo", timeout = 10000)
public class IcAgentServiceImpl implements IcAgentService {
    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private Logger logger = LoggerFactory.getLogger(getClass());

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @Resource(name = "icService")
    private IcService icService;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements: 

    @Override
    public String complex(String name) {
        Person person = TestPersonFactory.getPerson(name);
        Person echoed = icService.echoComplex(person);
        return JSON.toJSONString(echoed);
    }

    @Override
    public String echoSimple(String msg) {
        return icService.echoSimple(msg);
    }

    @Override
    public String echoSimple2(String msg, Integer randomTime) {
        return icService.echoSimple2(msg, randomTime);
    }

    @Override
    public Person echoComplex(Person person) {
        return icService.echoComplex(person);
    }

    @Override
    public Person echoComplex2(Person person, Integer randomTime) {
        return icService.echoComplex2(person, randomTime);
    }

    @Override
    public List<Person> echoListPerson(List<Person> persons) {
        return icService.echoListPerson(persons);
    }

    @Override
    public Map<String, Person> echoMapPerson(Map<String, Person> persons) {
        return icService.echoMapPerson(persons);
    }

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------
}
