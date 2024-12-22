import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.TreeViewer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        // قراءة الإدخال من ملف Lisp
        String input = readFile("C:/Users/Admin/Desktop//New folder (3)/src/main/java/Lisp.lisp");  // تأكد من أن المسار صحيح للملف

        // إنشاء lexer (المحلل اللغوي)
        MyGrammarLexer lexer = new MyGrammarLexer(CharStreams.fromString(input));

        // تحويل الرموز إلى تدفق مشترك من الرموز (Token Stream)
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // إنشاء parser (المحلل النحوي)
        MyGrammarParser parser = new MyGrammarParser(tokens);

        // استدعاء القاعدة الرئيسية (مثال: prog) للحصول على شجرة التحليل (ParseTree)
        ParseTree tree = parser.program();  // استدعاء القاعدة المعرّفة

        // طباعة شجرة التحليل
        System.out.println("Parsed tree: " + tree.toStringTree(parser));


        System.out.println("Tokens: " + tokens.getTokens());

        //
        TreeViewer viewer = new TreeViewer(null, tree);
        viewer.open();
    }

    // دالة لقراءة محتوى الملف إلى String
    private static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}