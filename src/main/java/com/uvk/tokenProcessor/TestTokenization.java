package com.uvk.tokenProcessor;

import java.util.ArrayList;
import java.util.List;

import com.uvk.model.TokenizedData;

public class TestTokenization {

	public static void main(String[] args) {
		List<TokenizedData> inputList = new ArrayList<TokenizedData>();
		
		TokenizedData input1 = new TokenizedData();
		
		inputList.add(input1);
		
		TokenizedFileProcessor processor = new TokenizedFileProcessor();
		
		List<TokenizedData> outputList = processor.process(inputList);
	}

}
