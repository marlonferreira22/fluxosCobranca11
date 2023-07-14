//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.07.11 às 05:32:40 PM BRT 
//


package br.com.bma.fluxosCobranca11.interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de saveAndSendTask complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="saveAndSendTask">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="companyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processInstanceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="choosedState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="colleagueIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="completeTask" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attachments" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="cardData" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="appointment" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="managerMode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="threadSequence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveAndSendTask", propOrder = {
    "username",
    "password",
    "companyId",
    "processInstanceId",
    "choosedState",
    "colleagueIds",
    "comments",
    "userId",
    "completeTask",
    "attachments",
    "cardData",
    "appointment",
    "managerMode",
    "threadSequence"
})
public class SaveAndSendTask {

    @XmlElement(required = true)
    protected String username;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected String companyId;
    @XmlElement(required = true)
    protected String processInstanceId;
    @XmlElement(required = true)
    protected String choosedState;
    @XmlElement(required = true)
    protected List<String> colleagueIds;
    @XmlElement(required = true)
    protected String comments;
    @XmlElement(required = true)
    protected String userId;
    @XmlElement(required = true)
    protected String completeTask;
    @XmlElement(required = true)
    protected List<String> attachments;
    @XmlElement(required = true)
    protected List<String> cardData;
    @XmlElement(required = true)
    protected List<String> appointment;
    @XmlElement(required = true)
    protected String managerMode;
    @XmlElement(required = true)
    protected String threadSequence;

    /**
     * Obtém o valor da propriedade username.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define o valor da propriedade username.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Obtém o valor da propriedade password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define o valor da propriedade password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Obtém o valor da propriedade companyId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * Define o valor da propriedade companyId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyId(String value) {
        this.companyId = value;
    }

    /**
     * Obtém o valor da propriedade processInstanceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    /**
     * Define o valor da propriedade processInstanceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessInstanceId(String value) {
        this.processInstanceId = value;
    }

    /**
     * Obtém o valor da propriedade choosedState.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoosedState() {
        return choosedState;
    }

    /**
     * Define o valor da propriedade choosedState.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoosedState(String value) {
        this.choosedState = value;
    }

    /**
     * Gets the value of the colleagueIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colleagueIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColleagueIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getColleagueIds() {
        if (colleagueIds == null) {
            colleagueIds = new ArrayList<String>();
        }
        return this.colleagueIds;
    }

    /**
     * Obtém o valor da propriedade comments.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Define o valor da propriedade comments.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Obtém o valor da propriedade userId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Define o valor da propriedade userId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Obtém o valor da propriedade completeTask.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompleteTask() {
        return completeTask;
    }

    /**
     * Define o valor da propriedade completeTask.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompleteTask(String value) {
        this.completeTask = value;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<String>();
        }
        return this.attachments;
    }

    /**
     * Gets the value of the cardData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCardData() {
        if (cardData == null) {
            cardData = new ArrayList<String>();
        }
        return this.cardData;
    }

    /**
     * Gets the value of the appointment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appointment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppointment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAppointment() {
        if (appointment == null) {
            appointment = new ArrayList<String>();
        }
        return this.appointment;
    }

    /**
     * Obtém o valor da propriedade managerMode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerMode() {
        return managerMode;
    }

    /**
     * Define o valor da propriedade managerMode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerMode(String value) {
        this.managerMode = value;
    }

    /**
     * Obtém o valor da propriedade threadSequence.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreadSequence() {
        return threadSequence;
    }

    /**
     * Define o valor da propriedade threadSequence.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreadSequence(String value) {
        this.threadSequence = value;
    }

}
