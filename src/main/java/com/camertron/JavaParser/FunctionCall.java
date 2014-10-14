package com.camertron.JavaParser;

import org.antlr.v4.runtime.tree.TerminalNodeImpl;

public class FunctionCall {
    private String m_sName;
    private Java8Parser.TypeNameContext m_tncTypeName;
    private Java8Parser.ArgumentListContext m_alArgList;

    public FunctionCall(String sName, Java8Parser.TypeNameContext tncTypeName, Java8Parser.ArgumentListContext alArgList) {
        m_sName = sName;
        m_tncTypeName = tncTypeName;
        m_alArgList = alArgList;
    }

    public String getName() {
        return m_sName;
    }

    public Java8Parser.TypeNameContext getTypeName() {
        return m_tncTypeName;
    }

    public Java8Parser.ArgumentListContext getArgumentList() {
        return m_alArgList;
    }
}
