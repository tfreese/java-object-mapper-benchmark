/**
 * Created: 06.10.2018
 */

package de.freese.benchmark.mapping.mapper;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Thomas Freese
 */
@RunWith(Suite.class)
@SuiteClasses(
{
    // @formatter:off
    DozerMapperTest.class,
    JMapperMapperTest.class,
    ManualMapperTest.class,
    MapStructMapperTest.class,
    ModelMapperTest.class,
    OrikaMapperTest.class,
    SelmaMapperTest.class
    // @formatter:off
})
@Ignore
public class AllTests
{
    /**
     * Erstellt ein neues {@link AllTests} Object.
     *
     */
    public AllTests()
    {
        super();
    }
}
