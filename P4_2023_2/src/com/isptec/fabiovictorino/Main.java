package com.isptec.fabiovictorino;

import java.io.IOException;
import java.util.*;

public class Main {
    public static List<Entity> entityList = new ArrayList<>();
    public static Scanner in = new Scanner(System.in);
    public static List<Integer> objectiveOfVisa = new ArrayList<>();
    public static List<Beneficiary> beneficiaryList = new ArrayList<>();
    public static List<Professional> profissionalList = new ArrayList<>();
    public static List<SME> smeList = new ArrayList<>();
    public static List<ResponsibleEntity> responsibleEntityList = new ArrayList<>();
    public static List<MigratoryData> migratoryDataList = new ArrayList<>();

    public static void main(String[] args) {
        Beneficiary beneficiary = new Beneficiary("Tales","Victorini","Angolana","Celestino",
                            "Angolana","Angelina","Angola","28/02/2001","Luanda",
                "Cazenga","Tala","Hady","Luanda",1,"Casado","232la3232",3232323,"Luanda",
                "2/4/2020","04/12/2027",93939393,"fabio@gmail.com",23,"NY","Broklin","ST",
                "LV","NY City");
        Professional professional = new Professional("SC","Scofield","Developer",2323,"fab@gmail.com","luanda-add");
        ResponsibleEntity responsible = new ResponsibleEntity("Fabio","0332KS32","20/02/2025",32,"Cazenga","Tala",
                "Hady","Cazenga","Cazenga","Angola");
        MigratoryData migratoryData = new MigratoryData("02/09/2021","Aeroporto","Estudo",32323,23,"Estudo");
        SME sme = new SME(12,"20/20/2021","Cazenga","Bento");

        beneficiaryList.add(beneficiary);
        profissionalList.add(professional);
        responsibleEntityList.add(responsible);
        migratoryDataList.add(migratoryData);
        smeList.add(sme);



        Integer integer = 2;
        objectiveOfVisa.add(integer);
        integer = 3;
        objectiveOfVisa.add(integer);

        Entity entity = new Entity(objectiveOfVisa.get(0),beneficiaryList.get(0),profissionalList.get(0),
                responsibleEntityList.get(0),migratoryDataList.get(0),smeList.get(0));
        entityList.add(entity);

       beneficiary = new Beneficiary("Ataide","Victorino","Angolana","Celestino",
                "Angolana","Angelina","Angola","28/02/2001","Luanda",
                "Cazenga","Tala","Hady","Luanda",1,"Solteiro","323bg222",3232323,"Luanda",
                "2/4/2020","14/02/2027",93939393,"fabio@gmail.com",23,"NY","Broklin","ST",
                "LV","NY City");
        professional = new Professional("Engineer","L&L","Programming",2323,"Ataid@gmail.com","luanda-add");
        responsible = new ResponsibleEntity("Artencio","033232","20/02/2025",32,"Cazenga","Tala",
                "Hady","Cazenga","Cazenga","Angola");
        migratoryData = new MigratoryData("02/09/2021","Vila","Saude",32323,23,"Saude");


        beneficiaryList.add(beneficiary);
        profissionalList.add(professional);
        responsibleEntityList.add(responsible);
        migratoryDataList.add(migratoryData);
        smeList.add(sme);


        entity = new Entity(objectiveOfVisa.get(1),beneficiaryList.get(1),profissionalList.get(1),
                            responsibleEntityList.get(1),migratoryDataList.get(1),smeList.get(1));
        entityList.add(entity);

        menu();

    }
    //   *************** THE BEGINNING OF ALL

    // ******************************* EXTRA FUNCTIONS*********************************
    public static void headFoot() {
        System.out.println("""
                        REPÚBLICA DE ANGOLA
                        MINISTÉRIO DO INTERIOR
                        SERVIÇO DE MIGRAÇÃO E ESTRANGEIROS
                """);
    }
    public static void clearScreen() {
        //System.out.print("\033c");

            try{
                ProcessBuilder pb = new ProcessBuilder("bash", "-c", "clear");
                Map<String, String> env = pb.environment();
                env.put("TERM", "xterm");
                pb.inheritIO().start().waitFor();
            } catch(Exception e) {
                System.out.println(e);
            }


    }
//*******************************************************************************
    public static void menu() {
        clearScreen();
        int option = 0;
        headFoot();
        System.out.println("""
                Insere para iniciar:
                1 - SME
                2 - BENEFICIARIO
                ::""");
        option = in.nextInt();
        if (option == 1){
            loginSME();
        }else {
            menuEntity();
            loginSME();
        }
        menu();
    }
    public static void loginSME(){
        clearScreen();
        headFoot();
        in.nextLine();
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
        System.out.println("Pass: ");
        password = in.nextInt();

        if (loginSME.containsKey(password) && loginSME.get(password).equals(userName)){
            SME smeUser = insertionSME();

            insertionEntity(objectiveOfVisa,beneficiaryList,profissionalList,
                    responsibleEntityList,migratoryDataList,smeUser);
            objectiveOfVisa = null;
            beneficiaryList = null;
            profissionalList = null;
            responsibleEntityList = null;
            migratoryDataList = null;
            System.out.println("Inserção feita com sucesso");
            menuEntity();
        }else{
            System.out.println("Usuario ou senha incorreta");
            loginSME();
        }
    }
    public static void menuEntity() {
        clearScreen();
        headFoot();
        int option = 0;
        int count = 0;
        do{
        System.out.println("    Insere uma opção");
        System.out.println("1 - 1ª VEZ");
        System.out.println("2 - PRORROGAÇÃO");
        System.out.println(":: ");
        option = in.nextInt();

            if (option == 1){
                if (insertion()) {
                    System.out.println("INSERIDO COM SUCESSO");
                    System.out.println("A seguir a fila ");
                }else{
                    System.out.println("Não inserido");
                }
            }else if(option == 2){
                menuProrrogation();
            }
        }while(++count != 3);

    }

    public static boolean insertion() {

        Integer OPTION;
        int option;
        showObjectiveOfVisa();
        option = in.nextInt();
        OPTION = option;
        Beneficiary beneficiary = insertBeneficiary();
        Professional professional = insertionProfession();
        ResponsibleEntity responsible = insertionResponsible();
        MigratoryData migratoryData = insertionMigratory();
        if (beneficiary != null && professional != null && responsible != null && migratoryData != null){
            objectiveOfVisa.add(OPTION);
            beneficiaryList.add(beneficiary);
            profissionalList.add(professional);
            responsibleEntityList.add(responsible);
            migratoryDataList.add(migratoryData);
            return true;
        }else{
            return false;
        }
    }
    public static void menuProrrogation(){
        clearScreen();
        headFoot();
        int indexOf;
        String bi;
        String nationality;
        System.out.println("    PRORROGAÇÃO");
        bi =  in.nextLine();
        System.out.println("Numero do BI: ");
            bi =  in.nextLine();
        System.out.println("Nacionalidade: ");
            nationality = in.nextLine();

        indexOf = selection(bi,nationality);
        if (indexOf != -1){
            int option;
            //entityList.get(indexOf);
            do{
            showWhatToDo();
            option = in.nextInt();

                switch (option) {
                    case 1-> menuUpdate(indexOf);
                    case 2-> search(indexOf);
                    case 3-> showAll(indexOf);
                    default -> {
                    }
                }
            }while(option != 0 );
        }else{
            System.out.println("Senha ou numero de identidficação incorreta");
        }
    }

    public static int deleteEntity() {
        String biNumber;
        String nationality;
        System.out.println("    DELETAR UMA ENTIDADE");
        System.out.println("Numero do bilhete: ");
            biNumber =  in.nextLine();
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
    public static int selection(String documentationNumber,String nationality) {
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
        clearScreen();
        headFoot();
        System.out.println("    MOSTRANDO TODOS OS CAMPOS");
            entityList.get(indexOf).showEntity();
    }

    public static void showWhatToDo() {
        clearScreen();
        headFoot();
        System.out.println("    SELECIONA O QUE DESEJA FAZER");
        System.out.println("""
                0 - SAIR
                1 - ACTUALIZAR
                2 - PESQUISAR
                3 - VISUALIZAR
                :: """);
    }

    public static void showTypeOfOperation(){
        clearScreen();
        headFoot();
        System.out.println("""
                FORMULARIO DIGITAL DE VISTO\n
                1 - 1ª VEZ \n
                2 - PRORROGAÇAO \n
                """);
    }

    public static void showEntity() {
        clearScreen();
        headFoot();
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
        clearScreen();
        headFoot();
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
        clearScreen();
        headFoot();
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
        clearScreen();
        headFoot();
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
        clearScreen();
        headFoot();
        System.out.println("""
                    ENTIDADE RESPONSÁVEL E LOCAL DE RESIDÊNCIA/HOSPEDAGEM     
                    Digite uma opção
                1 - Nome (Singular ou Empresa) 
                2 - Nº de Identificação (BI/Passaporte/Cartão/Outro)
                3 - Validade
                4 - Casa nº
                5 - Rua
                6 - Bairro/Aldeia
                7 - Comuna
                8 - Município
                9 - Província
                10 - País            
               :: """);
    }
    public static void   showMigratory() {
        clearScreen();
        headFoot();
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
        clearScreen();
        headFoot();
        System.out.println("""
                    PREENCHIMENTO RESERVADO AO SME
                    Digite uma opção\n
                1 - Processo Nº\n
                2 - Data de recepção\n
                3 - Local de recepção\n
                4 - Assinatura do Responsável\n
               
            
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
        String documentationNumber;
        int passportNumber;
        String localOfEmissionPassport;
        String dataOfEmissionPassport; //*******************
        String validate;
        int telephoneNumber;
        String e_mail;

        int houseNumberToBe;
        String StreetToBe;
        String bairroToBe;
        String comunaToBe;
        String MunicipioToBe;
        String provinceToBe;


        System.out.println("        INSERINDO DADOS DE IDENTIFICAÇÃO DO BENEFICIÁRIO");
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
        System.out.println("  Genero\n1 - Homem 2 - Mulher\n:: ");
        Gender = in.nextInt();
        in.nextLine();
        System.out.println("Estado Civil: ");
        civilState = in.nextLine();
        System.out.println("Documento de identificação: "); documentationNumber = in.nextLine();
        System.out.println("Passaporte nº: "); passportNumber = in.nextInt();
        in.nextLine();
        System.out.println("Local de emissão: "); localOfEmissionPassport = in.nextLine();
        System.out.println("Data de emissão: "); dataOfEmissionPassport = in.nextLine();
        System.out.println("Validade: ");validate = in.nextLine();;
        System.out.println("Telefone: "); telephoneNumber = in.nextInt();
        in.nextLine();
        System.out.println("E-mail: "); e_mail = in.nextLine();
        System.out.println("Local de hospedagem em Angola: Casa nº: ");
        houseNumberToBe = in.nextInt();
        in.nextLine();
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
        int telephoneNumber;
        String email;
        String address;

        System.out.println("        DADOS PROFISSIONAIS");
        System.out.println("    Inserindo  ");
        in.nextLine();
        System.out.println("Profissão: ");
        profession = in.nextLine();
        System.out.println("Empresa: ");
        company = in.nextLine();
        System.out.println("Função: ");
        function = in.nextLine();
        System.out.println("Telefones: ");
        telephoneNumber = in.nextInt();
        in.nextLine();
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

        System.out.println("        ENTIDADE RESPONSÁVEL E LOCAL DE RESIDÊNCIA/HOSPEDAGEM");
        System.out.println("    Inserindo ");
        in.nextLine();
        System.out.println("Nome (Singular ou Empresa): ");
        nome = in.nextLine();
        System.out.println("Nº de Identificação (BI/Passaporte/Cartão/Outro): ");
        numeroIdentificacao = in.nextLine();
        System.out.println("Validade: ");
        validade = in.nextLine();
        System.out.println("Casa nº: ");
        casaNumero = in.nextInt();
        in.nextLine();
        System.out.println("Rua: ");
        rua = in.nextLine();
        System.out.println("Bairro/Aldeia: ");
        bairroAldeia = in.nextLine();
        System.out.println("Comuna: ");
        comuna = in.nextLine();
        System.out.println("Município: ");
        municipio = in.nextLine();
        System.out.println("Província: ");
        provincia = in.nextLine();
        System.out.println("País: ");
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

        System.out.println("        DADOS MIGRATÓRIOS");
        System.out.println("    Inserindo");
        in.nextLine();
        System.out.println("Data da última entrada (se aplicável): ");
        dataUltimaEntrada = in.nextLine();
        System.out.println("Posto de fronteira utilizado: ");
        postoFronteira = in.nextLine();
        System.out.println("Tipo de visto: ");
        tipoVisto = in.nextLine();
        System.out.println("Nº do visto: ");
        numeroVisto = in.nextInt();
        System.out.println("Validade do visto: ");
        validadeVisto = in.nextInt();
        in.nextLine();
        System.out.println("Vem nos termos da lei aplicável solicitar o acto referido por motivos de: ");
        motivoSolicitacao = in.nextLine();

        migratoryData = new MigratoryData(dataUltimaEntrada,postoFronteira,
                tipoVisto,numeroVisto,validadeVisto,motivoSolicitacao);

        return migratoryData;

    }
    public static SME insertionSME() {
        SME sme;
        Random rand = new Random();
        int processNumber;
        String dateReception;
        String local;
        String assignature;
//        int i=0,m=0;
        System.out.println("        PREENCHIMENTO RESERVADO AO SME");
        System.out.println("    Inserindo");
        processNumber = rand.nextInt(1000);
//        if (smeList != null){
//
//
//            m = smeList.get(smeList.size()).getProcessNumber());
//            i = m;
//            System.out.println("value: "+ smeList.get(smeList.size()).getProcessNumber());
//            while(i > 0) {
//                if (smeList.get(i).getProcessNumber() == processNumber ){
//                    processNumber = rand.nextInt(1000);
//            }
//            i--;
//        }
//        }
        System.out.println("Processo Nº: " + processNumber);
//        processNumber = in.nextInt();
        in.nextLine();
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
            System.out.println("Não encontrado");
        }
    }
    public static void searchProfessional(int indexOf) {
        int option;
        showProfessionalData();
        option = in.nextInt();
        if (option > 0 && option < 7) {
            entityList.get(indexOf).getProfessional().showProfessional(option);
        }else {
            System.out.println("Não encontrado");        }
    }

    public static void searchResponsible(int indexOf) {
        int option;
        showProfessionalData();
        option = in.nextInt();
        if (option > 0 && option < 11) {
            entityList.get(indexOf).getResponsibleEntity().showResponsible(option);
        }else {
            System.out.println("Não encontrado");        }
    }
    public static void searcMigratory(int indexOf) {
        int option;
        showBeneficiaryData();
        option = in.nextInt();
        if (option > 0 && option < 27) {
            entityList.get(indexOf).getMigratoryData().showMigratory(option);
        }else {
            System.out.println("Não encontrado");        }
    }


    //   *************** UPDATE MENU

    public static void menuUpdate(int indexOfObject) {
        int option,newValue;
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
            case 1-> {
                showObjectiveOfVisa();
                option = in.nextInt();
                if (option > 0 && option < 9){

                    System.out.println("Insere o novo valor: ");
                    newValue = in.nextInt();
                    if(updateVisa(indexOfObject,option)) {
                        System.out.println("Actualição feita");
                    }else{
                        System.out.println("Actualização não feita");
                    }
                }
            }
            case 2-> {

                showBeneficiaryData();
                option = in.nextInt();


                if (option > 0 && option < 27) {
                    if(updateBeneficiary(indexOfObject,option)) {
                        System.out.println("Dados pessoais actualizado");
                    }else {
                        System.out.println("Dados pessoais não actualizado");
                    }
                }

            }
            case 3-> {
                showProfessionalData();
                option = in.nextInt();

                if (option > 0 && option < 6) {
                    if(updateProfessional(indexOfObject,option)) {
                        System.out.println("Dados profissionais actualizado");
                    }else {
                        System.out.println("Dados profissionais não actualizado");
                    }
                }else {
                    System.out.println("Opção invalida");
                }
            }
            case 4-> {
                showResponsible();
                option = in.nextInt();
                if (option > 0 && option < 11) {
                    if(updateResponsible(indexOfObject,option)){
                        System.out.println("Dados dos Responsavel actualizado");
                    }else {
                        System.out.println("Dados dos Responsavel não actualizado");
                    }
                }else {
                    System.out.println("Opção invalida");
                }

            }
            case 5-> {
                showMigratory();
                option = in.nextInt();
                if (option > 0 && option < 7) {
                       if(updateMigratory(indexOfObject,option)) {
                           System.out.println("Dados de Migração actualizado");
                       }else {
                           System.out.println("Dados de Migração não actualizado");
                       }
               }else{
                    System.out.println("Opção invalida");
                }
            }
            default -> {
                System.out.println("Erro no Menu option......!");
            }
        }
    }
    public static boolean updateVisa(int indexOfObject,int option) {

            int toCheckResult;
            toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject),option,1,option);
            if (toCheckResult != -1){
                return true;
            }else {
                return false;
            }
    }

    public static boolean updateBeneficiary(int indexOfObject,int option) {


        int intNewValue = 0;
        String stringNewValue = null;

        int toCheckResult;

            if (option == 12 || option == 14 || option == 15
                    || option == 18 || option == 19 || option == 21) {
                System.out.println("Insere o novo valor: ");
                intNewValue = in.nextInt();
            } else {
                in.nextLine();
                System.out.println("Insere o novo valor: ");
                stringNewValue = in.nextLine();
            }

            if (intNewValue != 0) {
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 2, intNewValue);

            } else {
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 2, stringNewValue);

            }
            return toCheckResult != -1;

    }
    public static boolean  updateProfessional(int indexOfObject,int option) {


        int intNewValue = 0;
        String stringNewValue = null;
        int toCheckResult;

            if (option == 4) {
                System.out.println("Insere o novo valor: ");
                intNewValue = in.nextInt();
            } else {
                in.nextLine();
                System.out.println("Insere o novo valor: ");
                stringNewValue = in.nextLine();
            }

            if (intNewValue != 0) {
                System.out.println("ddddddd");
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 3, intNewValue);

            }else {
                System.out.println("eeeeeee");
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 3, stringNewValue);

            }
        return toCheckResult != -1;
    }
    public static boolean updateResponsible( int indexOfObject,int option) {


        int intNewValue = 0;
        String stringNewValue = null;
        int toCheckResult;



        if (option == 2 || option == 3 || option == 4) {
                System.out.println("Insere o novo valor: ");
                intNewValue = in.nextInt();
            } else {
            in.nextLine();
                System.out.println("Insere o novo valor: ");
                stringNewValue = in.nextLine();
            }

        if (intNewValue != 0) {
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 4, intNewValue);
                return toCheckResult != -1;
            } else {
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 4, stringNewValue);
                return toCheckResult != -1;
            }
    }
    public static boolean updateMigratory(int indexOfObject, int option) {

        int intNewValue = 0;
        String stringNewValue = null;
        int toCheckResult;

            if (option == 4 || option == 5 || option == 3) {
                System.out.println("Insere o novo valor: ");
                intNewValue = in.nextInt();
            } else {
                in.nextLine();
                System.out.println("Insere o novo valor: ");
                stringNewValue = in.nextLine();
            }

            if (intNewValue != 0) {
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 5, intNewValue);
            } else {
                toCheckResult = entityList.get(indexOfObject).update(entityList.get(indexOfObject), option, 5, stringNewValue);
            }
        return toCheckResult != -1;


    }


    //   *************** UPDATE MENU


    //   *************** UPDATE MENU



    //   *************** UPDATE MENU


    //   *************** UPDATE MENU


    //   *************** UPDATE MENU







}

