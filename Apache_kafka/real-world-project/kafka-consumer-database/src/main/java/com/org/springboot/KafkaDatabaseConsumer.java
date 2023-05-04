package com.org.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.org.springboot.entity.WikimediaData;
import com.org.springboot.repositery.WikiMediaRepo;

@Service
public class KafkaDatabaseConsumer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	private WikiMediaRepo wikiMediaRepo;
	
	
	public KafkaDatabaseConsumer(WikiMediaRepo wikiMediaRepo) {
		super();
		this.wikiMediaRepo = wikiMediaRepo;
	}


	@KafkaListener(
			topics = "wikimedia_recentchange",
			groupId = "myGroup"
			)
	public void consume(String eventMsg) {
		LOGGER.info(String.format("message recievd --> %s", eventMsg));
		WikimediaData wikimediaData=new WikimediaData();
		wikimediaData.setWikiEventData(eventMsg);
		wikiMediaRepo.save(wikimediaData);
	}

}
