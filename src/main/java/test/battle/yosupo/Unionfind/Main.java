package test.battle.yosupo.Unionfind;

import net.egork.chelper.tester.NewTester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
    @Test
    public void test() throws Exception {
        if (!NewTester.test("src/main/java/test/battle/yosupo/Unionfind/Unionfind.json"))
            Assert.fail();
    }
}
