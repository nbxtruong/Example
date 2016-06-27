// Generated from Exp.g4 by ANTLR 4.5.3

	package exp.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, INT=6, FLOAT=7, NL=8, LP=9, RP=10, 
		ADDOP=11, MULOP=12, WS=13, ID=14, ERROR_CHAR=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "INT", "FLOAT", "NL", "LP", "RP", 
		"ADDOP", "MULOP", "WS", "ID", "ERROR_CHAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'then'", "'else'", "'='", "';'", null, null, "'\n'", "'('", 
		"')'", null, "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "INT", "FLOAT", "NL", "LP", "RP", 
		"ADDOP", "MULOP", "WS", "ID", "ERROR_CHAR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	@Override
	public Token emit() {
	    switch (getType()) {
	    case ERROR_CHAR:
	    	Token result = super.emit();
	    	throw new ErrorToken(result.getText());	
	    default:
	        return super.emit();
	    }
	}


	public ExpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Exp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21[\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\6\7\64\n\7\r\7\16"+
		"\7\65\3\b\6\b9\n\b\r\b\16\b:\3\b\3\b\7\b?\n\b\f\b\16\bB\13\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\6\16O\n\16\r\16\16\16P\3\16\3\16"+
		"\3\17\6\17V\n\17\r\17\16\17W\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21\3\2\6\3\2\62;\4\2-"+
		"-//\5\2\13\13\17\17\"\"\3\2c|_\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\3!\3\2\2\2\5$\3\2\2\2\7)\3\2\2\2\t.\3\2\2\2\13\60\3\2\2\2"+
		"\r\63\3\2\2\2\178\3\2\2\2\21C\3\2\2\2\23E\3\2\2\2\25G\3\2\2\2\27I\3\2"+
		"\2\2\31K\3\2\2\2\33N\3\2\2\2\35U\3\2\2\2\37Y\3\2\2\2!\"\7k\2\2\"#\7h\2"+
		"\2#\4\3\2\2\2$%\7v\2\2%&\7j\2\2&\'\7g\2\2\'(\7p\2\2(\6\3\2\2\2)*\7g\2"+
		"\2*+\7n\2\2+,\7u\2\2,-\7g\2\2-\b\3\2\2\2./\7?\2\2/\n\3\2\2\2\60\61\7="+
		"\2\2\61\f\3\2\2\2\62\64\t\2\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2"+
		"\2\2\65\66\3\2\2\2\66\16\3\2\2\2\679\5\r\7\28\67\3\2\2\29:\3\2\2\2:8\3"+
		"\2\2\2:;\3\2\2\2;<\3\2\2\2<@\7\60\2\2=?\5\r\7\2>=\3\2\2\2?B\3\2\2\2@>"+
		"\3\2\2\2@A\3\2\2\2A\20\3\2\2\2B@\3\2\2\2CD\7\f\2\2D\22\3\2\2\2EF\7*\2"+
		"\2F\24\3\2\2\2GH\7+\2\2H\26\3\2\2\2IJ\t\3\2\2J\30\3\2\2\2KL\7,\2\2L\32"+
		"\3\2\2\2MO\t\4\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QR\3\2\2\2R"+
		"S\b\16\2\2S\34\3\2\2\2TV\t\5\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2"+
		"\2X\36\3\2\2\2YZ\13\2\2\2Z \3\2\2\2\b\2\65:@PW\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}