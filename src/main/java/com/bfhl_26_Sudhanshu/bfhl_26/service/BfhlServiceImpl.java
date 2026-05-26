package com.bfhl_26_Sudhanshu.bfhl_26.service;

import com.bfhl_26_Sudhanshu.bfhl_26.dto.BfhlRequest;
import com.bfhl_26_Sudhanshu.bfhl_26.dto.BfhlResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Value("${bfhl.user-id}")
    private String userId;

    @Value("${bfhl.email}")
    private String email;

    @Value("${bfhl.roll-number}")
    private String rollNumber;

    @Override
    public BfhlResponse processData(BfhlRequest request) {
        BfhlResponse response = new BfhlResponse();
        response.setUserId(userId);
        response.setEmail(email);
        response.setRollNumber(rollNumber);

        try {
            if (request == null || request.getData() == null) {
                response.setSuccess(false);
                response.setOddNumbers(Collections.emptyList());
                response.setEvenNumbers(Collections.emptyList());
                response.setAlphabets(Collections.emptyList());
                response.setSpecialCharacters(Collections.emptyList());
                response.setSum("0");
                response.setConcatString("");
                return response;
            }

            List<String> oddNumbers = new ArrayList<>();
            List<String> evenNumbers = new ArrayList<>();
            List<String> alphabets = new ArrayList<>();
            List<String> specialCharacters = new ArrayList<>();
            List<String> originalAlphabets = new ArrayList<>();

            BigInteger totalSum = BigInteger.ZERO;

            for (String item : request.getData()) {
                if (item == null) {
                    continue;
                }
                if (item.matches("-?\\d+")) {
                    BigInteger val = new BigInteger(item);
                    totalSum = totalSum.add(val);
                    if (val.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                } else if (item.matches("[a-zA-Z]+")) {
                    alphabets.add(item.toUpperCase());
                    originalAlphabets.add(item);
                } else {
                    specialCharacters.add(item);
                }
            }

            // Process reversed alternating-caps concatenation of alphabets
            List<String> reversedAlphabets = new ArrayList<>(originalAlphabets);
            Collections.reverse(reversedAlphabets);
            String concatenated = String.join("", reversedAlphabets);
            StringBuilder alternatingCaps = new StringBuilder();
            for (int i = 0; i < concatenated.length(); i++) {
                char ch = concatenated.charAt(i);
                if (i % 2 == 0) {
                    alternatingCaps.append(Character.toUpperCase(ch));
                } else {
                    alternatingCaps.append(Character.toLowerCase(ch));
                }
            }

            response.setSuccess(true);
            response.setOddNumbers(oddNumbers);
            response.setEvenNumbers(evenNumbers);
            response.setAlphabets(alphabets);
            response.setSpecialCharacters(specialCharacters);
            response.setSum(totalSum.toString());
            response.setConcatString(alternatingCaps.toString());

        } catch (Exception e) {
            response.setSuccess(false);
            response.setOddNumbers(Collections.emptyList());
            response.setEvenNumbers(Collections.emptyList());
            response.setAlphabets(Collections.emptyList());
            response.setSpecialCharacters(Collections.emptyList());
            response.setSum("0");
            response.setConcatString("");
        }

        return response;
    }
}
