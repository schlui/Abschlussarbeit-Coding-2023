package com.intelligt.modbus.jlibmodbus.serial;

/*
 * Copyright (C) 2017 Vladislav Y. Kochedykov
 *
 * [http://jlibmodbus.sourceforge.net]
 *
 * This file is part of JLibModbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Authors: Vladislav Y. Kochedykov, software engineer.
 * email: vladislav.kochedykov@gmail.com
 */

import java.util.List;

abstract public class SerialPortAbstractFactory {
    final protected String mainClassName;
    final protected String connectorName;

    protected SerialPortAbstractFactory(final String mainClassName, final String connectorName) {
        this.mainClassName = mainClassName;
        this.connectorName = connectorName;
    }

    final public String getUnavailableString() {
        return "The " + connectorName + " library is missing";
    }

    final public String getMainClassName() {
        return mainClassName;
    }

    abstract SerialPort createSerialImpl(SerialParameters sp) throws SerialPortException;
    abstract List<String> getPortIdentifiersImpl() throws SerialPortException;

    final SerialPort createSerial(SerialParameters sp) throws SerialPortException {
        checkLibrary();
        return createSerialImpl(sp);
    }

    final List<String> getPortIdentifiers() throws SerialPortException {
        checkLibrary();
        return getPortIdentifiersImpl();
    }

    String getVersion() {
        return "The version number is unavailable.";
    }

    public boolean available() {
        try {
            Class.forName(getMainClassName());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final protected void checkLibrary() throws SerialPortException {
        if (!available())
            throw new SerialPortException(getUnavailableString());
    }
}
