package lexAnalyzer;

public enum Tokens {
  _boolean, _break, _class, _double,
  _else, _extends, _for, _if,
  _implements, _int, _interface, _new,
  _newarray, _null, _println, _readln,
  _return, _string, _void, _while,
  _plus, _minus, _multiplication, _division,
  _mod, _less, _lessequal, _greater,
  _greaterequal, _equal, _notequal, _and,
  _or, _not, _assignop, _semicolon,
  _comma, _period, _leftparen, _rightparen,
  _leftbracket, _rightbracket, _leftbrace, _rightbrace,
  _intconstant, _doubleconstant, _stringconstant, _booleanconstant, _id;
  
  private static final int OFFSET = 1000;
  
  public int getValue() { return this.ordinal() + this.OFFSET; }
}