package de.freese.benchmark;

import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.mapper.dozer.DozerMapper;
import de.freese.benchmark.mapping.mapper.jmapper.JMapperMapper;
import de.freese.benchmark.mapping.mapper.manual.ManualMapper;
import de.freese.benchmark.mapping.mapper.mapstruct.MapStructMapper;
import de.freese.benchmark.mapping.mapper.modelmapper.ModelMapper;
import de.freese.benchmark.mapping.mapper.orika.OrikaMapper;
import de.freese.benchmark.mapping.mapper.selma.SelmaMapper;
import de.freese.benchmark.mapping.model.OrderFactory;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.entity.Order;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Die Klassen-Annotations werden benutzt, wenn der Benchmark über 'org.openjdk.jmh.Main' aufgerufen wird.<br>
 * Console:<br>
 * - java -jar target/benchmarks.jar -h<br>
 * - java -jar target/benchmarks.jar -rf csv -rff results.csv<br>
 * - java -jar target/benchmarks.jar -bm thrpt -f 1 -wi 2 -w 2s -i 3 -r 2s -jvmArgs '-server -disablesystemassertions' -rf csv -rff results.csv<br>
 * - gnuplot benchmark.plt
 *
 * @author Thomas Freese
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 2, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1, jvmArgsAppend =
        {
                "-server", "-disablesystemassertions"
        })
@State(Scope.Benchmark)
public class MapperBenchmark
{
    /**
     *
     */
    @Param(
            {
                    "Manual", "MapStruct", "Selma", "JMapper", "Orika", "ModelMapper", "Dozer"
            })
    private String type = null;

    /**
     *
     */
    private OrderMapper mapper = null;

    /**
     *
     */
    private Order order = null;

    /**
     * Erstellt ein neues {@link MapperBenchmark} Object.
     */
    public MapperBenchmark()
    {
        super();
    }

    /**
     * @param args String[]
     *
     * @throws Exception Falls was schief geht.
     */
    public static void main(final String... args) throws Exception
    {
        // @formatter:off
        Options options = new OptionsBuilder()
                .include(MapperBenchmark.class.getSimpleName())
                .warmupIterations(2).warmupTime(TimeValue.seconds(2))
                .measurementIterations(3).measurementTime(TimeValue.seconds(2))
                .jvmArgs("-server", "-disablesystemassertions")
                .forks(1)
                .mode(Mode.Throughput)
                //.mode(Mode.AverageTime)
                .resultFormat(ResultFormatType.CSV)
                .result("results_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".csv")
                .build();
        // @formatter:on

        Collection<RunResult> results = new Runner(options).run();

        for (RunResult result : results)
        {
            Result<?> r = result.getPrimaryResult();
            System.out.printf("API replied benchmark score: %f %s over %d iterations%n", r.getScore(), r.getScoreUnit(), r.getStatistics().getN());
        }
    }

    /**
     * @return {@link OrderDTO}
     */
    @Benchmark
    public OrderDTO mapper()
    {
        return this.mapper.map(this.order);
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
            case "Selma":
                this.mapper = new SelmaMapper();
                break;
            case "JMapper":
                this.mapper = new JMapperMapper();
                break;
            case "Manual":
                this.mapper = new ManualMapper();
                break;
            default:
                throw new IllegalStateException("Unknown type: " + this.type);
        }
    }
}
