package cinema.model;

import java.util.UUID;

public class Token {
    private UUID token;

    public Token() {
        this.token = new UUID(Integer.MAX_VALUE, Integer.MIN_VALUE);
        this.token = UUID.randomUUID();
    }

    public Token(String token) {
        this.token = UUID.fromString(token);
    }

    public String getToken() {
        return token.toString();
    }

}
