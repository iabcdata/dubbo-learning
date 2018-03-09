package io.iabc.demo.share.common.domain.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.iabc.demo.share.common.domain.Gender;
import io.iabc.demo.share.common.domain.Parent;
import io.iabc.demo.share.common.domain.Person;

/**
 * TODO
 *
 * @author <a href="mailto:h@iabc.io">shuchen</a>
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-26 10:28
 */
public class TestPersonFactory {
    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static Person getPerson(String name) {

        Person father = new Person();
        father.setGender(Gender.Male);
        father.setAge(58);
        father.setName("father");
        father.setWeight(66);

        Person mother = new Person();
        mother.setGender(Gender.Female);
        mother.setAge(56);
        mother.setName("mother");
        mother.setWeight(45);

        Parent parent = new Parent();
        parent.setFather(father);
        parent.setMother(mother);

        Person brotherA = new Person();
        brotherA.setGender(Gender.Male);
        brotherA.setAge(30);
        brotherA.setName("brotherA");
        brotherA.setWeight(75);
        brotherA.setParent(parent);

        Person brotherB = new Person();
        brotherB.setGender(Gender.Male);
        brotherB.setAge(26);
        brotherB.setName("brotherB");
        brotherB.setWeight(66);
        brotherB.setParent(parent);

        Set<Person> brothers = new HashSet<Person>();
        brothers.add(brotherA);
        brothers.add(brotherB);

        Person friendA = new Person();
        friendA.setGender(Gender.Male);
        friendA.setAge(28);
        friendA.setName("friendA");
        friendA.setWeight(72);

        Person friendB = new Person();
        friendB.setGender(Gender.Female);
        friendB.setAge(25);
        friendB.setName("friendB");
        friendB.setWeight(50);

        Person friendC = new Person();
        friendC.setGender(Gender.Male);
        friendC.setAge(28);
        friendC.setName("friendC");
        friendC.setWeight(72);

        Person friendD = new Person();
        friendD.setGender(Gender.Female);
        friendD.setAge(28);
        friendD.setName("friendD");
        friendD.setWeight(72);

        List<Person> friends = new ArrayList<Person>();
        friends.add(friendA);
        friends.add(friendB);
        friends.add(friendC);
        friends.add(friendD);

        List<Person> friendGroupL1 = new ArrayList<Person>();
        friendGroupL1.add(friendA);
        friendGroupL1.add(friendB);

        List<Person> friendGroupL2 = new ArrayList<Person>();
        friendGroupL2.add(friendC);
        friendGroupL2.add(friendD);

        Map<String, List<Person>> friendGroup = new HashMap<String, List<Person>>();

        friendGroup.put("L1", friendGroupL1);
        friendGroup.put("L2", friendGroupL2);

        Person person = new Person();
        person.setGender(Gender.Male);
        person.setAge(28);
        person.setName(name);
        person.setWeight(72);
        person.setParent(parent);
        person.setBrothers(brothers);
        person.setFriends(friends);
        person.setFriendGroup(friendGroup);

        return person;
    }

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements:

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------
}
