package com.Temporal.OderManagement.OderManagementWorkFlow.WorkFlow.OderManagementWorker;


import com.Temporal.OderManagement.OderManagementWorkFlow.WorkFlow.TelecomOrderWorkflowImpl;
import com.Temporal.OderManagement.OderManagementWorkFlow.WorkFlow.WorkFlowActivity.TelecomOrderActivitiesImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.worker.WorkerFactory;
import io.temporal.worker.WorkerFactoryOptions;
import io.temporal.worker.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelecomWorker {

    @Autowired
    private WorkflowClient workflowClient;

    @Bean
    public WorkerFactory workerFactory() {
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient, WorkerFactoryOptions.getDefaultInstance());
        Worker worker = factory.newWorker("TELECOM_TASK_QUEUE");
        worker.registerWorkflowImplementationTypes(TelecomOrderWorkflowImpl.class);
        worker.registerActivitiesImplementations(new TelecomOrderActivitiesImpl());
        factory.start();
        return factory;
    }
}
