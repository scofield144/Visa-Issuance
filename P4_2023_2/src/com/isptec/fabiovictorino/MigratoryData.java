package com.isptec.fabiovictorino;

import java.util.Date;
import java.util.List;

public class MigratoryData {
    private String dataUltimaEntrada;
    private String postoFronteira;
    private String tipoVisto;
    private int numeroVisto;
    private int validadeVisto;
    private String motivoSolicitacao;

    public MigratoryData(String dataUltimaEntrada, String postoFronteira, String tipoVisto,
                         int numeroVisto, int validadeVisto, String motivoSolicitacao) {
        this.dataUltimaEntrada = dataUltimaEntrada;
        this.postoFronteira = postoFronteira;
        this.tipoVisto = tipoVisto;
        this.numeroVisto = numeroVisto;
        this.validadeVisto = validadeVisto;
        this.motivoSolicitacao = motivoSolicitacao;
    }

    public static int insertion(List<MigratoryData> migratoryDataList,MigratoryData newMigratory){
        boolean alreadyExist = search(migratoryDataList,newMigratory);
        if (!alreadyExist){
            migratoryDataList.add(newMigratory);
            return 1;
        }else {
            return -1;
        }
    }
    public  <T> void updateValue(int option,T newValue) {
        switch (option) {
            case 1 -> setDataUltimaEntrada((String) newValue);
            case 2 -> setPostoFronteira((String) newValue);
            case 3 -> setTipoVisto((String) newValue);
            case 4 -> setNumeroVisto((int) newValue);

            case 5 -> setValidadeVisto((int) newValue);
            case 6 -> setMotivoSolicitacao((String) newValue);
            default -> {
            }
        }
    }
    public static boolean search(List<MigratoryData> migratoryDataList,MigratoryData newMigratory){
        for (MigratoryData migratoryData: migratoryDataList) {
            if (migratoryData.equals(newMigratory)) return true;
        }
        return false;
    }

    public void showMigratory(int option) {
         switch (option) {
             case 1 -> System.out.println("Data da última entrada (se aplicável)  : " + getDataUltimaEntrada());
             case 2 -> System.out.println("Posto de fronteira utilizado : " + getPostoFronteira() );
             case 3 -> System.out.println("Tipo de visto : " + getTipoVisto());
             case 4 -> System.out.println("Nº do visto : " + getTipoVisto());
             case 5 -> System.out.println("Validade do visto : " + getValidadeVisto());
             case 6 -> System.out.println("Motivos : " + getMotivoSolicitacao() );
             default -> {
             }
         }
    }
    public String getDataUltimaEntrada() {
        return dataUltimaEntrada;
    }

    public void setDataUltimaEntrada(String dataUltimaEntrada) {
        this.dataUltimaEntrada = dataUltimaEntrada;
    }

    public String getPostoFronteira() {
        return postoFronteira;
    }

    public void setPostoFronteira(String postoFronteira) {
        this.postoFronteira = postoFronteira;
    }

    public String getTipoVisto() {
        return tipoVisto;
    }

    public void setTipoVisto(String tipoVisto) {
        this.tipoVisto = tipoVisto;
    }

    public int getNumeroVisto() {
        return numeroVisto;
    }

    public void setNumeroVisto(int numeroVisto) {
        this.numeroVisto = numeroVisto;
    }

    public int getValidadeVisto() {
        return validadeVisto;
    }

    public void setValidadeVisto(int validadeVisto) {
        this.validadeVisto = validadeVisto;
    }

    public String getMotivoSolicitacao() {
        return motivoSolicitacao;
    }

    public void setMotivoSolicitacao(String motivoSolicitacao) {
        this.motivoSolicitacao = motivoSolicitacao;
    }

    @Override
    public String toString() {
        return "DADOS MIGRATÓRIOS" +
                "\nData da última entrada: " + dataUltimaEntrada +
                "\nPosto de fronteira utilizado: " + postoFronteira +
                "\nTipo de visto: " + tipoVisto +
                "\nNº do visto: " + numeroVisto +
                "\nValidade do visto: " + validadeVisto +
                "\nMotivos de solicitação: " + motivoSolicitacao;
    }
}

