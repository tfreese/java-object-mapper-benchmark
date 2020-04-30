package de.freese.benchmark;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.mapper.dozer.DozerMapper;
import de.freese.benchmark.mapping.mapper.manual.ManualMapper;
import de.freese.benchmark.mapping.mapper.mapstruct.MapStructMapper;
import de.freese.benchmark.mapping.mapper.modelmapper.ModelMapper;
import de.freese.benchmark.mapping.mapper.orika.OrikaMapper;
import de.freese.benchmark.mapping.model.OrderFactory;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.entity.Order;

/**
 * Die Klassen-Annotations werden benutzt, wenn der Benchmark über 'org.openjdk.jmh.Main' aufgerufen wird.<br>
 *
 * @author Thomas Freese
 */
@BenchmarkMode(Mode.Throughput)
@State(Scope.Benchmark)
// @OutputTimeUnit(TimeUnit.MILLISECONDS) // Nur für Mode.AverageTime
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1, jvmArgsAppend =
{
        // Fork multipliziert die Anzahl der Iterationen
        "-disablesystemassertions"
})
@Threads(1)
public class MapperBenchmark
{
    /**
     *
     */
    private OrderMapper mapper = null;

    /**
     *
     */
    private Order order = null;

    /**
     *
     */
    @Param(
    {
            "Manual", "MapStruct", "Orika", "ModelMapper", "Dozer"
    })
    private String type = null;

    /**
     * Erstellt ein neues {@link MapperBenchmark} Object.
     */
    public MapperBenchmark()
    {
        super();
    }

    /**
     * @param blackhole B{@link Blackhole}
     */
    @Benchmark
    public void mapper(final Blackhole blackhole)
    {
        OrderDTO dto = this.mapper.map(this.order);

        blackhole.consume(dto);
    }

    /**
     *
     */
    @Setup(Level.Iteration)
    public void preInit()
    {
        this.order = OrderFactory.buildOrder();
    }

    /**
     *
     */
    @Setup(Level.Trial)
    public void setup()
    {
        switch (this.type)
        {
            case "Dozer":
                this.mapper = new DozerMapper();
                break;
            case "Orika":
                this.mapper = new OrikaMapper();
                break;
            case "ModelMapper":
                this.mapper = new ModelMapper();
                break;
            case "MapStruct":
                this.mapper = new MapStructMapper();
                break;
            case "Manual":
                this.mapper = new ManualMapper();
                break;
            default:
                throw new IllegalStateException("Unknown type: " + this.type);
        }
    }
}
