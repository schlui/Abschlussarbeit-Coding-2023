package com.example.abschlussprojekt2023.Klimaschrank.jlibmodbus.src.com.intelligt.modbus.jlibmodbus.msg.response;

import com.example.abschlussprojekt2023.Klimaschrank.jlibmodbus.src.com.intelligt.modbus.jlibmodbus.Modbus;
import com.example.abschlussprojekt2023.Klimaschrank.jlibmodbus.src.com.intelligt.modbus.jlibmodbus.exception.ModbusNumberException;
import com.example.abschlussprojekt2023.Klimaschrank.jlibmodbus.src.com.intelligt.modbus.jlibmodbus.utils.ModbusFunctionCode;

/*
 * Copyright (C) 2016 "Invertor" Factory", JSC
 * [http://www.sbp-invertor.ru]
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
final public class WriteMultipleRegistersResponse extends WriteSingleRegisterResponse {

    public WriteMultipleRegistersResponse() {
        super();
    }

    public int getQuantity() {
        return getValue();
    }

    public void setQuantity(int quantity) throws ModbusNumberException {
        setValue(quantity);
    }

    @Override
    protected boolean checkValue() {
        return Modbus.checkWriteRegisterCount(getValue());
    }

    @Override
    public int getFunction() {
        return ModbusFunctionCode.WRITE_MULTIPLE_REGISTERS.toInt();
    }
}
