package com.Temporal.OderManagement.OderManagementWorkFlow.WorkFlow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface TelecomOrderWorkflow {

    @WorkflowMethod
    void processOrder(String orderId);
}
