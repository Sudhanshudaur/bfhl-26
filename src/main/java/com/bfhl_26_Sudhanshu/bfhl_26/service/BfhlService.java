package com.bfhl_26_Sudhanshu.bfhl_26.service;

import com.bfhl_26_Sudhanshu.bfhl_26.dto.BfhlRequest;
import com.bfhl_26_Sudhanshu.bfhl_26.dto.BfhlResponse;

public interface BfhlService {
    BfhlResponse processData(BfhlRequest request);
}
