package com.camertron.JavaParser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

public class FunctionCallVisitor extends Java8BaseVisitor<Void> {
    public interface FunctionCallNotifier {
        void notify(FunctionCall fnCall);
    }

    private FunctionCallNotifier m_fcNotifier;

    public FunctionCallVisitor(FunctionCallNotifier notifier) {
        m_fcNotifier = notifier;
    }

    @Override public Void visitMethodInvocation(@NotNull Java8Parser.MethodInvocationContext ctx) {
        FunctionCall fnCall = new FunctionCall(getIdentifier(ctx.Identifier()), ctx.typeName(), ctx.argumentList());
        m_fcNotifier.notify(fnCall);

        visitChildren(ctx);
        return null;
    }

    @Override public Void visitMethodInvocation_lf_primary(@NotNull Java8Parser.MethodInvocation_lf_primaryContext ctx) {
        FunctionCall fnCall = new FunctionCall(getIdentifier(ctx.Identifier()), null, ctx.argumentList());
        m_fcNotifier.notify(fnCall);

        visitChildren(ctx);
        return null;
    }

    @Override public Void visitMethodInvocation_lfno_primary(@NotNull Java8Parser.MethodInvocation_lfno_primaryContext ctx) {
        FunctionCall fnCall = new FunctionCall(getIdentifier(ctx.Identifier()), ctx.typeName(), ctx.argumentList());
        m_fcNotifier.notify(fnCall);

        visitChildren(ctx);
        return null;
    }

    private String getIdentifier(TerminalNode tnIdentifierNode) {
        if (tnIdentifierNode != null)
            return tnIdentifierNode.getText();
        else
            return null;
    }
}
