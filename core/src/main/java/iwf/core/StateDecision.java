package iwf.core;

import org.immutables.value.Value;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static iwf.core.StateMovement.COMPLETING_WORKFLOW_MOVEMENT;
import static iwf.core.StateMovement.FAILING_WORKFLOW_MOVEMENT;

@Value.Immutable
public abstract class StateDecision {

    public abstract Optional<List<StateMovement>> getNextStates();

    public abstract Optional<Boolean> getWaitForMoreCommandResults();

    public static final StateDecision DEAD_END = ImmutableStateDecision.builder().build();
    public static final StateDecision COMPLETING_WORKFLOW = ImmutableStateDecision.builder().nextStates(Arrays.asList(COMPLETING_WORKFLOW_MOVEMENT)).build();
    public static final StateDecision FAILING_WORKFLOW = ImmutableStateDecision.builder().nextStates(Arrays.asList(FAILING_WORKFLOW_MOVEMENT)).build();

    public static final StateDecision WAIT_FOR_MORE_RESULTS = ImmutableStateDecision.builder().waitForMoreCommandResults(true).build();
}
