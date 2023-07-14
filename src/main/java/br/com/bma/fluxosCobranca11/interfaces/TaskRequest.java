//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.07.11 às 05:32:40 PM BRT 
//


package br.com.bma.fluxosCobranca11.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="taskInfo" type="{http://interfaces.fluxosCobranca.bma.com.br}saveAndSendTask"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "taskInfo"
})
@XmlRootElement(name = "taskRequest")
public class TaskRequest {

    @XmlElement(required = true)
    protected SaveAndSendTask taskInfo;

    /**
     * Obtém o valor da propriedade taskInfo.
     * 
     * @return
     *     possible object is
     *     {@link SaveAndSendTask }
     *     
     */
    public SaveAndSendTask getTaskInfo() {
        return taskInfo;
    }

    /**
     * Define o valor da propriedade taskInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveAndSendTask }
     *     
     */
    public void setTaskInfo(SaveAndSendTask value) {
        this.taskInfo = value;
    }

}
