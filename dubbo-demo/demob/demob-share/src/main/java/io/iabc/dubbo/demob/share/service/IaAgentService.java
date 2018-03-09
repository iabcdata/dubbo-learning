package io.iabc.dubbo.demob.share.service;

import java.util.List;
import java.util.Map;

import io.iabc.demo.share.common.domain.Person;

/**
 * TODO
 *
 * @author <a href="mailto:h@iabc.io">shuchen</a>
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-25 22:04
 */
public interface IaAgentService {

    String complex(String name);
    
    String echoSimple(String msg);

    String echoSimple2(String msg, Integer randomTime);

    Person echoComplex(Person person);

    Person echoComplex2(Person person, Integer randomTime);

    List<Person> echoListPerson(List<Person> persons);

    Map<String, Person> echoMapPerson(Map<String, Person> persons);

}
