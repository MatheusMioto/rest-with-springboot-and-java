package br.com.erudio.services;


import br.com.erudio.controllers.PersonController;
import br.com.erudio.data.dto.v1.PersonDTOV1;
import br.com.erudio.exception.RequiredObjectIsNullException;
import br.com.erudio.exception.ResourceNotFoundException;
import  static br.com.erudio.mapper.ObjectMapper.parseListObjects;
import  static br.com.erudio.mapper.ObjectMapper.parseObject;

import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonDTOV1> findAll(){
        logger.info("Finding all People!");
        var persons = parseListObjects(repository.findAll(), PersonDTOV1.class);
        persons.forEach(this::addHateoasLinks);
        return persons;
    }

    public PersonDTOV1 findById(Long id){
        logger.info("Finding one Person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        var dto = parseObject(entity, PersonDTOV1.class);
        addHateoasLinks(dto);
        return dto;
    }

    public PersonDTOV1 create(PersonDTOV1 person){
        logger.info("Creating one Person!");
        if (person == null) {
            throw new RequiredObjectIsNullException();
        }
        else {
            var entity = parseObject(person, Person.class);
            var dto = parseObject(repository.save(entity), PersonDTOV1.class);
            addHateoasLinks(dto);
            return dto;
        }
    }

    public PersonDTOV1 update(PersonDTOV1 person){
        logger.info("Updating one Person!");
        if(person == null){
            throw new RequiredObjectIsNullException();
        } else if (person.getId() == 0 || person.getId() == null) {
            throw new RequiredObjectIsNullException("Id is Required");
        } else{
            Person entity = repository.findById(person.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
            entity.setFirstName(person.getFirstName());
            entity.setLastName(person.getLastName());
            entity.setAddress(person.getAddress());
            entity.setGender(person.getGender());

            var dto = parseObject(repository.save(entity), PersonDTOV1.class);
            addHateoasLinks(dto);
            return dto;
        }
    }

    @Transactional
    public PersonDTOV1 disablePerson(Long id){
        logger.info("Disable one Person!");

        if (id == null || id == 0) {
            throw new RequiredObjectIsNullException("Id is Required");
        }
        else {
            repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
            repository.disablePerson(id);

            var entity = repository.findById(id).get();
            var dto = parseObject(entity, PersonDTOV1.class);
            addHateoasLinks(dto);
            return dto;
        }
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");

        if (id == null || id == 0) {
            throw new RequiredObjectIsNullException("Id is Required");
        }
        else {
            Person entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
            repository.delete(entity);

        }
    }

    private void addHateoasLinks(PersonDTOV1 dto) {
        dto.add(linkTo(methodOn(PersonController.class).findByeId(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findALL").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(PersonController.class).disablePerson(dto.getId())).withRel("disable").withType("PATH"));
        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
