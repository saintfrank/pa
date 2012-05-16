// $ANTLR 3.4 /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g 2011-11-24 00:06:03

    package parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TheLangParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ASSIGN", "COLON", "DIV", "DO", "ELSE", "END", "EQ", "FALSE", "FI", "GE", "GT", "IDENTIFIER", "IF", "INT", "INTEGER", "LBRACE", "LBRACKET", "LE", "LETTER", "LPAREN", "LT", "MINUS", "MUL", "NEQ", "NOT", "OD", "OR", "PLUS", "PROGRAM", "RBRACE", "RBRACKET", "READ", "ROOT", "RPAREN", "SEMI", "SKIP", "THEN", "TRUE", "UNIT", "WHILE", "WRITE", "WS"
    };

    public static final int EOF=-1;
    public static final int AND=4;
    public static final int ASSIGN=5;
    public static final int COLON=6;
    public static final int DIV=7;
    public static final int DO=8;
    public static final int ELSE=9;
    public static final int END=10;
    public static final int EQ=11;
    public static final int FALSE=12;
    public static final int FI=13;
    public static final int GE=14;
    public static final int GT=15;
    public static final int IDENTIFIER=16;
    public static final int IF=17;
    public static final int INT=18;
    public static final int INTEGER=19;
    public static final int LBRACE=20;
    public static final int LBRACKET=21;
    public static final int LE=22;
    public static final int LETTER=23;
    public static final int LPAREN=24;
    public static final int LT=25;
    public static final int MINUS=26;
    public static final int MUL=27;
    public static final int NEQ=28;
    public static final int NOT=29;
    public static final int OD=30;
    public static final int OR=31;
    public static final int PLUS=32;
    public static final int PROGRAM=33;
    public static final int RBRACE=34;
    public static final int RBRACKET=35;
    public static final int READ=36;
    public static final int ROOT=37;
    public static final int RPAREN=38;
    public static final int SEMI=39;
    public static final int SKIP=40;
    public static final int THEN=41;
    public static final int TRUE=42;
    public static final int UNIT=43;
    public static final int WHILE=44;
    public static final int WRITE=45;
    public static final int WS=46;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public TheLangParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public TheLangParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[49+1];
         

    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return TheLangParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g"; }


    public static class aexpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aexpr"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:74:1: aexpr : aexpr1 ( PLUS ^ aexpr1 | MINUS ^ aexpr1 )* ;
    public final TheLangParser.aexpr_return aexpr() throws RecognitionException {
        TheLangParser.aexpr_return retval = new TheLangParser.aexpr_return();
        retval.start = input.LT(1);

        int aexpr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token PLUS2=null;
        Token MINUS4=null;
        TheLangParser.aexpr1_return aexpr11 =null;

        TheLangParser.aexpr1_return aexpr13 =null;

        TheLangParser.aexpr1_return aexpr15 =null;


        CommonTree PLUS2_tree=null;
        CommonTree MINUS4_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:74:7: ( aexpr1 ( PLUS ^ aexpr1 | MINUS ^ aexpr1 )* )
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:74:9: aexpr1 ( PLUS ^ aexpr1 | MINUS ^ aexpr1 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_aexpr1_in_aexpr433);
            aexpr11=aexpr1();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr11.getTree());

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:74:16: ( PLUS ^ aexpr1 | MINUS ^ aexpr1 )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PLUS) ) {
                    alt1=1;
                }
                else if ( (LA1_0==MINUS) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:74:17: PLUS ^ aexpr1
            	    {
            	    PLUS2=(Token)match(input,PLUS,FOLLOW_PLUS_in_aexpr436); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    PLUS2_tree = 
            	    (CommonTree)adaptor.create(PLUS2)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS2_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_aexpr1_in_aexpr439);
            	    aexpr13=aexpr1();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr13.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:74:32: MINUS ^ aexpr1
            	    {
            	    MINUS4=(Token)match(input,MINUS,FOLLOW_MINUS_in_aexpr443); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MINUS4_tree = 
            	    (CommonTree)adaptor.create(MINUS4)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS4_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_aexpr1_in_aexpr446);
            	    aexpr15=aexpr1();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr15.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, aexpr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "aexpr"


    public static class aexpr1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aexpr1"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:76:1: aexpr1 : aexpr2 ( MUL ^ aexpr2 | DIV ^ aexpr2 )* ;
    public final TheLangParser.aexpr1_return aexpr1() throws RecognitionException {
        TheLangParser.aexpr1_return retval = new TheLangParser.aexpr1_return();
        retval.start = input.LT(1);

        int aexpr1_StartIndex = input.index();

        CommonTree root_0 = null;

        Token MUL7=null;
        Token DIV9=null;
        TheLangParser.aexpr2_return aexpr26 =null;

        TheLangParser.aexpr2_return aexpr28 =null;

        TheLangParser.aexpr2_return aexpr210 =null;


        CommonTree MUL7_tree=null;
        CommonTree DIV9_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:76:8: ( aexpr2 ( MUL ^ aexpr2 | DIV ^ aexpr2 )* )
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:76:10: aexpr2 ( MUL ^ aexpr2 | DIV ^ aexpr2 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_aexpr2_in_aexpr1457);
            aexpr26=aexpr2();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr26.getTree());

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:76:17: ( MUL ^ aexpr2 | DIV ^ aexpr2 )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==MUL) ) {
                    alt2=1;
                }
                else if ( (LA2_0==DIV) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:76:18: MUL ^ aexpr2
            	    {
            	    MUL7=(Token)match(input,MUL,FOLLOW_MUL_in_aexpr1460); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MUL7_tree = 
            	    (CommonTree)adaptor.create(MUL7)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(MUL7_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_aexpr2_in_aexpr1463);
            	    aexpr28=aexpr2();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr28.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:76:32: DIV ^ aexpr2
            	    {
            	    DIV9=(Token)match(input,DIV,FOLLOW_DIV_in_aexpr1467); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DIV9_tree = 
            	    (CommonTree)adaptor.create(DIV9)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV9_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_aexpr2_in_aexpr1470);
            	    aexpr210=aexpr2();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr210.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, aexpr1_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "aexpr1"


    public static class aexpr2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aexpr2"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:78:1: aexpr2 : ( MINUS ^ aexpr3 | aexpr3 );
    public final TheLangParser.aexpr2_return aexpr2() throws RecognitionException {
        TheLangParser.aexpr2_return retval = new TheLangParser.aexpr2_return();
        retval.start = input.LT(1);

        int aexpr2_StartIndex = input.index();

        CommonTree root_0 = null;

        Token MINUS11=null;
        TheLangParser.aexpr3_return aexpr312 =null;

        TheLangParser.aexpr3_return aexpr313 =null;


        CommonTree MINUS11_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:78:8: ( MINUS ^ aexpr3 | aexpr3 )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==MINUS) ) {
                alt3=1;
            }
            else if ( (LA3_0==IDENTIFIER||LA3_0==INTEGER||LA3_0==LPAREN) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:78:10: MINUS ^ aexpr3
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    MINUS11=(Token)match(input,MINUS,FOLLOW_MINUS_in_aexpr2481); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS11_tree = 
                    (CommonTree)adaptor.create(MINUS11)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(MINUS11_tree, root_0);
                    }

                    pushFollow(FOLLOW_aexpr3_in_aexpr2484);
                    aexpr312=aexpr3();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr312.getTree());

                    }
                    break;
                case 2 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:79:10: aexpr3
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_aexpr3_in_aexpr2495);
                    aexpr313=aexpr3();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr313.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, aexpr2_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "aexpr2"


    public static class aexpr3_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aexpr3"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:82:1: aexpr3 : ( IDENTIFIER ( LBRACKET aexpr RBRACKET )? | INTEGER | LPAREN ! aexpr RPAREN !);
    public final TheLangParser.aexpr3_return aexpr3() throws RecognitionException {
        TheLangParser.aexpr3_return retval = new TheLangParser.aexpr3_return();
        retval.start = input.LT(1);

        int aexpr3_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER14=null;
        Token LBRACKET15=null;
        Token RBRACKET17=null;
        Token INTEGER18=null;
        Token LPAREN19=null;
        Token RPAREN21=null;
        TheLangParser.aexpr_return aexpr16 =null;

        TheLangParser.aexpr_return aexpr20 =null;


        CommonTree IDENTIFIER14_tree=null;
        CommonTree LBRACKET15_tree=null;
        CommonTree RBRACKET17_tree=null;
        CommonTree INTEGER18_tree=null;
        CommonTree LPAREN19_tree=null;
        CommonTree RPAREN21_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:82:8: ( IDENTIFIER ( LBRACKET aexpr RBRACKET )? | INTEGER | LPAREN ! aexpr RPAREN !)
            int alt5=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt5=1;
                }
                break;
            case INTEGER:
                {
                alt5=2;
                }
                break;
            case LPAREN:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:82:10: IDENTIFIER ( LBRACKET aexpr RBRACKET )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    IDENTIFIER14=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_aexpr3511); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER14_tree = 
                    (CommonTree)adaptor.create(IDENTIFIER14)
                    ;
                    adaptor.addChild(root_0, IDENTIFIER14_tree);
                    }

                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:82:21: ( LBRACKET aexpr RBRACKET )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==LBRACKET) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:82:22: LBRACKET aexpr RBRACKET
                            {
                            LBRACKET15=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_aexpr3514); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LBRACKET15_tree = 
                            (CommonTree)adaptor.create(LBRACKET15)
                            ;
                            adaptor.addChild(root_0, LBRACKET15_tree);
                            }

                            pushFollow(FOLLOW_aexpr_in_aexpr3516);
                            aexpr16=aexpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr16.getTree());

                            RBRACKET17=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_aexpr3518); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RBRACKET17_tree = 
                            (CommonTree)adaptor.create(RBRACKET17)
                            ;
                            adaptor.addChild(root_0, RBRACKET17_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:83:10: INTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    INTEGER18=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_aexpr3531); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER18_tree = 
                    (CommonTree)adaptor.create(INTEGER18)
                    ;
                    adaptor.addChild(root_0, INTEGER18_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:84:10: LPAREN ! aexpr RPAREN !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    LPAREN19=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_aexpr3542); if (state.failed) return retval;

                    pushFollow(FOLLOW_aexpr_in_aexpr3545);
                    aexpr20=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr20.getTree());

                    RPAREN21=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_aexpr3547); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, aexpr3_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "aexpr3"


    public static class bexpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bexpr"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:87:1: bexpr : bexpr1 ( OR bexpr1 )* ;
    public final TheLangParser.bexpr_return bexpr() throws RecognitionException {
        TheLangParser.bexpr_return retval = new TheLangParser.bexpr_return();
        retval.start = input.LT(1);

        int bexpr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token OR23=null;
        TheLangParser.bexpr1_return bexpr122 =null;

        TheLangParser.bexpr1_return bexpr124 =null;


        CommonTree OR23_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:87:7: ( bexpr1 ( OR bexpr1 )* )
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:87:9: bexpr1 ( OR bexpr1 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_bexpr1_in_bexpr564);
            bexpr122=bexpr1();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr122.getTree());

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:87:16: ( OR bexpr1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==OR) ) {
                    int LA6_2 = input.LA(2);

                    if ( (synpred9_TheLang()) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:87:17: OR bexpr1
            	    {
            	    OR23=(Token)match(input,OR,FOLLOW_OR_in_bexpr567); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR23_tree = 
            	    (CommonTree)adaptor.create(OR23)
            	    ;
            	    adaptor.addChild(root_0, OR23_tree);
            	    }

            	    pushFollow(FOLLOW_bexpr1_in_bexpr569);
            	    bexpr124=bexpr1();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr124.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, bexpr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "bexpr"


    public static class bexpr1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bexpr1"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:90:1: bexpr1 : bexpr2 ( AND bexpr2 )* ;
    public final TheLangParser.bexpr1_return bexpr1() throws RecognitionException {
        TheLangParser.bexpr1_return retval = new TheLangParser.bexpr1_return();
        retval.start = input.LT(1);

        int bexpr1_StartIndex = input.index();

        CommonTree root_0 = null;

        Token AND26=null;
        TheLangParser.bexpr2_return bexpr225 =null;

        TheLangParser.bexpr2_return bexpr227 =null;


        CommonTree AND26_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:90:8: ( bexpr2 ( AND bexpr2 )* )
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:90:10: bexpr2 ( AND bexpr2 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_bexpr2_in_bexpr1586);
            bexpr225=bexpr2();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr225.getTree());

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:90:17: ( AND bexpr2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==AND) ) {
                    int LA7_2 = input.LA(2);

                    if ( (synpred10_TheLang()) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:90:18: AND bexpr2
            	    {
            	    AND26=(Token)match(input,AND,FOLLOW_AND_in_bexpr1589); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND26_tree = 
            	    (CommonTree)adaptor.create(AND26)
            	    ;
            	    adaptor.addChild(root_0, AND26_tree);
            	    }

            	    pushFollow(FOLLOW_bexpr2_in_bexpr1591);
            	    bexpr227=bexpr2();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr227.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, bexpr1_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "bexpr1"


    public static class bexpr2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bexpr2"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:93:1: bexpr2 : ( aexpr opr ^ aexpr | NOT ^ bexpr | TRUE | FALSE | LPAREN ! bexpr ^ RPAREN !);
    public final TheLangParser.bexpr2_return bexpr2() throws RecognitionException {
        TheLangParser.bexpr2_return retval = new TheLangParser.bexpr2_return();
        retval.start = input.LT(1);

        int bexpr2_StartIndex = input.index();

        CommonTree root_0 = null;

        Token NOT31=null;
        Token TRUE33=null;
        Token FALSE34=null;
        Token LPAREN35=null;
        Token RPAREN37=null;
        TheLangParser.aexpr_return aexpr28 =null;

        TheLangParser.opr_return opr29 =null;

        TheLangParser.aexpr_return aexpr30 =null;

        TheLangParser.bexpr_return bexpr32 =null;

        TheLangParser.bexpr_return bexpr36 =null;


        CommonTree NOT31_tree=null;
        CommonTree TRUE33_tree=null;
        CommonTree FALSE34_tree=null;
        CommonTree LPAREN35_tree=null;
        CommonTree RPAREN37_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:93:8: ( aexpr opr ^ aexpr | NOT ^ bexpr | TRUE | FALSE | LPAREN ! bexpr ^ RPAREN !)
            int alt8=5;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
            case INTEGER:
            case MINUS:
                {
                alt8=1;
                }
                break;
            case LPAREN:
                {
                int LA8_4 = input.LA(2);

                if ( (synpred11_TheLang()) ) {
                    alt8=1;
                }
                else if ( (true) ) {
                    alt8=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 4, input);

                    throw nvae;

                }
                }
                break;
            case NOT:
                {
                alt8=2;
                }
                break;
            case TRUE:
                {
                alt8=3;
                }
                break;
            case FALSE:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:93:10: aexpr opr ^ aexpr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_aexpr_in_bexpr2609);
                    aexpr28=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr28.getTree());

                    pushFollow(FOLLOW_opr_in_bexpr2611);
                    opr29=opr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(opr29.getTree(), root_0);

                    pushFollow(FOLLOW_aexpr_in_bexpr2614);
                    aexpr30=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr30.getTree());

                    }
                    break;
                case 2 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:94:10: NOT ^ bexpr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    NOT31=(Token)match(input,NOT,FOLLOW_NOT_in_bexpr2626); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT31_tree = 
                    (CommonTree)adaptor.create(NOT31)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(NOT31_tree, root_0);
                    }

                    pushFollow(FOLLOW_bexpr_in_bexpr2629);
                    bexpr32=bexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr32.getTree());

                    }
                    break;
                case 3 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:95:10: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    TRUE33=(Token)match(input,TRUE,FOLLOW_TRUE_in_bexpr2640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE33_tree = 
                    (CommonTree)adaptor.create(TRUE33)
                    ;
                    adaptor.addChild(root_0, TRUE33_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:96:10: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    FALSE34=(Token)match(input,FALSE,FOLLOW_FALSE_in_bexpr2651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE34_tree = 
                    (CommonTree)adaptor.create(FALSE34)
                    ;
                    adaptor.addChild(root_0, FALSE34_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:97:10: LPAREN ! bexpr ^ RPAREN !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    LPAREN35=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_bexpr2662); if (state.failed) return retval;

                    pushFollow(FOLLOW_bexpr_in_bexpr2665);
                    bexpr36=bexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(bexpr36.getTree(), root_0);

                    RPAREN37=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_bexpr2668); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, bexpr2_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "bexpr2"


    public static class opr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "opr"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:100:1: opr : ( GT | GE | LT | LE | EQ | NEQ );
    public final TheLangParser.opr_return opr() throws RecognitionException {
        TheLangParser.opr_return retval = new TheLangParser.opr_return();
        retval.start = input.LT(1);

        int opr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set38=null;

        CommonTree set38_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:100:5: ( GT | GE | LT | LE | EQ | NEQ )
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set38=(Token)input.LT(1);

            if ( input.LA(1)==EQ||(input.LA(1) >= GE && input.LA(1) <= GT)||input.LA(1)==LE||input.LA(1)==LT||input.LA(1)==NEQ ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set38)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, opr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "opr"


    public static class decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "decl"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:108:1: decl : INT ^ IDENTIFIER ( LBRACKET ! INTEGER RBRACKET !)? SEMI !;
    public final TheLangParser.decl_return decl() throws RecognitionException {
        TheLangParser.decl_return retval = new TheLangParser.decl_return();
        retval.start = input.LT(1);

        int decl_StartIndex = input.index();

        CommonTree root_0 = null;

        Token INT39=null;
        Token IDENTIFIER40=null;
        Token LBRACKET41=null;
        Token INTEGER42=null;
        Token RBRACKET43=null;
        Token SEMI44=null;

        CommonTree INT39_tree=null;
        CommonTree IDENTIFIER40_tree=null;
        CommonTree LBRACKET41_tree=null;
        CommonTree INTEGER42_tree=null;
        CommonTree RBRACKET43_tree=null;
        CommonTree SEMI44_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:108:6: ( INT ^ IDENTIFIER ( LBRACKET ! INTEGER RBRACKET !)? SEMI !)
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:108:8: INT ^ IDENTIFIER ( LBRACKET ! INTEGER RBRACKET !)? SEMI !
            {
            root_0 = (CommonTree)adaptor.nil();


            INT39=(Token)match(input,INT,FOLLOW_INT_in_decl738); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INT39_tree = 
            (CommonTree)adaptor.create(INT39)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(INT39_tree, root_0);
            }

            IDENTIFIER40=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_decl741); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER40_tree = 
            (CommonTree)adaptor.create(IDENTIFIER40)
            ;
            adaptor.addChild(root_0, IDENTIFIER40_tree);
            }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:108:24: ( LBRACKET ! INTEGER RBRACKET !)?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LBRACKET) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:108:25: LBRACKET ! INTEGER RBRACKET !
                    {
                    LBRACKET41=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_decl744); if (state.failed) return retval;

                    INTEGER42=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_decl747); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER42_tree = 
                    (CommonTree)adaptor.create(INTEGER42)
                    ;
                    adaptor.addChild(root_0, INTEGER42_tree);
                    }

                    RBRACKET43=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_decl749); if (state.failed) return retval;

                    }
                    break;

            }


            SEMI44=(Token)match(input,SEMI,FOLLOW_SEMI_in_decl754); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, decl_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "decl"


    public static class stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stmt"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:110:1: stmt : ( assignStmt | skipStmt | readStmt | writeStmt | ifStmt | whileStmt );
    public final TheLangParser.stmt_return stmt() throws RecognitionException {
        TheLangParser.stmt_return retval = new TheLangParser.stmt_return();
        retval.start = input.LT(1);

        int stmt_StartIndex = input.index();

        CommonTree root_0 = null;

        TheLangParser.assignStmt_return assignStmt45 =null;

        TheLangParser.skipStmt_return skipStmt46 =null;

        TheLangParser.readStmt_return readStmt47 =null;

        TheLangParser.writeStmt_return writeStmt48 =null;

        TheLangParser.ifStmt_return ifStmt49 =null;

        TheLangParser.whileStmt_return whileStmt50 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:110:6: ( assignStmt | skipStmt | readStmt | writeStmt | ifStmt | whileStmt )
            int alt10=6;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt10=1;
                }
                break;
            case SKIP:
                {
                alt10=2;
                }
                break;
            case READ:
                {
                alt10=3;
                }
                break;
            case WRITE:
                {
                alt10=4;
                }
                break;
            case IF:
                {
                alt10=5;
                }
                break;
            case WHILE:
                {
                alt10=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:110:8: assignStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_assignStmt_in_stmt764);
                    assignStmt45=assignStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignStmt45.getTree());

                    }
                    break;
                case 2 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:111:8: skipStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_skipStmt_in_stmt773);
                    skipStmt46=skipStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, skipStmt46.getTree());

                    }
                    break;
                case 3 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:112:8: readStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_readStmt_in_stmt782);
                    readStmt47=readStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, readStmt47.getTree());

                    }
                    break;
                case 4 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:113:8: writeStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_writeStmt_in_stmt791);
                    writeStmt48=writeStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, writeStmt48.getTree());

                    }
                    break;
                case 5 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:114:8: ifStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_ifStmt_in_stmt800);
                    ifStmt49=ifStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStmt49.getTree());

                    }
                    break;
                case 6 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:115:8: whileStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_whileStmt_in_stmt809);
                    whileStmt50=whileStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStmt50.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, stmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "stmt"


    public static class assignStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignStmt"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:118:1: assignStmt : IDENTIFIER ( LBRACKET aexpr RBRACKET )? ASSIGN ^ aexpr SEMI !;
    public final TheLangParser.assignStmt_return assignStmt() throws RecognitionException {
        TheLangParser.assignStmt_return retval = new TheLangParser.assignStmt_return();
        retval.start = input.LT(1);

        int assignStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER51=null;
        Token LBRACKET52=null;
        Token RBRACKET54=null;
        Token ASSIGN55=null;
        Token SEMI57=null;
        TheLangParser.aexpr_return aexpr53 =null;

        TheLangParser.aexpr_return aexpr56 =null;


        CommonTree IDENTIFIER51_tree=null;
        CommonTree LBRACKET52_tree=null;
        CommonTree RBRACKET54_tree=null;
        CommonTree ASSIGN55_tree=null;
        CommonTree SEMI57_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:118:12: ( IDENTIFIER ( LBRACKET aexpr RBRACKET )? ASSIGN ^ aexpr SEMI !)
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:118:14: IDENTIFIER ( LBRACKET aexpr RBRACKET )? ASSIGN ^ aexpr SEMI !
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENTIFIER51=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignStmt823); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER51_tree = 
            (CommonTree)adaptor.create(IDENTIFIER51)
            ;
            adaptor.addChild(root_0, IDENTIFIER51_tree);
            }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:118:25: ( LBRACKET aexpr RBRACKET )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==LBRACKET) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:118:26: LBRACKET aexpr RBRACKET
                    {
                    LBRACKET52=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_assignStmt826); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACKET52_tree = 
                    (CommonTree)adaptor.create(LBRACKET52)
                    ;
                    adaptor.addChild(root_0, LBRACKET52_tree);
                    }

                    pushFollow(FOLLOW_aexpr_in_assignStmt828);
                    aexpr53=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr53.getTree());

                    RBRACKET54=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_assignStmt830); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACKET54_tree = 
                    (CommonTree)adaptor.create(RBRACKET54)
                    ;
                    adaptor.addChild(root_0, RBRACKET54_tree);
                    }

                    }
                    break;

            }


            ASSIGN55=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignStmt834); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSIGN55_tree = 
            (CommonTree)adaptor.create(ASSIGN55)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN55_tree, root_0);
            }

            pushFollow(FOLLOW_aexpr_in_assignStmt837);
            aexpr56=aexpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr56.getTree());

            SEMI57=(Token)match(input,SEMI,FOLLOW_SEMI_in_assignStmt839); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, assignStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "assignStmt"


    public static class skipStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "skipStmt"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:120:1: skipStmt : SKIP ^ SEMI !;
    public final TheLangParser.skipStmt_return skipStmt() throws RecognitionException {
        TheLangParser.skipStmt_return retval = new TheLangParser.skipStmt_return();
        retval.start = input.LT(1);

        int skipStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token SKIP58=null;
        Token SEMI59=null;

        CommonTree SKIP58_tree=null;
        CommonTree SEMI59_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:120:10: ( SKIP ^ SEMI !)
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:120:12: SKIP ^ SEMI !
            {
            root_0 = (CommonTree)adaptor.nil();


            SKIP58=(Token)match(input,SKIP,FOLLOW_SKIP_in_skipStmt849); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SKIP58_tree = 
            (CommonTree)adaptor.create(SKIP58)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(SKIP58_tree, root_0);
            }

            SEMI59=(Token)match(input,SEMI,FOLLOW_SEMI_in_skipStmt852); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, skipStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "skipStmt"


    public static class readStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "readStmt"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:122:1: readStmt : READ ^ IDENTIFIER ( LBRACKET aexpr RBRACKET )? SEMI !;
    public final TheLangParser.readStmt_return readStmt() throws RecognitionException {
        TheLangParser.readStmt_return retval = new TheLangParser.readStmt_return();
        retval.start = input.LT(1);

        int readStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token READ60=null;
        Token IDENTIFIER61=null;
        Token LBRACKET62=null;
        Token RBRACKET64=null;
        Token SEMI65=null;
        TheLangParser.aexpr_return aexpr63 =null;


        CommonTree READ60_tree=null;
        CommonTree IDENTIFIER61_tree=null;
        CommonTree LBRACKET62_tree=null;
        CommonTree RBRACKET64_tree=null;
        CommonTree SEMI65_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:122:10: ( READ ^ IDENTIFIER ( LBRACKET aexpr RBRACKET )? SEMI !)
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:122:12: READ ^ IDENTIFIER ( LBRACKET aexpr RBRACKET )? SEMI !
            {
            root_0 = (CommonTree)adaptor.nil();


            READ60=(Token)match(input,READ,FOLLOW_READ_in_readStmt862); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            READ60_tree = 
            (CommonTree)adaptor.create(READ60)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(READ60_tree, root_0);
            }

            IDENTIFIER61=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_readStmt865); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER61_tree = 
            (CommonTree)adaptor.create(IDENTIFIER61)
            ;
            adaptor.addChild(root_0, IDENTIFIER61_tree);
            }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:122:29: ( LBRACKET aexpr RBRACKET )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LBRACKET) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:122:30: LBRACKET aexpr RBRACKET
                    {
                    LBRACKET62=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_readStmt868); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACKET62_tree = 
                    (CommonTree)adaptor.create(LBRACKET62)
                    ;
                    adaptor.addChild(root_0, LBRACKET62_tree);
                    }

                    pushFollow(FOLLOW_aexpr_in_readStmt870);
                    aexpr63=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr63.getTree());

                    RBRACKET64=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_readStmt872); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACKET64_tree = 
                    (CommonTree)adaptor.create(RBRACKET64)
                    ;
                    adaptor.addChild(root_0, RBRACKET64_tree);
                    }

                    }
                    break;

            }


            SEMI65=(Token)match(input,SEMI,FOLLOW_SEMI_in_readStmt876); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, readStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "readStmt"


    public static class writeStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "writeStmt"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:124:1: writeStmt : WRITE ^ aexpr SEMI !;
    public final TheLangParser.writeStmt_return writeStmt() throws RecognitionException {
        TheLangParser.writeStmt_return retval = new TheLangParser.writeStmt_return();
        retval.start = input.LT(1);

        int writeStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token WRITE66=null;
        Token SEMI68=null;
        TheLangParser.aexpr_return aexpr67 =null;


        CommonTree WRITE66_tree=null;
        CommonTree SEMI68_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:124:11: ( WRITE ^ aexpr SEMI !)
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:124:13: WRITE ^ aexpr SEMI !
            {
            root_0 = (CommonTree)adaptor.nil();


            WRITE66=(Token)match(input,WRITE,FOLLOW_WRITE_in_writeStmt886); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WRITE66_tree = 
            (CommonTree)adaptor.create(WRITE66)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(WRITE66_tree, root_0);
            }

            pushFollow(FOLLOW_aexpr_in_writeStmt889);
            aexpr67=aexpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr67.getTree());

            SEMI68=(Token)match(input,SEMI,FOLLOW_SEMI_in_writeStmt891); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, writeStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "writeStmt"


    public static class ifStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStmt"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:126:1: ifStmt : IF ^ bexpr THEN ( stmt )+ ELSE ( stmt )+ FI !;
    public final TheLangParser.ifStmt_return ifStmt() throws RecognitionException {
        TheLangParser.ifStmt_return retval = new TheLangParser.ifStmt_return();
        retval.start = input.LT(1);

        int ifStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IF69=null;
        Token THEN71=null;
        Token ELSE73=null;
        Token FI75=null;
        TheLangParser.bexpr_return bexpr70 =null;

        TheLangParser.stmt_return stmt72 =null;

        TheLangParser.stmt_return stmt74 =null;


        CommonTree IF69_tree=null;
        CommonTree THEN71_tree=null;
        CommonTree ELSE73_tree=null;
        CommonTree FI75_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:126:8: ( IF ^ bexpr THEN ( stmt )+ ELSE ( stmt )+ FI !)
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:126:10: IF ^ bexpr THEN ( stmt )+ ELSE ( stmt )+ FI !
            {
            root_0 = (CommonTree)adaptor.nil();


            IF69=(Token)match(input,IF,FOLLOW_IF_in_ifStmt901); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IF69_tree = 
            (CommonTree)adaptor.create(IF69)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IF69_tree, root_0);
            }

            pushFollow(FOLLOW_bexpr_in_ifStmt904);
            bexpr70=bexpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr70.getTree());

            THEN71=(Token)match(input,THEN,FOLLOW_THEN_in_ifStmt906); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN71_tree = 
            (CommonTree)adaptor.create(THEN71)
            ;
            adaptor.addChild(root_0, THEN71_tree);
            }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:126:25: ( stmt )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= IDENTIFIER && LA13_0 <= IF)||LA13_0==READ||LA13_0==SKIP||(LA13_0 >= WHILE && LA13_0 <= WRITE)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:126:25: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_ifStmt908);
            	    stmt72=stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt72.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            ELSE73=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifStmt911); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ELSE73_tree = 
            (CommonTree)adaptor.create(ELSE73)
            ;
            adaptor.addChild(root_0, ELSE73_tree);
            }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:126:36: ( stmt )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0 >= IDENTIFIER && LA14_0 <= IF)||LA14_0==READ||LA14_0==SKIP||(LA14_0 >= WHILE && LA14_0 <= WRITE)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:126:36: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_ifStmt913);
            	    stmt74=stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt74.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            FI75=(Token)match(input,FI,FOLLOW_FI_in_ifStmt916); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, ifStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "ifStmt"


    public static class whileStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "whileStmt"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:128:1: whileStmt : WHILE ^ bexpr DO ! ( stmt )+ OD !;
    public final TheLangParser.whileStmt_return whileStmt() throws RecognitionException {
        TheLangParser.whileStmt_return retval = new TheLangParser.whileStmt_return();
        retval.start = input.LT(1);

        int whileStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token WHILE76=null;
        Token DO78=null;
        Token OD80=null;
        TheLangParser.bexpr_return bexpr77 =null;

        TheLangParser.stmt_return stmt79 =null;


        CommonTree WHILE76_tree=null;
        CommonTree DO78_tree=null;
        CommonTree OD80_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:128:11: ( WHILE ^ bexpr DO ! ( stmt )+ OD !)
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:128:13: WHILE ^ bexpr DO ! ( stmt )+ OD !
            {
            root_0 = (CommonTree)adaptor.nil();


            WHILE76=(Token)match(input,WHILE,FOLLOW_WHILE_in_whileStmt926); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHILE76_tree = 
            (CommonTree)adaptor.create(WHILE76)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(WHILE76_tree, root_0);
            }

            pushFollow(FOLLOW_bexpr_in_whileStmt929);
            bexpr77=bexpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr77.getTree());

            DO78=(Token)match(input,DO,FOLLOW_DO_in_whileStmt931); if (state.failed) return retval;

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:128:30: ( stmt )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0 >= IDENTIFIER && LA15_0 <= IF)||LA15_0==READ||LA15_0==SKIP||(LA15_0 >= WHILE && LA15_0 <= WRITE)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:128:30: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_whileStmt934);
            	    stmt79=stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt79.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            OD80=(Token)match(input,OD,FOLLOW_OD_in_whileStmt937); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, whileStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "whileStmt"


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "program"
    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:130:1: program : PROGRAM ! ( decl )* ( stmt )+ END !;
    public final TheLangParser.program_return program() throws RecognitionException {
        TheLangParser.program_return retval = new TheLangParser.program_return();
        retval.start = input.LT(1);

        int program_StartIndex = input.index();

        CommonTree root_0 = null;

        Token PROGRAM81=null;
        Token END84=null;
        TheLangParser.decl_return decl82 =null;

        TheLangParser.stmt_return stmt83 =null;


        CommonTree PROGRAM81_tree=null;
        CommonTree END84_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:130:9: ( PROGRAM ! ( decl )* ( stmt )+ END !)
            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:130:11: PROGRAM ! ( decl )* ( stmt )+ END !
            {
            root_0 = (CommonTree)adaptor.nil();


            PROGRAM81=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program949); if (state.failed) return retval;

            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:130:20: ( decl )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==INT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:130:20: decl
            	    {
            	    pushFollow(FOLLOW_decl_in_program952);
            	    decl82=decl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, decl82.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:130:26: ( stmt )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0 >= IDENTIFIER && LA17_0 <= IF)||LA17_0==READ||LA17_0==SKIP||(LA17_0 >= WHILE && LA17_0 <= WRITE)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:130:26: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_program955);
            	    stmt83=stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt83.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            END84=(Token)match(input,END,FOLLOW_END_in_program958); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, program_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "program"

    // $ANTLR start synpred9_TheLang
    public final void synpred9_TheLang_fragment() throws RecognitionException {
        // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:87:17: ( OR bexpr1 )
        // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:87:17: OR bexpr1
        {
        match(input,OR,FOLLOW_OR_in_synpred9_TheLang567); if (state.failed) return ;

        pushFollow(FOLLOW_bexpr1_in_synpred9_TheLang569);
        bexpr1();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred9_TheLang

    // $ANTLR start synpred10_TheLang
    public final void synpred10_TheLang_fragment() throws RecognitionException {
        // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:90:18: ( AND bexpr2 )
        // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:90:18: AND bexpr2
        {
        match(input,AND,FOLLOW_AND_in_synpred10_TheLang589); if (state.failed) return ;

        pushFollow(FOLLOW_bexpr2_in_synpred10_TheLang591);
        bexpr2();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred10_TheLang

    // $ANTLR start synpred11_TheLang
    public final void synpred11_TheLang_fragment() throws RecognitionException {
        // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:93:10: ( aexpr opr aexpr )
        // /Users/showandtell/officina/ProgramAnalysis/src/parser/TheLang.g:93:10: aexpr opr aexpr
        {
        pushFollow(FOLLOW_aexpr_in_synpred11_TheLang609);
        aexpr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_opr_in_synpred11_TheLang611);
        opr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_aexpr_in_synpred11_TheLang614);
        aexpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred11_TheLang

    // Delegated rules

    public final boolean synpred10_TheLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_TheLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_TheLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_TheLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_TheLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_TheLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_aexpr1_in_aexpr433 = new BitSet(new long[]{0x0000000104000002L});
    public static final BitSet FOLLOW_PLUS_in_aexpr436 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr1_in_aexpr439 = new BitSet(new long[]{0x0000000104000002L});
    public static final BitSet FOLLOW_MINUS_in_aexpr443 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr1_in_aexpr446 = new BitSet(new long[]{0x0000000104000002L});
    public static final BitSet FOLLOW_aexpr2_in_aexpr1457 = new BitSet(new long[]{0x0000000008000082L});
    public static final BitSet FOLLOW_MUL_in_aexpr1460 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr2_in_aexpr1463 = new BitSet(new long[]{0x0000000008000082L});
    public static final BitSet FOLLOW_DIV_in_aexpr1467 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr2_in_aexpr1470 = new BitSet(new long[]{0x0000000008000082L});
    public static final BitSet FOLLOW_MINUS_in_aexpr2481 = new BitSet(new long[]{0x0000000001090000L});
    public static final BitSet FOLLOW_aexpr3_in_aexpr2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aexpr3_in_aexpr2495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_aexpr3511 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_LBRACKET_in_aexpr3514 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr_in_aexpr3516 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RBRACKET_in_aexpr3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_aexpr3531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_aexpr3542 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr_in_aexpr3545 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RPAREN_in_aexpr3547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bexpr1_in_bexpr564 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_OR_in_bexpr567 = new BitSet(new long[]{0x0000040025091000L});
    public static final BitSet FOLLOW_bexpr1_in_bexpr569 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_bexpr2_in_bexpr1586 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_bexpr1589 = new BitSet(new long[]{0x0000040025091000L});
    public static final BitSet FOLLOW_bexpr2_in_bexpr1591 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_aexpr_in_bexpr2609 = new BitSet(new long[]{0x000000001240C800L});
    public static final BitSet FOLLOW_opr_in_bexpr2611 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr_in_bexpr2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_bexpr2626 = new BitSet(new long[]{0x0000040025091000L});
    public static final BitSet FOLLOW_bexpr_in_bexpr2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_bexpr2640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_bexpr2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_bexpr2662 = new BitSet(new long[]{0x0000040025091000L});
    public static final BitSet FOLLOW_bexpr_in_bexpr2665 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RPAREN_in_bexpr2668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_decl738 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_decl741 = new BitSet(new long[]{0x0000008000200000L});
    public static final BitSet FOLLOW_LBRACKET_in_decl744 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_INTEGER_in_decl747 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RBRACKET_in_decl749 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_SEMI_in_decl754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignStmt_in_stmt764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_skipStmt_in_stmt773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readStmt_in_stmt782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_writeStmt_in_stmt791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStmt_in_stmt800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStmt_in_stmt809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assignStmt823 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_LBRACKET_in_assignStmt826 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr_in_assignStmt828 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RBRACKET_in_assignStmt830 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_in_assignStmt834 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr_in_assignStmt837 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_SEMI_in_assignStmt839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SKIP_in_skipStmt849 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_SEMI_in_skipStmt852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_in_readStmt862 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_readStmt865 = new BitSet(new long[]{0x0000008000200000L});
    public static final BitSet FOLLOW_LBRACKET_in_readStmt868 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr_in_readStmt870 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RBRACKET_in_readStmt872 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_SEMI_in_readStmt876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_in_writeStmt886 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr_in_writeStmt889 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_SEMI_in_writeStmt891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStmt901 = new BitSet(new long[]{0x0000040025091000L});
    public static final BitSet FOLLOW_bexpr_in_ifStmt904 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_THEN_in_ifStmt906 = new BitSet(new long[]{0x0000311000030000L});
    public static final BitSet FOLLOW_stmt_in_ifStmt908 = new BitSet(new long[]{0x0000311000030200L});
    public static final BitSet FOLLOW_ELSE_in_ifStmt911 = new BitSet(new long[]{0x0000311000030000L});
    public static final BitSet FOLLOW_stmt_in_ifStmt913 = new BitSet(new long[]{0x0000311000032000L});
    public static final BitSet FOLLOW_FI_in_ifStmt916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whileStmt926 = new BitSet(new long[]{0x0000040025091000L});
    public static final BitSet FOLLOW_bexpr_in_whileStmt929 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_DO_in_whileStmt931 = new BitSet(new long[]{0x0000311000030000L});
    public static final BitSet FOLLOW_stmt_in_whileStmt934 = new BitSet(new long[]{0x0000311040030000L});
    public static final BitSet FOLLOW_OD_in_whileStmt937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program949 = new BitSet(new long[]{0x0000311000070000L});
    public static final BitSet FOLLOW_decl_in_program952 = new BitSet(new long[]{0x0000311000070000L});
    public static final BitSet FOLLOW_stmt_in_program955 = new BitSet(new long[]{0x0000311000030400L});
    public static final BitSet FOLLOW_END_in_program958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_synpred9_TheLang567 = new BitSet(new long[]{0x0000040025091000L});
    public static final BitSet FOLLOW_bexpr1_in_synpred9_TheLang569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_synpred10_TheLang589 = new BitSet(new long[]{0x0000040025091000L});
    public static final BitSet FOLLOW_bexpr2_in_synpred10_TheLang591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aexpr_in_synpred11_TheLang609 = new BitSet(new long[]{0x000000001240C800L});
    public static final BitSet FOLLOW_opr_in_synpred11_TheLang611 = new BitSet(new long[]{0x0000000005090000L});
    public static final BitSet FOLLOW_aexpr_in_synpred11_TheLang614 = new BitSet(new long[]{0x0000000000000002L});

}