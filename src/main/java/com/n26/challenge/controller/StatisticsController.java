package com.n26.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n26.challenge.entity.Statistics;
import com.n26.challenge.services.StatisticsService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "api/statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping
    @ApiOperation(value = "Get Statistics")
    public Statistics getStatistics() {
        return statisticsService.getStatistics();
    }

}
