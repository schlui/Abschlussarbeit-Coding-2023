package com.example.abschlussprojekt2023;

import org.python.core.PyInstance;
import org.python.util.PythonInterpreter;

public class Python_Interpreter {

    private PythonInterpreter interpreter;
    public Object FDM;

    public Python_Interpreter() {
        interpreter = new PythonInterpreter();
    }

    public void execfile(String fileName) {
        interpreter.execfile(fileName);
    }

    public PyInstance createClass(String className, String opts) {
        return (PyInstance) this.interpreter.eval(className + "(" + opts + ")");
    }

    public static void main(String[] args) {
        Python_Interpreter ie = new Python_Interpreter();

        ie.execfile("FDM_ClimateChamber.py");

        PyInstance FDM = ie.createClass("FDM_ClimateChamberClassMP", "object");

        /*
         * FDM.invoke("convertReadingData( data: int )");
         * 
         * FDM.invoke("assertLimits( data )");
         * 
         * FDM.invoke("getChamberTemperaturePV");
         * 
         * FDM.invoke("getChamberTemperaturePV_NoLog");
         * 
         * FDM.invoke("setChamberTemperatureSP( temperature )");
         * 
         * FDM.invoke("getChamberTemperatureSP");
         * 
         * FDM.invoke("getChamberHumidityPV");
         * 
         * FDM.invoke("getChamberHumidityPV_NoLog");
         * 
         * FDM.invoke("setChamberHumiditySP( humidity )");
         * 
         * FDM.invoke("getChamberHumiditySP");
         * 
         * FDM.invoke("switchOnChamberManualRun");
         * 
         * FDM.invoke("switchOffChamberManualRun");
         * 
         * FDM.invoke("getChamberManualRunState");
         * 
         * FDM.invoke("switchOnHumidityControl");
         * 
         * FDM.invoke("switchOffHumidityControl");
         * 
         * FDM.invoke("getHumidityControlState");
         * 
         * FDM.invoke("switchOnChamberManualRun_NoLog");
         * 
         * FDM.invoke("waitChamberTemperaturePV_Event SP");
         * 
         * FDM.invoke("constChamberTemperaturePV( SP, timeMinutes )");
         * 
         * FDM.invoke("waitChamberHumidityPV_Event( SP )");
         * 
         * FDM.invoke("setCorrosionProtection");
         * 
         */

    }
}