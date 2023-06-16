package com.isptec.fabiovictorino;

 import java.util.List;

public class Beneficiary {

    public String name;
    public String Nickname;
    public String Nationality;
    public String fatherName;
    public String fatherNationality;
    public String motherName;
    public String motherNationality;
    public String dateOfBirth;
    public String local;
    public String street;
    public String comuna;
    public String municipio;
    public String province;
    public Integer Gender;
    public String civilState;
    public String documentationNumber;
    public Integer passportNumber;
    public String localOfEmissionPassport;
    public String dataOfEmissionPassport;
    public String validate;
    public Integer telephoneNumber;
    public String e_mail;

    public int houseNumberToBe;
    public String StreetToBe;
    public String bairroToBe;
    public String comunaToBe;
    public String MunicipioToBe;
    public String provinceToBe;

    public Beneficiary(String name, String nickname, String nationality, String fatherName, String fatherNationality, String motherName, String motherNationality,
                       String dateOfBirth, String local, String street,
                       String comuna, String municipio, String province, Integer gender, String civilState,
                       String documentationNumber, Integer passportNumber, String localOfEmissionPassport,
                       String dataOfEmissionPassport, String validate, Integer telephoneNumber, String e_mail,
                       Integer houseNumberToBe, String streetToBe, String bairroToBe, String comunaToBe,
                       String municipioToBe, String provinceToBe) {
        this.name = name;
        Nickname = nickname;
        Nationality = nationality;
        this.fatherName = fatherName;
        this.fatherNationality = fatherNationality;
        this.motherName = motherName;
        this.motherNationality = motherNationality;
        this.dateOfBirth = dateOfBirth;
        this.local = local;
        this.street = street;
        this.comuna = comuna;
        this.municipio = municipio;
        this.province = province;
        Gender = gender;
        this.civilState = civilState;
        this.documentationNumber = documentationNumber;
        this.passportNumber = passportNumber;
        this.localOfEmissionPassport = localOfEmissionPassport;
        this.dataOfEmissionPassport = dataOfEmissionPassport;
        this.validate = validate;
        this.telephoneNumber = telephoneNumber;
        this.e_mail = e_mail;
        this.houseNumberToBe = houseNumberToBe;
        StreetToBe = streetToBe;
        this.bairroToBe = bairroToBe;
        this.comunaToBe = comunaToBe;
        MunicipioToBe = municipioToBe;
        this.provinceToBe = provinceToBe;
    }
    public boolean insertionPerson(List<Beneficiary> personalList, Beneficiary newPerson){
       if (!findPerson(personalList,newPerson)){
           personalList.add(newPerson);
            return true;
       }else{
           System.out.println("error");
           return false;
       }
    }
    public boolean findPerson(List<Beneficiary> p, Beneficiary newPerson) {
            for (Beneficiary personal: p){
                if (personal.getNationality().equals(newPerson.getNationality())
                        &&( personal.getDocumentationNumber() == newPerson.documentationNumber)){
                    return true;
                }
            }
            return false;
    }

    private static Beneficiary findPersonList(List<Beneficiary> p, String BI, String country) {
        for (Beneficiary personal: p){
            if (personal.getNationality().equals(country)
                    &&( personal.getDocumentationNumber().equals(BI))){
                return personal;
            }
        }
        return null;
    }


    public boolean deletePerson(List<Beneficiary> p, String BI, String country) {
        Beneficiary personal = findPersonList(p, BI, country);
        if (personal != null){
           p.remove(personal);
            return true;
        }else{
            return false;
        }
    }

    public <T> void updateValue(int option,T newValue) {
        switch (option){
            case 1:
                System.out.println("INSIDE");
                setName((String) newValue);break;
            case 2:  setNickname((String) newValue);
                 break;
            case 3: setNationality((String) newValue);
                break;
            case 4: setFatherName((String) newValue);
                break;
            case 5: setFatherNationality((String) newValue);break;
            case 6: setMotherName((String) newValue); break;
            case 7: setMotherNationality((String) newValue);break;
            case 8: setDateOfBirth((String) newValue);break;
            case 9:  setLocal((String) newValue);
                break;
            case 10: setComuna((String) newValue);
                break;
            case 11: setProvince((String) newValue);
                break;
            case 12: setGender((Integer) newValue);break;
            case 13: setCivilState((String) newValue); break;
            case 14: setDocumentationNumber((String) newValue);break;
            case 15:setPassportNumber((Integer) newValue);break;
            case 16:  setLocalOfEmissionPassport((String) newValue);break;
            case 17: setDataOfEmissionPassport((String) newValue);
                break;
            case 18: setValidate((String) newValue);
                break;
            case 19: setTelephoneNumber((Integer) newValue);break;
            case 20: setE_mail((String) newValue); break;
            case 21: setHouseNumberToBe((Integer) newValue);break;
            case 22:setStreetToBe((String) newValue); break;
            case 23:  setBairroToBe((String) newValue);
                break;
            case 24: setComunaToBe((String) newValue);
                break;
            case 25: setMunicipioToBe((String) newValue);
                break;
            case 26: setProvinceToBe((String) newValue);break;

            default: break;
        }
    }
    public void show(){
        System.out.println("Name: " + getName()+
                "Nationality: " + getNationality());
    }
    public void showBeneficiary(int option){
        switch (option){
            case 1 -> System.out.println("Nome: " + getName());
            case 2 -> System.out.println("Apelido: " + getNickname());
            case 3 -> System.out.println("Nacionalide " + getNationality());
            case 4 -> System.out.println("Nome Completo do Pai: " + getFatherName());
            case 5-> System.out.println("Nacionalidade do Pai : " + getFatherNationality());
            case 6 -> System.out.println("Nome Completo da Mãe : " + getMotherName());
            case 7 -> System.out.println("Nacionalidade da Mãe : " + getMotherNationality());
            case 8 -> System.out.println("Data de nascimento : " + getDateOfBirth());
            case 9 -> System.out.println("Local de nascimento : " + getLocal());
            case 10 -> System.out.println("Comuna : " + getComuna());
            case 11 -> System.out.println("Província : " + getProvince());
            case 12 -> System.out.println("Gênero : " + getGender());
            case 13 -> System.out.println("Estado civil : " + getCivilState());
            case 14 -> System.out.println("Documento de identificação : " + getDocumentationNumber());
            case 15 -> System.out.println("Passaporte nº : " + getPassportNumber());
            case 16 -> System.out.println("Local de emissão : " + getLocalOfEmissionPassport());
            case 17 -> System.out.println("Data de emissão : " + getDataOfEmissionPassport());
            case 18 -> System.out.println("Validade : " + getValidate());
            case 19 -> System.out.println("Telefones : " + getTelephoneNumber());
            case 20 -> System.out.println("E-mail : " + getE_mail());
            case 21 -> System.out.println("Local de hospedagem em Angola: Casa nº : " + getHouseNumberToBe());
            case 22 -> System.out.println("Rua : " + getStreetToBe());
            case 23 -> System.out.println("Aldeia : " + getBairroToBe());
            case 24 -> System.out.println("Comuna : " + getComunaToBe());
            case 25 -> System.out.println("Município : " + getMunicipioToBe());
            case 26 -> System.out.println("Província : " + getProvinceToBe());
            default -> {
            }
        }
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setFatherNationality(String fatherNationality) {
        this.fatherNationality = fatherNationality;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setMotherNationality(String motherNationality) {
        this.motherNationality = motherNationality;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setGender(Integer gender) {
        Gender = gender;
    }

    public void setCivilState(String civilState) {
        this.civilState = civilState;
    }

    public void setDocumentationNumber(String documentationNumber) {
        this.documentationNumber = documentationNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setLocalOfEmissionPassport(String localOfEmissionPassport) {
        this.localOfEmissionPassport = localOfEmissionPassport;
    }

    public void setDataOfEmissionPassport(String dataOfEmissionPassport) {
        this.dataOfEmissionPassport = dataOfEmissionPassport;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public void setTelephoneNumber(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }


    public void setHouseNumberToBe(Integer houseNumberToBe) {
        this.houseNumberToBe = houseNumberToBe;
    }

    public void setStreetToBe(String streetToBe) {
        StreetToBe = streetToBe;
    }

    public void setBairroToBe(String bairroToBe) {
        this.bairroToBe = bairroToBe;
    }

    public void setComunaToBe(String comunaToBe) {
        this.comunaToBe = comunaToBe;
    }

    public void setMunicipioToBe(String municipioToBe) {
        MunicipioToBe = municipioToBe;
    }

    public void setProvinceToBe(String provinceToBe) {
        this.provinceToBe = provinceToBe;
    }



    public String getName() {
        return name;
    }

    public String getNickname() {
        return Nickname;
    }

    public String getNationality() {
        return Nationality;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getFatherNationality() {
        return fatherNationality;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getMotherNationality() {
        return motherNationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLocal() {
        return local;
    }

    public String getStreet() {
        return street;
    }

    public String getComuna() {
        return comuna;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getProvince() {
        return province;
    }

    public int getGender() {
        return Gender;
    }

    public String getCivilState() {
        return civilState;
    }

    public String getDocumentationNumber() {
        return documentationNumber;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public String getLocalOfEmissionPassport() {
        return localOfEmissionPassport;
    }

    public String getDataOfEmissionPassport() {
        return dataOfEmissionPassport;
    }

    public String getValidate() {
        return validate;
    }

    public Integer getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getE_mail() {
        return e_mail;
    }



    public Integer getHouseNumberToBe() {
        return houseNumberToBe;
    }

    public String getStreetToBe() {
        return StreetToBe;
    }

    public String getBairroToBe() {
        return bairroToBe;
    }

    public String getComunaToBe() {
        return comunaToBe;
    }

    public String getMunicipioToBe() {
        return MunicipioToBe;
    }

    public String getProvinceToBe() {
        return provinceToBe;
    }

    @Override
    public String toString() {
        return
                "   Nome: " + name +
                "\n Nome do Meio: " + Nickname +
                "\n Nacionalidade: " + Nationality +
                "\n Nome do pai: " + fatherName +
                "\n Nacionalidade do pai: " + fatherNationality  +
                "\n Nome da mãe: " + motherName +
                "\n Nacionalidade da mãe: " + motherNationality +
                "\n dateOfBirth: " + dateOfBirth + '\'' +
                "\n local: " + local + '\'' +
                "\n street: " + street + '\'' +
                "\n comuna: " + comuna + '\'' +
                "\n municipio: " + municipio + '\'' +
                "\n province: " + province + '\'' +
                "\n Gender=" + Gender +
                "\n civilState='" + civilState + '\'' +
                "\n documentationNumber=" + documentationNumber +
                "\n passportNumber=" + passportNumber +
                "\n localOfEmissionPassport='" + localOfEmissionPassport + '\'' +
                "\n dataOfEmissionPassport='" + dataOfEmissionPassport + '\'' +
                ", validate=" + validate +
                ", telephoneNumber=" + telephoneNumber +
                ", e_mail='" + e_mail + '\'' +
                ", houseNumberToBe=" + houseNumberToBe +
                ", StreetToBe='" + StreetToBe + '\'' +
                ", bairroToBe='" + bairroToBe + '\'' +
                ", comunaToBe='" + comunaToBe + '\'' +
                ", MunicipioToBe='" + MunicipioToBe + '\'' +
                ", provinceToBe='" + provinceToBe + '\'';
    }
}
