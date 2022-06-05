package leetcode.leetcode22xx.leetcode2296;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextEditorTest {
    @Test
    void test1() {
        TextEditor textEditor = new TextEditor();
        TextEditor2 textEditor2 = new TextEditor2();
        textEditor.addText("jxarid");
        textEditor2.addText("jxarid");

        assertEquals("j", textEditor.cursorLeft(5));
        assertEquals("j", textEditor2.cursorLeft(5));

        assertEquals("", textEditor.cursorLeft(10));
        assertEquals("", textEditor2.cursorLeft(10));

        textEditor.addText("du");
        textEditor2.addText("du");

        assertEquals(2, textEditor.deleteText(20));
        assertEquals(2, textEditor2.deleteText(20));

        assertEquals("jxarid", textEditor.cursorRight(10));
        assertEquals("jxarid", textEditor2.cursorRight(10));
    }
}