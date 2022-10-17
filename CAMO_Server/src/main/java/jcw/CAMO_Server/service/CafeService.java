package jcw.CAMO_Server.service;

import jcw.CAMO_Server.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeService {

    @Autowired
    CafeRepository cafeRepository;
}
