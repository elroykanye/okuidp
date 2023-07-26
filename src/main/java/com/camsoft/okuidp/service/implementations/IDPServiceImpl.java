package com.camsoft.okuidp.service.implementations;


import com.camsoft.okuidp.service.IDPService;
import com.camsoft.okuidp.domain.*;
import com.camsoft.okuidp.repository.ContactRepository;
import com.camsoft.okuidp.repository.IDPAnswerRepository;
import com.camsoft.okuidp.repository.IDPRepository;
import com.camsoft.okuidp.util.Gender;
import com.camsoft.okuidp.util.IDPType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IDPServiceImpl implements IDPService {

    @Autowired
    private IDPRepository idpRepos;

    @Autowired
    private IDPAnswerRepository iAnswerRepos;

    @Autowired
    private ContactRepository contactRepos;

    @Override
    public IDP createIDP(User user, IDP idp) {
        Contact contact = new Contact();
        if (!Objects.isNull(user)) {
            user.addIDP(idp);
            idp.setUser(user);
        }

        if (!Objects.isNull(idp.getContact())) {
            contact = contactRepos.save(idp.getContact());
            idp.setContact(contact);
        }
        return idpRepos.save(idp);
    }

    @Override
    public IDP getIDP(Long id) {
        return idpRepos.getReferenceById(id);
    }

    @Override
    public IDP getIDP(String name) {
        return idpRepos.findByNameIgnoreCase(name);
    }

    @Override
    public IDP getIDPByCNI(String cni) {
        return idpRepos.findByCniIgnoreCase(cni);
    }

    @Override
    public List<IDP> getIDPs(int minAge, int maxAge) {
        return idpRepos.findByAgeBetween(minAge, maxAge);
    }

    @Override
    public List<IDP> getIDPs(IDPType type) {

        return idpRepos.findByType(type);
    }

    @Override
    public List<IDP> getIDPs(Gender gender) {
        return idpRepos.findByGender(gender);
    }

    @Override
    public List<IDP> getIDPs(Interest interest) {
        return idpRepos.findAll().parallelStream()
            .filter(idp -> idp.getInterests().contains(interest)).collect(Collectors.toList());
    }

    @Override
    public List<IDPAnswer> getIDPAnswers(IDP idp) {
        return iAnswerRepos.findByIdp(idp);
    }

    @Override
    public IDP updateIDP(Long id, IDP idp) {
        IDP idpFromDb = idpRepos.getReferenceById(id);
        System.out.println(idpFromDb);
        idpFromDb.setAddress((idp.getAddress().isBlank()) ? idpFromDb.getAddress() : idp.getAddress());
        idpFromDb.setAge((idp.getAge() > 0) ? idp.getAge() : idpFromDb.getAge());
        idpFromDb.setCni((idp.getCni().isBlank()) ? idpFromDb.getCni() : idp.getCni());
        idpFromDb.setGender((Objects.isNull(idp.getGender())) ? idpFromDb.getGender() : idp.getGender());
        idpFromDb.setName((idp.getName().isBlank()) ? idpFromDb.getName() : idp.getName());
        idpFromDb.setType(Objects.isNull(idp.getType()) ? idpFromDb.getType() : idp.getType());
        idpFromDb.setPastActivities((idp.getPastActivities().isBlank()) ? idpFromDb.getPastActivities() : idp.getPastActivities());
        idpFromDb.setNumofminors((idp.getNumofminors() <= 0) ? idpFromDb.getNumofminors() : idp.getNumofminors());
        if (!Objects.isNull(idp.getContact())) {
            Contact contact = idpFromDb.getContact();
            if (Objects.isNull(contact)) {
                contact = contactRepos.save(idp.getContact());
            } else {
                contact.setEmail((idp.getContact().getEmail().isBlank()) ? contact.getEmail() : idp.getContact().getEmail());
                contact.setLocation((idp.getContact().getLocation().isBlank()) ? contact.getLocation() : idp.getContact().getLocation());
                contact.setPhoneNumber((idp.getContact().getPhoneNumber() <= 0) ? contact.getPhoneNumber() : idp.getContact().getPhoneNumber());
                contact = contactRepos.save(idp.getContact());
            }
            idpFromDb.setContact(contact);
        }
        return idpRepos.save(idpFromDb);
    }

    @Override
    public void deleteIDP(Long id) {
        idpRepos.deleteById(id);
    }

    @Override
    public List<IDP> getIDPs() {
        return idpRepos.findAll();
    }

    @Override
    public List<IDP> getIDPsByMinors(int minMinor, int maxMinor) {

        return idpRepos.findByNumofminorsBetween(minMinor, maxMinor);
    }

    @Override
    public List<IDP> getIDPs(int numOfMinor) {
        return idpRepos.findByNumofminorsGreaterThanEqual(numOfMinor);
    }


    @Override
    public Optional<IDP> getById(long id) {
        return idpRepos.findById(id);
    }


    @Override
    public IDP saveIDP(User user, IDP idp) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IDP addIDP(String name) {
        // TODO Auto-generated method stub
        return null;
    }

}
