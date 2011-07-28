package org.tautua.markdownpapers.benchmarks;

import com.sun.japex.JapexDriverBase;
import com.sun.japex.TestCase;

import java.io.*;

import static org.tautua.markdownpapers.benchmarks.Util.slurp;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 7/26/11
 * Time: 2:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class TxtmarkDriver extends JapexDriverBase {
    private String content;

    @Override
    public void prepare(TestCase testCase) {

        String fileName = testCase.getParam("input");
        File file = new File(fileName);
        try {
            content = slurp(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public final void warmup(TestCase testCase) {
        run(testCase);
    }

    @Override
    public final void run(TestCase testCase) {
        transform();
    }

    public void transform() {
        Reader reader = new StringReader(content);

        try {
            String output = com.github.rjeschke.txtmark.Processor.process(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
