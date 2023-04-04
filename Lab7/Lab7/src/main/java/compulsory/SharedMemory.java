package compulsory;

import java.util.*;

public class SharedMemory {
    private final List<Token> tokens = new ArrayList<>();
    public SharedMemory(int n) {
        List<Token> tokenList = new ArrayList<>();
        for(int i=0; i<n*n*n; i++){
            tokenList.add(new Token(i));
        }
        Collections.shuffle(tokenList);
        tokens.addAll(tokenList);
    }
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            Random random = new Random();
            int index = random.nextInt(tokens.size());
            extracted.add(tokens.get(index));
            tokens.remove(index);
        }
        return extracted;
    }

}
