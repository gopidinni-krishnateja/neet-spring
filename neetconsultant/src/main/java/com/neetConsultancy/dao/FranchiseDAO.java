package com.neetConsultancy.dao;

import com.neetConsultancy.model.Franchise;

import java.util.List;

public interface FranchiseDAO {
    public void addFranchise(Franchise franchise);
    public Franchise getFranchise(int franchiseId);
    public Franchise updateFranchise(Franchise franchise);
    public void  deleteFranchise(int franchiseId);
    public List<Franchise> filterFranchises(String name);
    public List<Franchise> getAllFranchises();
    public void approveFranchise(List<Franchise> franchises);
}
