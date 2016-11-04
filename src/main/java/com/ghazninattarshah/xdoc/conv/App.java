package com.ghazninattarshah.xdoc.conv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import fr.opensagres.xdocreport.converter.ConverterRegistry;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.IConverter;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.document.DocumentKind;

/**
 * @author Ghazni Nattarshah
 * Created on Apr 22, 2016
 *
 */
public class App {

    public static void main( String[] args ) throws Exception {

    	//NOTE : by default the ODT 2 PDF converter is done with ODT->XSL-FO->FOP.

    	// 1) Create options ODT 2 PDF to select well converter form the registry
    	Options options = Options.getFrom(DocumentKind.ODT).to(ConverterTypeTo.PDF);

    	// 2) Get the converter from the registry
    	IConverter converter = ConverterRegistry.getRegistry().getConverter(options);

    	// 3) Convert ODT 2 PDF
    	InputStream in = App.class.getResourceAsStream("sample.odt");

    	OutputStream out = new FileOutputStream(new File("sample.pdf"));
    	converter.convert(in, out, options);    
    }
}
