package main;

public enum Notes {
    A(60), S(62), D(64), F(65),
    G(67), H(69), J(71), W(61),
    E(63), T(66), Y(68), U(70);
    public int code;
    Notes(int code){
        this.code = code;
    }
}
