package com.camertron.JavaParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Tester {
    public static void main(String[] args) {
        String str = "package controllers.account;\n\npublic class Reset extends Controller {\n    private static void sendFailedPasswordResetAttempt(String email) {\n        String subject = I18n.t(\"mail.reset.fail.subject\");\n        String message = I18n.t(\"mail.reset.fail.message\", email);\n\n        Mail.Envelop envelop = new Mail.Envelop(subject, message, email);\n        Mail.sendMail(envelop);\n    }\n}\n";
        CharStream in = new ANTLRInputStream(str);
        Java8Lexer lexer = new Java8Lexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java8Parser parser = new Java8Parser(tokens);

        FunctionCallVisitor fcVisitor = new FunctionCallVisitor(
            (FunctionCall fnCall) -> {
                System.out.println(fnCall.getName());
            }
        );

        fcVisitor.visit(parser.compilationUnit());
    }
}
