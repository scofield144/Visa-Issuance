package com.isptec.fabiovictorino;

import java.util.Date;
import java.util.List;

public class ResponsibleEntity {
    private String nome;
    private String numeroIdentificacao;
    private String validade;
    private int casaNumero;
    private String rua;
    private String bairroAldeia;
    private String comuna;
    private String municipio;
    private String provincia;
    private String pais;

    // Constructor
    public ResponsibleEntity(String nome, String numeroIdentificacao, String validade,
                             int casaNumero, String rua, String bairroAldeia,
                             String comuna, String municipio, String provincia, String pais) {
        this.nome = nome;
        this.numeroIdentificacao = numeroIdentificacao;
        this.validade = validade;
        this.casaNumero = casaNumero;
        this.rua = rua;
        this.bairroAldeia = bairroAldeia;
        this.comuna = comuna;
        this.municipio = municipio;
        this.provincia = provincia;
        this.pais = pais;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    public void setNumeroIdentificacao(String numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getCasaNumero() {
        return casaNumero;
    }

    public void setCasaNumero(int casaNumero) {
        this.casaNumero = casaNumero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairroAldeia() {
        return bairroAldeia;
    }

    public void setBairroAldeia(String bairroAldeia) {
        this.bairroAldeia = bairroAldeia;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int insert(List<ResponsibleEntity> responsibleEntities,
                       ResponsibleEntity newResponsible) {
        ResponsibleEntity alreadyExists = search(responsibleEntities,newResponsible.getNumeroIdentificacao());

        if (alreadyExists == null){
            responsibleEntities.add(newResponsible);
            return 1;
        }
        return -1;
    }

    public <T> void updateValue(int option,T newValue) {
        switch (option) {
            case 1 -> setNome((String) newValue);
            case 2 -> setBairroAldeia((String) newValue);
            case 3 -> setCasaNumero((int)newValue);
            case 4 -> setNumeroIdentificacao((String) newValue);
            case 5 -> setMunicipio((String) newValue);
            case 6 -> setPais((String) newValue);
            case 7 -> setComuna((String) newValue);
            case 8 -> setProvincia((String)  newValue);
            case 9 -> setValidade((String)  newValue);
            case 10 -> setRua((String)  newValue);
            default -> {
            }
        }
    }

    public ResponsibleEntity search(List<ResponsibleEntity> responsibleEntities, String BI) {
            for (ResponsibleEntity responsible: responsibleEntities){
                if (BI.equals(responsible.getNumeroIdentificacao())) return responsible;
            }
            return null;
    }

    public void showResponsible(int option){
        switch (option) {
            case 1  -> System.out.println("Nome (Singular ou Empresa) : " + getNome() );
            case 2  -> System.out.println("Nº de Identificação (BI/Passaporte/Cartão/Outro) : " + getNumeroIdentificacao() );
            case 3  -> System.out.println("Validade : " + getValidade());
            case 4  -> System.out.println("Casa nº : " + getCasaNumero());
            case 5  -> System.out.println("Rua : " + getRua());
            case 6  -> System.out.println("Bairro/Aldeia : " + getBairroAldeia() );
            case 7  -> System.out.println("Comuna : " + getComuna());
            case 8  -> System.out.println("Município : " +  getMunicipio());
            case 9  -> System.out.println("Província : " + getProvincia());
            case 10  -> System.out.println("País : " + getPais());
            default -> {

            }
        }
    }

    // toString method to display the object's data
    @Override
    public String toString() {
        return "Responsible Entity Details:" +
                "\nNome: " + nome +
                "\nNúmero de Identificação: " + numeroIdentificacao +
                "\nValidade: " + validade +
                "\nCasa Número: " + casaNumero +
                "\nRua: " + rua +
                "\nBairro/Aldeia: " + bairroAldeia +
                "\nComuna: " + comuna +
                "\nMunicípio: " + municipio +
                "\nProvíncia: " + provincia +
                "\nPaís: " + pais;
    }
}

