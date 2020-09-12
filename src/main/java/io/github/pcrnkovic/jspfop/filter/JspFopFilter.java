/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pcrnkovic.jspfop.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;



/**
 *
 * @author Pavle
 */
public abstract class JspFopFilter implements Filter {
    
    private FopFactory fopFactory;
    private Transformer transformer;
    
    private static final Logger LOGGER;
    
    public static final String DEFAULT_FOP_CONFIG_PATH_PARAM;
    
    static {
        LOGGER = Logger.getLogger(JspFopFilter.class.getSimpleName());
        DEFAULT_FOP_CONFIG_PATH_PARAM = "fop_config_path_param";
    }
    
    protected static void logInfo(String message) {
        LOGGER.log(Level.INFO, "{0} : {1}", new Object[]{LOGGER.getName(), message});
    }
    
    protected abstract FopFactory initFopFactory(FilterConfig config) throws ServletException;
    
    private void initTransformer() throws ServletException {
        try {
            this.transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException ex) {
            throw new ServletException(ex);
        }
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fopFactory = initFopFactory(filterConfig);
        initTransformer();
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PokusResponse pokusResponse = new PokusResponse((HttpServletResponse) response);
        chain.doFilter(request, pokusResponse);
        
        try {
            response.setContentType(MimeConstants.MIME_PDF);
        Fop fop = this.fopFactory.newFop(MimeConstants.MIME_PDF, response.getOutputStream());
        transformer.transform(new StreamSource(new StringReader(pokusResponse.stringWriter.toString())), new SAXResult(fop.getDefaultHandler()));
        }
        catch (FOPException | TransformerException e) {
            throw new ServletException(e);
        }
    }
    
    private static class PokusResponse extends HttpServletResponseWrapper {

        private PrintWriter writer;

        private StringWriter stringWriter;

        public PokusResponse(HttpServletResponse response) {
            super(response);
            stringWriter = new StringWriter();
            writer = new PrintWriter(stringWriter);
        }

        @Override
        public PrintWriter getWriter() {
            return writer;
        }

    }
    
    @Override
    public void destroy() {}
}
