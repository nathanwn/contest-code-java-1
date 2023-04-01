package test.battle.self.TestPermutations;

import net.egork.chelper.tester.NewTester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
    @Test
    public void test() throws Exception {
        if (!NewTester.test(
                "src/main/java/test/battle/self/TestPermutations/TestPermutations.json"))
            Assert.fail();
    }
}
