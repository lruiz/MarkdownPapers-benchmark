/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tautua.markdownpapers.benchmarks;

import com.sun.japex.JapexDriverBase;
import com.sun.japex.TestCase;
import org.pegdown.PegDownProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.tautua.markdownpapers.benchmarks.Util.slurp;

public class PegdownDriver extends JapexDriverBase {
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
        PegDownProcessor parser = new PegDownProcessor();
        String output = parser.markdownToHtml(content);
    }
}
