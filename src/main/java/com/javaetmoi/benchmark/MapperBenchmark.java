package com.javaetmoi.benchmark;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.mapper.dozer.DozerMapper;
import com.javaetmoi.benchmark.mapping.mapper.jmapper.JMapperMapper;
import com.javaetmoi.benchmark.mapping.mapper.manual.ManualMapper;
import com.javaetmoi.benchmark.mapping.mapper.mapstruct.MapStructMapper;
import com.javaetmoi.benchmark.mapping.mapper.modelmapper.ModelMapper;
import com.javaetmoi.benchmark.mapping.mapper.orika.OrikaMapper;
import com.javaetmoi.benchmark.mapping.mapper.selma.SelmaMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import com.javaetmoi.benchmark.mapping.model.entity.OrderFactory;

/**
 * @author Thomas Freese
 */
@State(Scope.Benchmark)
public class MapperBenchmark
{
    /**
     * @param args String[]
     * @throws Exception Falls was schief geht.
     */
    public static void main(final String...args) throws Exception
    {
        // @formatter:off
        Options opts = new OptionsBuilder()
                .include(MapperBenchmark.class.getSimpleName())
                .warmupIterations(1)
                .measurementIterations(1)
                .jvmArgs("-server")
                .forks(1)
//                .mode(Mode.AverageTime)
                //.resultFormat(ResultFormatType.TEXT)
                .resultFormat(ResultFormatType.CSV)
                .result("results_" + new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(new Date()) + ".csv")
                .build();
        // @formatter:on

        // java -jar target/benchmarks.jar -rff results.csv -rf csv

        Collection<RunResult> results = new Runner(opts).run();

        for (RunResult result : results)
        {
            Result<?> r = result.getPrimaryResult();
            System.out.println("API replied benchmark score: " + r.getScore() + " " + r.getScoreUnit() + " over " + r.getStatistics().getN() + " iterations");
        }
    }

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
