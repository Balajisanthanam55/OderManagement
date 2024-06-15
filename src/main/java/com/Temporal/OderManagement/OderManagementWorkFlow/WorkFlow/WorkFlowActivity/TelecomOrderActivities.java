package com.Temporal.OderManagement.OderManagementWorkFlow.WorkFlow.WorkFlowActivity;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface TelecomOrderActivities {

    @ActivityMethod
    void validateOrder(String orderId);

    @ActivityMethod
    void provisionOrder(String orderId);

    @ActivityMethod
    void completeOrder(String orderId);
}
