package com.np.order.service.impl;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.netflix.servo.monitor.Counter;
import com.np.order.entity.Sequence;

@Service
public class SequenceGenerator {
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public Integer generateNextOrderId() {
		
//		Sequence counter1 = mongoOperations.findOne(
//	            new Query(Criteria.where("_id").is("sequence")), 
//	            Sequence.class);
//
//	    System.out.println("-------counter1: "+counter1);
		
		Sequence counter = mongoOperations.findAndModify(
				new Query(Criteria.where("_id").is("sequence")), 
				new Update().inc("sequence", 1) , 
				options().returnNew(true).upsert(true),
				Sequence.class);
		System.out.println("-------counter: "+counter);
		
		return counter.getSequence();
//	    return 1;
	}

}
