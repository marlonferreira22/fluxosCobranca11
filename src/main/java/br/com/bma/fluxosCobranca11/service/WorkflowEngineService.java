package br.com.bma.fluxosCobranca11.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import br.com.bma.fluxosCobranca11.ws.Exception_Exception;
import br.com.bma.fluxosCobranca11.ws.ProcessAttachmentDtoArray;
import br.com.bma.fluxosCobranca11.ws.ProcessTaskAppointmentDtoArray;
import br.com.bma.fluxosCobranca11.ws.StringArrays;
import br.com.bma.fluxosCobranca11.ws.StringArrayArray;

@WebService(name = "WorkflowEngineService", targetNamespace = "http://ws.workflow.ecm.technology.totvs.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
	br.com.bma.fluxosCobranca11.ws.ObjectFactory.class,
    net.java.dev.jaxb.array.ObjectFactory.class
})
public class WorkflowEngineService {

	@WebMethod(action = "saveAndSendTask")
    @WebResult(name = "result", partName = "result")
    public StringArrayArray saveAndSendTask(
        @WebParam(name = "username", partName = "username")
        String username,
        @WebParam(name = "password", partName = "password")
        String password,
        @WebParam(name = "companyId", partName = "companyId")
        int companyId,
        @WebParam(name = "processInstanceId", partName = "processInstanceId")
        int processInstanceId,
        @WebParam(name = "choosedState", partName = "choosedState")
        int choosedState,
        @WebParam(name = "colleagueIds", partName = "colleagueIds")
        StringArrays colleagueIds,
        @WebParam(name = "comments", partName = "comments")
        String comments,
        @WebParam(name = "userId", partName = "userId")
        String userId,
        @WebParam(name = "completeTask", partName = "completeTask")
        boolean completeTask,
        @WebParam(name = "attachments", partName = "attachments")
        ProcessAttachmentDtoArray attachments,
        @WebParam(name = "cardData", partName = "cardData")
        StringArrayArray cardData,
        @WebParam(name = "appointment", partName = "appointment")
        ProcessTaskAppointmentDtoArray appointment,
        @WebParam(name = "managerMode", partName = "managerMode")
        boolean managerMode,
        @WebParam(name = "threadSequence", partName = "threadSequence")
        int threadSequence)
        throws Exception_Exception {
		return null;
	}
}
