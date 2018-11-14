package lexAnalyzer;

import java.util.Vector;

public class Trie
{
	final int alphaLen = 52;
	int[] switcher = new int[alphaLen];
	Vector<Node> symbol = new Vector<Node>();
	class Node { 
        char value;
        int redirect = -1;
        Node(char val)
        {
        	value = val;
        	redirect = -1;
        }
        void setRed(int pos)
        {
        	redirect = pos;
        }
        void setValue(char thing)
        {
        	value = thing;
        }
        char getVal()
        {
        	return value;
        }
        int getRed()
        {
        	return redirect;
        }
    } 
	Trie()
	{
		initialize();
	}

	void initialize()
	{
		for (int i = 0;i < alphaLen; i++)
			switcher[i] = -1;
	}

	void add(String word)
	{
		int indexOfSw = checkPos(word.charAt(0)); // returns where letter should be in switcher array
		if(switcher[indexOfSw]== -1) // if brand new word
		{
			switcher[indexOfSw] = symbol.size(); // if never set, add to end of symbol list. Update switcher.
			addBranch(word, 1);
		}
		else // if one already exists with first char
		{
			int indexOfSy = switcher[indexOfSw];
			int wordIndex = 1; // cursor of word
			while (wordIndex < word.length()) // go thru whole word
			{
				Node symbolCursor = symbol.elementAt(indexOfSy);
				if(!(symbolCursor.getVal()== word.charAt(wordIndex))) // if letter does not match new thread
				{
					if(symbolCursor.getRed() == -1) // if no new thread exists. make one.
					{
						symbol.elementAt(indexOfSy).setRed(symbol.size()); // point to the end of the tree
						addBranch(word, wordIndex);
						break;
					}
					else
						indexOfSy = symbolCursor.getRed();
				}
				else{
					wordIndex++;
					indexOfSy++;
				}
			}
		}
		
	}
	void print()
	{
		int begin = 0, end = 0, linelen =20;
		System.out.print("          ");
		for(int i = 0; i < alphaLen; i++){
			System.out.print(" "+checkChar(i) + " ");
			if((i+1) % linelen == 0 || i == alphaLen-1) // skip line
			{
				begin=end;
				end+=linelen;
				if(i == alphaLen-1) // if last line 
					end = alphaLen;
				System.out.print("\nswitch:   ");
				for(int j = begin; j < end; j++)
					System.out.print(switcher[j] + " ");
				System.out.println("\n");
				System.out.print("          ");
			}
		}
		begin = 0; 
		end = 0;
		System.out.print("\n          ");
		for(int i = 0; i < symbol.size(); i++){
			System.out.print(i + " ");
			if((i+1) % 20 == 0 || i == symbol.size()-1) // skip line
			{
				begin=end;
				end+=linelen;
				if(i == symbol.size()-1) // if last line 
					end = symbol.size();
				//print symbol
				System.out.print("\nsymbol:   ");
				for(int j = begin; j < end; j++){
					char val = symbol.elementAt(j).getVal();
					System.out.print(val);
					//line up with dynamic spacing
					for (int sp=0; sp < String.valueOf(j).length() ;sp++) 
						System.out.print(" ");
				}
				System.out.print("\nnext:     ");
				for(int j = begin; j < end; j++){
					int val = symbol.elementAt(j).getRed();
					if(val == -1)
						System.out.print("  ");
					else
						System.out.print(val);
					//line up with dynamic spacing
					for (int sp=0; sp < String.valueOf(j).length()-1 ;sp++) 
						System.out.print(" ");
				}
				System.out.print("\n          ");
			}
		}
	}
	void addBranch(String word, int indexOfWord)
	{
			for (int i = indexOfWord; i < word.length();i++) // go thru whole word
				symbol.add(new Node(word.charAt(i)));
			symbol.add(new Node('*')); //delimiter
	}
	int checkPos(char letter) //conver char to pos of switcher
	{
		int pos = letter;
		if(pos >= 65 && pos <= 90)
			pos -= 65;
		else if (pos >= 97 && pos <= 122)
			pos -= 71;
		else; // symbol I guess

		return pos;
	}
	char checkChar(int ascii)
	{
		if(ascii >= 0 && ascii <= 25)
			ascii += 65;
		else if (ascii >= 26 && ascii <= 52)
			ascii += 71;
		else; // symbol I guess
		char charval = ((char) ascii);
		return charval;

	}

};

