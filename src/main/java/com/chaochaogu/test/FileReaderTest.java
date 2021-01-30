package com.chaochaogu.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import java.io.*;

/**
 * Junit 测试框架
 *
 * <p>
 * test-suite 测试套件：包含多个测试用例
 * test-case 测试用例
 * test-fixture 测试装备：用于测试的对象样本
 * </p>
 *
 * @author chaochao gu
 * @date 2021/1/30
 */
public class FileReaderTest extends TestCase {

    public static void main(String[] args) {
//        TestRunner.run(suite());
        // 运行指定类下所有以test开头的测试方法
        TestRunner.run(new TestSuite(FileReaderTest.class));
    }

    private InputStreamReader input, empty;

    public FileReaderTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() {
        try {
            input = new FileReader("Refactoring-Improving-the-Design-of-Existing-Code/data.txt");
            empty = newEmptyFile();
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Override
    protected void tearDown() {
        try {
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("error on closing test file");
        }
    }

    public void testRead() throws IOException {
        char ch = '&';
        for (int i = 0; i < 4; i++) {
            ch = (char) input.read();
        }
        assertEquals('m', ch);
    }

    public void testReadAtEnd() throws IOException {
        int ch = -1234;
        for (int i = 0; i < 141; i++) {
            ch = input.read();
        }
        assertEquals(-1, ch);
    }

    public void testReadBoundaries() throws IOException {
        assertEquals("read first char", 'B', input.read());
        int ch;
        for (int i = 1; i < 140; i++) {
            ch = input.read();
        }
        assertEquals("read last char", '6', input.read());
        assertEquals("read at end", -1, input.read());
        assertEquals("read past end", -1, input.read());
    }

    public void testEmptyRead() throws IOException {
        assertEquals(-1, empty.read());
    }

    public void testReadAfterClose() throws IOException {
        input.close();
        try {
            input.read();
            fail("no exception for read past end");
        } catch (IOException io) {
        }
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new FileReaderTest("testRead"));
        suite.addTest(new FileReaderTest("testReadAtEnd"));
        return suite;
    }

    private FileReader newEmptyFile() throws IOException {
        File empty = new File("empty.txt");
        FileOutputStream out = new FileOutputStream(empty);
        out.close();
        return new FileReader(empty);
    }
}
