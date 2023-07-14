//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.07.11 às 05:32:40 PM BRT 
//


package br.com.bma.fluxosCobranca11.interfaces;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.bma.fluxoscobranca.interfaces package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.bma.fluxoscobranca.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TaskRequest }
     * 
     */
    public TaskRequest createTaskRequest() {
        return new TaskRequest();
    }

    /**
     * Create an instance of {@link SaveAndSendTask }
     * 
     */
    public SaveAndSendTask createSaveAndSendTask() {
        return new SaveAndSendTask();
    }

    /**
     * Create an instance of {@link TaskResponse }
     * 
     */
    public TaskResponse createTaskResponse() {
        return new TaskResponse();
    }

    /**
     * Create an instance of {@link ServiceStatus }
     * 
     */
    public ServiceStatus createServiceStatus() {
        return new ServiceStatus();
    }

}
