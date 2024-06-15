package com.Temporal.OderManagement.OderManagementWorkFlow.WorkFlow;

import com.Temporal.OderManagement.OderManagementWorkFlow.WorkFlow.WorkFlowActivity.TelecomOrderActivities;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TelecomOrderWorkflowImpl implements TelecomOrderWorkflow {

    private static final Logger logger = LoggerFactory.getLogger(TelecomOrderWorkflowImpl.class);

    private final TelecomOrderActivities activities =  Workflow.newActivityStub(TelecomOrderActivities.class, ActivityOptions.newBuilder()
            .setScheduleToCloseTimeout(Duration.ofMinutes(5)) // Example ScheduleToCloseTimeout
            .build());


    @Override
    public void processOrder(String orderId) {
        logger.info("Processing order: {}", orderId);
        activities.validateOrder(orderId);
        activities.provisionOrder(orderId);
        activities.completeOrder(orderId);
        logger.info("Order processed: {}", orderId);
    }
}
