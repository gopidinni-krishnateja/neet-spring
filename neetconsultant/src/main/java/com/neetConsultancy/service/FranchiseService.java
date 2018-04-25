package com.neetConsultancy.service;

import com.neetConsultancy.model.Franchise;

import java.util.List;

public interface FranchiseService {
    public void addFranchise(Franchise franchise);
    public Franchise getFranchise(int id);
    public Franchise updateFranchise(Franchise franchise);
    public void  deleteFranchise(int id);
    public List<Franchise> filterFranchises(String name);
    public List<Franchise> getAllFranchises();
}
