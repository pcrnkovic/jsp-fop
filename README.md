# jsp-fop 
## What is this?
The idea of jsp-fop is to provide a simple and fast reporting tool by combining JSP and XSL-FO (Apache FOP). This is JSP tag library designed in the sense that every jsp-fop tag/attribute corresponds to XSL-FO tag/attribute.
## Who is this for?
This is for Java developers who are developing in Servlet environment and are required to create reports.
## How to use it?
Include jsp-fop.jar in your Java web project and use `https://github.com/pcrnkovic/jsp-fop` namespace in your JSP document/page. 
The example of JSP document is as follows:
```
<?xml version="1.0" encoding="UTF-8"?>
<fo:root xmlns:fo="https://github.com/pcrnkovic/jsp-fop">

  <fo:layoutMasterSet>
    <fo:simplePageMaster masterName="pages">
      <fo:regionBody marginTop="20mm" marginBottom="3mm"/>
    </fo:simplePageMaster>
  </fo:layoutMasterSet>
  
  <fo:pageSequence masterReference="pages">
    <fo:flow flowName="xsl-region-body">
      <fo:block fontSize="20pt">Hello world!</fo:block>
    </fo:flow>
  </fo:pageSequence>
  
</fo:root>
```
The above JSP document will be transformed into valid XSL-FO document by Servlet container as follows:
```
<?xml version="1.0" encoding="UTF-8"?>
<root xmlns="http://www.w3.org/1999/XSL/Format">

  <layout-master-set>
    <simple-page-master master-name="pages">
      <region-body margin-top="20mm" margin-bottom="3mm"/>
    </simple-page-master>
  </layout-master-set>
  
  <page-sequence master-reference="pages">
    <flow flow-name="xsl-region-body">
      <block font-size="20pt">Hello world!</block>
    </flow>
  </page-sequence>
  
</root>
```
As you can see from the above, every jsp-fop tag/attribute (`xxxXxx`) transforms into corresponding XSL-FO tag/attribute (`xxx-xxx`).
## Attributes
Besides literal (and valid XSL-FO) values, jsp-fop tag attribute can also take runtime expressions (attributeName="${*expression*}"), which is the main reason why this library was created. In addition to standard *XSL-FO*-corresponding attributes, every tag can take `rendered` attribute which takes literal/rtexpression `boolean` value (default is `true`). The purpose of `rendered` attribute is to determine whether tag will be included in XSL-FO output or not. For instance the result of the following JSP document
```
<?xml version="1.0" encoding="UTF-8"?>
<fo:root xmlns:fo="https://github.com/pcrnkovic/jsp-fop">

  <fo:layoutMasterSet>
    <fo:simplePageMaster masterName="pages">
      <fo:regionBody/>
    </fo:simplePageMaster>
  </fo:layoutMasterSet>
  
  <fo:pageSequence masterReference="pages">
    <fo:flow flowName="xsl-region-body">
      <fo:block>You will see this.</fo:block>
      <fo:block rendered="false">You will not see this.</fo:block>
    </fo:flow>
  </fo:pageSequence>
  
</fo:root>
```
will be
```
<?xml version="1.0" encoding="UTF-8"?>
<root xmlns="http://www.w3.org/1999/XSL/Format">
  <layout-master-set>
    <simple-page-master master-name="pages">
      <region-body/>
    </simple-page-master>
  </layout-master-set>
  <page-sequence master-reference="pages">
    <flow flow-name="xsl-region-body">
      <block>You will see this.</block>
    </flow>
  </page-sequence>
</root>
```
## PDF filter
Most likely, the report which is served to the end-user should be in human-readable format like PDF. This is the point where you might find Servlet filter classes defined in `io.github.pcrnkovic.jspfop.filter` package useful. To properly configure this filter you must specify `fop_config_path_param` (`FopPdfFilter.FOP_CONFIG_PATH_PARAM`) initialisation parameter. The value of this parameter should be path to your [Apache FOP configuration file](https://xmlgraphics.apache.org/fop/2.2/configuration.html). For instance you have the following situation: path in your web app to your FOP configuration file is /WEB-INF/fop-config.xml and the path to the directory where you keep your JSP documents/pages you are using for reports is /reports/. The following filter configuration in your web.xml
```
<filter>
  <filter-name>fop</filter-name>
  <filter-class>pc.jsp.fop.filter.FopPdfFilter</filter-class>
  <init-param>
    <param-name>fop_config_path_param</param-name>
    <param-value>/WEB-INF/fop-config.xml</param-value>
  </init-param>
</filter>
    
<filter-mapping>
  <filter-name>fop</filter-name>
  <url-pattern>/reports/*</url-pattern>
</filter-mapping>
```
will take care that for every request to [*context_name*]/reports/[*jsp_file_name*] you get PDF response.
