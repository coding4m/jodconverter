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
package com.github.jodconverter;

import static com.github.jodconverter.office.OfficeUtils.*;

import com.github.jodconverter.document.DocumentFamily;
import com.github.jodconverter.office.OfficeException;


import com.sun.star.lang.XComponent;
import com.sun.star.lang.XServiceInfo;

class OfficeDocumentUtils {

    private OfficeDocumentUtils() {
        throw new AssertionError("utility class must not be instantiated");
    }

    public static DocumentFamily getDocumentFamily(XComponent document) throws OfficeException {
        XServiceInfo serviceInfo = cast(XServiceInfo.class, document);
        if (serviceInfo.supportsService("com.sun.star.text.GenericTextDocument")) {
            // NOTE: a GenericTextDocument is either a TextDocument, a WebDocument, or a GlobalDocument
            // but this further distinction doesn't seem to matter for conversions
            return DocumentFamily.TEXT;
        } else if (serviceInfo.supportsService("com.sun.star.sheet.SpreadsheetDocument")) {
            return DocumentFamily.SPREADSHEET;
        } else if (serviceInfo.supportsService("com.sun.star.presentation.PresentationDocument")) {
            return DocumentFamily.PRESENTATION;
        } else if (serviceInfo.supportsService("com.sun.star.drawing.DrawingDocument")) {
            return DocumentFamily.DRAWING;
        } else {
            throw new OfficeException("document of unknown family: " + serviceInfo.getImplementationName());
        }
    }

}