package com.isptec.fabiovictorino;

import java.util.List;

public class Entity {
    private Integer visaPurpose;
    private final Beneficiary beneficiary;
    private final Professional professional;
    private final ResponsibleEntity responsibleEntity;
    private final MigratoryData migratoryData;
    private final SME sme;
    private static Entity entityList;

    //public static Entity create(){    }

    public Entity(Integer visaPurpose, Beneficiary beneficiary, Professional professional,
                  ResponsibleEntity responsibleEntity, MigratoryData migratoryData, SME sme) {
        this.visaPurpose = visaPurpose;
        this.beneficiary = beneficiary;
        this.professional = professional;
        this.responsibleEntity = responsibleEntity;
        this.migratoryData = migratoryData;
        this.sme = sme;
    }

    public   int insertion(List<Entity> entityList, Entity newEntity) {
        if (entityList == null) {
            entityList.add(newEntity);
        } else {
            for (Entity entity : entityList) {
                if (entity.equals(newEntity)) return 1;
            }
            entityList.add(newEntity);
        }
        return 0;
    }
    public   int search(Entity entity, Entity toCheck) {
        if (entity != null) {
            if (entity.equals(toCheck)) {
                return 1;
            }
        }
        return -1;
    }
    public   int search(List<Entity> entityList, String biNumber, String nationality) {
        if (entityList != null) {
            for (Entity entity : entityList) {
                if (entity.beneficiary.getDocumentationNumber().equals(biNumber)
                        && entity.beneficiary.getNationality().equals(nationality)) {
                    return entityList.indexOf(entity);
                }
            }
        }
        return -1;
    }

    public   <T> int update(Entity entity,int optionObject, int option, T newValue) {

        switch (option) {
            case 1:

                if ((Integer) newValue <= 8) {
                    entity.visaPurpose = (Integer) newValue;
                } else {
                    return -1;
                }
                break;
            case 2:
                entity.beneficiary.updateValue(optionObject, newValue);
                break;
            case 3:
                entity.professional.updateValue(optionObject, newValue);

                break;
            case 4:
                entity.responsibleEntity.updateValue(optionObject, newValue);
                break;
            case 5:
                entity.migratoryData.updateValue(optionObject, newValue);
                break;
            default:
                return -1;

        }
        return 0;
    }
    public   boolean delete(List<Entity> entityList, int indexOf){
        boolean resultOfDelete = entityList.remove(entityList.get(indexOf));
        if (resultOfDelete){
            return true;
        }else{
            return false;
        }
    }
    public void showEntity(){
        switch (visaPurpose) {
            case 1 -> System.out.println("FRONTEIRA");
            case 2 ->System.out.println("ESTUDO");
            case 3 -> System.out.println("CURTA DURAÇÃO");
            case 4 ->System.out.println("TRABALHO");
            case 5 -> System.out.println("PERM. TEMPORARIA");
            case 6 ->System.out.println("VISTO DE TURISMO");
            case 7 -> System.out.println("INVESTIDOR");
            case 8 ->System.out.println("TRATAMENTO MÉDICO");
            default -> {

            }
        };
        System.out.println("BENEFICIARIO \n" + beneficiary.toString());
        System.out.println("PROFESSIONAL \n"+ professional.toString());
        System.out.println("RESPONSAVEL \n"+ responsibleEntity.toString());
        System.out.println("MIGRAÇÃO \n"+ migratoryData.toString());
        System.out.println("SME \n"+ sme.toString());

    }

    public Integer getVisaPurpose() {
        return visaPurpose;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public Professional getProfessional() {
        return professional;
    }

    public ResponsibleEntity getResponsibleEntity() {
        return responsibleEntity;
    }

    public MigratoryData getMigratoryData() {
        return migratoryData;
    }

    public SME getSme() {
        return sme;
    }

    public static Entity getEntityList() {
        return entityList;
    }

}