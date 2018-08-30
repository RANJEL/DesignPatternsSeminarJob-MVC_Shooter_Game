package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.concreteCommands.IncreaseForceCommand;
import cz.fit.dpo.mvcshooter.designPatterns.model.mementoPattern.Memento;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;

/**
 * Tests for interface {@link Model}
 */
@RunWith(EasyMockRunner.class)
public class ModelMockTest extends EasyMockSupport {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private ModelImpl model;

    @Mock
    private Memento memento;

    @Test
    public void increaseForce() {
        expect(model.createMemento()).andReturn(memento);
        model.increaseForce();
        expectLastCall().times(1);
        replayAll();
        IncreaseForceCommand increaseForceCommand = new IncreaseForceCommand(model);
        increaseForceCommand.execute();
        verifyAll();
    }

}
