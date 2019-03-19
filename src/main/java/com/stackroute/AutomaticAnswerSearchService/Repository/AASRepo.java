package com.stackroute.AutomaticAnswerSearchService.Repository;

import java.util.List;

public interface AASRepo {

    void save(List<com.stackroute.StackOverflowDb.domain.Items> items);

    List<com.stackroute.StackOverflowDb.domain.Items> findAll();


}
