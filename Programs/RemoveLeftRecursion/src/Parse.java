public class Parse {
//	private Tokenstream ts;
//
//	public Parse(Tokenstream ts) {
//		this.ts = ts;
//	}
//
//	void E() {
//		T();
//		Eopt();
//		return;
//	}
//
//	void Eopt() {
//		switch (ts.tok) {
//		case '-':
//			ts.next();
//			T();
//			Eopt();
//			return;
//		default:
//			return;
//		}
//	}
//
//	void T() {
//		switch (ts.tok) {
//		case '0':
//			ts.next();
//			return;
//		case '1':
//			ts.next();
//			return;
//		default:
//			throw ts.parseerror("Expected 0 or 1");
//		}
//	}
//
//	void parse() {
//		E();
//		if (ts.tok != Tokenstream.EOF)
//			throw ts.parseerror("Expected end of file");
//		return;
//	}
}