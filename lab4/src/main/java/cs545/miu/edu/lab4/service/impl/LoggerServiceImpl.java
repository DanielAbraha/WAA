package cs545.miu.edu.lab4.service.impl;

import cs545.miu.edu.lab4.domain.Logger;
import cs545.miu.edu.lab4.repository.LoggerRepo;
import cs545.miu.edu.lab4.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    LoggerRepo loggerRepo;

    @Override
    public void save(Logger logger) {
        loggerRepo.save(logger);
    }
}
