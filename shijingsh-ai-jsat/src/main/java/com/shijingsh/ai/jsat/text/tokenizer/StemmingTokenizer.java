
package com.shijingsh.ai.jsat.text.tokenizer;

import java.util.List;

import com.shijingsh.ai.jsat.text.stemming.Stemmer;
import com.shijingsh.ai.jsat.text.stemming.Stemmer;

/**
 *
 * @author Edward Raff
 */
public class StemmingTokenizer implements Tokenizer {

    private static final long serialVersionUID = 2883247633791522390L;
    private Stemmer stemmer;
    private Tokenizer baseTokenizer;

    public StemmingTokenizer(Stemmer stemmer, Tokenizer baseTokenizer) {
        this.stemmer = stemmer;
        this.baseTokenizer = baseTokenizer;
    }

    @Override
    public List<String> tokenize(String input) {
        List<String> tokens = baseTokenizer.tokenize(input);
        stemmer.applyTo(tokens);
        return tokens;
    }

    @Override
    public void tokenize(String input, StringBuilder workSpace, List<String> storageSpace) {
        baseTokenizer.tokenize(input, workSpace, storageSpace);
        stemmer.applyTo(storageSpace);
    }

}
