/* Lexer.java */
/* Generated By:JavaCC: Do not edit this line. Lexer.java */
package com.hugovs.jps;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.io.*;
import com.hugovs.jps.structure.semanthic.*;
import com.hugovs.jps.structure.exception.*;

public class Lexer implements LexerConstants {

    public static Block program = new Block();
    public static int blockCount = 0;
    public static Stack<Block> stack = new Stack<Block>();

    public static void main(String[] args) {
        try {
            new Lexer(new java.io.FileInputStream(args[0])).S();
            System.out.println("Syntax is okay");
        } catch (Throwable e) {
            // Catching Throwable is ugly but JavaCC throws Error objects!
            System.out.println("Syntax check failed: " + e.getMessage());
        }
    }

// Regra inicial
  static final public void S() throws ParseException {
    PROGRAM();
    jj_consume_token(0);
  }

// Regra do programa
  static final public void PROGRAM() throws ParseException {Block program = Lexer.program;
        Block block = null;
    block = ROOT_BLOCK();
program = block;
  }

// Regra de Sub-Programa
  static final public Subprogram SUB_PROGRAM() throws ParseException {Subprogram subprogram = new Subprogram();
        Block block, parent = Lexer.stack.peek();
        Token typeToken = null, idToken = null;
        List<Variable> parameters = new ArrayList<Variable>();
    jj_consume_token(DEF);
    idToken = jj_consume_token(ID);
    jj_consume_token(LPAREN);
    if (jj_2_1(8)) {
      parameters = PARAMETERS();
    } else {
      ;
    }
    jj_consume_token(RPAREN);
    if (jj_2_2(8)) {
      jj_consume_token(COLON);
      typeToken = jj_consume_token(TYPE);
    } else {
      ;
    }
    block = BLOCK();
String id = idToken.toString();
        Type returnType = typeToken == null ? Type.VOID : Type.valueOf(typeToken.toString().toUpperCase());

        block.setParent(parent);
        subprogram.setId(id);
        subprogram.setReturnType(returnType);
        subprogram.setBlock(block);
        subprogram.setParameters(parameters);
        block.getParent().addIdentifier(subprogram);

        {if ("" != null) return subprogram;}
    throw new Error("Missing return statement in function");
  }

// Bloco inicial do programa
  static final public Block ROOT_BLOCK() throws ParseException {Block block = new Block();
        Lexer.stack.push(block);
        List<Variable> varList = null;
    if (jj_2_3(8)) {
      varList = VAR_SECTION();
    } else {
      ;
    }
    if (jj_2_4(8)) {
      EXPRESSION();
    } else {
      ;
    }
if (varList != null) {
            block.addAll(varList);
        }

        System.out.println("Identifiers found in block " + Lexer.blockCount + ": ");
        for (Identifier i : block.getIdentifiers().values())
            System.out.println("  " + i.toString());

        Lexer.stack.pop();
        {if ("" != null) return block;}
    throw new Error("Missing return statement in function");
  }

// Blocos internos no programa
  static final public Block BLOCK() throws ParseException {Lexer.blockCount++;
        Block block = new Block();
        Lexer.stack.push(block);
        List<Variable> varList = null;
    jj_consume_token(LBRACE);
    if (jj_2_5(8)) {
      varList = VAR_SECTION();
    } else {
      ;
    }
    if (jj_2_6(8)) {
      EXPRESSION();
    } else {
      ;
    }
    jj_consume_token(RBRACE);
if (varList != null)
            block.addAll(varList);

        Lexer.stack.pop();
        {if ("" != null) return block;}
    throw new Error("Missing return statement in function");
  }

//void SUB_PROGRAM_CALL(): {} { }
  static final public 
void EXPRESSION() throws ParseException {Subprogram sub;
    sub = SUB_PROGRAM();
    jj_consume_token(SEMICOLON);
    if (jj_2_7(8)) {
      EXPRESSION();
    } else {
      ;
    }

  }

// Command syntax
  static final public void CMD() throws ParseException {
    if (jj_2_8(8)) {
      CMD_IF();
    } else if (jj_2_9(8)) {
      CMD_FOR();
    } else if (jj_2_10(8)) {
      CMD_WHILE();
    } else if (jj_2_11(8)) {
      CMD_READ();
    } else if (jj_2_12(8)) {
      CMD_WRITE();
    } else if (jj_2_13(8)) {
      CMD_STOP();
    } else if (jj_2_14(8)) {
      CMD_SKIP();
    } else if (jj_2_15(8)) {
      CMD_RETURN();
    } else if (jj_2_16(8)) {
      CMD_SUB();
    } else if (jj_2_17(8)) {
      CMD_RETURN();
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void CMD_IF() throws ParseException {
    jj_consume_token(CMD_IF);
    jj_consume_token(LPAREN);
    EXP();
    jj_consume_token(RPAREN);
    BLOCK();
    if (jj_2_18(8)) {
      CMD_ELSE();
    } else {
      ;
    }
  }

  static final public void CMD_ELSE() throws ParseException {
    jj_consume_token(CMD_ELSE);
    if (jj_2_19(8)) {
      CMD_IF();
    } else if (jj_2_20(8)) {
      BLOCK();
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void CMD_FOR() throws ParseException {
    jj_consume_token(CMD_FOR);
    jj_consume_token(LPAREN);
    VAR();
    jj_consume_token(SEMICOLON);
    EXP();
    jj_consume_token(SEMICOLON);
    VAR_LIST();
  }

  static final public void CMD_WHILE() throws ParseException {
    jj_consume_token(CMD_WHILE);
    jj_consume_token(LPAREN);
    EXP();
    jj_consume_token(RPAREN);
  }

  static final public void CMD_READ() throws ParseException {
    jj_consume_token(CMD_READ);
    jj_consume_token(ID);
  }

  static final public void CMD_WRITE() throws ParseException {
    jj_consume_token(CMD_WRITE);
    EXP();
  }

  static final public void CMD_STOP() throws ParseException {
    jj_consume_token(CMD_STOP);
  }

  static final public void CMD_SKIP() throws ParseException {
    jj_consume_token(CMD_SKIP);
  }

  static final public void CMD_RETURN() throws ParseException {
    jj_consume_token(CMD_RETURN);
    EXP();
  }

  static final public void CMD_SUB() throws ParseException {
    jj_consume_token(ID);
    jj_consume_token(LPAREN);
    if (jj_2_22(8)) {
      EXP();
      label_1:
      while (true) {
        if (jj_2_21(8)) {
          ;
        } else {
          break label_1;
        }
        jj_consume_token(SEMICOLON);
        EXP();
      }
    } else {
      ;
    }
    jj_consume_token(RPAREN);
  }

  static final public void EXP() throws ParseException {
    VALUE();
    label_2:
    while (true) {
      if (jj_2_23(8)) {
        ;
      } else {
        break label_2;
      }
      if (jj_2_24(8)) {
        jj_consume_token(OP);
      } else if (jj_2_25(8)) {
        jj_consume_token(BOP);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
      VALUE();
    }
  }

// Regra base para declaração de umaou mais variáveis
  static final public List<Variable> VAR() throws ParseException {List<Variable> varList;
        Token typeToken;
    jj_consume_token(VAR);
    varList = VAR_LIST();
    jj_consume_token(COLON);
    typeToken = jj_consume_token(TYPE);
Type type = Type.valueOf(typeToken.toString().toUpperCase());
        Util.updateVariableTypes(varList, type);

        {if ("" != null) return varList;}
    throw new Error("Missing return statement in function");
  }

// Lista de variáveis
  static final public List<Variable> VAR_LIST() throws ParseException {List<Variable> varList = new ArrayList<Variable>(), ret = new ArrayList<Variable>();
        Variable var = new Variable();
        Token idToken, lengthToken = null;
        boolean isArray = false;
    if (jj_2_29(8)) {
      idToken = jj_consume_token(ID);
      jj_consume_token(LBRACK);
      if (jj_2_26(8)) {
        lengthToken = jj_consume_token(NUM);
      } else {
        ;
      }
      jj_consume_token(RBRACK);
      if (jj_2_27(8)) {
        jj_consume_token(COMMA);
        ret = VAR_LIST();
      } else {
        ;
      }
isArray = true;
    } else if (jj_2_30(8)) {
      idToken = jj_consume_token(ID);
      if (jj_2_28(8)) {
        jj_consume_token(COMMA);
        ret = VAR_LIST();
      } else {
        ;
      }
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
String id = idToken.toString();

        if (lengthToken != null) {
            var.setLength(Integer.valueOf(lengthToken.toString()));
        }

        var.setId(id);
        var.setArray(isArray);
        varList.addAll(ret);
        varList.add(var);
        {if ("" != null) return varList;}
    throw new Error("Missing return statement in function");
  }

// Seção de variáveis separadas por ponto e vírgula
  static final public List<Variable> VAR_SECTION() throws ParseException {List<Variable> varList = null, ret = null;
    varList = VAR();
    jj_consume_token(SEMICOLON);
    if (jj_2_31(8)) {
      ret = VAR_SECTION();
    } else {
      ;
    }
if (ret != null)
            varList.addAll(ret);
        {if ("" != null) return varList;}
    throw new Error("Missing return statement in function");
  }

// Regra de definição de parâmetros de sub-programa
  static final public List<Variable> PARAMETERS() throws ParseException {List<Variable> varList, v2 = null;
            Token typeToken;
    varList = PARAM_LIST();
    jj_consume_token(COLON);
    typeToken = jj_consume_token(TYPE);
    if (jj_2_32(8)) {
      jj_consume_token(SEMICOLON);
      v2 = PARAMETERS();
    } else {
      ;
    }
Type type = Type.valueOf(typeToken.toString().toUpperCase());
            Util.updateVariableTypes(varList, type);

            if (v2 != null)
                varList.addAll(v2);

            {if ("" != null) return varList;}
    throw new Error("Missing return statement in function");
  }

  static final public List<Variable> PARAM_LIST() throws ParseException {List<Variable> varList = new ArrayList<Variable>(), ret = new ArrayList<Variable>();
        Variable var = new Variable();
        Token idToken;
        boolean isArray = false;
    if (jj_2_35(8)) {
      idToken = jj_consume_token(ID);
      jj_consume_token(LBRACK);
      jj_consume_token(RBRACK);
      if (jj_2_33(8)) {
        jj_consume_token(COMMA);
        ret = PARAM_LIST();
      } else {
        ;
      }
isArray = true;
    } else if (jj_2_36(8)) {
      idToken = jj_consume_token(ID);
      if (jj_2_34(8)) {
        jj_consume_token(COMMA);
        ret = PARAM_LIST();
      } else {
        ;
      }
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
String id = idToken.toString();

        var.setId(id);
        var.setArray(isArray);
        varList.addAll(ret);
        varList.add(var);
        {if ("" != null) return varList;}
    throw new Error("Missing return statement in function");
  }

  static final public void VALUE() throws ParseException {
    if (jj_2_37(8)) {
      CMD_SUB();
    } else if (jj_2_38(8)) {
      jj_consume_token(NUM);
    } else if (jj_2_39(8)) {
      jj_consume_token(ID);
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_2_5(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  static private boolean jj_2_6(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  static private boolean jj_2_7(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  static private boolean jj_2_8(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  static private boolean jj_2_9(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  static private boolean jj_2_10(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  static private boolean jj_2_11(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_11(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(10, xla); }
  }

  static private boolean jj_2_12(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_12(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(11, xla); }
  }

  static private boolean jj_2_13(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_13(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(12, xla); }
  }

  static private boolean jj_2_14(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_14(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(13, xla); }
  }

  static private boolean jj_2_15(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_15(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(14, xla); }
  }

  static private boolean jj_2_16(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_16(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(15, xla); }
  }

  static private boolean jj_2_17(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_17(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(16, xla); }
  }

  static private boolean jj_2_18(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_18(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(17, xla); }
  }

  static private boolean jj_2_19(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_19(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(18, xla); }
  }

  static private boolean jj_2_20(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_20(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(19, xla); }
  }

  static private boolean jj_2_21(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_21(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(20, xla); }
  }

  static private boolean jj_2_22(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_22(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(21, xla); }
  }

  static private boolean jj_2_23(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_23(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(22, xla); }
  }

  static private boolean jj_2_24(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_24(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(23, xla); }
  }

  static private boolean jj_2_25(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_25(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(24, xla); }
  }

  static private boolean jj_2_26(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_26(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(25, xla); }
  }

  static private boolean jj_2_27(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_27(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(26, xla); }
  }

  static private boolean jj_2_28(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_28(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(27, xla); }
  }

  static private boolean jj_2_29(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_29(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(28, xla); }
  }

  static private boolean jj_2_30(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_30(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(29, xla); }
  }

  static private boolean jj_2_31(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_31(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(30, xla); }
  }

  static private boolean jj_2_32(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_32(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(31, xla); }
  }

  static private boolean jj_2_33(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_33(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(32, xla); }
  }

  static private boolean jj_2_34(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_34(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(33, xla); }
  }

  static private boolean jj_2_35(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_35(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(34, xla); }
  }

  static private boolean jj_2_36(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_36(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(35, xla); }
  }

  static private boolean jj_2_37(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_37(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(36, xla); }
  }

  static private boolean jj_2_38(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_38(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(37, xla); }
  }

  static private boolean jj_2_39(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_39(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(38, xla); }
  }

  static private boolean jj_3_2()
 {
    if (jj_scan_token(COLON)) return true;
    if (jj_scan_token(TYPE)) return true;
    return false;
  }

  static private boolean jj_3_27()
 {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_17()) return true;
    return false;
  }

  static private boolean jj_3_14()
 {
    if (jj_scan_token(29)) return true;
    return false;
  }

  static private boolean jj_3_36()
 {
    if (jj_scan_token(ID)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_34()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3_35()
 {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(LBRACK)) return true;
    if (jj_scan_token(RBRACK)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_33()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3_31()
 {
    if (jj_3R_4()) return true;
    return false;
  }

  static private boolean jj_3R_18()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_35()) {
    jj_scanpos = xsp;
    if (jj_3_36()) return true;
    }
    return false;
  }

  static private boolean jj_3R_5()
 {
    if (jj_3R_20()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_7()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3_5()
 {
    if (jj_3R_4()) return true;
    return false;
  }

  static private boolean jj_3_13()
 {
    if (jj_scan_token(28)) return true;
    return false;
  }

  static private boolean jj_3_4()
 {
    if (jj_3R_5()) return true;
    return false;
  }

  static private boolean jj_3R_3()
 {
    if (jj_3R_18()) return true;
    if (jj_scan_token(COLON)) return true;
    if (jj_scan_token(TYPE)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_32()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3R_14()
 {
    if (jj_scan_token(LBRACE)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_5()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3_6()) jj_scanpos = xsp;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  static private boolean jj_3_12()
 {
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3_26()
 {
    if (jj_scan_token(NUM)) return true;
    return false;
  }

  static private boolean jj_3_18()
 {
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3_1()
 {
    if (jj_3R_3()) return true;
    return false;
  }

  static private boolean jj_3R_4()
 {
    if (jj_3R_19()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_31()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3_11()
 {
    if (jj_3R_9()) return true;
    return false;
  }

  static private boolean jj_3_28()
 {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_17()) return true;
    return false;
  }

  static private boolean jj_3_3()
 {
    if (jj_3R_4()) return true;
    return false;
  }

  static private boolean jj_3_21()
 {
    if (jj_scan_token(SEMICOLON)) return true;
    if (jj_3R_15()) return true;
    return false;
  }

  static private boolean jj_3_39()
 {
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3_25()
 {
    if (jj_scan_token(BOP)) return true;
    return false;
  }

  static private boolean jj_3_20()
 {
    if (jj_3R_14()) return true;
    return false;
  }

  static private boolean jj_3_22()
 {
    if (jj_3R_15()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_21()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_3_10()
 {
    if (jj_3R_8()) return true;
    return false;
  }

  static private boolean jj_3_38()
 {
    if (jj_scan_token(NUM)) return true;
    return false;
  }

  static private boolean jj_3_24()
 {
    if (jj_scan_token(OP)) return true;
    return false;
  }

  static private boolean jj_3_17()
 {
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3_23()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_24()) {
    jj_scanpos = xsp;
    if (jj_3_25()) return true;
    }
    if (jj_3R_16()) return true;
    return false;
  }

  static private boolean jj_3_30()
 {
    if (jj_scan_token(ID)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_28()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3_29()
 {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(LBRACK)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_26()) jj_scanpos = xsp;
    if (jj_scan_token(RBRACK)) return true;
    xsp = jj_scanpos;
    if (jj_3_27()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3R_17()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_29()) {
    jj_scanpos = xsp;
    if (jj_3_30()) return true;
    }
    return false;
  }

  static private boolean jj_3_32()
 {
    if (jj_scan_token(SEMICOLON)) return true;
    if (jj_3R_3()) return true;
    return false;
  }

  static private boolean jj_3_19()
 {
    if (jj_3R_6()) return true;
    return false;
  }

  static private boolean jj_3_33()
 {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_15()
 {
    if (jj_3R_16()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_23()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_3_9()
 {
    if (jj_3R_7()) return true;
    return false;
  }

  static private boolean jj_3R_16()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_37()) {
    jj_scanpos = xsp;
    if (jj_3_38()) {
    jj_scanpos = xsp;
    if (jj_3_39()) return true;
    }
    }
    return false;
  }

  static private boolean jj_3R_12()
 {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_22()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  static private boolean jj_3_37()
 {
    if (jj_3R_12()) return true;
    return false;
  }

  static private boolean jj_3_7()
 {
    if (jj_3R_5()) return true;
    return false;
  }

  static private boolean jj_3_16()
 {
    if (jj_3R_12()) return true;
    return false;
  }

  static private boolean jj_3R_11()
 {
    if (jj_scan_token(CMD_RETURN)) return true;
    if (jj_3R_15()) return true;
    return false;
  }

  static private boolean jj_3R_20()
 {
    if (jj_scan_token(DEF)) return true;
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_1()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    xsp = jj_scanpos;
    if (jj_3_2()) jj_scanpos = xsp;
    if (jj_3R_14()) return true;
    return false;
  }

  static private boolean jj_3R_10()
 {
    if (jj_scan_token(CMD_WRITE)) return true;
    if (jj_3R_15()) return true;
    return false;
  }

  static private boolean jj_3R_9()
 {
    if (jj_scan_token(CMD_READ)) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3R_8()
 {
    if (jj_scan_token(CMD_WHILE)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_15()) return true;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  static private boolean jj_3R_7()
 {
    if (jj_scan_token(CMD_FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_19()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    if (jj_3R_15()) return true;
    return false;
  }

  static private boolean jj_3R_13()
 {
    if (jj_scan_token(CMD_ELSE)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_19()) {
    jj_scanpos = xsp;
    if (jj_3_20()) return true;
    }
    return false;
  }

  static private boolean jj_3R_6()
 {
    if (jj_scan_token(CMD_IF)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_15()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_14()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_18()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3R_19()
 {
    if (jj_scan_token(VAR)) return true;
    if (jj_3R_17()) return true;
    if (jj_scan_token(COLON)) return true;
    if (jj_scan_token(TYPE)) return true;
    return false;
  }

  static private boolean jj_3_8()
 {
    if (jj_3R_6()) return true;
    return false;
  }

  static private boolean jj_3_6()
 {
    if (jj_3R_5()) return true;
    return false;
  }

  static private boolean jj_3_34()
 {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3_15()
 {
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public LexerTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[0];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[39];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Lexer(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Lexer(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LexerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Lexer(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LexerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Lexer(LexerTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(LexerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[35];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 0; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 35; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 39; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
            case 10: jj_3_11(); break;
            case 11: jj_3_12(); break;
            case 12: jj_3_13(); break;
            case 13: jj_3_14(); break;
            case 14: jj_3_15(); break;
            case 15: jj_3_16(); break;
            case 16: jj_3_17(); break;
            case 17: jj_3_18(); break;
            case 18: jj_3_19(); break;
            case 19: jj_3_20(); break;
            case 20: jj_3_21(); break;
            case 21: jj_3_22(); break;
            case 22: jj_3_23(); break;
            case 23: jj_3_24(); break;
            case 24: jj_3_25(); break;
            case 25: jj_3_26(); break;
            case 26: jj_3_27(); break;
            case 27: jj_3_28(); break;
            case 28: jj_3_29(); break;
            case 29: jj_3_30(); break;
            case 30: jj_3_31(); break;
            case 31: jj_3_32(); break;
            case 32: jj_3_33(); break;
            case 33: jj_3_34(); break;
            case 34: jj_3_35(); break;
            case 35: jj_3_36(); break;
            case 36: jj_3_37(); break;
            case 37: jj_3_38(); break;
            case 38: jj_3_39(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
