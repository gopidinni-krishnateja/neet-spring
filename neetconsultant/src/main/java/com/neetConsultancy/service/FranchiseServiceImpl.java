package com.neetConsultancy.service;

import com.neetConsultancy.dao.FranchiseDAO;
import com.neetConsultancy.model.Franchise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FranchiseServiceImpl implements FranchiseService {
    @Autowired
    FranchiseDAO franchiseDAO;
    public void addFranchise(Franchise franchise) {
        franchiseDAO.addFranchise(franchise);
    }

    public Franchise getFranchise(int id) {
        return franchiseDAO.getFranchise(id);
    }

    public Franchise updateFranchise(Franchise franchise) {
        return franchiseDAO.updateFranchise(franchise);
    }

    public void deleteFranchise(int id) {
        franchiseDAO.deleteFranchise(id);
    }

    public List<Franchise> filterFranchises(String name) {
        return franchiseDAO.filterFranchises(name);
    }

    public List<Franchise> getAllFranchises() {
        return franchiseDAO.getAllFranchises();
    }
}
