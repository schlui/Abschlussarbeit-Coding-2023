package com.example.abschlussprojekt2023;

public class datacom {
    private static final int MB_ADDR_TEMPERATURE_PV = 1000;
    private static final int MB_ADDR_HUMIDITY_PV = 1002;
    private static final int MB_ADDR_TEMPERATURE_SP = 2020;
    private static final int MB_ADDR_HUMIDITY_SP = 2022;
    private static final int MB_ADDR_MANUAL_RUN = 3500;
    private static final int MB_ADDR_HUMIDITY_CONTROL = 3503;

    private static final int LIMIT_BINARY_COMPLEMENT = 32767;
    private static final int MAX_BINARY_VALUE = 65535;

    private static final double MIN_TEMPERATURE_SP = -25.0;
    private static final double MAX_TEMPERATURE_SP = 70.0;

    private static final double MIN_HUMIDITY_SP = 10.0;
    private static final double MAX_HUMIDITY_SP = 98.0;

    private static final double CORROSION_PROTECTION_TEMPERATURE = 60.0;
    private static final double CORROSION_PROTECTION_HUMIDITY = 10.0;

    private ModbusTCPMaster client;
    private int bytesRead;

    public datacom(String host){
        System.out.println("Constructor of FDM_ClimateChamberMP (" + host + ") Started");
        int idSlave = 255;
        bytesRead = 2;

        try {
            client = new ModbusTCPMaster(host, idSlave, true);
            client.setAutoOpen(true);
            client.setAutoClose(true);
        } catch (Exception e) {
            System.out.println("NOT CONNECTED");
            System.out.println("Application will be terminated ... NOT CONNECTED!");
            System.exit( );
        }
        System.out.println("Constructor of FDM_ClimateChamberMP (" + host + ") Finished!");
    }
    
   public void convertReadingData(int data) {
        if(data >LIMIT_BINARY_COMPLEMENT){
            data = -(MAX_BINARY_VALUE - data +1);
        }
        floate result = data / 10; 
        return result; 
   }




}
