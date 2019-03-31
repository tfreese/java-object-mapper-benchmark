/**
 * Created: 06.10.2018
 */

package de.freese.benchmark.mapping.mapper;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

/**
 * @author Thomas Freese
 */
@RunWith(JUnitPlatform.class)
@SuiteDisplayName("TestSuite for Binding")
// @SelectPackages("de.freese.benchmark.mapping.mapper")
@SelectClasses(
{
        DozerMapperTest.class,
        JMapperMapperTest.class,
        ManualMapperTest.class,
        MapStructMapperTest.class,
        ModelMapperTest.class,
        OrikaMapperTest.class,
        SelmaMapperTest.class
})
public class TestSuite
{
    /**
     * Erstellt ein neues {@link TestSuite} Object.
     */
    public TestSuite()
    {
        super();
    }
}
