//
// JODConverter - Java OpenDocument Converter
// Copyright 2004-2012 Mirko Nasato and contributors
//
// JODConverter is Open Source software, you can redistribute it and/or
// modify it under either (at your option) of the following licenses
//
// 1. The GNU Lesser General Public License v3 (or later)
//    -> http://www.gnu.org/licenses/lgpl-3.0.txt
// 2. The Apache License, Version 2.0
//    -> http://www.apache.org/licenses/LICENSE-2.0.txt
//
package com.github.jodconverter.office;

import java.util.EventObject;

class OfficeConnectionEvent extends EventObject {

    private static final long serialVersionUID = 2060652797570876077L;

    public OfficeConnectionEvent(OfficeConnection source) {
        super(source);
    }

}
