package com.isptec.fabiovictorino;

import java.util.*;

public class Main {
    public static List<Entity> entityList = new ArrayList<>();
    public static Scanner in = new Scanner(System.in);
    public static List<Integer> objectiveOfVisa;
    public static List<Beneficiary> beneficiaryList = new ArrayList<>();
    public static List<Professional> profissionalList = new ArrayList<>();
    public static List<SME> smeList = new ArrayList<>();
    public static List<ResponsibleEntity> responsibleEntityList = new ArrayList<>();
    public static List<MigratoryData> migratoryDataList = new ArrayList<>();

    public static void main(String[] args) {
        Beneficiary beneficiary = new Beneficiary("Tales","Victorini","Angolana","Celestino",
                            "Angolana","Angelina","Angola","28/02/2001","Luanda",
                "Cazenga","Tala","Hady","Luanda",1,"Casado",2323232,3232323,"Luanda",
                "2/4/2020",4,93939393,"fabio@gmail.com",23,"NY","Broklin","ST",
                "LV","NY City");
        Professional professional = new Professional("SC","Scofield","Developer",2323,"fab@gmail.com","luanda-add");
        ResponsibleEntity responsible = new ResponsibleEntity("Fabio","0332KS32","20/02/2025",32,"Cazenga","Tala",
                "Hady","Cazenga","Cazenga","Angola");
        MigratoryData migratoryData = new MigratoryData("02/09/2021","Aeroporto","Estudo",32323,23,"Estudo");
        SME sme = new SME(12,"20/20/2021","Cazenga","Bento");
       Entity entity = new Entity(1,beneficiary,professional,responsible,migratoryData,sme);
       entityList.add(entity);

       beneficiary = new Beneficiary("Ataide","Victorino","Angolana","Celestino",
                "Angolana","Angelina","Angola","28/02/2001","Luanda",
                "Cazenga","Tala","Hady","Luanda",1,"Solteiro",323222,3232323,"Luanda",
                "2/4/2020",4,93939393,"fabio@gmail.com",23,"NY","Broklin","ST",
                "LV","NY City");
        professional = new Professional("Engineer","L&L","Programming",2323,"Ataid@gmail.com","luanda-add");
        responsible = new ResponsibleEntity("Artencio","0332KS32","20/02/2025",32,"Cazenga","Tala",
                "Hady","Cazenga","Cazenga","Angola");
        migratoryData = new MigratoryData("02/09/2021","Vila","Saude",32323,23,"Saude");
        entity = new Entity(3,beneficiary,professional,responsible,migratoryData,sme);

        entityList.add(entity);

        menu();

    }
    //   *************** THE BEGINNING OF ALL

    public static void menu() {
        int option = 0;
        System.out.println("""
                REPÚBLICA DE ANGOLA
               MINISTÉRIO DO INTERIOR
         SERVIÇO DE MIGRAÇÃO E ESTRANGEIROS
         
                Insere para iniciar:
                1 - SME
                2 - BENEFICIARIO
                ::""");
        option = in.nextInt();
        if (option == 1){
            loginSME();
        }else {
            menuEntity();
        }

    }
    public static void loginSME(){

        Map<Integer,String> loginSME = new HashMap<>();
            loginSME.put(1122,"Fabio");
            loginSME.put(2212,"Tales");
            loginSME.put(1212,"Bento");
            loginSME.put(192,"Victorino");
            loginSME.put(3102,"Scofield");

        String userName;
        int password;
        System.out.println("User: ");
        userName = in.nextLine();
        System.out.println("Pass");
        password = in.nextInt();

        if (loginSME.containsKey(password) && loginSME.get(password).equals(userName)){
            SME smeUser = insertionSME();
            insertionEntity(objectiveOfVisa,beneficiaryList,profissionalList,responsibleEntityList,migratoryDataList,smeUser);
            objectiveOfVisa = null;
            beneficiaryList = null;
        }else{
            System.out.println("Usuario ou senha incorreta");
        }
    }
    public static void menuEntity() {
        int option;
        System.out.println("Insere uma opção");
        System.out.println("1 - 1ª VEZ");
        System.out.println("2 - PRORROGAÇÃO");
            option = in.nextInt();

            if (option == 1){
                firstTime();
                menuEntity();
            }else{
                menuProrrogation();
                menuEntity();
            }
    }
    public static void firstTime() {
        Entity entity;
        insertion();
    }
    public static void insertion() {


        beneficiaryList.add(insertBeneficiary());
        profissionalList.add(insertionProfession());
        responsibleEntityList.add(insertionResponsible());
        migratoryDataList.add(insertionMigratory());
        smeList.add(insertionSME());
        Integer option;
        showObjectiveOfVisa();
        option = in.nextInt();
        System.out.println("ffff:  " + option);
        objectiveOfVisa.add(option);

        System.out.println("INSERIDO COM SUCESSO");
        System.out.println("A seguir a fila ");
    }
    public static void menuProrrogation(){
        int indexOf;
        int bi;
        String nationality;
        System.out.println("PRORROGAÇÃO");

        System.out.println("Numero do BI: ");
            bi = in.nextInt();
        in.nextLine();
        System.out.println("Nacionalidade: ");
            nationality = in.nextLine();

        indexOf = selection(bi,nationality);

        if (indexOf != -1){
            int option;
            //entityList.get(indexOf);
            showWhatToDo();
            option = in.nextInt();

            switch (option) {
                case 1-> menuUpdate(indexOf);
                case 2-> search(indexOf);
                case 3-> showAll(indexOf);
                default -> {

                }
            }
        }
    }

    public static int deleteEntity() {
        int biNumber;
        String nationality;
        System.out.println("DELETAR UMA ENTIDADE");
        System.out.println("Numero do bilhete: ");
            biNumber = in.nextInt();
        System.out.println("Nacionalidade: ");
            nationality = in.nextLine();

            int indexOf = 0;
            for (Entity entity: entityList) {
                indexOf = entity.search(entityList,biNumber,nationality);
                if (indexOf != -1){
                    if (entity.delete(entityList,indexOf)) {
                        return 1;
                    }
                }
            }
           return -1;

    }
    public static int selection(int documentationNumber,String nationality) {
        int indexOf = 0;
        for (Entity entity: entityList) {
            indexOf = entity.search(entityList,documentationNumber,nationality);
            if (indexOf != -1){
                return indexOf;
            }
        }
        return -1;
    }






    //   *************** SHOWS MENUS


    public static void showAll(int indexOf) {
        System.out.println("MOSTRANDO TODOS OS CAMPOS");

            entityList.get(indexOf).showEntity();
    }

    public static void showWhatToDo() {
        System.out.println("SELECIONA O QUE DESEJA FAZER");
        System.out.println("""
                1 - ACTUALIZAR
                2 - PESQUISAR
                3 - VISUALIZAR
                :: """);
    }

    public static void showTypeOfOperation(){
        System.out.println("""
                FORMULARIO DIGITAL DE VISTO\n
                1 - 1ª VEZ \n
                2 - PRORROGAÇAO \n
                """);
    }

    public static void showEntity() {
        System.out.println("""
                    DIGITE O QUE DESEJA VER
                1 - TIPO DE VISTO
                2 - DADOS PESSOAIS
                3 - DADOS PROFISSIONAIS
                4 - DADOS DO RESPONSAVEL
                5 - DADOS MIGRATORIOS
                6 - DADOS DO SME 
                :: """);
    }
    public static void showObjectiveOfVisa(){
        System.out.println("""
                DEFININDO O TIPO DO VISTO
                Digite uma opção
                1 - FRONTEIRA
                2 - ESTUDO
                3 - CURTA DURAÇÃO
                4 - TRABALHO
                5 - PERM. TEMPORÁRIA
                6 -  VISTO DE TURISMO
                7 - INVESTIDOR
                8 - TRATAMENTO MÉDICO                        
            
                ::""");
    }
    public static void showBeneficiaryData(){
        System.out.println("""
                 DADOS DE IDENTIFICAÇÃO DO BENEFICIÁRIO
                 Digite uma opção
                1 - Nome
                2 - Apelido
                3 - Nacionalide
                4 - Nome Completo do Pai
                5 - Nacionalidade do Pai
                6 - Nome Completo da Mãe
                7 - Nacionalidade da Mãe
                8 - Data de nascimento
                9 - Local de nascimento
                10 - Comuna
                11 - Província
                12 - Gênero
                13 - Estado civil
                14 - Documento de identificação
                15 - Passaporte nº
                16 - Local de emissão
                17 - Data de emissão
                18 - Validade
                19- Telefones
                20 - E-mail
                21 - Local de hospedagem em Angola: Casa nº
                     22 - Rua
                     23 - Aldeia
                     24 - Comuna
                     25 - Município
                     26 - Província
                 :: """);
    }
    public static void showProfessionalData() {
        System.out.println("""
                    DADOS PROFISSIONAIS
                    Digite uma opção
                1 - Profissão
                2 - Empresa
                3 - Função
                4 - Telefones
                5 - E-mail
                6 - Endereço
            
               :: """);
    }
    public static void showResponsible() {
        System.out.println("""
                    ENTIDADE RESPONSÁVEL E LOCAL DE RESIDÊNCIA/HOSPEDAGEM         \n 
                    Digite uma opção\n
                1 - Nome (Singular ou Empresa) \n
                2 - Nº de Identificação (BI/Passaporte/Cartão/Outro)\n
                3 - Validade\n
                4 - Casa nº\n
                5 - Rua\n
                6 - Bairro/Aldeia\n
                7 - Comuna\n
                8 - Município\n
                9 - Província\n
                10 - País\n
            
               :: """);
    }
    public static void   showMigratory() {
        System.out.println("""
                    DADOS MIGRATÓRIOS        
                    Digite uma opção 
                1 - Data da última entrada (se aplicável)  
                2 - Posto de fronteira utilizado 
                3 - Tipo de visto
                4 - Nº do visto
                5 - Validade do visto
                6 - Vem nos termos da lei aplicável solicitar o acto referido por motivos de
               """);
    }
    public static void showSME() {
        System.out.println("""
                    PREENCHIMENTO RESERVADO AO SME
                    Digite uma opção\n
                1 - Processo Nº\n
                2 - Data de recepção\n
                3 - Local de recepção\n
                4 - Assinatura do Responsável\n
               
            
               :: """);
    }
    public static void showAssignment() {
        System.out.println("""
                    ASSINATURA DO REQUERENTE
                    
            
               :: """);
    }

    //   *************** INSERTION MENU

    public static List<Beneficiary> createPersonList(){
        return new ArrayList<>();
    }
    public boolean insertionPerson(List<Beneficiary> p, Beneficiary newPerson){
        newPerson.insertionPerson(p,newPerson);
        return true;
    }
//    public static int showInsertion() {
//        Scanner in = new Scanner(System.in);
//        int option = 0;
//        System.out.println("""
//                    OPÇÕES PARA INSERIR INFORMAÇÕES\n
//                    Digite uma\n
//                 1 - Personal data\n
//                 2 - Profession\n
//                 3 - \n
//                 4 - \n
//                 5 - \n
//                 6 - \n
//
//                ::""");
//        option = in.nextInt();
//        if(option >-1 && option < 7)  insertionOptions(option);
//        else{
//            System.out.println("Opção invalida." +
//                    "           Insere" +
//                    "0 - cancelar" +
//                    "1 - repetir\n ");
//            if(in.nextInt() == 0) return 0;
//            showInsertion();
//        }
//        return 1;
//    }

    public static Beneficiary insertBeneficiary(){
        Scanner in = new Scanner(System.in);
        Beneficiary beneficiary;
        String name;
        String Nickname;
        String Nationality;
        String fatherName;
        String fatherNationality;
        String motherName;
        String motherNationality;
        String dateOfBirth; //*******************
        String local;
        String street;
        String comuna;
        String municipio;
        String province;
        int Gender;
        String civilState;
        int documentationNumber;
        int passportNumber;
        String localOfEmissionPassport;
        String dataOfEmissionPassport; //*******************
        int validate;
        int telephoneNumber;
        String e_mail;

        int houseNumberToBe;
        String StreetToBe;
        String bairroToBe;
        String comunaToBe;
        String MunicipioToBe;
        String provinceToBe;


        System.out.println("INSERINDO DADOS DE IDENTIFICAÇÃO DO BENEFICIÁRIO");
        System.out.println("Nome: ");name = in.nextLine();
        System.out.println("Apelido: "); Nickname = in.nextLine();
        System.out.println("Nacionalidade: "); Nationality = in.nextLine();
        System.out.println("Nome Completo do Pai: "); fatherName = in.nextLine();
        System.out.println("Nacionalidade do Pai: ");fatherNationality = in.nextLine();
        System.out.println("Nome Completo da Mãe: "); motherName = in.nextLine();
        System.out.println("Nacionalidade do Maẽ: ");motherNationality = in.nextLine();
        System.out.println("Data de Nascimento (dd/mm/aa): "); dateOfBirth = in.nextLine();
        System.out.println("Local de Nascimento: "); local = in.nextLine();

        System.out.println("Bairro/Aldeia: "); street = in.nextLine();
        System.out.println("Comuna: "); comuna = in.nextLine();
        System.out.println("Município: "); municipio = in.nextLine();
        System.out.println("Província: "); province = in.nextLine();
        System.out.println("Genero: " +
                "1 - Homem \n" +
                "2 - Mulher\n"); Gender = in.nextInt();
        in.nextInt();
        System.out.println("Estado Civil: ");civilState = in.nextLine();
        System.out.println("Documentos de identificação: "); documentationNumber = in.nextInt();
        System.out.println("Passaporte nº: "); passportNumber = in.nextInt();

        in.nextInt();
        System.out.println("Local de emissão: "); localOfEmissionPassport = in.nextLine();

        System.out.println("Data de emissão: "); dataOfEmissionPassport = in.nextLine();
        System.out.println("Validade: ");validate = in.nextInt();
        System.out.println("Telefone: "); telephoneNumber = in.nextInt();
        in.nextInt();
        System.out.println("E-mail: "); e_mail = in.nextLine();
        System.out.println("Local de hospedagem em Angola: Casa nº: ");
        houseNumberToBe = in.nextInt();
        in.nextInt();
        System.out.println("Rua: "); StreetToBe = in.nextLine();
        System.out.println("Bairro"); bairroToBe = in.nextLine();
        System.out.println("Comuna: "); comunaToBe = in.nextLine();

        System.out.println("Município: "); MunicipioToBe = in.nextLine();
        System.out.println("Província"); provinceToBe = in.nextLine();

        beneficiary = new Beneficiary(name, Nickname,Nationality, fatherName, fatherNationality,motherName, motherNationality,
                dateOfBirth,  local, street,
                comuna,  municipio, province, Gender,civilState,
                documentationNumber,passportNumber, localOfEmissionPassport,
                dataOfEmissionPassport,  validate,  telephoneNumber,  e_mail,
                houseNumberToBe,  StreetToBe,  bairroToBe, comunaToBe,
                MunicipioToBe,  provinceToBe );


        return beneficiary;
    }
    public static Professional insertionProfession() {
        Professional professional;
        String profession;
        String company;
        String function;
        Integer telephoneNumber;
        String email;
        String address;

        System.out.println("DADOS PROFISSIONAIS");
        System.out.println("Inserindo  ");

        System.out.println("Profissão: ");
        profession = in.nextLine();//*********
        System.out.println("Empresa: ");//********
        company = in.nextLine();
        System.out.println("Função: ");
        function = in.nextLine();
        System.out.println("Telefones: ");
        telephoneNumber = in.nextInt();
        in.nextInt();
        System.out.println("E-mail: ");
        email = in.nextLine();
        System.out.println("Endereço: ");
        address = in.nextLine();
        professional = new Professional(profession,company,function,telephoneNumber,email,address);

        return professional;

    }

    public static ResponsibleEntity insertionResponsible() {
        ResponsibleEntity responsible;
        String nome;
        String numeroIdentificacao;
        String validade;
        int casaNumero;
        String rua;
        String bairroAldeia;
        String comuna;
        String municipio;
        String provincia;
        String pais;

        System.out.println("ENTIDADE RESPONSÁVEL E LOCAL DE RESIDÊNCIA/HOSPEDAGEM");
        System.out.println("Inserindo ");

        System.out.println("Nome (Singular ou Empresa)");
        nome = in.nextLine();
        System.out.println("Nº de Identificação (BI/Passaporte/Cartão/Outro)");
        numeroIdentificacao = in.nextLine();
        System.out.println("Validade");
        validade = in.nextLine();
        System.out.println("Casa nº ");
        casaNumero = in.nextInt();
        in.nextInt();
        System.out.println("Rua");
        rua = in.nextLine();
        System.out.println("Bairro/Aldeia ");
        bairroAldeia = in.nextLine();
        System.out.println("Comuna");
        comuna = in.nextLine();
        System.out.println("Município ");
        municipio = in.nextLine();
        System.out.println("Província:");
        provincia = in.nextLine();
        System.out.println("País:");
        pais = in.nextLine();

        responsible = new ResponsibleEntity(nome,numeroIdentificacao,validade,
                casaNumero,rua,bairroAldeia,comuna,municipio,provincia,pais);

        return responsible;

    }
    public static MigratoryData insertionMigratory() {
        MigratoryData migratoryData;

        String dataUltimaEntrada;
        String postoFronteira;
        String tipoVisto;
        int numeroVisto;
        int validadeVisto;
        String motivoSolicitacao;

        System.out.println("DADOS MIGRATÓRIOS");
        System.out.println("Inserindo");

        System.out.println("Data da última entrada (se aplicável): ");
        dataUltimaEntrada = in.nextLine();
        System.out.println("Posto de fronteira utilizado ");
        postoFronteira = in.nextLine();
        System.out.println("Tipo de visto");
        tipoVisto = in.nextLine();
        System.out.println("Nº do visto");
        numeroVisto = in.nextInt();
        System.out.println("Validade do visto");
        validadeVisto = in.nextInt();
        System.out.println("Vem nos termos da lei aplicável solicitar o acto referido por motivos de");
        motivoSolicitacao = in.nextLine();

        migratoryData = new MigratoryData(dataUltimaEntrada,postoFronteira,
                tipoVisto,numeroVisto,validadeVisto,motivoSolicitacao);

        return migratoryData;

    }
    public static SME insertionSME() {
        SME sme;
        int processNumber;
        String dateReception;
        String local;
        String assignature;

        System.out.println("PREENCHIMENTO RESERVADO AO SME");
        System.out.println("Inserindo");

        System.out.println("Processo Nº: ");
        processNumber = in.nextInt();
        System.out.println("Data de recepção: ");
        dateReception = in.nextLine();
        System.out.println("Local de recepção");
        local = in.nextLine();
        System.out.println("Assinatura do Responsável");
        assignature = in.nextLine();

        sme = new SME(processNumber,dateReception,local,assignature);

        return sme;

    }

    public static void insertionEntity(List<Integer> visaObject,List<Beneficiary> beneficiaries,List<Professional> professionals,
                                       List<ResponsibleEntity> responsibleEntities, List<MigratoryData> migratoryData,
                                       SME smes) {
        Entity entity;
        for (int i =  0; i < visaObject.size();i++) {
            entity = new Entity(visaObject.get(i),beneficiaries.get(i),professionals.get(i),
                    responsibleEntities.get(i),migratoryData.get(i),smes);
            if (!searchEntity(beneficiaries.get(i))){
                entityList.add(entity);
            };
        }
    }



    //   *************** SEARCHING MENU


    public static boolean searchEntity(Beneficiary beneficiary) {

        if (!entityList.isEmpty()) {
            for (Entity entity: entityList) {
                if (entity.getBeneficiary().equals(beneficiary)) {
                    return true;
                }
            }
        }
        return false;
    }



    public static void search(int indexOf){
        int option;
        showEntity();
        option = in.nextInt();
        switch (option) {
            case 1 -> System.out.println("Tipo do Visto: "
                    + entityList.get(indexOf).getVisaPurpose());
            case 2 -> searchBeneficiary(indexOf);
            case 3 -> searchProfessional(indexOf);
            case 4 -> searchResponsible(indexOf);
            case 5 -> searcMigratory(indexOf);
            default -> {

            }
        }
    }

    public static void searchBeneficiary(int indexOf) {
        int option;
        showBeneficiaryData();
        option = in.nextInt();
        if (option > 0 && option < 27) {
            entityList.get(indexOf).getBeneficiary().showBeneficiary(option);
        }else {
            System.out.println("ERRROR");
        }
    }
    public static void searchProfessional(int indexOf) {
        int option;
        showProfessionalData();
        option = in.nextInt();
        if (option > 0 && option < 7) {
            entityList.get(indexOf).getProfessional().showProfessional(option);
        }else {
            System.out.println("ERRROR");
        }
    }

    public static void searchResponsible(int indexOf) {
        int option;
        showProfessionalData();
        option = in.nextInt();
        if (option > 0 && option < 11) {
            entityList.get(indexOf).getResponsibleEntity().showResponsible(option);
        }else {
            System.out.println("ERRROR");
        }
    }
    public static void searcMigratory(int indexOf) {
        int option;
        showBeneficiaryData();
        option = in.nextInt();
        if (option > 0 && option < 27) {
            entityList.get(indexOf).getMigratoryData().showMigratory(option);
        }else {
            System.out.println("ERRROR");
        }
    }


    //   *************** UPDATE MENU

    public static void menuUpdate(int indexOfObject) {
        int option;
        System.out.println("Escolha uma das opções ");
        System.out.println("""
                1 - Tipo do Visto
                2 - Informações do Beneficiario
                3 - Dados Profissionais
                4 - Entidade Responsavel
                5 - Dados Migratorios
                """);
        option = in.nextInt();
        switch (option){
            case 1-> updateVisa(indexOfObject);
            case 2-> updateBeneficiary(indexOfObject);
            case 3-> updateProfessional(indexOfObject);
            case 4-> updateResponsible(indexOfObject);
            case 5-> updateMigratory(indexOfObject);
            default -> {
                System.out.println("Erro no Menu option......!");
            }
        }
    }
    public static void updateVisa(int indexOfObject) {
        int option;
        int newValue;
        showObjectiveOfVisa();
        option = in.nextInt();

        System.out.println("Insere o novo valor: ");
        newValue = in.nextInt();

        if (option >0 && option < 9){
            int toCheckResult;
            Entity entity;
            toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject),option,1,newValue);
            if (toCheckResult != -1){
                System.out.println("UPDATED VISA");
            }
        }else {
            System.out.println("ERROR UPDATE VISA");
        }
    }


    public static void updateBeneficiary(int indexOfObject) {
        int option = 0;

        int intNewValue = 0;
        String stringNewValue = null;
        showBeneficiaryData();
        option = in.nextInt();


        if (option > 0 && option < 27) {

            if (option == 12 || option == 14 || option == 15
                    || option == 18 || option == 19 || option == 21) {
                System.out.println("Insere o novo valor: ");
                intNewValue = in.nextInt();
            } else {
                System.out.println("Insere o novo valor: ");
                stringNewValue = in.nextLine();
            }

            if (intNewValue != 0) {
                int toCheckResult;
                Entity entity;
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 2, intNewValue);

            } else {
                int toCheckResult;
                Entity entity;
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 2, stringNewValue);

            }
        } else {
            System.out.println("Dados pessoais não actualizado");
        }

    }
    public static void  updateProfessional(int indexOfObject) {
        int option = 0;

        int intNewValue = 0;
        String stringNewValue = null;
        showProfessionalData();
        option = in.nextInt();


        if (option > 0 && option < 6) {

            if (option == 4) {
                System.out.println("Insere o novo valor: ");
                intNewValue = in.nextInt();
            } else {
                System.out.println("Insere o novo valor: ");
                stringNewValue = in.nextLine();
            }

            if (intNewValue != 0) {
                int toCheckResult;
                Entity entity;
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 3, intNewValue);

            } else {
                int toCheckResult;
                Entity entity;
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 3, stringNewValue);

            }
        } else {
            System.out.println("Dados profissionais não actualizado");
        }
    }
    public static void updateResponsible( int indexOfObject) {
        int option = 0;

        int intNewValue = 0;
        String stringNewValue = null;
        showResponsible();
        option = in.nextInt();


        if (option > 0 && option < 11) {

            if (option == 2 || option == 3 || option == 4) {
                System.out.println("Insere o novo valor: ");
                intNewValue = in.nextInt();
            } else {
                System.out.println("Insere o novo valor: ");
                stringNewValue = in.nextLine();
            }

            if (intNewValue != 0) {
                int toCheckResult;
                Entity entity;
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 4, intNewValue);

            } else {
                int toCheckResult;
                Entity entity;
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 4, stringNewValue);
            }

        } else {
            System.out.println("Dados dos Responsavel não actualizado");
        }
    }
    public static void updateMigratory(int indexOfObject) {
        int option = 0;

        int intNewValue = 0;
        String stringNewValue = null;
        showMigratory();
        option = in.nextInt();


        if (option > 0 && option < 7) {

            if (option == 4 || option == 5 || option == 3) {
                System.out.println("Insere o novo valor: ");
                intNewValue = in.nextInt();
            } else {
                System.out.println("Insere o novo valor: ");
                stringNewValue = in.nextLine();
            }

            if (intNewValue != 0) {
                int toCheckResult;
                Entity entity;
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 5, intNewValue);

            } else {
                int toCheckResult;
                Entity entity;
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 5, stringNewValue);
            }

        } else {
            System.out.println("Dados de Migração não actualizado");
        }
    }


    //   *************** UPDATE MENU


    //   *************** UPDATE MENU



    //   *************** UPDATE MENU


    //   *************** UPDATE MENU


    //   *************** UPDATE MENU







}

