package burov.statics.resolve;

import org.junit.Assert;
import org.junit.Test;

public class ChildTest {

    @Test
    public void testGetInfo() throws Exception {
        Child c = new Child();
        Assert.assertEquals(c.var, Child.var);
        Assert.assertEquals(((Base)c).var, Base.baseVar);
    }
}