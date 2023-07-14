package br.com.bma.fluxosCobranca11.serviceImpl;

import org.springframework.stereotype.Service;

import br.com.bma.fluxosCobranca11.model.Task;
import br.com.bma.fluxosCobranca11.service.ITaskService;

@Service
public class TaskService implements ITaskService {

	@Override
	public Task sendTask(Task task){
		
		return task;
	}
}
