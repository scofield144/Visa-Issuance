package com.isptec.fabiovictorino;

import java.util.List;

public interface TAD {
    public <E> void insertion(List<E> newValue);
    public <E> boolean findObject(List<E> p, E objectName);

    public void insertionPerson(Beneficiary newPerson);
//    void insertionPerson(Profissional p, Profissional newPerson);
//    void insertionPerson(Profissional newPerson);
    public boolean findPerson(List<Beneficiary> p, int BI, String country);

    public boolean findPerson(List<Beneficiary> p, Beneficiary newPerson);

    public boolean deletePerson(List<Beneficiary> p, int BI, String country);
    public void updatePerson(Beneficiary p, int BI, String country);
    public void findProfissional(Beneficiary p, int BI, String country);
    <T> int updatePerson(List<Beneficiary> p, int BI, String country, T change, T newValue);
}
