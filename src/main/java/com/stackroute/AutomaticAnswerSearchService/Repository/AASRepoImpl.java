package com.stackroute.AutomaticAnswerSearchService.Repository;


import com.stackroute.AutomaticAnswerSearchService.model.Items;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AASRepoImpl implements AASRepo {

    private RedisTemplate<List<Items>, Items> redisTemplate;

    private HashOperations hashOperations;

    public AASRepoImpl(RedisTemplate<List<Items>, Items> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public void save(List<com.stackroute.StackOverflowDb.domain.Items> items) {

        hashOperations.put("ITEMS", items, items);


    }


    @Override
    public List<com.stackroute.StackOverflowDb.domain.Items> findAll() {
        return hashOperations.values("ITEMS");
    }


}
