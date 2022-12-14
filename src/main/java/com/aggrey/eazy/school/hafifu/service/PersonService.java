package com.aggrey.eazy.school.hafifu.service;

import com.aggrey.eazy.school.hafifu.constants.EazySchoolConstants;
import com.aggrey.eazy.school.hafifu.model.Person;
import com.aggrey.eazy.school.hafifu.model.Roles;
import com.aggrey.eazy.school.hafifu.repository.PersonRepository;
import com.aggrey.eazy.school.hafifu.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}