package com.camsoft.okuidp.service.implementations;

import com.camsoft.okuidp.service.InterestService;
import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.Interest;
import com.camsoft.okuidp.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestServiceImpl implements InterestService {
    @Autowired
    private InterestRepository intRepos;

    @Override
    public Interest createInterestIfNotExist(String interestName) {
        if (!interestName.isBlank() || interestName != null) {
            Interest intterestFormDB = intRepos.findByNameIgnoreCase(interestName);
            if (intterestFormDB != null) {
                return intterestFormDB;
            }
            return intRepos.save(new Interest(interestName));
        }
        return null;
    }

    @Override
    public Interest getInterest(Long id) {
        return intRepos.getReferenceById(id);
    }

    @Override
    public Interest getInterest(String name) {
        return intRepos.findByNameIgnoreCase(name);
    }

    @Override
    public List<Interest> getInterests() {
        return intRepos.findAll();
    }

    @Override
    public List<Interest> getInterest(Category cat) {
        return intRepos.findByCategory(cat);
    }

    @Override
    public void deleteInterest(Long id) {
        intRepos.deleteById(id);

    }

    @Override
    public void deleteInterest(String name) {
        intRepos.deleteByNameIgnoreCase(name);

    }

    @Override
    public void deleteInterests(List<Long> id) {
        intRepos.deleteAllByIdInBatch(id);

    }

    @Override
    public List<Interest> getInterest(IDP idp) {
        return idp.getInterests();
    }

    @Override
    public Interest save(Interest interest) {
        // TODO Auto-generated method stub
        return null;
    }
}

