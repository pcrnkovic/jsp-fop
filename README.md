# jsp-fop 
## What is this?
The idea of jsp-fop is to provide a simple and fast reporting tool by combining JSP and XSL-FO (Apache FOP). This is JSP tag library designed in the sense that every jsp-fop tag/attribute corresponds to XSL-FO tag/attribute.
## Who is this for?
This is for Java developers who are developing in Servlet environment and are required to create reports.
## Minimum requirements
Java SE 7 or above.
## How to use it?
Add following dependency in your web application's `pom.xml` file:
```
<dependency>
	<groupId>io.github.pcrnkovic</groupId>
	<artifactId>jsp-fop</artifactId>
    <version>0.9</version>
</dependency>
```
Use `https://github.com/pcrnkovic/jsp-fop` namespace in your JSP document/page.  The example of JSP document is as follows:
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
### Runtime expressions
Besides literal (and valid XSL-FO) values, jsp-fop tag attribute can also take runtime expressions (`attributeName = "${rt_expression}"`), which is the main reason why this library was created. 
### `rendered`
In addition to standard *XSL-FO*-corresponding attributes, every tag can take `rendered` attribute which takes literal/rtexpression `boolean` value (default is `true`). The purpose of `rendered` attribute is to determine whether tag will be included in XSL-FO output or not. For instance the result of the following JSP document
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
### Iterable tags
According to W3C's recommendation of [XSL 1.1](https://www.w3.org/TR/2006/REC-xsl11-20061205/xsl11.pdf), some XSL-FO tags can have multiple child tag of an exact one type. JSP-FOP counterparts of these tags are:

 - `bookmarkTree`
 - `declarations`
 - `flowMap`
 - `flowSourceList`
 - `flowTargetList`
 - `listBlock`
 - `multiSwitch`
 - `repeatablePageMasterAlternatives`
 - `tableBody`
 - `tableFooter`
 - `tableHeader`
 - `tableRow`

For instance, `list-block` can have at least one child of a type `list-item`. Each of their JSP-FOP counterparts can take 3 additional attributes: `iterable`, `iterableVar` and `itemCountVar`.
#### `itemCountVar`
Sets the name of a variable which is used to store current number of children. It can be used for numbering children. For instance, the following segment
```
<fo:listBlock itemCountVar="c">
	<fo:listItem>
		<fo:listItemLabel>${c}</fo:listItemLabel>
		<fo:listItemBody>First item.</fo:listItemBody>
	</fo:listItem>
	<fo:listItem>
		<fo:listItemLabel>${c}</fo:listItemLabel>
		<fo:listItemBody>Second item.</fo:listItemBody>
	</fo:listItem>
	<fo:listItem>
		<fo:listItemLabel>${c}</fo:listItemLabel>
		<fo:listItemBody>Third item.</fo:listItemBody>
	</fo:listItem>
</fo:listBlock>
``` 
will be evaluated to:
```
<list-block>
	<list-item>
		<list-item-label>1</list-item-label>
		<list-item-body>First item.</list-item-body>
	</list-item>
	<list-item>
		<list-item-label>2</list-item-label>
		<list-item-body>Second item.</list-item-body>
	</list-item>
	<list-item>
		<list-item-label>3</list-item-label>
		<list-item-body>Third item.</list-item-body>
	</list-item>
</list-block>
```
#### `iterable` and `itemVar`
Iterable tag can work in 2 modes, *default* mode and *iterable* mode. The latter one can be activated by setting both `iterable` and `itemVar` attribute values. The `iterable` takes runtime expression value which must be evaluated to non-null object of a type `java.lang.Iterable`, while the value of `itemVar` is the name of the variable used to store current item reference. Iterable tag in *iterable* mode evaluates it's body for each element found by `Iterable`'s iterator. Let's assume you have list of person objects of a class like
```
public class Person {
	private final String name;
	private final int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
}
```
stored as a `javax.servlet.ServletRequest` attribute under name of *personList* and the entries (name (age)) in the list are Victor (20), Sandra (30) and Martin (40). The following segment
```
<fo:table>
	<fo:tableHeader>
		<fo:tableCell><fo:block>#</fo:block></fo:tableCell>
		<fo:tableCell><fo:block>Name</fo:block></fo:tableCell>
		<fo:tableCell><fo:block>Age</fo:block></fo:tableCell>
	</fo:tableHeader>
	<fo:tableBody iterable="${personList}" itemVar="p" itemCountVar="c">
		<fo:tableRow>
			<fo:tableCell><fo:block>${c}</fo:block></fo:tableCell>
			<fo:tableCell><fo:block>${p.name}</fo:block></fo:tableCell>
			<fo:tableCell><fo:block>${p.age}</fo:block></fo:tableCell>
		</fo:tableRow>
	</fo:tableBody>
</fo:table>
```
will be evaluated to
```
<table>
	<table-header>
		<table-cell><block>#</block></table-cell>
		<table-cell><block>Name</block></table-cell>
		<table-cell><block>Age</block></table-cell>
	</table-header>
	<table-body>
		<table-row>
			<table-cell><block>1</block></table-cell>
			<table-cell><block>Victor</block></table-cell>
			<table-cell><block>20</block></table-cell>
		</table-row>
		<table-row>
			<table-cell><block>2</block></table-cell>
			<table-cell><block>Sandra</block></table-cell>
			<table-cell><block>30</block></table-cell>
		</table-row>
		<table-row>
			<table-cell><block>3</block></table-cell>
			<table-cell><block>Martin</block></table-cell>
			<table-cell><block>40</block></table-cell>
		</table-row>
	</table-body>
</table>
```
## PDF filter
Most likely, the report which is served to the end-user should be in human-readable format like PDF. This is the point where you might find 2 servlet filter classes defined in `io.github.pcrnkovic.jspfop.filter` package useful. 
### Default PDF filter (`io.github.pcrnkovic.jspfop.filter.DefaultJspFopPdfFilter`)
The easiest way to use default pdf filter is to add content like this to your web application `web.xml` file:
```
<filter>
  <filter-name>fop</filter-name>
  <filter-class>io.github.pcrnkovic.jspfop.filter.DefaultJspFopPdfFilter</filter-class>
</filter>
    
<filter-mapping>
  <filter-name>fop</filter-name>
  <url-pattern>/pdf/*</url-pattern>
</filter-mapping>
```
If you want to override default [Apache FOP configuration file](https://xmlgraphics.apache.org/fop/2.5/configuration.html), use `fop_config_path_param` filter configuration parameter like this:
```
<filter>
  <filter-name>fop</filter-name>
  <filter-class>io.github.pcrnkovic.jspfop.filter.DefaultJspFopPdfFilter</filter-class>
  <init-param>
    <param-name>fop_config_path_param</param-name>
    <param-value>/WEB-CONTEXT-RELATIVE-PATH/TO/CONFIGURATION_XML</param-value>
  </init-param>
</filter>
```
### Custom PDF filter (`io.github.pcrnkovic.jspfop.filter.JspFopPdfFilter`)
To make your custom pdf filter, you can extend `JspFopPdfFilter` class from `io.github.pcrnkovic.jspfop.filter` package. This is an abstract class with one abstract method:
```
protected abstract org.apache.fop.apps.FopFactory 
	acquireFopFactory(javax.servlet.FilterConfig config) throws ServletException;
```
This method is invoked during filter initialization and should be implemented in a way it never returns `null`. If for some reason `FopFactory` cannot be acquired, method should throw `javax.servlet.ServletException`.
