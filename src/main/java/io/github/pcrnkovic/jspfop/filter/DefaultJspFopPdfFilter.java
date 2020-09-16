/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.filter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import org.apache.commons.io.IOUtils;
import org.apache.fop.apps.FopFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Pavle Crnković
 */

public class DefaultJspFopPdfFilter extends JspFopPdfFilter {

    @Override
    protected FopFactory acquireFopFactory(FilterConfig config) throws ServletException {
        try {
            String fopConfigPath = config.getInitParameter(DEFAULT_FOP_CONFIG_PATH_PARAM);
            if (fopConfigPath == null) {
                logInfo("Custom \"" + DEFAULT_FOP_CONFIG_PATH_PARAM + "\" not specified.");
                logInfo("Detecting Operating system...");
                String os, osName = System.getProperty("os.name").toLowerCase();
                if (osName.contains("windows")) {
                    os = "windows";
                } else if (osName.contains("linux")) {
                    os = "linux";
                } else {
                    os = "misc";
                }
                
                File webInfFolder = new File(config.getServletContext().getRealPath("/WEB-INF"));
                File jspfopFilterConfig = new File(webInfFolder, "jspfop-filter-config");
                File defaultConfigFile = new File(jspfopFilterConfig, os + ".xml");
                jspfopFilterConfig.mkdir();
                try (
                        FileOutputStream fos = new FileOutputStream(defaultConfigFile); 
                        InputStream confInput = getClass().getClassLoader().getResourceAsStream("META-INF/jspfop-filter-config/" + os + ".xml")) 
                {
                    if (confInput == null)
                        throw new ServletException("input is null.");
                    if (fos == null)
                        throw new ServletException("output is null.");
                    IOUtils.copy(confInput, fos);
                }
                
                return FopFactory.newInstance(defaultConfigFile);

            } else {

                String realPath = config.getServletContext().getRealPath(fopConfigPath);
                if (realPath == null) {
                    throw new ServletException("Real path of \"" + fopConfigPath + "\" cannot be resolved.");
                }
                return FopFactory.newInstance(new File(realPath));
            }
        } 
        catch (IOException | SAXException e) {
            throw new ServletException(e);
        }
    }
}
