package com.example.tourapi.test.service;

import com.example.tourapi.test.model.TestDAO;
import com.example.tourapi.test.model.TestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TestService {
    public final TestDAO testDAO;

    public List<TestDTO> getTestList() {
        return testDAO.getTestList();
    }

    public String insertTest(TestDTO testDTO) throws Exception {
        // testDTO db에 insert
        int result = testDAO.insertTest(testDTO);
        return result + " rows inserted";
    }
}
