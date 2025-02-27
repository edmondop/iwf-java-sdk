package io.iworkflow.integ.interstatechannel;

import io.iworkflow.core.Context;
import io.iworkflow.core.StateDecision;
import io.iworkflow.core.WorkflowState;
import io.iworkflow.core.command.CommandRequest;
import io.iworkflow.core.command.CommandResults;
import io.iworkflow.core.communication.Communication;
import io.iworkflow.core.communication.InternalChannelCommand;
import io.iworkflow.core.communication.InternalChannelCommandResult;
import io.iworkflow.core.persistence.Persistence;
import io.iworkflow.gen.models.ChannelRequestStatus;

public class BasicInterStateChannelWorkflowState1 implements WorkflowState<Integer> {
    public static final String COMMAND_ID = "test-cmd-id";
    
    @Override
    public Class<Integer> getInputType() {
        return Integer.class;
    }

    @Override
    public CommandRequest waitUntil(
            Context context,
            Integer input,
            Persistence persistence,
            final Communication communication) {
        return CommandRequest.forAnyCommandCompleted(
                InternalChannelCommand.create(COMMAND_ID, BasicInterStateChannelWorkflow.INTER_STATE_CHANNEL_NAME_1),
                InternalChannelCommand.create(COMMAND_ID, BasicInterStateChannelWorkflow.INTER_STATE_CHANNEL_NAME_2)
        );
    }

    @Override
    public StateDecision execute(
            Context context,
            Integer input,
            CommandResults commandResults,
            Persistence persistence,
            final Communication communication) {
        final InternalChannelCommandResult result1 = commandResults.getAllInternalChannelCommandResult().get(0);
        Integer output = input + (Integer) result1.getValue().get();

        final InternalChannelCommandResult result2 = commandResults.getAllInternalChannelCommandResult().get(1);
        if (result2.getRequestStatusEnum() != ChannelRequestStatus.WAITING) {
            throw new RuntimeException("the second command should be waiting");
        }
        return StateDecision.gracefulCompleteWorkflow(output);
    }
}
