package de.freese.benchmark;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import de.freese.benchmark.mapping.mapper.OrderMapper;
import de.freese.benchmark.mapping.mapper.dozer.DozerMapper;
import de.freese.benchmark.mapping.mapper.jmapper.JMapperMapper;
import de.freese.benchmark.mapping.mapper.manual.ManualMapper;
import de.freese.benchmark.mapping.mapper.mapstruct.MapStructMapper;
import de.freese.benchmark.mapping.mapper.modelmapper.ModelMapper;
import de.freese.benchmark.mapping.mapper.orika.OrikaMapper;
import de.freese.benchmark.mapping.model.OrderFactory;
import de.freese.benchmark.mapping.model.dto.OrderDTO;
import de.freese.benchmark.mapping.model.entity.Order;

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
@State(Scope.Benchmark)
// @OutputTimeUnit(TimeUnit.MILLISECONDS) // Nur für Mode.AverageTime
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
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
     * @param args String[]
     * @throws Exception Falls was schief geht.
     */
    public static void main(final String...args) throws Exception
    {
        // Bei Meldung 'No benchmarks to run' -> mvn clean compile

        // Der Builder überschreibt die Klassen-Annotationen.
        // @formatter:off
        Options options = new OptionsBuilder()
                .include(MapperBenchmark.class.getSimpleName())
                .mode(Mode.Throughput)
                //.mode(Mode.AverageTime).timeUnit(TimeUnit.MICROSECONDS)
                .warmupIterations(1).warmupTime(TimeValue.seconds(1))
                .measurementIterations(3).measurementTime(TimeValue.seconds(1))
                .forks(1) // Fork multipliziert die Anzahl der Iterationen
                .jvmArgs("-disablesystemassertions")
                .threads(1)
                .resultFormat(ResultFormatType.CSV)
                .result("results_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".csv")
                .build()
                ;
        // @formatter:on

        new Runner(options).run();

        // Collection<RunResult> results = new Runner(options).run();
        //
//        // @formatter:off
//        results.stream()
//            .map(RunResult::getPrimaryResult)
//            .sorted(Comparator.comparing(Result::getScore, Comparator.reverseOrder()))
//            .forEach(r -> System.out.printf("Benchmark score: %f %s over %d iterations%n", r.getScore(), r.getScoreUnit(), r.getStatistics().getN()));
//            ;
//        // @formatter:on
    }

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
            "Manual", "MapStruct", "JMapper", "Orika", "ModelMapper", "Dozer"
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
