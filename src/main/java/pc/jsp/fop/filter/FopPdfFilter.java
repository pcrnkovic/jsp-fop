/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.jsp.fop.filter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
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
import org.xml.sax.SAXException;

/**
 *
 * @author Pavle Crnković
 */
public class FopPdfFilter implements Filter {

    private FopFactory fopFactory;

    private Transformer transformer;

    public static final String FOP_CONFIG_PATH_PARAM = "fop_config_path_param";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            String fopConfig = filterConfig.getInitParameter(FOP_CONFIG_PATH_PARAM);
            transformer = TransformerFactory.newInstance().newTransformer();
            fopFactory = FopFactory.newInstance(new File(filterConfig.getServletContext().getResource(fopConfig).toURI()));
        } catch (URISyntaxException | TransformerConfigurationException | SAXException | IOException ex) {
            throw new ServletException(filterConfig.getFilterName() + " cannot be initialized!", ex);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        FopResponseWrapper responseWrapper = new FopResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, (ServletResponse) responseWrapper);

        response.setContentType(MimeConstants.MIME_PDF);
        response.setCharacterEncoding("UTF-8");

        Fop fop = null;
        try {
            fop = fopFactory.newFop(MimeConstants.MIME_PDF, response.getOutputStream());
        } catch (FOPException ex) {
            throw new ServletException("Fop cannot be initialised!", ex);
        }

        try {
            transformer.transform(new StreamSource(new StringReader(responseWrapper.sw.toString())), new SAXResult(fop.getDefaultHandler()));
        } catch (TransformerException | FOPException ex) {
            throw new ServletException("Transformation failed!", ex);
        }

    }

    @Override
    public void destroy() {

    }

    private static class FopResponseWrapper extends HttpServletResponseWrapper {

        private PrintWriter pw;

        private StringWriter sw;

        public FopResponseWrapper(HttpServletResponse response) {
            super(response);
            sw = new StringWriter();
            pw = new PrintWriter(sw);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return pw;
        }

    }
}
