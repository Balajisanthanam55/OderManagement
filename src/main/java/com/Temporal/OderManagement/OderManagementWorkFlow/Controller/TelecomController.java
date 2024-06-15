package com.Temporal.OderManagement.OderManagementWorkFlow.Controller;


import com.Temporal.OderManagement.OderManagementWorkFlow.WorkFlow.TelecomOrderWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelecomController {

    @Autowired
    private WorkflowClient workflowClient;

    @GetMapping("/startOrder/{orderId}")
    public String startOrder(@PathVariable String orderId) {
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue("TELECOM_TASK_QUEUE")
                .build();
        TelecomOrderWorkflow workflow = workflowClient.newWorkflowStub(TelecomOrderWorkflow.class, options);
        WorkflowClient.start(workflow::processOrder, orderId);
        return "Order processing started for orderId: " + orderId;
    }
}
