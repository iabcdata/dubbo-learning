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
import io.iabc.dubbo.demoa.share.service.IbAgentService;
import io.iabc.dubbo.demob.share.service.IbService;

/**
 * TODO
 *
 * @author <a href="mailto:h@iabc.io">shuchen</a>
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-25 23:10
 */
@Service(protocol = "dubbo", timeout = 10000)
public class IbAgentServiceImpl implements IbAgentService {
    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private Logger logger = LoggerFactory.getLogger(getClass());

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @Resource(name = "ibService")
    private IbService ibService;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements: 

    @Override
    public String complex(String name) {
        Person person = TestPersonFactory.getPerson(name);
        Person echoed = ibService.echoComplex(person);
        return JSON.toJSONString(echoed);
    }

    @Override
    public String echoSimple(String msg) {
        return ibService.echoSimple(msg);
    }

    @Override
    public String echoSimple2(String msg, Integer randomTime) {
        return ibService.echoSimple2(msg, randomTime);
    }

    @Override
    public Person echoComplex(Person person) {
        return ibService.echoComplex(person);
    }

    @Override
    public Person echoComplex2(Person person, Integer randomTime) {
        return ibService.echoComplex2(person, randomTime);
    }

    @Override
    public List<Person> echoListPerson(List<Person> persons) {
        return ibService.echoListPerson(persons);
    }

    @Override
    public Map<String, Person> echoMapPerson(Map<String, Person> persons) {
        return ibService.echoMapPerson(persons);
    }

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------
}
