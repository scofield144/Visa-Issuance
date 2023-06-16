package com.isptec.fabiovictorino;

import java.util.List;



public class Professional {
    public String profession;
    public String Company;
    public String function;
    public Integer telephoneNumber;
    public String email;
    public String address;

    public Professional(String profession, String company,
                        String function, int telephoneNumber,
                        String email, String address) {
        this.profession = profession;
        this.Company = company;
        this.function = function;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.address = address;
    }

    public int insertion(List<Professional> professionals, Professional newValue) {
        boolean testingIfAlreadyExist = findProfessional(professionals,newValue);
        if (testingIfAlreadyExist) {
            return -1;
        }
        else {
            professionals.add(newValue);
            return 0;
        }
    }
    public boolean findProfessional(List<Professional> professionals, Professional newProfessional) {
        for (Professional prof: professionals){
            if (prof.getTelephoneNumber() == newProfessional.getTelephoneNumber())
                if (prof.getProfession().equals(newProfessional.getProfession())) {
                    return true;
                }
        }
        return false;
    }
    public <T> void updateValue(int option,T newValue) {
        switch (option) {
            case 1 -> {
                System.out.println("INSIDE DDDD");
                setProfession((String) newValue);
            }
            case 2 ->setCompany((String) newValue);
            case 3 ->setFunction((String) newValue);
            case 4 -> setTelephoneNumber((Integer) newValue);
            case 5 -> setEmail((String) newValue);
            case 6 -> setAddress((String) newValue);
            default -> {
            }
        }
    }
    public void showProfessional(int option) {
        switch (option) {
            case 1-> System.out.println("Profissão : " + getProfession());
            case 2-> System.out.println("Empresa : " + getCompany());
            case 3-> System.out.println("Função : " + getFunction());
            case 4-> System.out.println("Telefones : " + getTelephoneNumber() );
            case 5-> System.out.println("E-mail : " + getEmail());
            case 6-> System.out.println("Endereço : " + getAddress());
            default -> {

            }
        }

    }

    @Override
    public String toString() {
        return "Professional{" +
                "profession='" + profession + '\'' +
                ", Company='" + Company + '\'' +
                ", function='" + function + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }




    public String getProfession() {
        return profession;
    }

    public String getCompany() {
        return Company;
    }

    public String getFunction() {
        return function;
    }

    public Integer getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public void setCompany(String company) {
        Company = company;
    }
    public void setFunction(String function) {
        this.function = function;
    }
    public void setTelephoneNumber(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}

