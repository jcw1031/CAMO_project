package jcw.camoServer.service;

import jcw.camoServer.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeService {

    @Autowired
    CafeRepository cafeRepository;
}
